package models.address

import anorm.RowParser
import anorm.SqlParser.get
import play.api.libs.json.Reads
import play.api.libs.json.Writes

object TypeAddress extends Enumeration {
  type TypeAddress = Value

  val HOME: TypeAddress.Value = Value("HOME")
  val BUSINESS: TypeAddress.Value = Value("BUSINESS")

  val parser: RowParser[TypeAddress] = {
    get[String]("a_address_type") map (name => TypeAddress.withName(name))
  }

  implicit val reads: Reads[Value] = Reads.enumNameReads(TypeAddress)
  implicit val writes: Writes[Value] = Writes.enumNameWrites
}
