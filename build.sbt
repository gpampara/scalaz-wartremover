scalaVersion := "2.10.3"

libraryDependencies := Seq(
  "org.brianmckenna" % "wartremover_2.10.2" % "0.4",
  "org.scalatest" %% "scalatest" % "1.9.1" % "test"
)

resolvers ++= Seq(Resolver.sonatypeRepo("releases"), "Local Maven Repository" at "file://"+Path.userHome.absolutePath+"/.m2/repository")
