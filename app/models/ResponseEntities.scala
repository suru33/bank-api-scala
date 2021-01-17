package models

import play.api.libs.json.JsObject
import play.api.libs.json.JsString
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.Writes

object SuccessEntity {

  def apply[C](content: C)(implicit writes: Writes[C]): JsValue = Json.obj(
    "success" -> true,
    "response" -> Json.toJson(content)
  )

  def apply(content: AnyVal): JsValue = Json.obj(
    "success" -> true,
    "response" -> JsString(content.toString)
  )
}

object FailureEntity {
  def apply[C](content: C)(implicit writes: Writes[C]): JsValue = Json.obj(
    "success" -> false,
    "response" -> Json.toJson(content)
  )

  def apply(exception: Exception): JsValue = Json.obj(
    "success" -> false,
    "exception" -> JsString(exception.toString)
  )

  def apply(content: Any = "Bad Request"): JsObject = Json.obj(
    "success" -> false,
    "response" -> content.toString
  )

  def apply[C](content: C, exception: Exception)(implicit writes: Writes[C]): JsValue = Json.obj(
    "success" -> false,
    "exception" -> JsString(exception.toString),
    "response" -> Json.toJson(content)
  )
}