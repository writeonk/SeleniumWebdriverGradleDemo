/*
@author Kunal Soni
*/

package library;

import common.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class WebDriver extends TestBase {

    public void enterText(By locator, String text) {
        WebElement element = driver.findElement(locator);
        element.sendKeys(text);
    }

    public void clearText(By locator) {
        WebElement element = driver.findElement(locator);
        element.clear();
    }

    public void clickOnButton(By locator) {
        WebElement element = driver.findElement(locator);
        element.click();
    }

    public String getText(By locator) {
        WebElement element = driver.findElement(locator);
        return element.getText();
    }

    public String getPlaceholder(By locator) {
        WebElement element = driver.findElement(locator);
        return element.getAttribute("placeholder");
    }

    public void selectValueOnDropDown(By locator, String Text) {
        Select selectValue = new Select(driver.findElement(locator));
        selectValue.selectByVisibleText(Text);
    }

    public void selectValueOnCheckBox(By chkBoxCollection, By labelText, By getInput, String Text) {

        List<WebElement> chkBoxCollections = driver.findElements(chkBoxCollection);
        for (WebElement webElement : chkBoxCollections) {
            WebElement getLabel = webElement.findElement(labelText);
            WebElement getInput1 = webElement.findElement(getInput);
            if (getLabel.getText().equals(Text)) {
                if (!getInput1.isSelected()) {
                    getLabel.click();
                    break;
                }
            }
        }

    }

    public void waitForElementVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForElementClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void randomClickFromList(By Value) {

        List<WebElement> itemsInList = driver.findElements(Value);
        int size = itemsInList.size();
        System.out.println(size);
        int randomNumber = ThreadLocalRandom.current().nextInt(0, size);
        itemsInList.get(randomNumber).click();
    }

    public static String randomString() {
        String SaltChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 250) {
            int index = (int) (rnd.nextFloat() * SaltChars.length());
            salt.append(SaltChars.charAt(index));
        }
        return salt.toString();
    }
}