package com.test.app;

import org.openqa.selenium.By;

public interface IConstants {

    By txtName = By.xpath("//input[@name='q']");
    By btnGoogleSearch = By.xpath("//input[@name='btnK']");
    By consoleList = By.xpath("//ul[@class='erkvQe']//li//div/div//div//span");
    By linkFlipkart = By.xpath("(//span[text()='Flipkart'])[1]");
    By btnCross = By.xpath("//button[@class='_2KpZ6l _2doB4z']");
    By linkTvAndAppliances = By.xpath("//span[text()='TVs & Appliances']");
    By linkWindowAC = By.xpath("//a[@title='Window ACs']");
    By checkBoxCompareProduct2 = By.xpath("(//span[text()='Add to Compare'])[2]");
    By checkBoxCompareProduct3 = By.xpath("(//span[text()='Add to Compare'])[3]");
    By checkBoxCompareProduct6 = By.xpath("(//span[text()='Add to Compare'])[6]");
    By btnCOMPARE = By.xpath("//span[text()='COMPARE']");
    By textProductName = By.xpath("//a[@class='_2Kn22P gBNbID']");
    By textProductPrice = By.xpath("c ");
    By btnAddToCart = By.xpath("//button[text()='ADD TO CART']");
    By txtPinCode = By.xpath("//input[@placeholder='Enter delivery pincode']");
    By deliverTo = By.xpath("//div[@class='_2VjdZj _3ZnIlT']");
    By btnCheck = By.xpath("//span[text()='Check']");
    By deliveryBy = By.xpath("//div[@class='bzD9az']");
}
