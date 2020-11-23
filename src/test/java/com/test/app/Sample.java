/*
@author Kunal Soni
*/

package com.test.app;

import com.aventstack.extentreports.Status;
import common.TestBaseClass;
import org.testng.annotations.Test;

public class Sample extends TestBaseClass {

    @Test(groups = "Smoke")
    public void tc01VerifyURL() {

        test = extent.createTest("Verify URL", "Verify the google link")
                .assignCategory("Functional_TestCase")
                .assignAuthor("Kunal");
        logger.info("Verify URL");

        webdriver.openURL("https://www.google.com");
        test.log(Status.INFO, "Open URL");
        logger.info("Open URL");
    }

    @Test
    public void tc02VerifySearchBoxAndLink() {

        test = extent.createTest("Verify Search Box And Link", "Verify the google search box and flipkart link")
                .assignCategory("Functional_TestCase")
                .assignAuthor("Kunal");
        logger.info("Verify Search Box And Link");

        webdriver.enterText(IConstants.txtName, "Flipkart");
        test.log(Status.INFO, "Enter word");
        logger.info("Enter word");

        webdriver.list(IConstants.consoleList);
        test.log(Status.INFO, "Print the google console result");
        logger.info("Print the google console result");

        webdriver.waitForElementClickable(IConstants.btnGoogleSearch);
        webdriver.clickOnButton(IConstants.btnGoogleSearch);
        test.log(Status.INFO, "Click on Search Box");
        logger.info("Click on Search Box");

        webdriver.waitForElementClickable(IConstants.linkFlipkart);
        webdriver.clickOnButton(IConstants.linkFlipkart);
        test.log(Status.INFO, "Verify flipkart link");
        logger.info("Verify flipkart link");

        if (IConstants.btnCross != null) {
            webdriver.clickOnButton(IConstants.btnCross);
            test.log(Status.INFO, "Close pop up");
            logger.info("Close pop up");
        } else {
            test.log(Status.INFO, "Element is not present");
            logger.info("Element is not present");
        }

    }

    @Test
    public void tc03VerifyMouseMovement() {

        test = extent.createTest("Verify Mouse Movement", "Verify Mouse Movement From TVs & Appliances to Window ACs")
                .assignCategory("Functional_TestCase")
                .assignAuthor("Kunal");
        logger.info("Verify Mouse Movement");

        webdriver.waitForElementVisible(IConstants.linkTvAndAppliances);
        webdriver.clickOnButton(IConstants.linkTvAndAppliances);
        webdriver.mouseMovement(IConstants.linkTvAndAppliances, IConstants.linkWindowAC);
        test.log(Status.INFO, "Verify Mouse Movement From TVs & Appliances to Window ACs");
        logger.info("Verify Mouse Movement From TVs & Appliances to Window ACs");
    }

    @Test
    public void tc04VerifyComparisonAndAddToCart() throws InterruptedException {

        test = extent.createTest("Verify Comparison And Add To Cart", "Add 3 Products For Comparison And All Add To Cart")
                .assignCategory("Functional_TestCase")
                .assignAuthor("Kunal");
        logger.info("Verify Comparison And Add To Cart");

        webdriver.clickOnButton(IConstants.checkBoxCompareProduct2);
        test.log(Status.INFO, "Click 2nd Product");
        logger.info("Click 2nd Product");

        webdriver.clickOnButton(IConstants.checkBoxCompareProduct3);
        test.log(Status.INFO, "Click 3rd Product");
        logger.info("Click 3rd Product");

        webdriver.clickOnButton(IConstants.checkBoxCompareProduct6);
        test.log(Status.INFO, "Click 6th Product");
        logger.info("Click 6th Product");

        webdriver.clickOnButton(IConstants.btnCOMPARE);
        test.log(Status.INFO, "Click on Compare");
        logger.info("Click on Compare");

        webdriver.clickOnButton(IConstants.btnAddToCart);
        test.log(Status.INFO, "Click on Add to Cart");
        logger.info("Click on Add to Cart");

        Thread.sleep(1000);
        driver.navigate().back();

        webdriver.clickOnButton(IConstants.btnAddToCart);
        test.log(Status.INFO, "Click on Add to Cart");
        logger.info("Click on Add to Cart");

        Thread.sleep(1000);
        driver.navigate().back();

        webdriver.clickOnButton(IConstants.btnAddToCart);
        test.log(Status.INFO, "Click on Add to Cart");
        logger.info("Click on Add to Cart");

        webdriver.list(IConstants.textProductName);

        webdriver.list(IConstants.textProductPrice);
    }

    @Test
    public void tc05VerifyCart() {

        test = extent.createTest("Verify Cart", "")
                .assignCategory("Functional_TestCase")
                .assignAuthor("Kunal");
        logger.info("Verify Cart");

        webdriver.waitForElementVisible(IConstants.txtPinCode);
        webdriver.enterText(IConstants.txtPinCode, "380007");
        test.log(Status.INFO, "Enter Pin Code");
        logger.info("Enter Pin Code");

        webdriver.clickOnButton(IConstants.btnCheck);
        test.log(Status.INFO, "Click on Check");
        logger.info("Click on Check");

        webdriver.waitForElementClickable(IConstants.deliverTo);
        webdriver.clickOnButton(IConstants.deliverTo);
        test.log(Status.INFO, "Click on Deliver To");
        logger.info("Click on Deliver To");

        webdriver.enterText(IConstants.txtPinCode, "380009");
        test.log(Status.INFO, "Enter Different Pin Code");
        logger.info("Enter Different Pin Code");

        webdriver.clickOnButton(IConstants.btnCheck);
        test.log(Status.INFO, "Click on Check");
        logger.info("Click on Check");
    }

}
