### Selenium Webdriver Gradle Demo
- Automation test suite for Web Application

### Key Feature
1. Java 8 as a language
2. Gradle as a Build Tool
3. :fire: [Selnium 4.0 Webdriver](https://www.selenium.dev/maven/)
4. :fire: [Extent Spark Report](https://github.com/extent-framework/extentreports-java/wiki/A-Complete-Example) 
5. :fire: [Log4j2](https://logging.apache.org/log4j/2.x/manual/configuration.html)
6. Cross Browser Testing - Chrome, Firefox, Safari
7. [WebDriverManager](https://github.com/bonigarcia/webdrivermanager)

### Setup Project on Machine for work 

- Install [IntelliJ IDEA](https://www.jetbrains.com/idea/)
- Install [java](https://www.java.com/en/download/help/mac_10_10.xml) 
- Install [jdk & jre](https://docs.aws.amazon.com/corretto/latest/corretto-8-ug/downloads-list.html)
- As it is a gradle project, no other dependencies need to download. All the dependencies that required for project is already added.


### After setting up IntelliJ & Java on your machine 

- Download the project from git and unzip it or take a [git clone](https://www.atlassian.com/git/tutorials/setting-up-a-repository/git-clone).
- Open IntelliJ
- Import projects pop up will open
- Browse the project from your local machine.

### Run Project and Get a Report & logs

- Run TestNg Suite
- wait till project run completly. Once it finished.
- Expand Report folder and you will find latest report there with latest date and time.
- Click on Report and open with web-browser
- Find logs in log folder

### Running test suites from the command line

- CD into the directory containing the test suite for the application you want. `cd com.novohq.app`
- `Run $ gradle clean test` to run full suite
- `Run $ gradle clean smokeTests` to run smoke testcases
