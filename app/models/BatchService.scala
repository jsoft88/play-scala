package models

import javax.inject.Inject

import play.api.db.DBApi

/**
  * Created by jorge on 27/2/2017.
  */
class BatchService {

  case class Batch(
                  batchId: Long,
                  batchDate: Long
                  )

  /**
  * Helper for pagination.
  */
  case class Page[A](items: Seq[A], page: Int, offset: Long, total: Long) {
    lazy val prev = Option(page - 1).filter(_ >= 0)
    lazy val next = Option(page + 1).filter(_ => (offset + items.size) < total)
  }

  @javax.inject.Singleton
  class TweetService @Inject()(dbapi: DBApi) {

    private val db = dbapi.database("default")


  }
}
