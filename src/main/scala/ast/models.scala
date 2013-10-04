package com.decaf.langz

sealed trait Expression

sealed trait SymbolExp extends Expression
case class NumberSym(value: Int) extends SymbolExp
case class StringSym(value: String) extends SymbolExp

sealed trait Operation extends Expression {
	def left: Expression
	def right: Expression
}

case class Add(left: Expression, right: Expression) extends Operation
case class Multiply(left: Expression, right: Expression) extends Operation