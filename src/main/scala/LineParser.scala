package com.tk.libra

trait LineParser {
  val wordParsers:List[WordParser] = List(CamelCaseParser)
  def parse(line: String): List[String] = {
    def split(line:String): List[String] = {
      if (line.isEmpty) {
        Nil
      } else {
        line.trim.split("\\W").toList.filterNot(_.isEmpty)
      }
    }
    split(line).map { word =>
      wordParsers.find(_.isAccept(word)).map {
        _.parse(word)
      }.getOrElse(List(word))
    }.flatten.map { _.toLowerCase }
  }
}
