package com.gmail.baseTest;

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
            FileInputStream fis = new FileInputStream("C:\\Users\\ken20963\\Videos\\gmail\\src\\main\\java\\com\\gmail\\Configuration\\Config.Properties");
            prop.load(fis);
            System.out.println("Testing");

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();

        }
    }
    public static void SetUp(){
//      WebDriverManager.chromedriver().setup();
//      WebDriverManager.firefoxdriver().setup();

        System.out.println("After the driver");

        if(prop.getProperty("browser").equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\ken20963\\Pictures\\Drivers/chromedriver.exe");
            driver = new ChromeDriver();
            System.out.println("chrome driver");
        }
        else if(prop.getProperty("browser").equalsIgnoreCase("FF")){
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\ken20963\\Pictures\\Drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        }

        else if(prop.getProperty("browser").equalsIgnoreCase("EE")){
            driver = new EdgeDriver();
        }
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
