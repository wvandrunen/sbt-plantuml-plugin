name := "scalasig-example"

version := "0.1"

organization := "com.julianpeeters"

//scalaVersion := "2.9.1"
scalaVersion := "2.11.5"

resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"

libraryDependencies ++= Seq(
"org.scala-lang" % "scalap" % "2.11.5",
"org.scala-lang" % "scala-compiler" % "2.11.5",
"org.scala-lang" % "scala-reflect" % "2.11.5"
)
