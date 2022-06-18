package com.gmail.pages;

import org.openqa.selenium.WebDriver;

public class LoginPage implements ILoginPage {

    @Override
    public String VerifyTitle(WebDriver driver) {
        return driver.findElement(verifyTile).getText();
    }

    @Override
    public void EnterEmail(WebDriver driver, String email) {
          driver.findElement(email_txt).click();
          driver.findElement(email_txt).sendKeys(email);

    }

    @Override
    public WelcomePage ClickNext(WebDriver driver) {
        driver.findElement(nextBtn).click();
        return new WelcomePage();

    }
}
