package models.address

import anorm.RowParser
import anorm.SqlParser.get
import anorm.~
import models.address.TypeAddress.TypeAddress
import play.api.libs.json.Json
import play.api.libs.json.Writes

case class Address(
  id: Long,
  line1: String,
  line2: Option[String],
  zipCode: String,
  city: String,
  countryCode: String,
  addressType: TypeAddress
)

object Address {
  implicit val writes: Writes[Address] = (o: Address) => {
    Json.obj(
      "id" -> o.id,
      "line_1" -> o.line1,
      "line_2" -> o.line2,
      "zip_code" -> o.zipCode,
      "city" -> o.city,
      "country_code" -> o.countryCode,
      "address_type" -> o.addressType
    )
  }

  val parser: RowParser[Address] =
    get[Long]("a_id") ~
      get[String]("a_line_1") ~
      get[String]("a_line_2").? ~
      get[String]("a_zip_code") ~
      get[String]("a_city") ~
      get[String]("a_country_code") ~
      TypeAddress.parser map {
      case id ~ line1 ~ line2 ~ zipCode ~ city ~ countryCode ~ addressType =>
        Address(id, line1, line2, zipCode, city, countryCode, addressType)
    }
}

