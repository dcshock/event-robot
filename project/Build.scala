import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

    val appName         = "event-robot"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(
      "org.quartz-scheduler" % "quartz" % "2.1.6",
      javaCore, javaJdbc, javaEbean      
      // Add your project dependencies here,
    )

    val main = play.Project(appName, appVersion, appDependencies).settings(
      // Add your own project settings here      
    )

}
