package scalaz.wartremover
package test

import org.scalatest.FunSuite

import org.brianmckenna.wartremover.test._
import scalaz.wartremover.ListWarts

class ListWartsTest extends FunSuite {
  test("can't use List#max on non-empty list") {
    val result = WartTestTraverser(ListWarts) {
      List(1,2,3).max
    }
    assert(result.errors == List("Using List#max is disabled - use NonEmptyList#max instead"))
    assert(result.warnings == List.empty)
  }

  test("can't use List#max on empty list") {
    val result = WartTestTraverser(ListWarts) {
      Nil.max
    }
    assert(result.errors == List("Using List#max is disabled - use NonEmptyList#max instead"))
    assert(result.warnings == List.empty)
  }

   // test("can't use List#min on non-empty list") {
   //   val result = WartTestTraverser(ListWarts) {
   //     List(1,2,3).min
   //   }
   //   assert(result.errors == List("Using List#min is disabled - use NonEmptyList#min instead"))
   //   assert(result.warnings == List.empty)
   // }

  // test("can't use List#min on empty list") {
  //   val result = WartTestTraverser(ListWarts) {
  //     Nil.min
  //   }
  //   assert(result.errors == List("Using List#min is disabled - use NonEmptyList#min instead"))
  //   assert(result.warnings == List.empty)
  // }
}
