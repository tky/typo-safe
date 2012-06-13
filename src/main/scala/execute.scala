package com.tk.libra


object Executor {

  def execute(source: Resource): Result = {
    val resolver = MockResolver
    new SimpleResult(
      source.read.flatMap { word => if (!resolver.resolve(word)) Some(word) else None } toList)
  }

}
