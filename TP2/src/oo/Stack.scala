package ch.unige.hepia.tp
import java.util.ArrayList

class Stack[A]() {
	private val list: ArrayList[A] = new ArrayList()

	def push(value: A) = this.list.add(value)

	def isEmpty(): Boolean = this.list.isEmpty()

	def size(): Int = this.list.size()

	//what if empty?
	def pop(): A = this.list.remove(this.list.size()-1)

	def swap() = {
		if (this.size() >= 2) {
			val last: A = this.pop()
			val beforeLast: A = this.pop()
			this.push(last)
			this.push(beforeLast)
		}
	}

	//Not needed, it's here for debugging purposes
	override def toString(): String =  list.toString
}
