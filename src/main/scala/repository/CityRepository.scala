package repository

import model.City

import scala.collection.mutable

object CityRepository {
  val cities: mutable.HashSet[City] = mutable.HashSet.empty

  def create(city: City): Unit = {
    cities.add(city)
  }

  def getAll(): mutable.HashSet[City] = {
    cities
  }

  def getByName(name: String): Option[City] = {
    val city = cities.find((city: City) => city.name == name)
    city match {
      case Some(city) => Some(city)
      case None =>
        println("city doesn't exist")
        Option.empty
    }
  }

}
