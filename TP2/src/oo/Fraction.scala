package ch.unige.hepia.tp

class Fraction(val num: Int, val den: Int) extends scala.math.Ordered [ Fraction ] {
	def invert(): Fraction = new Fraction(den,num)

	def *(b: Fraction): Fraction = new Fraction(this.num*b.num,this.den*b.den)

	def /(b: Fraction): Fraction = this * b.invert

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

	def simplify(): Fraction = {
		val commonDen = gcd(this.num, this.den);
		new Fraction(this.num / commonDen, this.den / commonDen)
	}

	def +(b: Fraction): Fraction = {
		//do the ppmc and stuff
		val newDen = this.den * b.den;
		val newNum = (this.num * (newDen / this.den)) + (b.num * (newDen / b.den))
		val result = new Fraction(newNum, newDen)
		result.simplify()
	}

	def -(b: Fraction): Fraction = this + (new Fraction(-1,1) * b)

	override def toString: String = s"$num / $den"

	def toDouble: Double = num.toDouble / den.toDouble

	override def compare(that: Fraction): Int = if ((this - that).toDouble < 0) -1 else 1;

	override def equals(that: Any): Boolean = {
		that match{
			case that: Fraction => this.simplify.num == that.simplify.num && this.simplify.den == that.simplify.den
			case _ => false
		}
	}
}

object Fraction {
	def fromDouble(value: Double): Fraction = {
		if (value < 0){
			new Fraction(-1,1) * Fraction.fromDouble(value)
		}else{
			var num = 1
			var den = 1

			while(num.toDouble / den.toDouble != value){
				if (num.toDouble / den.toDouble < value) {
					num += 1
					den -= 1
				}else {
					den += 1
				}
			}
			new Fraction(num,den)
		}
	}
}
