package com.gmail.baseTest;

import com.gmail.constant.DriverType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {


    public static WebDriver driver;
    public static Properties prop;


    public static  void openBrowser(){
        try{
            prop = new Properties();
            FileInputStream fis = new FileInputStream("src/main/java/com/gmail/Configuration/Config.Properties");
            prop.load(fis);
            System.out.println("Testing");

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();

        }
    }
    public static void SetUp()  {
//      WebDriverManager.chromedriver().cachePath("Drivers").setup();
    //  WebDriverManager.firefoxdriver().cachePath("Drivers").setup();

        System.out.println("After the driver");

        if(prop.getProperty("browser").equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
            System.out.println("chrome driver");
        }
        else if(prop.getProperty("browser").equalsIgnoreCase("FF")){
            System.setProperty("webdriver.gecko.driver","Drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        }

        else if(prop.getProperty("browser").equalsIgnoreCase("EE")){
            driver = new EdgeDriver();
        }
//        WebDriver driver;
////        String browser = System.getProperty("browser");
//        switch (DriverType.valueOf(prop.getProperty("browser"))){
//            case chrome->{
//                WebDriverManager.chromedriver().cachePath("Drivers").setup();
//                driver = new ChromeDriver();
//            }
//
//
//            case FF->{
//                WebDriverManager.firefoxdriver().cachePath("Drivers").setup();
//                driver = new FirefoxDriver();
//            }
//
//
//            case Edge->{
//                WebDriverManager.edgedriver().cachePath("Drivers");
//                driver =new EdgeDriver();
//            }
//            default->throw new IllegalStateException("Invalid browser name:");
//        }
        System.out.println("Before url");
        driver.get(prop.getProperty("url"));
        System.out.println("After url ");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    @AfterSuite
    public void CloseBrowser(){
    
        driver.close();
    }

}
