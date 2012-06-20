package com.tk.libra


object Executor {

  def execute(source: Resource): Result = {
    val resolvers = List(FileResolver(source.extension), FileResolver("common")).flatten
    new SimpleResult(
      source.read.flatMap { word =>
          if (!resolvers.find(_.resolve(word)).isDefined) Some(word) else None
        } toList
      )
  }
}
