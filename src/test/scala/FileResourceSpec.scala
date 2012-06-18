package com.tk.libra

import org.specs2.mutable._

class FileResourceSpec extends Specification {
  "read" should {
    "simple file read" in {
      new FileResource("./resource/test/simple.txt").read.toList == List("apple", "applo")
    }
  }
}
