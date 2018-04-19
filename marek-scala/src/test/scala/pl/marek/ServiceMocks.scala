package pl.marek

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import pl.marek.services.JsonExtractor

import scala.concurrent.ExecutionContext.Implicits.global

trait ServiceMocks {

  implicit val system: ActorSystem
  implicit val materializer: ActorMaterializer

  trait successful {
    val jsonExtractor = new JsonExtractor()
  }

  trait failed {
    val jsonExtractor = new JsonExtractor()
  }

}
