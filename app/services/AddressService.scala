package services

import com.google.inject.Inject
import daos.AddressDao
import helpers.DatabaseExecutionContext
import helpers.DatabaseHelper
import models.address.Address
import models.address.AddressRequest
import play.api.db.Database

import scala.concurrent.Future

class AddressService @Inject()
(dao: AddressDao, val db: Database)
(implicit ec: DatabaseExecutionContext) extends DatabaseHelper {
  def createAddress(addressRequest: AddressRequest): Future[Address] =
    withFutureConnection { implicit connection =>
      dao.createAddress(addressRequest)
    }
}
