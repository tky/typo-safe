package com.tk.libra

import org.specs2.mutable._

class CamleCaseParseSpec extends Specification {
  "isAccept" should {
    "getter and setter" in {
      CamelCaseParser.isAccept("getHoge") must_== true
      CamelCaseParser.parse("getHoge") must_== List("get", "hoge")

      CamelCaseParser.isAccept("setFuga") must_== true
      CamelCaseParser.parse("setFuga") must_== List("set", "fuga")
    }

    "complex words" in {
      CamelCaseParser.isAccept("iWantToGetMoreSalary") must_== true
      CamelCaseParser.parse("iWantToGetMoreSalary") must_== List("i", "want", "to", "get", "more", "salary")

      CamelCaseParser.isAccept("HttpUtils") must_== true
      CamelCaseParser.parse("HttpUtils") must_== List("http", "utils")

      CamelCaseParser.isAccept("DBUtils") must_== true
      CamelCaseParser.parse("DBUtils") must_== List("db", "utils")
    }

    "failure pattern" in {
      CamelCaseParser.isAccept("_x") must_== false
      CamelCaseParser.isAccept("get_word") must_== false
      CamelCaseParser.isAccept("get-word") must_== false
    }
  }
}
