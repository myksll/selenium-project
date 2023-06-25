package com.cydeo.utilities;

/*
This class will be storing only the utility methods that can be used across the project
 */

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class BrowserUtils {

    /*
    This method will accept int(in seconds) and
    execute Thread.sleep method for given duration
    Arg: int second

     */

    public static void sleep(int second){
        second*=1000;
        try{
            Thread.sleep(second);
        }catch(InterruptedException e){

        }
    }

    public static void switchWindowAndVerify (WebDriver driver, String expectedInURl, String expectedTitle){

        //Return and store all window handles in aSet
        Set<String> allWindowHandles= driver.getWindowHandles();

        for (String each : allWindowHandles) {
            driver.switchTo().window(each);
            System.out.println("Current URL: " +driver.getCurrentUrl());

            if(driver.getCurrentUrl().contains(expectedInURl)){
                break;
            }
        }

        //5. Assert: Title contains “Etsy”

        String actualTitle= driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitle));



    }
    @Test
    public static void verifyTitle(WebDriver driver, String expectedTitle){

        String actualTitle= driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);

    }


    @Test
    public static void  verifyTitleContains(WebDriver driver, String expectedInTitle){

        String actualTitle= driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedInTitle));
    }


    /*
       This method accepts WebElement target,
       and waits for that WebElement not to be displayed on the page
        */
    public static void waitForInvisibilityOf(WebElement target){
        //Create the object of 'WebDriverWait' class, and set up the constructor args
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        //use the 'wait' object with the proper syntax to create explicit wait conditions.
        wait.until(ExpectedConditions.invisibilityOf(target));
    }

    /*
    This method accepts String title,
    and waits for that Title to contain given String value.
     */
    public static void waitForTitleContains(String title){
        //Create the object of 'WebDriverWait' class, and set up the constructor args
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        //use the 'wait' object with the proper syntax to create explicit wait conditions.
        wait.until(ExpectedConditions.titleContains(title));
    }

    public static void scrollDown(int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0, "+ pixels +")");
    }

    public static void clickOption(WebDriver driver, String option){

        driver.findElement(By.linkText(option)).click();

    }

}
