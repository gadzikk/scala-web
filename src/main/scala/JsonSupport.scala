import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import model.Account
import response.AccountResponse
import spray.json.DefaultJsonProtocol

trait JsonSupport extends SprayJsonSupport with DefaultJsonProtocol {
  implicit val responseFormat = jsonFormat1(Response)
  implicit val accountFormat = jsonFormat2(Account)
}