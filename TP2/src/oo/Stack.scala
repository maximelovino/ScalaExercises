package ch.unige.hepia.tp
import java.util.ArrayList

class Stack[A] {
	private val list: ArrayList[A] = new ArrayList()

	def push(value: A) = this.list.add(value)

	def isEmpty(): Boolean = size == 0

	def size(): Int = this.list.size()

	def pop(): Option[A] = {
		if (this.isEmpty) {
			None
		}else{
			Some(this.list.remove(size-1))
		}
	}

	def swap() = {
		/*
		Another method without any test or individual match, this will unwrap the optional, and then only if both are ok, will do the pushes
		*/
		for {
			last <- pop()
			beforeLast <- pop()
		} {
			push(last)
			push(beforeLast)
		}
	}

	//Not needed, it's here for debugging purposes
	override def toString(): String =  list.toString
}
