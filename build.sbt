name := "fastnfluid"

version := "1.0"

lazy val `fastnfluid` = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq( javaJdbc ,  cache , javaWs )

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )  

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"

// https://mvnrepository.com/artifact/org.milyn/milyn-smooks-all
// https://mvnrepository.com/artifact/org.milyn/milyn-smooks-javabean
// https://mvnrepository.com/artifact/org.milyn/milyn-commons
// https://mvnrepository.com/artifact/org.milyn/milyn-smooks-csv
// https://mvnrepository.com/artifact/org.freemarker/freemarker

libraryDependencies += "org.milyn" % "milyn-smooks-core" % "1.7.0"
libraryDependencies += "org.milyn" % "milyn-smooks-templating" % "1.7.0"
libraryDependencies += "org.milyn" % "milyn-smooks-javabean" % "1.7.0"
libraryDependencies += "org.milyn" % "milyn-commons" % "1.7.0"
libraryDependencies += "org.milyn" % "milyn-smooks-csv" % "1.7.0"
libraryDependencies += "org.milyn" % "milyn-smooks-json" % "1.7.0"

libraryDependencies += "org.freemarker" % "freemarker" % "2.3.23"
