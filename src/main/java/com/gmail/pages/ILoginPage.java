package com.gmail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public interface ILoginPage {
    By verifyTile = By.xpath("//*[@id=\"headingText\"]/span");
    By email_txt =By.id("identifierId");
    By nextBtn = By.xpath("//*[@id=\"identifierNext\"]/div/button/span");


    public String VerifyTitle(WebDriver driver);
    public void EnterEmail(WebDriver driver, String email);
    public WelcomePage ClickNext(WebDriver driver);
}
