package com.github.fsanaulla.core.model

/**
  * Created by
  * Author: fayaz.sanaulla@gmail.com
  * Date: 05.08.17
  */
final case class InfluxTag(key: String, value: String)

sealed trait InfluxField {
  override def toString: String
}

final case class StringField(key: String, value: String) extends InfluxField {
  override def toString: String = key + "=" + "\"" + value + "\""
}

final case class IntField(key: String, value: Int) extends InfluxField {
  override def toString: String = key + "=" + value + "i"
}

final case class LongField(key: String, value: Long) extends InfluxField {
  override def toString: String = key + "=" + value
}

final case class DoubleField(key: String, value: Double) extends InfluxField {
  override def toString: String = key + "=" + value
}

final case class BooleanField(key: String, value: Boolean) extends InfluxField {
  override def toString: String = key + "=" + value
}

final case class CharField(key: String, value: Char) extends InfluxField {
  override def toString: String = key + "=" + value
}

final case class BigDecimalField(key: String, value: BigDecimal) extends InfluxField {
  override def toString: String = key + "=" + value
}

final case class Point(
                        measurement: String,
                        tags: List[InfluxTag] = Nil,
                        fields: List[InfluxField] = Nil,
                        time: Long = -1L) {

  def addTag(key: String, value: String): Point = copy(tags = tags :+ InfluxTag(key, value))
  def addField(key: String, value: String): Point = copy(fields = fields :+ StringField(key, value))
  def addField(key: String, value: Int): Point = copy(fields = fields :+ IntField(key, value))
  def addField(key: String, value: Long): Point = copy(fields = fields :+ LongField(key, value))
  def addField(key: String, value: Double): Point = copy(fields = fields :+ DoubleField(key, value))
  def addField(key: String, value: Float): Point = copy(fields = fields :+ DoubleField(key, value))
  def addField(key: String, value: BigDecimal): Point = copy(fields = fields :+ BigDecimalField(key, value))
  def addField(key: String, value: Boolean): Point = copy(fields = fields :+ BooleanField(key, value))
  def addField(key: String, value: Char): Point = copy(fields = fields :+ CharField(key, value))

  /** You need to specify time in nanosecond precision */
  def addTimestamp(time: Long): Point = copy(time = time)

  def serialize: String = {
    val sb = StringBuilder.newBuilder

    sb.append(measurement).append(",")
    sb.append(tags.map(tag => tag.key + "=" + tag.value).mkString(","))
    sb.append(" ")
    sb.append(fields.map(_.toString).mkString(","))

    if (time != -1L) {
      sb.append(" ").append(time)
    }

    sb.toString()
  }
}
