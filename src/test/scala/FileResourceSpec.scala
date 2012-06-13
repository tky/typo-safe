package com.tk.libra

import org.specs2.mutable._

class FileResourceSpec extends Specification {
  "read" should {
    "simple file read" in {
      new FileResource("./resource/test/simple.txt").read.toList == List("apple", "applo")
    }
  }
}

class LineParseSpec extends Specification {
  object Parser extends LineParser
  "parseLine" should {
    "read simple line" in {
      Parser.split(" a ") must_== List("a")
      Parser.split(" a ; b") must_== List("a", "b")
      Parser.split(" a ; b & c;") must_== List("a", "b", "c")
    }
  }
}
