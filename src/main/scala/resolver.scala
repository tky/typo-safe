package com.tk.libra

trait Resolver {
  def resolve(word: String): Boolean
}

object MockResolver extends Resolver {
  override def resolve(word: String): Boolean = {
    word == "apple"
  }
}
