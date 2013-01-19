import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "event-robot"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(
      "org.quartz-scheduler" % "quartz" % "2.1.6"      
      // Add your project dependencies here,
    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = JAVA).settings(
      // Add your own project settings here      
    )

}
