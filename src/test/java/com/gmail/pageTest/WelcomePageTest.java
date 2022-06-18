package com.gmail.pageTest;

import com.gmail.baseTest.BaseTest;
import com.gmail.pages.LoginPage;
import com.gmail.pages.WelcomePage;
import org.testng.annotations.Test;

public class WelcomePageTest extends BaseTest {
    WelcomePage welcomePage = new WelcomePage();
    LoginPage loginPage = new LoginPage();


    @Test(priority = 1)
    public void ClickNext(){
        welcomePage = loginPage.ClickNext(driver);
    }
}
