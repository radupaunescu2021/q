## Java Project with TestNG and Selenium WebDriver
This project demonstrates the use of TestNG for unit testing and Selenium WebDriver for automated web testing.

It includes examples of calculating Pascal's Triangle values and checking for balanced parentheses, as well as a Selenium WebDriver script for automated browser interactions.

## Prerequisites
**Java JDK 11 or higher.**

Maven (for dependency management and running the tests).

A compatible web browser (**Google Chrome**) for Selenium tests.

An IDE such as **IntelliJ IDEA** (optional, but recommended).

## Setup
Clone the Repository:

Clone this repository to your local machine or download the source code.

Install Dependencies:

Open the project in your IDE or navigate to the project directory in the command line.

Run ``` mvn clean install  ``` to install the required dependencies (**TestNG, Selenium, WebDriverManager**).

Web Browser Setup for Selenium:

Ensure you have the web browser installed (**Google Chrome**).

WebDriverManager will handle the driver setup for the browser.

## Running the Tests
Unit Tests:

**RUN from cmd line:**

Run ``` mvn test ``` to execute the unit tests written with TestNG.

These tests include checking Pascal's Triangle calculations and validating balanced parentheses functionality: **AppTest.java**

Selenium WebDriver Tests: **SeleniumTest.java**

The Selenium tests are configured to run as part of the TestNG test suite.


**RUN from Intellij IDE**

**right click on AppTest --->click run AppTest**

**right click on SeleniumTest--->click run SeleniumTest**


