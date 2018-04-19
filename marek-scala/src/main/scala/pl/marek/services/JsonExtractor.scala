package pl.marek.services

import akka.actor.ActorSystem
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._
import akka.http.scaladsl.marshalling.ToResponseMarshallable
import akka.stream.Materializer
import org.apache.poi.ss.usermodel.WorkbookFactory
import pl.marek.domain.out.{Node, SuccessfulResponse}
import pl.marek.routing.FlowResource

import scala.concurrent.{ExecutionContext, Future}

class JsonExtractor(implicit val executionContext: ExecutionContext,
                    implicit val system: ActorSystem,
                    implicit val materializer: Materializer) extends FlowResource {

  def getJsonData(fileName: String): Future[List[Node]] = {

    val is = getClass.getClassLoader.getResourceAsStream("test1.xlsx")
    val workbook = WorkbookFactory.create(is)
    val sheet = workbook.getSheetAt(0)
    val rowIt = sheet.rowIterator()

    var result: List[Node] = List()
//    val result: List[Node] = List[Node](Node(1,"test", new util.ArrayList[Node]()))

    var level1: Node = null
    var level2: Node = null
    rowIt.next // skip headers

    while (rowIt.hasNext) {
      val row = rowIt.next
      val cell0 = row.getCell(0).getStringCellValue
      val cell1 = row.getCell(1).getStringCellValue
      val cell2 = row.getCell(2).getStringCellValue
      val id = row.getCell(3).getNumericCellValue
      if (!cell0.isEmpty) {
        level1 = Node(id.toInt, cell0, List())
        result = result :+ level1
      }
      else if (!cell1.isEmpty) {
        level2 = Node(id.toInt, cell1, List())
        level1.nodes = level1.nodes :+ level2
      }
      else if (!cell2.isEmpty) {
          val level3 = Node(id.toInt, cell2, List())
          level2.nodes = level2.nodes :+ level3
        }
    }
    return Future.successful(result)
  }

  def exact(): Future[ToResponseMarshallable] = {
    getJsonData("test1.xlsx").map[ToResponseMarshallable] {
      case json => SuccessfulResponse(json)
    }
  }
}