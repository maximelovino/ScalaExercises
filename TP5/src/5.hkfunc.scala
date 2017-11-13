package ch.hepia.tpscala

/* Implémentez les fonctions suivantes. Vous ne pouvez utiliser que les
 *  méthode de 'List' vues dans les exercices précédents.
 */
object HKFunc {

  /* La fonction 'map' applique une fonction 'f' sur chaque élément de
   * la liste 'as'.  La liste résultat doit avoir la même longueur que
   * l'argument.
   */
  def map[A,B]( as: List[A] )( f: A=>B ): List[B] = {
    def internal(currentResult: List[B], list: List[A]):List[B] = list match {
      case Nil => currentResult.reverse //because with :: we add at the beginning, so we reverse at the end
      case a :: b => internal(f(a) :: currentResult, b)
    }
    internal(List[B](),as)
  }

  /* La fonction 'filter' utilise le prédicat 'f' pour déterminer quel
   * élément garder. Le résultat peut être vide, mais l'ordre doit
   * être préservé.
   */
  def filter[A]( as: List[A] )( f: A=>Boolean ): List[A] = {
    def internal(currentResult: List[A], sub: List[A]) : List[A] = sub match{
      case Nil => currentResult.reverse
      case a :: b => if (f(a)) internal(a :: currentResult, b) else internal(currentResult,b)
    }
    internal(List[A](), as)
  }

  /* Réduit une liste 'as' en utilisant une opération binaire 'f'.  On
   * supposera que 'as' n'est pas vide.
   */
  def reduce[A]( as: List[A] )( f: (A,A)=>A ): A = {

    def internal(currentResult: A, sub: List[A]): A = sub match{
      case Nil => currentResult
      case a :: b => internal(f(currentResult,a), b)
    }

    internal(as.head,as.tail)
  }

  /* Transforme une fonction 'f' en une fonction s'appliquant sur une
  *  liste. Utiliser la fonction 'map' définie ci-dessus
  */
  def lift[A,B]( f: A=>B ): List[A]=>List[B] = { (lst: List[A]) => map(lst)(f) }

  /* DIFFICILE. Transforme une liste 'as' au moyen de la fonction 'f'.
   * Cette fonction est appliquée à chaque élément de 'as' pour
   * produire une nouvelle liste (qui peut être vide). Le résultat est
   * la concaténation de chaque nouvelle liste en respectant l'ordre.
   */
  def bind[A,B]( as: List[A] )( f: A=>List[B] ): List[B] = {

    def internal(currentList: List[B], sub: List[A]): List[B] = sub match{
      case Nil => currentList
      case a :: b => internal(currentList ++ f(a), b)
    }
    internal(List[B](), as)
  }

}
