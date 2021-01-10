package models.address

import models.address.TypeAddress.TypeAddress
import play.api.libs.functional.syntax._
import play.api.libs.json._

case class AddressRequest(
  line1: String,
  line2: Option[String],
  zipCode: String,
  city: String,
  countryCode: String,
  addressType: TypeAddress
)

object AddressRequest {
  implicit val reads: Reads[AddressRequest] = (
    (__ \ "line_1").read[String] and
      (__ \ "line_2").readNullable[String] and
      (__ \ "zip_code").read[String] and
      (__ \ "city").read[String] and
      (__ \ "country_code").read[String] and
      (__ \ "address_type").read[TypeAddress]
    ) (AddressRequest.apply _)
}