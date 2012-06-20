package com.tk.libra

import com.tk.libra.utils.Using

trait Resource {
  def read: List[String]
  def extension: String
}

object MockResource extends Resource {
  override def read: List[String] = List("apple", "applo")
  override def extension: String = "java"
}

class FileResource(val filename: String) extends Resource with Using with LineParser  {
  import scala.io.Source
  override def read: List[String] = {
    using(Source.fromFile(filename)) { source =>
      source.getLines.toList.map { line =>
        parse(line)
      }.flatten
    }
  }

  override def extension: String = filename.split('.').toList.last
}
