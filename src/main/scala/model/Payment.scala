package model

final case class Payment(login: String, products: List[Product], totalPrice: BigDecimal)
