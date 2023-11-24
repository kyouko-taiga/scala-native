package scala.scalanative
package nir

/** A binary operation. */
sealed abstract class Bin {

  /** A textual representation of `this`. */
  final def show: String = nir.Show(this)

  /** Returns a NIR operation applying the operator represented by `this` to
   *  `lhs` and `rhs` as values of type `ty`.
   *
   *  `this` is an operator that is defined for two values of type `ty`.
   */
  final def apply(ty: Type, lhs: Val, rhs: Val): Op.Bin = {
    Op.Bin(this, ty, lhs, rhs)
  }

}

object Bin {

  case object Iadd extends Bin
  case object Fadd extends Bin
  case object Isub extends Bin
  case object Fsub extends Bin
  case object Imul extends Bin
  case object Fmul extends Bin
  case object Sdiv extends Bin
  case object Udiv extends Bin
  case object Fdiv extends Bin
  case object Srem extends Bin
  case object Urem extends Bin
  case object Frem extends Bin
  case object Shl extends Bin
  case object Lshr extends Bin
  case object Ashr extends Bin
  case object And extends Bin
  case object Or extends Bin
  case object Xor extends Bin

}
