package com.tk.libra

import org.specs2.mutable._

class FileResolverSpec extends Specification {
  "common" should {
    "contains word" in {
      FileResolver("common").get.resolve("get") must_== true
      FileResolver("common").get.resolve("set") must_== true
      FileResolver("common").get.resolve("hogehoge") must_== false
    }
  }
}
