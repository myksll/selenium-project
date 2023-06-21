package com.cydeo.tests.officeHours.week_02;

import com.cydeo.tests.base.TestBase;
import com.cydeo.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonPractice extends TestBase {

    //TC002 As a user I should be able to select my favorite color and sport
    //
    //  1-open a chrome browser

    @Test
    public void radio_button_test(){

        //  2-go to https://practice.cydeo.com/
        driver.get(" https://practice.cydeo.com/");

        //  3-click Radio Buttons
        BrowserUtils.clickOption(driver,"Radio Buttons");

        BrowserUtils.sleep(1);
        //  4-verify title is Radio buttons
      //  Assert.assertEquals(driver.getTitle(),"Radio buttons");1.way

        BrowserUtils.verifyTitle(driver,"Radio buttons"); //2.way

        //  5-select the favorite color as Red
        WebElement redButton  = driver.findElement(By.cssSelector("#red"));
        redButton.click();

        //  6-verify the Red is selected
        Assert.assertTrue(redButton.isSelected());

        BrowserUtils.sleep(1);

        //  7-select the favorite sport as Football

        WebElement footballButton = driver.findElement(By.cssSelector("#football"));
        footballButton.click();

        BrowserUtils.sleep(1);

        //  8-verify the Football is selected
        Assert.assertTrue(footballButton.isSelected());


    }
}
