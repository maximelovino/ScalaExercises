package ch.hepia.tpscala.fp

/*

 * Implémenter les fonctions suivantes en suivant les commentaires.
 * Respectez également les consignes suivantes:
 *  - Toutes les fonctions doivent être pures
 *  - Tout doit être immutable (val au lieu de var)
 *  - Utiliser la recursion terminale si possible
 *  - Utiliser le pattern matching si possible
 */
object Serie3 {

  /*
   * Donne la longueur d'une liste. Votre implémentation ne peut
   *  utiliser aucune fonction de List excepté isEmpty()
   */
  def len[A](as: List[A]): Int = {
    def lenRec(currentVal: Int, subList: List[A]): Int = subList match {
      case Nil => currentVal //here it's empty
      case _ :: b => lenRec(currentVal + 1, b) //here with _ we ignore the first element and after the :: we have the tail then
    }

    lenRec(0, as)
  }

  /*
   * Inverse une liste. Votre implémentation ne peut
   * utiliser aucune fonction de List excepté:
   *    - isEmpty
   *    - ::
   *    - head
   *    - tail
   */
  def rev[A](as: List[A]): List[A] = {
    def revRec(currentNewList: List[A], subList: List[A]): List[A] = subList match {
      case Nil => currentNewList
      case a :: b => revRec(a :: currentNewList, b)
    }

    revRec(List(), as)
  }

  /*
   * Somme une liste. Votre implémentation ne peut
   * utiliser aucune fonction de List excepté: -
   *    - isEmpty
   *    - head
   *    - tail
   */
  def sum(xs: List[Int]): Int = {
    def sumRec(currentSum: Int, subList: List[Int]): Int = subList match {
      case Nil => currentSum
      case a :: b => sumRec(currentSum + a, b)
    }

    sumRec(0, xs)
  }

  /*
   *  Retourne vrai si et seulement si la liste xs ne
   *  comprend que des valeures vraies. Votre implémentation
   *  ne peutcutiliser aucune fonction de List excepté:
   *    - isEmpty
   *    - head
   *    - tail
   */
  def and(xs: List[Boolean]): Boolean = {
    def andRec(subList: List[Boolean]): Boolean = subList match {
      case Nil => true
      case a :: b => if (!a) false else andRec(b)
    }

    andRec(xs)
  }

  /*
   *  Applatit une liste. Votre implémentation
   *  ne peut utiliser aucune fonction de List excepté:
   *   - isEmpty
   *   - head
   *   - tail
   *   - ++
   */
  def flat[A](las: List[List[A]]): List[A] = {
    def flatRec(currentList: List[A], subList: List[List[A]]): List[A] = subList match {
      case Nil => currentList
      case a :: b => flatRec(currentList ++ a, b)
    }

    flatRec(List[A](), las)
  }

  /*
   *  Retourne vrai si la liste a un nombre pair d'éléments
   *  Ne pas utiliser:
   *   - size
   *   - isEmpty
   */
  def even[A](as: List[A]): Boolean = {
    len(as) % 2 == 0
  }

}
