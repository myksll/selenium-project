package com.cydeo.utilities;

/*
This class will be storing only the utility methods that can be used across the project
 */

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

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
}
