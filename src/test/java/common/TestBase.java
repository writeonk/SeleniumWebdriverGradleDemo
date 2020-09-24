/*
@author Kunal Soni
*/

package common;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import library.WebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static Properties properties;
    public static org.openqa.selenium.WebDriver driver;
    public static WebDriver webdriver = new WebDriver();
    public ExtentTest test;

    public static Date date = new Date();
    public static SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
    public static String dt = formatter.format(date);
    public static FileReader fileReader;
    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest ReportLog;
    public static String reportDestination = "reports/report_" + dt + ".html";
    protected final Logger logger = LogManager.getLogger(getClass());

    @BeforeSuite(alwaysRun = true)
    public void setUp() throws IOException {

        propertiesLoad();
        extentReport();
        openBrowser();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() throws EncryptedDocumentException {

        driver.quit();
        extent.flush();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {

        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName());
            test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable());

        } else if (result.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP, "Test Case SKIPPED IS " + result.getName());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, "Test Case PASSED IS " + result.getName());
        }
    }

    public void extentReport() {

        htmlReporter = new ExtentHtmlReporter(reportDestination);

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("Browser Name", properties.getProperty("BrowserName"));
        extent.setSystemInfo("Environment", properties.getProperty("Environment"));
        extent.setSystemInfo("Base URL", properties.getProperty("URL"));
        extent.setSystemInfo("User Name", properties.getProperty("UserName"));
        extent.setSystemInfo("User Email", properties.getProperty("UserEmail"));

        htmlReporter.config().setDocumentTitle("Automation Testing Report");
        htmlReporter.config().setReportName("Automation Test Suite");
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
    }

    public void propertiesLoad() throws IOException {

        try {
            fileReader = new FileReader("config/QA.properties");
            properties = new Properties();
            properties.load(fileReader);

        } catch (FileNotFoundException ex) {
            ReportLog.info("*************************************************");
            ReportLog.info("Property file you are looking for does not exist.");
            ReportLog.info("*************************************************");
        }
    }

    public void openBrowserForLinux() {

        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        driver = new ChromeDriver();
        System.out.println(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void openBrowser() {

        if (System.getProperty("os.name").equalsIgnoreCase("Mac OS X")) {
            if (properties.getProperty("BrowserName").equalsIgnoreCase("chrome")) {

                System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
                System.setProperty("webdriver.chrome.logfile", "./logs/chromeLogs.txt");
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            } else if (properties.getProperty("BrowserName").equalsIgnoreCase("firefox")) {

                System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver");
                System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "./logs/FirefoxLogs.txt");
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            } else if (properties.getProperty("BrowserName").equalsIgnoreCase("safari")) {

                driver = new SafariDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            } else {

                ChromeOptions options = new ChromeOptions();
                options.setHeadless(true);
                System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
                driver = new ChromeDriver(options);
            }

        } else if (properties.getProperty("BrowserName").equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
            System.setProperty("webdriver.chrome.logfile", "./logs/chromeLogs.txt");
            driver = new ChromeDriver();
            System.out.println(driver);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } else {

            System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
            System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "./logs/FirefoxLogs.txt");
            driver = new FirefoxDriver();
            System.out.println(driver);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
    }

    public void openURL(String url) {

        driver.get(url);
    }

}

