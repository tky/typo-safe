package com.tk.libra

trait Resource {
  def read: List[String]
}

object MockResource extends Resource {
  override def read: List[String] = List("apple", "applo")
}

class FileResource(filename: String) extends Resource {
  import scala.io.Source
  override def read:List[String] = {
    // TODO: close
    Source.fromFile(filename).getLines.toList
  }
}
