package com.tk.libra

trait Resource {
  def read: Iterator[String]
}

object MockResource extends Resource {
  override def read: Iterator[String] = Iterator("apple", "applo")
}

class FileResource(filename: String) extends Resource {
  import scala.io.Source
  override def read:Iterator[String] = {
    // TODO: close
    Source.fromFile(filename).getLines
  }
}
