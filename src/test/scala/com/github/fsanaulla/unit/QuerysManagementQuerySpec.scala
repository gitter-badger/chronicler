package com.github.fsanaulla.unit

import akka.http.scaladsl.model.Uri
import com.github.fsanaulla.query.QuerysManagementQuery
import com.github.fsanaulla.utils.TestHelper._
import com.github.fsanaulla.utils.{AkkaQueryHandler, TestSpec}

/**
  * Created by
  * Author: fayaz.sanaulla@gmail.com
  * Date: 20.08.17
  */
class QuerysManagementQuerySpec
  extends TestSpec
    with AkkaQueryHandler
    with QuerysManagementQuery[Uri] {

  "show query" should "correctly work" in {
    showQuerysQuery() shouldEqual queryTesterAuth("SHOW QUERIES")

    showQuerysQuery()(emptyCredentials) shouldEqual queryTester("SHOW QUERIES")
  }

  "kill query" should "correctly work" in {
    killQueryQuery(5) shouldEqual queryTesterAuth("KILL QUERY 5")

    killQueryQuery(5)(emptyCredentials) shouldEqual queryTester("KILL QUERY 5")
  }
}
