package com.gmail.pageTest;

import com.gmail.baseTest.BaseTest;
import com.gmail.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {
LoginPage loginPage = new LoginPage();
    @BeforeMethod
    public void initialize() {
        openBrowser();
        SetUp();

    }

    @Test(priority = -1)
    public void verifyTitle(){
        String Actual = loginPage.VerifyTitle(driver);
        String Expected = "Sign in";
        Assert.assertEquals(Actual,Expected);
        System.out.println("Testing");

    }

    @Test
    public  void Email(){
        loginPage.EnterEmail(driver,"bashirabdi1994@gmail.com");
    }





}
