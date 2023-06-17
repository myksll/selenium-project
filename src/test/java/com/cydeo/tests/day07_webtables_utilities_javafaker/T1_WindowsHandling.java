package com.cydeo.tests.day07_webtables_utilities_javafaker;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class T1_WindowsHandling {

    //TC #1: Window Handle practice

    WebDriver driver;


    @BeforeMethod
    public void setupMethod(){
        //1. Create new test and make setups
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //2. Go to : https://www.amazon.com
        driver.get("https://www.amazon.com");
    }

    @Test
    public void windowHandling() {

        //3. Copy /paste the lines from below into your class
        ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");

        BrowserUtils.switchWindowAndVerify(driver, "etsy", "Etsy");
    }

    @Test
    public void windowHandling2() {

            //3. Copy /paste the lines from below into your class
            ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
            ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
            ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");

            //4. Create a logic to switch to the tab where Etsy.com is open
            //Return and store all window handles in aSet
            Set<String> allWindowHandles = driver.getWindowHandles();

            for (String each : allWindowHandles) {
                driver.switchTo().window(each);
                System.out.println("Current URL: " + driver.getCurrentUrl());

                if (driver.getCurrentUrl().contains("etsy")) {
                    break;
                }
            }

            BrowserUtils.verifyTitleContains(driver, "Etsy");
        }

    }

