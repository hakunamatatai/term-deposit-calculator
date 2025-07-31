# Term Deposit Calculator

# Pre-requisites
* Java 1.8/1.11
* Maven 3.6+
* Junit 5 (import automatically)


# How to build 
Open your terminal and navigate to the project root directory (where pom.xml is located), 
then run:
  
mvn clean package

This will compile the source code and package it into a jar file under the target/ directory, 
such as: 

target/term-deposit-cal-1.0.jar


# How to run the CLI program
From the project root, run the following command:

java -cp target/term-deposit-cal-1.0.jar com.ferocia.Main


# How to execute the unit tests

 `mvn clean test` will execute the unit test cases.

# code structure
model - Input parameter definitions

service - Core calculation logic

cli - Command line interaction

validator - parameter validator

Main - Program entry point

test - Unit tests
