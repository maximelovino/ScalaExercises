package ch.hepia.tpscala.fp

import org.scalatest.FunSuite


class FPIntroSuite extends FunSuite {

  import Serie3._

  val is = List( 1, 2, 3, 4, 5 )
  val bs1 = List( true, true, false, true )
  val bs2 = List( true, true, true )
  val las1 = List.empty[List[Int]]
  val las2 = List( List(1,2), List(3), List(4,5) )

  test( "List length" ) {
    assert( len(is) == 5 )
    assert( len( las1 ) == 0 )
    assert( len( bs1 ) == 4 )
  }

  test( "List flatten" ) {
    assert( flat(las1) == 0 )
    assert( flat(las1) == Nil )
    assert( flat(las2) == is )
  }

  test( "List sum" ) {
    assert( sum(is) == 15 )
    assert( sum(flat(las2)) == sum(is) )
  }

  test( "List reverse" ) {
    assert( rev(is) == List( 5, 4, 3, 2, 1 ) )
    assert( rev(las1) == las1 )
    assert( rev(las2) == List( List(4,5), List(3), List(1,2) ) )
    assert( rev( bs1 ) == List( true, false, true, true ) )
    assert( rev( bs2 ) == bs2 )
  }

  test( "List even" ) {
    assert( even( is ) == false )
    assert( even( bs1 ) == true )
    assert( even( las1 ) == true )
  }

}
