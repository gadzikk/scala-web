package repository

import model.Country

import scala.collection.mutable

object Country {
  private val countries: mutable.HashSet[Country] = mutable.HashSet.empty

  def getCountries(): mutable.HashSet[Country] = {
    countries
  }

  def create(country:Country): Unit = {
    countries.add(country)
  }

  def getCountryByCode(code: String): Option[Country] = {
    val country = countries.find((country:Country) => country.code == code)
    country match {
      case Some(country) => Some(country)
      case None =>
        println("country doesn't exist")
        Option.empty
    }
  }

}
