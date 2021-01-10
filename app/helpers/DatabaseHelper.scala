package helpers

import play.api.db.Database

import java.sql.Connection
import scala.concurrent.ExecutionContext
import scala.concurrent.Future

trait DatabaseHelper {

  val db: Database

  def withFutureConnection[A](block: Connection => A)(implicit ec: ExecutionContext): Future[A] =
    Future {
      db.withConnection { implicit connection =>
        block(connection)
      }
    }

}
