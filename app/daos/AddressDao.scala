package daos

import anorm.SQL
import anorm.SqlParser.scalar
import com.google.inject.Inject
import helpers.DatabaseExecutionContext
import models.address.AddressRequest

import java.sql.Connection

class AddressDao @Inject()(implicit ec: DatabaseExecutionContext) {
  def createAddress(addressRequest: AddressRequest)(implicit connection: Connection): Long = SQL(
    s"""
       | INSERT INTO address(
       |    a_line_1,
       |    a_line_2,
       |    a_zip_code,
       |    a_city,
       |    a_country_code,
       |    a_address_type
       | ) VALUES (
       |    {a_line_1},
       |    {a_line_2},
       |    {a_zip_code},
       |    {a_city},
       |    {a_country_code},
       |    {a_address_type} :: type_address
       | );
       |""".stripMargin)
    .on(
      "a_line_1" -> addressRequest.line1,
      "a_line_2" -> addressRequest.line2,
      "a_zip_code" -> addressRequest.zipCode,
      "a_city" -> addressRequest.city,
      "a_country_code" -> addressRequest.countryCode,
      "a_address_type" -> addressRequest.addressType.toString
    ).executeInsert(scalar[Long].single)
}
