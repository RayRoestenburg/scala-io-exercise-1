package com.xebia.exercise1

import spray.http.StatusCodes
import spray.routing._

import spray.httpx.SprayJsonSupport._

class Receptionist extends HttpServiceActor with ReverseRoute {

  //TODO create the child actor: ReverseActor

  def receive = runRoute(reverseRoute)

}

trait ReverseRoute extends HttpService {

  def reverseRoute:Route = path("reverse") {
    post {
      entity(as[ReverseRequest]) { request =>
       //TODO send message to ReverseActor instead and get the response back.
        val response = ReverseResponse(request.value.reverse)
        complete(StatusCodes.OK, response)
      }
    }
  }
}

