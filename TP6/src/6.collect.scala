package ch.hepia.tpscala


/* Implémentez les fonctions suivantes. 
 */
object Collect {

  case class Album(title: String, artist: String, year: Int)

  case class Duration(minutes: Int, seconds: Int)

  case class Track(title: String, duration: Duration)

  val albums = List(
    Album("Mit Gas", "Tomahawk", 2003),
    Album("Pork Soda", "Primus", 1993),
    Album("Brown Album", "Primus", 1997),
    Album("Distraction Pieces", "Scroobius Pip", 2011)
  )

  val tracks = Map(
    "Mit Gas" -> List(
      Track("Mayday", Duration(3, 32))
    ),
    "Pork Soda" -> List(
      Track("DMV", Duration(4, 58)),
      Track("Mr. Krinkle", Duration(5, 27))
    ),
    "Brown Album" -> List(
      Track("Fisticuffs", Duration(4, 25)),
      Track("Camelback Cinema", Duration(4, 0)),
      Track("Kalamazoo", Duration(3, 31))
    ),
    "Distraction Pieces" -> List(
      Track("Let 'Em Come", Duration(4, 25)),
      Track("Domestic Silence", Duration(3, 58))
    )
  )

  /* Retourne la liste de morceaux associés à un artiste */
  def tracksOf(artist: String): List[Track] = {
    //albums.filter(_.artist == artist).map(_.title).flatMap(tracks)
    albums.filter(_.artist == artist).flatMap(a => tracks(a.title))
  }

  /* Retourne la liste de tous les morceaux de moins de 4 minutes */
  def shortTracks: List[Track] = {
    tracks.values.toList.flatten.filter(_.duration.minutes < 4)
  }

  /* Retourne les titres des morceaux antérieurs à une année */
  def titlesBefore(year: Int): List[String] = {
    albums.filter(_.year < year).flatMap(a => tracks(a.title)).map(_.title)
  }

  /* Calcule la durée totale de tous les morceaux disponibles.
     REMARQUE: ont veut que les secondes soient inférieures à 60 mais les
     minutes peuvent dépasser ce total.
   */
  def totalDuration: Duration = {
    tracks
      .values
      .toList
      .flatten
      .map(_.duration)
      .reduceLeft((a, b) => Duration(a.minutes + b.minutes + ((a.seconds + b.seconds) / 60), (a.seconds + b.seconds) % 60))
  }


}
