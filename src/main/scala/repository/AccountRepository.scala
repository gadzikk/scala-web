package repository

import model.Account

import scala.collection.mutable

object AccountRepository {
  val accounts: mutable.HashSet[Account] = mutable.HashSet.empty

  def create(account: Account): Unit = {
    accounts.add(account)
  }

  def getAll(): mutable.HashSet[Account] = {
    accounts
  }

  def getByLogin(login: String): Option[Account] = {
    val account = accounts.find((acccount: Account) => acccount.login == login)
    account match {
      case Some(account) => Some(account)
      case None =>
        println("Account doesnt exist")
        Option.empty
    }
  }


  def deleteByLogin(login: String): Unit = {
    val account = accounts.find(_.login == login)
    account match {
      case Some(account: Account) => accounts.remove(account)
      case None => println("Account doesnt exist")
    }

  }
}
