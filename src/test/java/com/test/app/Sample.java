/*
@author Kunal Soni
*/

package com.test.app;

import com.aventstack.extentreports.Status;
import common.TestBase;
import org.testng.annotations.Test;

public class Sample extends TestBase {

    @Test
    public void tc01VerifyURL() {

        test = extent.createTest("Verify URL");
        logger.info("Verify URL");

        openURL("https://www.google.com");
        test.log(Status.INFO, "Open URL");
        logger.info("Open URL");
    }

}
