package controllers

import play.api.mvc._

import javax.inject._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class TestController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  def index(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    Ok("OK!")
  }

  def helloWorld(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    Ok("Hello World!")
  }
}
