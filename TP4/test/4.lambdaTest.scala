package ch.hepia.tpscala

import org.scalatest.FunSuite

import Predicates._

class PredicatesSuite4 extends FunSuite {

  val big = (_:Int) >= 100
  val even = (_:Int) % 2 == 0

  val small = not[Int]( big )
  val bae = and[Int]( big, even )
  val boe = or[Int]( big, even )

  test("Predicate Evaluation") {
    assert( big(200) )
    assert( ! big(19) )
    assert( even(200) )
    assert( ! even(201) )
  }

  test("Predicate negation") {
    assert( small(19) )
    assert( !small( 200 ) )
  }

  test("Predicate AND") {
    assert( bae( 200 ) )
    assert( !bae( 201 ) )
  }

  test("Predicate OR") {
    assert( boe( 201 ) )
    assert( !boe( 19 ) )
  }

  val mul3 = (_:Int ) % 3 == 0
  val ps = List( big, even, mul3 )

  test("Predicates FORALL") {
    assert( forall[Int]( ps )( 402 ) )
    assert( ! forall[Int]( ps )( 200 ) )
  }

  test("Predicates EXISTS") {
    assert( exists[Int]( ps )( 18 ) )
    assert( ! exists[Int]( ps )( 1 ) )
  }

}
