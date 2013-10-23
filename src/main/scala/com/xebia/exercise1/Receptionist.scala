package com.xebia.exercise1

import spray.http.StatusCodes
import spray.routing._

import spray.httpx.SprayJsonSupport._
import scala.concurrent.{ExecutionContext, Future}

class Receptionist extends HttpServiceActor with ReverseRoute {

  //TODO create child reverse actor

  def receive = runRoute(reverseRoute)

}

trait ReverseRoute extends HttpService {

  //TODO define a method that returns the ActorRef to the reverse actor

  def reverseRoute:Route = path("reverse") {
    post {
      entity(as[ReverseRequest]) { request =>
        // We will fix this import in a next exercise
        import ExecutionContext.Implicits.global

        import akka.pattern.ask

        //TODO replace the next line by asking the actor to Reverse and mapping the result to a Future[ReverseResult]
        val futureResult = Future.successful(ReverseResponse(request.value.reverse))

        val futureResponse = futureResult.map(r=> ReverseResponse(r.value))
        complete(futureResponse)
      }
    }
  }
}

