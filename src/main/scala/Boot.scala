package com.decaf.langz

object Boot {
	def main(args: Array[String]): Unit = {
		println("hello, world")	

		val ast = new AST()
		val printer = new Printer()
		val infixPrinter = new Printer(infix = true)

		val exp1 = NumberSym(12)
		val exp2 = Add(NumberSym(2), NumberSym(3))

		println("Pretty Print: ")
		println(printer.prettyPrint(exp1))
		println(infixPrinter.prettyPrint(exp1))
		println("")
		println(printer.prettyPrint(exp2))
		println(infixPrinter.prettyPrint(exp2))

		val exp3 = 
			Add(
				Add(
					NumberSym(4), NumberSym(5)
				),
				Multiply(
					NumberSym(6), Add(
						NumberSym(7), NumberSym(8)
					)
				)
			)

		val exp4 = Multiply(exp3, Add(exp3, exp3))

		println(printer.prettyPrint(exp3))
		println(infixPrinter.prettyPrint(exp3))

		println("\nEvaluated:")
		println(printer.prettyPrint(exp1) + " = " + ast.evaluateExpression(exp1))
		println(printer.prettyPrint(exp2) + " = " + ast.evaluateExpression(exp2))
		println(printer.prettyPrint(exp3) + " = " + ast.evaluateExpression(exp3))
		println(printer.prettyPrint(exp4) + " = " + ast.evaluateExpression(exp4))
	}
}