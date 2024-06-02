# Flight Search By Google
This repository uses Serenity BDD to perform automation tests on the Google Flight search functionality.

Currently, this project only supports testing the round trip and multi-city (up to 3 destinations) functionalities.
Please refer to the feature files for configuring the test cases with different data table values.

## Set up ##

* Java 11 or higher
* Apache Maven 3.9.6 or higher
* Google Chrome installed

## Executing the tests ##

You can run this project with a system that satisfies the above setup requirements by following the steps below.

* Download the code into the computer system
* Open command prompt
* Goto the project root directory
* Run the below command
  mvn clean verify

Note: 
* 'demo' tag has been used inside the feature and runner file, hence no need to specify tags for maven execution. 
* This project can be configured with Jenkins as well, please refer Jenkins manual to configure this project.

## Generating the reports ##

By default, Serenity BDD will create reports with an aggregate function and when you run the maven build command (mvn clean verify), the aggregate function is called within to generate the reports.

Hence, the reports will be ready under **/target/site/serenity** folder upon completion of maven build execution.

### Result files ###

Reports come in two variants.

* index.html file (Detailed report file used for analysing the test cases details)
* serenity-summary.html file (Summary report with high level details on the test execution)
  
