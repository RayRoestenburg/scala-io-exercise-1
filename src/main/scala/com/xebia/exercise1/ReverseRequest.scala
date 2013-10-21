package com.xebia.exercise1

import spray.json.DefaultJsonProtocol

case class ReverseRequest(value:String)

object ReverseRequest extends DefaultJsonProtocol {
  implicit val format = jsonFormat1(ReverseRequest.apply)
}

case class ReverseResponse(value:String)

object ReverseResponse extends DefaultJsonProtocol {
  implicit val format = jsonFormat1(ReverseResponse.apply)
}
