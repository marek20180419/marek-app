package pl.marek.resources

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import pl.marek.services.JsonExtractor

trait Resources {

  val extractor: JsonExtractor

  def resources: Route = {
    path("marek-scala" / "api" / "nodes") {
      get {
        pathEndOrSingleSlash {
          complete {
            extractor.exact()
          }
        }
      }
    }
  }
}