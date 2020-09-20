package repository

import model.Payment

import scala.collection.mutable

object PaymentRepository {
  private val payments: mutable.HashSet[Payment] = mutable.HashSet.empty

  def getByLogin(login:String): mutable.HashSet[Payment] = {
    payments.filter((payment: Payment) => payment.login == login)
  }

  def getByLoginPriceGreaterThan(login:String, totalPrice: BigDecimal): mutable.HashSet[Payment] = {
    payments
      .filter((payment: Payment) => payment.login == login)
      .filter((payment: Payment) => payment.totalPrice > totalPrice)
  }

  def create(payment: Payment): Unit = {
    payments.add(payment)
  }

}
