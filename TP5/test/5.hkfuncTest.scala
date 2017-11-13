package ch.hepia.tpscala

import org.scalatest.FunSuite

import HKFunc._

class HKFunc5Suite extends FunSuite {

  val i0 = List[Int]()
  val is = List( 1, 2, 3, 4 )

  test("map") {
    assert( map( i0 )(_ + 1 ) == i0 )
    assert( map( is )(_ + 1 ) == List( 2, 3, 4, 5 ) )
    assert( map( is )(_ * 2 ) == List( 2, 4, 6, 8 ) )
  }

  test("filter") {
    assert( filter( i0 )(_ % 2 == 0 ) == i0 )
    assert( filter( is )(_ % 2 == 0 ) == List( 2, 4 ) )
  }

  test("reduce") {
    assert( reduce( is )( _ + _ ) == is.sum )
    assert( reduce( is )( _ * _ ) == 24 )
  }

  test("lift") {
    val f = (_:Int) + 1
    val g = (_:Int) * 2
    val id = lift[Int,Int]( identity )
    assert( id(i0) == i0 )
    assert( id(is) == is )
    val h1 = lift( f andThen g )
    val h2 = lift(f) andThen lift(g)
    assert( h1(i0) == h2(i0) )
    assert( h1(is) == h2(is) )
  }

  test("bind") {
    val k = (i:Int) => if( i%2 == 0 ) List( -i, i ) else Nil
    val l = (i:Int) => List( i, i )
    assert( bind( i0 )( k ) == i0 )
    assert( bind( is )( k ) == List( -2, 2, -4, 4 ) )
    assert( bind( is )( l ) == List( 1, 1, 2, 2, 3, 3, 4, 4 ) )
  }


}
