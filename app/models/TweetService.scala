package models

import com.google.inject.Inject
import play.api.db.DBApi
import anorm._

/**
  * Created by jorge on 25/2/2017.
  */
class TweetService {

  case class Tweet(tweetId: Long,
                   userAlias: String,
                   date: Long,
                   sentiment: Double,
                   batchId: Long)

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

    def insert(tweet: Tweet, batchId: Long) = {
      db.withConnection { implicit connection =>
        SQL(
          """
            |insert into Tweet values (
            |{tweetId}, {userAlias}, {date}, {sentiment}, {batchId}
          """
        ).on(
          'tweetId -> tweet.tweetId,
          'userAlias -> tweet.userAlias,
          'date -> tweet.date,
          'sentiment -> tweet.sentiment,
          'batchId -> batchId
        ).executeUpdate()
      }
    }
  }
}
