package com.tk.libra.input

trait Resource {
  def read: Iterator[String]
}

object MockResource extends Resource {
  override def read: Iterator[String] = Iterator("apple", "applo")
}
