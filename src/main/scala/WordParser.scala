package com.tk.libra

trait WordParser {
  def isAccept(word: String): Boolean
  def parse(word: String): List[String]
}

object CamelCaseParser extends WordParser {
  val CAMEL_CASE_PATTERN = "(?<=[A-Z])(?=[A-Z][a-z])|(?<=[a-z])(?=[A-Z])"

  override def isAccept(word: String): Boolean = {
    CAMEL_CASE_PATTERN.r.findFirstIn(word) != None
  }

  override def parse(word: String): List[String] = {
    word.split(CAMEL_CASE_PATTERN).toList.map {_.toLowerCase }
  }
}
