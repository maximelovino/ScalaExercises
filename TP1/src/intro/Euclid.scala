package ch.unige.hepia.tp

object Euclid extends App {

	// Implémenter correctement cette fonction
	def gcd( i: Int, j: Int ): Int = {
		var a = i
		var b = j
		while (b != 0) {
			val t = b
			b = a % b
			a = t
		}
		a
	}

	println("GCD TIME")
	println( gcd( 100, 30 ) )  //=> 10
	println( gcd( 30, 100 ) )  //=> 10
	println( gcd( 12, 3732 ) ) //=> 12
	println( gcd( 1, 3732 ) )  //=> 1
	println( gcd( 25, 3732 ) ) //=> 1
}
