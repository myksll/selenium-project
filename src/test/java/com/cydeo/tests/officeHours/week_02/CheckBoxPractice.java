package com.cydeo.tests.officeHours.week_02;

import com.cydeo.tests.base.TestBase;
import com.cydeo.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxPractice extends TestBase {

    // TC001 As a user I should be able to click checkboxes

    //  1-open a Chrome browser


    @Test
    public void checkbox_text(){

        //  2-goto https://practice.cydeo.com/
        driver.get("https://practice.cydeo.com/");

        //  3-click Checkboxes
        //Since I will not need Checkbox web element in next coming , I did not store in webElement
       // driver.findElement(By.linkText("Checkboxes")).click();

        BrowserUtils.clickOption(driver,"Checkboxes");

        //  4-verify title equals Checkboxes

        //1.way
        //String actualTitle = driver.getTitle();
        //String expectedTitle= "Checkboxes";
        //Assert.assertEquals(actualTitle,expectedTitle);
        //Assert.assertTrue(actualTitle.equals(expectedTitle));

        //2.way
        Assert.assertEquals(driver.getTitle(),"Checkboxes");

        //  5-click Checkbox 1
        WebElement checkbox1= driver.findElement(By.id("box1"));
        checkbox1.click();

        BrowserUtils.sleep(2);

        //  6-verify the Checkbox 1 is selected
        Assert.assertTrue(checkbox1.isSelected());

        //  7-click Checkbox 2
        WebElement checkbox2 = driver.findElement(By.id("box2"));
        checkbox2.click();

        //  8-verify the Checkbox 2 is not selected
        Assert.assertTrue(!checkbox2.isSelected(), "checkbox2 verification failed!!!");
    }







}
