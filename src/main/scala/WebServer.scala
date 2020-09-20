import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.StatusCodes._
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.stream.ActorMaterializer
import model.Account
import service.AccountService

import scala.io.StdIn

object WebServer extends JsonSupport {
  implicit val system = ActorSystem()
  implicit val materializer = ActorMaterializer()
  implicit val executionContext = system.dispatcher

  def main(args: Array[String]) {
    val route: Route =
      get {
        path("test" / LongNumber) { id =>
          println(id)
          complete(OK)
        } ~
          path("accounts") {
            println(AccountService.getAll())
            complete(OK)
          } ~
          path("accounts" / Segment) { login =>
            println(AccountService.getByLogin(login))
            complete(OK)
          }
      } ~
        post {
          path("test") {
            entity(as[String]) { value =>
              println(value)
              val response: Response = Response(value)
              complete(OK -> response)
            }
          } ~
            path("accounts") {
              entity(as[Account]) { account =>
                println(account)
                AccountService.create(account)
                complete(OK)
              }
            }

        }

    val bindingFuture = Http().bindAndHandle(route, "localhost", 8080)
    println(s"Server online at http://localhost:8080/\nPress RETURN to stop...")
    StdIn.readLine() // let it run until user presses return
    bindingFuture
      .flatMap(_.unbind()) // trigger unbinding from the port
      .onComplete(_ ⇒ system.terminate()) // and shutdown when done

  }
}
