/*
@author Kunal Soni
*/

package com.test.app;

import com.aventstack.extentreports.Status;
import common.TestBaseClass;
import org.testng.annotations.Test;

public class Sample extends TestBaseClass {

    @Test(groups = "Smoke")
    public void tc00VerifyURL() {

        test = extent.createTest("Verify URL", "Test the google link")
                .assignCategory("Functional_TestCase")
                .assignCategory("Positive_TestCase")
                .assignAuthor("Kunal");
        logger.info("Verify URL");

        webdriver.openURL("https://www.google.com");
        test.log(Status.INFO, "Open URL");
        logger.info("Open URL");
    }

    @Test
    public void tc01VerifyEnterText() {

        test = extent.createTest("Verify Search Box", "")
                .assignCategory("Functional_TestCase")
                .assignCategory("Positive_TestCase")
                .assignAuthor("Kunal");
        logger.info("Verify Search Box");

        webdriver.enterText(IConstants.txtName, "Automation testing");
        webdriver.clickOnButton(IConstants.btnGoogleSearch);
        test.log(Status.INFO, "Verify Search Box");
        logger.info("Verify Search Box");
    }
}
