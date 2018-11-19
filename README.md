# Paint Calculator App
---
## Synopsis

The **Paint Calculator** is a hypothetical project that calculates how many gallons of paint would be required to paint a number of rooms.

## Requirements

* Python 3 (not 2)
* Pip

## What we're looking for

* Install Python / Pip
* Run application
* Write tests against the application. They do not have to be in Python, and should be in whatever language you are most comfortable with.
* Write a test plan for the application.  You are free to determine the structure and length of the test plan.
* You are allowed to change any of the source code as you see fit to make things easier for yourself. You are encouraged to fix any bugs you discover.
* Explain any problems you had while writing the tests, and what you did to make it easier. Pointing to localhost for the application is OK.
* What would be the proper level of execution for tests of this application?  If this differs from the testing level you wrote tests for, please explain where they would be better suited.

## Instructions

Because each applicant's code should be secret from one another, we should not submit it to the same repo.

1. Clone the repo (do not fork)
2. Create a new public repo on Github
3. Add the new repo as as a new remote
* `git remote add uptake <url>`
4. Initialize the new repo with what is cloned
* `git push uptake master`
5. Create a new branch off of master to put your changes on
6. Run the application locally
* `pip3 install -r requirements.txt`
* `python3 app/run.py`
7. Perform testing and debugging activities

## Submitting 

To make it easier on everybody, it's best if we use a PR to diff what work was completed.

1. Make any and all commits to your new branch and push the changes
* `git push uptake <branch>`
2. Create a PR to your new repo
3. Make sure you include your test plan and any automated tests, as well as update this README to instruct someone on how to run the tests
4. Include any other text in a file - which tests would be suited for a different level of execution, or any problems encountered...etc
5. Send the link to the PR

## Running Tests

Write instructions for how a user executes the automated tests you created.

# Run Automation Test
---
## Test Automation Paint Calculator

Web test automation project using Eclipse IDE, Java, Maven, Junit, TestNG, Selenium 3 and Page Object Model (POM)

## Test Subject

This is an automation challenge to test a Paint Calculator written in Python using a localhost url.

## Libraries and Frameworks

Version for some of these can be found in the POM file.

Selenium - Web automation<br/>
Maven - Build and package management<br/>
Junit and TestNG - Test execution and Reporting<br/>

## Tools

Eclipse IDE or IntelliJ IDEA.

## Programming Language

I'm using Java SE version jdk1.6.0

## Run Tests
The automation scripts were tested and ran on MacOS but it was not tested on Windows. However, the windows  chrome driver is available in the project. If it's throughing an error complaining about the driver location, make sure the chrome driver path is set correctly.
You can run the tests from __automation-test/src/test/junitTest__ select single or multiple tests by clicking right click on the test/s you want to run and select Run As Junit<br/> OR __automation-test/src/test/testNGTest__ select Run As TestNG.
You can find few screenshots under screenshot folder to see how to validate the tests and get the time execusion as well as passed and failed tests.

