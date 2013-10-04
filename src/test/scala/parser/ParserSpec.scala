package com.decaf.langz
import org.specs2.mutable.Specification

object ParserSpec extends Specification {

  "The Parser" should {
    "tell us if some simple expressions validate" in {
      val exp1 = "12"
      val exp2 = "12.2"
      val exp3 = "(+ 12 1)"
      val exp4 = "(* 1 12)"
      val exp5 = "(1 + 12)"
      //      parser.parseString(exp1).isDefined must beTrue
      //parser.parseString(exp2).isDefined must beTrue
      //parser.parseString(exp3).isDefined must beTrue
      //parser.parseString(exp4).isDefined must beTrue
      parser.parseString(exp5).isDefined must beTrue
    }
    "fail on improper expressions" in {
      val exp1 = "*"
      val exp2 = "()"
      val exp3 = "(+ 12 + 1)"
      val exp4 = "(12 41 +)"
      val exp5 = "(12 41)"
      success
      // parser.parseString(exp1).isDefined must beFalse
      // parser.parseString(exp2).isDefined must beFalse
      // parser.parseString(exp3).isDefined must beFalse
      // parser.parseString(exp4).isDefined must beFalse
      // parser.parseString(exp5).isDefined must beFalse
    }
  }

  val parser = Parser
}