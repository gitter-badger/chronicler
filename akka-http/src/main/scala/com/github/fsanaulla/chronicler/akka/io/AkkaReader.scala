package com.github.fsanaulla.chronicler.akka.io

import _root_.akka.http.scaladsl.model.Uri
import com.github.fsanaulla.chronicler.akka.handlers.{AkkaQueryHandler, AkkaRequestHandler, AkkaResponseHandler}
import com.github.fsanaulla.core.enums.Epoch
import com.github.fsanaulla.core.io.ReadOperations
import com.github.fsanaulla.core.model.{Executable, HasCredentials, QueryResult}
import com.github.fsanaulla.core.query.DatabaseOperationQuery
import jawn.ast.JArray

import scala.concurrent.Future

/**
  * Created by
  * Author: fayaz.sanaulla@gmail.com
  * Date: 15.03.18
  */
private[fsanaulla] trait AkkaReader
  extends AkkaRequestHandler
    with AkkaResponseHandler
    with AkkaQueryHandler
    with DatabaseOperationQuery[Uri]
    with HasCredentials { self: ReadOperations[Future] with Executable =>

  override def readJs0(
                        dbName: String,
                        query: String,
                        epoch: Epoch,
                        pretty: Boolean,
                        chunked: Boolean): Future[QueryResult[JArray]] =
    readRequest(readFromInfluxSingleQuery(dbName, query, epoch, pretty, chunked)).flatMap(toQueryJsResult)


  override def bulkReadJs0(
                            dbName: String,
                            queries: Seq[String],
                            epoch: Epoch,
                            pretty: Boolean,
                            chunked: Boolean): Future[QueryResult[Array[JArray]]] =
    readRequest(readFromInfluxBulkQuery(dbName, queries, epoch, pretty, chunked)).flatMap(toBulkQueryJsResult)

}
