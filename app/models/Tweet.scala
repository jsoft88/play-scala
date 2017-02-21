package models

case class Tweet(tweetId: String, userAlias: String, date: Long, sentiment: double, batchId: Int)

case class Page[A](items: Seq[A], page: Int, offset: Long, total: Long) {

}