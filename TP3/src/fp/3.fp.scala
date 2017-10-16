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
   def len[A]( as: List[A] ): Int = {
	 def lenRec(currentVal: Int, subList: List[A]): Int = {
		 if (!subList.isEmpty)
		   lenRec(currentVal + 1, subList.tail)
		 else
		   currentVal
	 }
	 lenRec(0,as)
   }

  /*
   * Inverse une liste. Votre implémentation ne peut
   * utiliser aucune fonction de List excepté:
   *    - isEmpty
   *    - ::
   *    - head
   *    - tail
   */
  def rev[A]( as: List[A] ): List[A] = {
	  def revRec(currentNewList: List[A], subList: List[A]): List[A] = {
		  if (!subList.isEmpty)
		  	revRec(subList.head :: currentNewList, subList.tail)
		  else
		  	currentNewList
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
  def sum( xs: List[Int] ): Int = {
	  def sumRec(currentSum: Int, subList: List[Int]): Int = {
		  if (!subList.isEmpty)
		  	sumRec(currentSum + subList.head, subList.tail)
		  else
		  	currentSum
	  }
	  sumRec(0,xs)
  }

  /*
   *  Retourne vrai si et seulement si la liste xs ne
   *  comprend que des valeures vraies. Votre implémentation
   *  ne peutcutiliser aucune fonction de List excepté:
   *    - isEmpty
   *    - head
   *    - tail
   */
  def and( xs: List[Boolean] ): Boolean = ???

  /*
   *  Applatit une liste. Votre implémentation
   *  ne peut utiliser aucune fonction de List excepté:
   *   - isEmpty
   *   - head
   *   - tail
   *   - ++
   */
  def flat[A]( las: List[List[A]] ): List[A] = ???

  /*
   *  Retourne vrai si la liste a un nombre pair d'éléments
   *  Ne pas utiliser:
   *   - size
   *   - isEmpty
   */
  def even[A]( as: List[A] ): Boolean = ???

}
