### automation-webapp
Automation test suite for WebApp

### Running test suites from the command line
-  Run `$ brew install maven` to install maven onto your machine
-  CD into the directory containing the test suite for the application you want, e.g. `cd com.novohq.webapp.dev`
-  Run `$ mvn clean test -DsuiteFile=testng.xml`


#### Examining the generated test report
- Wait until the test suite has executed successfully
- Open the 'reports' directory in the application's test suite directory
- The TestNG framework generates an HTML report per test run in this directory, which you can open in any webbrowser


### Setup Project on Machine for work 

- Install IntelliJ IDEA
https://www.jetbrains.com/idea/

- Install java 
https://www.java.com/en/download/help/mac_10_10.xml

- Install jdk & jre 
https://docs.aws.amazon.com/corretto/latest/corretto-8-ug/downloads-list.html

- As it is a gradle project, no other dependencies need to download. All the dependencies that required for project is already added.


### After setting up IntelliJ & Java on your machine 

- Download the project from git and unzip it or take a git clone.
- Open IntelliJ
- Import projects pop up will open
- Browse the project from your local machine.


### Run Project and Get a Report 
- Expand Build folder and find testng.xml
- Right click on `testng.xml` and Run as TestNg Suite
- wait till project run completly. Once it finished.
- Expand Report folder and you will find latest report there with latest date and time.
- Click on Report and open with web-browser
