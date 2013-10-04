package com.decaf.langz

object Parser {
  def parseString(str: String): Option[Expression] = 
    isInfixExpression(str) orElse isPrefixExpression(str) orElse isNumberAsOption(str)

  private[this] val PrefixRegex = s"""^\\((${symbolList}) (${number}) (${number})\\)$$""".r
  private[this] def isPrefixExpression(s: String) = PrefixRegex findFirstIn s match {
    case Some(PrefixRegex(op, left, right)) if (isSymbol(op) && isNumber(left) && isNumber(right)) => deriveOperation(op) match {
      case Add => Some(Add(NumberSym(left.toInt), NumberSym(right.toInt)))
      case Multiply => Some(Multiply(NumberSym(left.toInt), NumberSym(right.toInt)))
    }
    case _ => println("aa"); None
  }

  private[this] val InfixRegex = s"""^\\((${number}) (${symbolList}) (${number})\\)$$""".r 
  private[this] def isInfixExpression(s: String) = InfixRegex findFirstIn s match {
    case Some(InfixRegex(left, op, right)) if (isSymbol(op) && isNumber(left) && isNumber(right)) => deriveOperation(op) match {
      case Add => Some(Add(NumberSym(left.toInt), NumberSym(right.toInt)))
      case Multiply => Some(Multiply(NumberSym(left.toInt), NumberSym(right.toInt)))
    }
    case _ => println("bb"); None
  }

  private[this] val number = """[\d]+"""
  private[this] val symbolList = """\+|\*"""

  private[this] def isSymbol(s: String): Boolean = (s"""^($symbolList)$$""".r findFirstIn s).isDefined
  private[this] def isNumber(s: String): Boolean = (s"""^(${number})$$""".r findFirstIn s).isDefined
  private[this] def isNumberAsOption(s: String) = if (isNumber(s)) Some(NumberSym(s.toInt)) else None

  private[this] def  deriveOperation(op: String) = op match {
    case "+" => println("a"); Add
    case "*" => println("b"); Multiply
    case o => println("c " + o); ???
  }
}