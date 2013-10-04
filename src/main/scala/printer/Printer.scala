package com.decaf.langz

class Printer(private[this] val infix: Boolean = false) {
  def prettyPrint(exp: Expression, level: Int = 0): String = exp match {
    case sym: SymbolExp => prettyPrintSymbolExpression(sym, level)
    case op: Operation => 
  		if (infix) {
  			newLine + indent(level) + prettyPrintOperationInfix(op, level)
  		} else {
  			prettyPrintOperation(op, level)
  		}
  }

    private[this] val newLine = "\n"
  private[this] def indent(level: Int) = List.fill(level)(" ").mkString

  private[this] def prettyPrintSymbolExpression(sym: SymbolExp, level: Int) = sym match {
  	case NumberSym(n) => s"${n}"
  	case StringSym(s) => s"${s}"
  }

  private[this] def prettyPrintOperationInfix(op: Operation, level: Int) = op match {
  	case Add(left, right) => s"(+ ${prettyPrint(left, level+1)} ${prettyPrint(right, level+1)})"
  	case Multiply(left, right) => s"(* ${prettyPrint(left, level+1)} ${prettyPrint(right, level+1)})"
  }

  private[this] def prettyPrintOperation(op: Operation, level: Int) = op match {
  	case Add(left, right) => s"(${prettyPrint(left, level+1)} + ${prettyPrint(right, level+1)})"
  	case Multiply(left, right) => s"(${prettyPrint(left, level+1)} * ${prettyPrint(right, level+1)})"
  }
}