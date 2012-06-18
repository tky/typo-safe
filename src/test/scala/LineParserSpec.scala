package com.tk.libra

import org.specs2.mutable._

class LineParserSpec extends Specification {
  object Parser extends LineParser

  "LineParser" should {
    "camel case only" in {
      Parser.parse("val hoge = Fuga.get(\"aaa\");") must_== List("val", "hoge", "fuga", "get", "aaa")
      Parser.parse("val hoge = Fuga.get(\"aaa\");\nhoge;") must_== List("val", "hoge", "fuga", "get", "aaa", "hoge")
    }
  }
}
