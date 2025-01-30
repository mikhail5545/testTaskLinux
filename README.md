This repository contains test task for Idea Platform.
Main goal of the project is to read json file and calculate the necessary data.
It uses Jackson(jackson-databind) - https://javadoc.io/doc/com.fasterxml.jackson.core/jackson-databind/latest/index.html to serialize json to Java entities.

Run on Linux with .jar file with dependencies:
$ java -jar path/to/task-1.0-SNAPSHOT-jar-with-dependencies.jar

Build on Linux with maven:
$ mvn -f path/to/pom.xml clean install -U
