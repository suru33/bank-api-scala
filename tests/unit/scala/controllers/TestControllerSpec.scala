package controllers

import org.scalatestplus.play._
import org.scalatestplus.play.guice._
import play.api.test._
import play.api.test.Helpers._

class TestControllerSpec extends PlaySpec with GuiceOneAppPerTest with Injecting {

  "TestController GET" should {

    "return OK! for index" in {
      val controller = new TestController(stubControllerComponents())
      val request = controller.index() {
        FakeRequest(GET, "/")
      }

      status(request) mustBe OK
      contentType(request) mustBe Some("text/plain")
      contentAsString(request) mustBe "OK!"
    }

    "return Hello World! for helloWorld" in {
      val controller = inject[TestController]
      val request = controller.helloWorld() {
        FakeRequest(GET, "/hello-world")
      }

      status(request) mustBe OK
      contentType(request) mustBe Some("text/plain")
      contentAsString(request) mustBe "Hello World!"
    }
  }
}
