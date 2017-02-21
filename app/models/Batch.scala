package models

import anorm.SqlParser._
import javax.inject.Inject
import anorm._
import play.api.db.DBApi

case class Batch(batchId: Int, date: Long)

/**
* Helper for pagination.
*/
case class Page[A](items: Seq[A], page: Int, offset: Long, total: Long) {
  lazy val prev = Option(page - 1).filter(_ >= 0)
  lazy val next = Option(page + 1).filter(_ => (offset + items.size) < total)
}

@javax.inject.Singleton
class BatchService @Inject() (dbapi: DBApi, batchService: BatchService) {

  private val db = dbapi.database("default")

  def insert(batch: Batch) = {
    db.withCon
  }
}