package controllers

import com.google.inject.Inject
import com.google.inject.Singleton
import models.FailureEntity
import models.SuccessEntity
import models.address.AddressRequest
import play.api.libs.json.JsError
import play.api.libs.json.JsSuccess
import play.api.mvc.AbstractController
import play.api.mvc.ControllerComponents
import services.AddressService

import scala.concurrent.ExecutionContext
import scala.concurrent.Future

@Singleton
class AddressController @Inject()(
  addressService: AddressService,
  controllerComponents: ControllerComponents
)(implicit ec: ExecutionContext) extends AbstractController(controllerComponents) {

  def create = Action.async(parse.json) { implicit request =>
    request.body.validate[AddressRequest] match {
      case JsSuccess(addressRequest, _) =>
        addressService.createAddress(addressRequest) map {
          id: Long => Created(SuccessEntity(id))
        }
      case JsError(_) => Future.successful(BadRequest(FailureEntity()))
    }
  }
}
