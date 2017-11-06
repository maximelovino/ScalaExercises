package ch.hepia.tpscala

/*
 * Implémenter les fonctions suivantes en suivant les commentaires.
 */

object Predicates {

  type P[A] = A=>Boolean

  /*
   * La méthode 'not' retourne un nouveau prédicat dont le résultat
   * est toujours la négation du résultat de l'argument.
   */
  def not[A]( p: (A)=>Boolean ): (A)=>Boolean = { (a:A) =>
    !p(a)
  }

  /*
   * La méthode 'and' retourne un nouveau prédicat dont le résultat
   * est toujours la conjonction des résultats des deux arguments.
   */
  def and[A]( p1: (A)=>Boolean, p2: (A)=>Boolean ): (A)=>Boolean = { (a:A) =>
    p1(a) && p2(a)
  }

  /*
   * La fonction 'or' retourne un nouveau prédicat dont le résultat
   * est toujours la disjonction des résultats des deux arguments.
   */
  def or[A]( p1: (A)=>Boolean, p2: (A)=>Boolean ): (A)=>Boolean = { (a:A) =>
    p1(a) || p2(a)
  }

  /*
   * La fonction 'exists' retourne un nouveau prédicat dont le
   * résultat est vrai si au moins un des prédicat de l'argument est
   * vrai.
   */
  def exists[A]( ps: List[(A)=>Boolean] ): (A)=>Boolean = { (a:A) =>
    ps.exists((p) => p(a))
  }

  /*
   * La fonction 'forall' retourne un nouveau prédicat dont le
   * résultat est vrai si et seulement si tous les prédicats de
   * l'argument sont vrais.
   */
  def forall[A]( ps: List[(A)=>Boolean] ): (A)=>Boolean = { (a:A) =>
    ps.forall((p) => p(a))
  }


}
