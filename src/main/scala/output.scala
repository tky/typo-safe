package com.tk.libra

trait Result {
  def failures:List[String]
}

object MockResult extends Result {
  def failures:List[String] = List("applo")
}

class SimpleResult(xs: List[String]) extends Result {
  override def failures:List[String] = xs
}
