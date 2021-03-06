/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Scala application project to get you started.
 * For more details take a look at the 'Building Java & JVM projects' chapter in the Gradle
 * User Manual available at https://docs.gradle.org/7.3/userguide/building_java_projects.html
 * This project uses @Incubating APIs which are subject to change.
 */

plugins {
    // Apply the scala Plugin to add support for Scala.
    scala

    // Apply the application plugin to add support for building a CLI application in Java.
    application

    // keep code nice and clean
    id("com.diffplug.spotless") version "6.0.0"

    //https://plugins.gradle.org/plugin/org.scoverage
    id("org.scoverage") version "7.0.0"
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    // Use Scala 2.13 in our library project
    implementation("org.scala-lang:scala-library:2.13.6")

    // This dependency is used by the application.
    implementation("com.google.guava:guava:30.1.1-jre")

    // https://mvnrepository.com/artifact/com.typesafe.scala-logging/scala-logging
    implementation("com.typesafe.scala-logging:scala-logging_3:3.9.4")

    // https://mvnrepository.com/artifact/ch.qos.logback/logback-classic
    implementation("ch.qos.logback:logback-classic:1.2.7")


}

testing {
    suites {
        // Configure the built-in test suite
        val test by getting(JvmTestSuite::class) {
            // Use JUnit4 test framework
            useJUnit("4.13.2")

            dependencies {
                // Use Scalatest for testing our library
                implementation("org.scalatest:scalatest_2.13:3.2.9")
                implementation("org.scalatestplus:junit-4-13_2.13:3.2.2.0")

                // Need scala-xml at test runtime
                runtimeOnly("org.scala-lang.modules:scala-xml_2.13:1.2.0")
            }
        }
    }
}

application {
    // Define the main class for the application.
    mainClass.set("org.snowi.aoc2020.App")
}

spotless {
    scala {
        // by default, all `.scala` and `.sc` files in the java sourcesets will be formatted

        scalafmt() // has its own section below

        licenseHeader("/* (C) stefan.devops@gmail.com 2021 */", "package") // or licenseHeaderFile
        // note the 'package ' argument - this is a regex which identifies the top
        // of the file, be careful that all of your sources have a package declaration,
        // or pick a regex which works better for your code
    }
}

