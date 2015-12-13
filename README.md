# Happy Numbers

This project contains functionality for testing if numbers are *happy* (see the [Wikipedia page](https://en.wikipedia.org/wiki/Happy_number) for more information), as well as a console application for printing all the happy numbers up to a certain limit.

## Build instructions

To build the project, clone the repository and simply run the supplied Gradle wrapper, `gradlew` (`gradlew.bat` on Windows). Note that you'll need JDK8 in order to build this project.

Tests are run by running `gradlew test`.

## How to run

The console application can be run through Gradle as well, by running `gradlew run`. Note that the environment variable `JAVA_HOME` needs to exist and point at the JDK folder.

Running the application will print all the happy numbers from 1 to 1000 (inclusive).
