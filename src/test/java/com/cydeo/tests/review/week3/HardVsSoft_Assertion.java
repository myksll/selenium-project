package com.cydeo.tests.review.week3;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class HardVsSoft_Assertion {


    WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
        // 1. Open Chrome browser
      driver= WebDriverFactory.getDriver("chrome");
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 2. Go to https://practice.cydeo.com/login
        driver.get("https://practice.cydeo.com/login");
    }


    @Test
    public void login_test_with_hard_assertion() throws InterruptedException {

        // 3. Enter username: "tomsmith"
        // 4. Enter password: "SuperSecretPassword"
        // 5. Click to Login button
        // 6. Verify text displayed on page#
        //    Expected: "You logged into a secure area!"

        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("tomsmith");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("SuperSecretPassword");

        WebElement loginBtn1 = driver.findElement(By.id("wooden_spoon"));
        loginBtn1.click();

        Assert.assertTrue(driver.getTitle().contains("Secure Area"));//  if there is an exception or fail , it will not execute until this line


        Thread.sleep(1000);
      //  WebElement resultText1 = driver.findElement(By.cssSelector(".flash.success"));
        WebElement resultText1 = driver.findElement(By.xpath("//div[normalize-space(text())='You logged into a secure area!']"));

        System.out.println(resultText1.getText());

        String actualText = resultText1.getText();
        String expectedText = "You logged into a secure area!";

        Assert.assertTrue(actualText.contains(expectedText));



    }

    @Test
    public void login_test_with_soft_assertion(){

        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("tomsmith");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("SuperSecretPassword");

        WebElement loginBtn1 = driver.findElement(By.id("wooden_spoon"));
        loginBtn1.click();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(driver.getTitle().contains("Secure Area"));;

        WebElement resultText1 = driver.findElement(By.xpath("//div[normalize-space(text())='You logged into a secure area!']"));

        System.out.println(resultText1.getText());

        String actualText = resultText1.getText();
        String expectedText = "You logged into a secure area!";

      softAssert.assertTrue(actualText.contains(expectedText));

      //we have to use assertAll() method at the end of Test method execute all assertions
      softAssert.assertAll();//like try-catch. if there is an exception or fail , it will still execute
    }
}
