package service

import model.Account
import repository.AccountRepository

import scala.collection.mutable

object AccountService {

  def create(account: Account): Unit = {
    AccountRepository.create(account)
  }

  def getAll(): mutable.HashSet[Account] = {
    AccountRepository.getAll()
  }

  def getByLogin(login: String): Option[Account] = {
    AccountRepository.getByLogin(login)
  }

  def deleteByLogin(login: String) = {
    AccountRepository.deleteByLogin(login)
  }
}
