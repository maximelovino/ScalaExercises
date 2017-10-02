package ch.unige.hepia.tp

object TP2 extends App {
	println("Hello world");

	println("FRACTION TIME")
	val a = new Fraction(1,2)
	val b = new Fraction(1,3)
	val c = a / b
	println(c)
	println(c.toDouble)
	val sum = a + b
	println(sum)
	println(sum.toDouble)
	val d = new Fraction(2,4)
	println(d.simplify)
	println(a == d)
	println(a == b)
	val doubleValue = 1.toDouble / 3.toDouble
	val tolerance = 1E-6
	println(s"Getting value of $doubleValue with tolerance $tolerance")
	val frac = Fraction.fromDouble(doubleValue)
	println(frac)

	println("STACK TIME")
	var myStack = new Stack[Int]

	for (i <- 0 to 10){
		myStack.push(i)
	}

	println(myStack)
	myStack.swap()
	println(myStack)

	while(!myStack.isEmpty){
		//unwrap, if successful, print
		for {
			value <- myStack.pop
		} {
			println(value)
		}
	}
}
