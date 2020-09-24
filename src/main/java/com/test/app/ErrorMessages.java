/*
@author Kunal Soni
*/

package com.test.app;

import org.openqa.selenium.By;

public class ErrorMessages {

    public static By ThisFieldIsRequired = By.xpath("(//span[text()='This field is required'])[1]");
    public static By EnterValidEmail = By.xpath("//span[text()='Please enter a valid email']");
}
