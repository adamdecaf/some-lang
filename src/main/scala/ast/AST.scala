package com.decaf.langz

class AST() {
  def evaluateExpression(exp: Expression): Int = exp match {
    case sym: SymbolExp => evaluateSymbolExpression(sym)
    case op: Operation => evaluateOperation(op)
  }

  private[this] def evaluateSymbolExpression(sym: SymbolExp): Int = sym match 	{
    case NumberSym(n) => n
    case StringSym(s) => 0 // todo: decimal value of char
  }

  private[this] def evaluateOperation(op: Operation) = op match {
    case Add(left, right) => evaluateExpression(left) + evaluateExpression(right)
    case Multiply(left, right) => evaluateExpression(left) * evaluateExpression(right)
  }
}