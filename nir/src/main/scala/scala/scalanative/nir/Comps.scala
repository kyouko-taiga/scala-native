package scala.scalanative
package nir

/** A comparison operator two values. */
sealed abstract class Comp {

  /** A textual representation of `this`. */
  final def show: String = nir.Show(this)

  /** Returns a NIR operation comparing `lhs` to `rhs` as values of type `ty`
   *  with the operator represented by `this`.
   *
   *  `this` is an operator that is defined for two values of type `ty`.
   */
  final def apply(ty: Type, lhs: Val, rhs: Val): Op = {
    Op.Comp(this, ty, lhs, rhs)
  }

}

object Comp {

  /** An integer comparison operator. */
  sealed abstract class Icmp extends Comp

  case object Ieq extends Icmp
  case object Ine extends Icmp
  case object Ugt extends Icmp
  case object Uge extends Icmp
  case object Ult extends Icmp
  case object Ule extends Icmp
  case object Sgt extends Icmp
  case object Sge extends Icmp
  case object Slt extends Icmp
  case object Sle extends Icmp

  /** A floating point comparison operator. */
  sealed abstract class Fcmp extends Comp

  case object Feq extends Fcmp
  case object Fne extends Fcmp
  case object Fgt extends Fcmp
  case object Fge extends Fcmp
  case object Flt extends Fcmp
  case object Fle extends Fcmp

}
