package com.tk.libra

import com.tk.libra.utils.Using

trait LineParser {
  def split(line:String): List[String] = {
    if (line.isEmpty) {
      Nil
    } else {
      line.trim.split("\\W").toList.filterNot(_.isEmpty)
    }
  }
}

trait Resource {
  def read: List[String]
}

object MockResource extends Resource {
  override def read: List[String] = List("apple", "applo")
}

class FileResource(filename: String) extends Resource with Using {
  import scala.io.Source
  override def read:List[String] = {
    using(Source.fromFile(filename)) { source =>
      source.getLines.toList
    }
  }
}
