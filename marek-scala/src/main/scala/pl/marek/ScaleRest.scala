package pl.marek

import akka.actor.ActorSystem
import akka.http.scaladsl.server.Route
import akka.stream.Materializer
import pl.marek.resources.Resources
import pl.marek.services.JsonExtractor

import scala.concurrent.ExecutionContext

trait ScaleRest extends Resources {

  implicit val system: ActorSystem
  implicit val materializer: Materializer
  implicit val executionContext: ExecutionContext

  lazy val extractor = new JsonExtractor

  val routes: Route = resources
}
