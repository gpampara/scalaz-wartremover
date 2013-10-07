package scalaz.wartremover

import org.brianmckenna.wartremover.{WartTraverser, WartUniverse}

object ListWarts extends WartTraverser {
  def apply(u: WartUniverse): u.Traverser = {
    import u.universe._

    val listSymbol = rootMirror.staticClass("scala.collection.immutable.List")
    val MaxName: TermName = "max"
    val MinName: TermName = "min"

    new Traverser {
      override def traverse(tree: Tree) {
        tree match {
          case Select(left, MaxName) =>
            u.error(tree.pos, "Using List#max is disabled - use NonEmptyList#max instead")
          case Select(left, MinName) =>
            u.error(tree.pos, "Using List#min is disabled - use NonEmptyList#min instead")
          case _ =>
        }
        super.traverse(tree)
      }
    }
  }
}
