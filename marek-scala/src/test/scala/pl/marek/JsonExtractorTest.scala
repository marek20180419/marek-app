package pl.marek

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.{Matchers, WordSpec}
import pl.marek.TestObjects._
import pl.marek.serializers.Protocols

import scala.concurrent.Future

class JsonExtractorTest extends WordSpec
  with Matchers with Protocols with ScalaFutures with ServiceMocks {

  implicit val system = ActorSystem("test-salary-service")
  implicit val materializer = ActorMaterializer()

  "The salary service" should {

    "return one job" in new successful {
      val exact = jsonExtractor.fetchExact(Future.successful(Right(jobResponse)))
      exact.futureValue should equal(Right(job))
    }
  }
}