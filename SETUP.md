Setting up the environment
-----------------------------------

 * Install git
 * Clone example project:
```
git clone https://github.com/RayRoestenburg/scala-io-exercise-1.git
git clone https://github.com/RayRoestenburg/scala-io-exercise-2.git
git clone https://github.com/RayRoestenburg/scala-io-exercise-3.git
git clone https://github.com/RayRoestenburg/scala-io-exercise-4.git
git clone https://github.com/RayRoestenburg/scala-io-exercise-5.git
```

 * Install sbt. Please use version 0.13.5. See http://www.scala-sbt.org/release/docs/Getting-Started/Setup.html
 * Configure SBT, which runs on the JVM, to have some more memory than the default 64Mb:
```
export SBT_OPTS = "-Dfile.encoding=UTF8 -Xmx2048M -XX:MaxPermSize=1024m -XX:+UseConcMarkSweepGC -XX:+CMSClassUnloadingEnabled "
```
The MaxPermSize should be omitted when using Java 8.
 * Install your IDE/Editor of choice:
 * IntelliJ
     * (download from https://www.jetbrains.com/idea/download/)
     * Setup sbt-idea plugin globally:
       Add this code to your `~/.sbt/0.13/plugins/plugins.sbt` file:
       ```
       addSbtPlugin("com.github.mpeltonen" % "sbt-idea" % "1.6.0")
       ```
 * Sublime Text 3
     * (download from http://www.sublimetext.com/3)
     * Setup sbt-sublime plugin globally:
       Add this code to your `~/.sbt/0.13/plugins/plugins.sbt` file:
       ```
       addSbtPlugin("com.orrsella" % "sbt-sublime" % "1.0.9")
       ```
 * Scala IDE (Eclipse)
     * (download from http://scala-ide.org/)
     * Setup sbt-eclipse plugin globally:
       Add this code to your `~/.sbt/0.13/plugins/plugins.sbt` file:
       ```
       addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "2.5.0")
       ```
 * Start `sbt` in the project directory
 * Generate a project for your IDE/Editor of choice:
 * Type `gen-idea` to generate Intellij IDEA project
 * Type `gen-sublime` to generate Sublime Text project
 * Type `eclipse` to generate Eclipse project
 * Run `test` in sbt to get started
 * Verify that the tests work
