package controllers

import com.google.inject.Inject
import com.google.inject.Singleton
import play.api.mvc.AbstractController
import play.api.mvc.ControllerComponents

@Singleton
class AddressController @Inject()(controllerComponents: ControllerComponents)
  extends AbstractController(controllerComponents) {

}
