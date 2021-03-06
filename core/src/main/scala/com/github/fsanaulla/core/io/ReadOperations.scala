package com.github.fsanaulla.core.io

import com.github.fsanaulla.core.enums.Epoch
import com.github.fsanaulla.core.model.QueryResult
import jawn.ast.JArray

import scala.concurrent.Future

/***
  * Trait that define main IO operation for working with DB.
  */
trait ReadOperations[M[_]] {

  /**
    * Execute single query from InfluxDB
    * @param dbName  - For which database
    * @param query   - SQL based query
    * @param epoch   - Epochs interval
    * @param pretty  - Flag for enabling/disabling JSON pretty printing
    * @param chunked - Chunked response
    * @return        - Query result, array of JArray
    */
  def readJs0(dbName: String, query: String, epoch: Epoch, pretty: Boolean, chunked: Boolean): M[QueryResult[JArray]]

  /**
    * Execute several queries in one time
    * @param dbName  - For which database
    * @param queries - SQL based queries, that must be executed
    * @param epoch   - Epochs interval
    * @param pretty  - Flag for enabling/disabling JSON pretty printing
    * @param chunked - Chunked response
    * @return        - Multiple query results, array of JArray
    */
  def bulkReadJs0(dbName: String, queries: Seq[String], epoch: Epoch, pretty: Boolean, chunked: Boolean): M[QueryResult[Array[JArray]]]

}
