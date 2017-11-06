organization := "ch.hepia"

name := "tpscala"

version := "2017A"

scalaVersion := "2.12.3"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.0.0" % "test"
)

fork in run := true

javaOptions in run += "-Xmx2G"

scalacOptions ++= Seq( "-deprecation", "-unchecked", "-Xfatal-warnings", "-Xlint" )


scalaSource in Compile := baseDirectory.value / "src"

javaSource in Compile := baseDirectory.value / "java" / "src" 

scalaSource in Test := baseDirectory.value / "test"

    
