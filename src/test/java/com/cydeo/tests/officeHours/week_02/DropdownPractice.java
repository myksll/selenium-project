package com.cydeo.tests.officeHours.week_02;

import com.cydeo.tests.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropdownPractice extends TestBase {


    //As a user,   I should be able to see default option as Select a State
    //Open a Chrome browser



    @Test
    public void dropdown_test(){

        //2. go to https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");

        //3. verify default option Select a State
        Select selectState =new Select(driver.findElement(By.id("state")));

        WebElement defaultOption = selectState.getFirstSelectedOption();

        String actualDefaultOption=defaultOption.getText();
        String expectedDefaultOption= "Select a State";

        Assert.assertEquals(actualDefaultOption,expectedDefaultOption,"Default option verification failed!!");
    }

    @Test
    public void dropdown_test2(){

        //As a user I should be able to select Alabama
        //  1-open a chrome browser


        //  2-goto https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");

        //  3-select Alabama
        Select selectAlabama =new Select(driver.findElement(By.id("state")));

       // selectAlabama.selectByIndex(1);
        //selectAlabama.selectByVisibleText("Alabama");
        selectAlabama.selectByValue("AL");



        //  4-verify Alabama is selected

        //1.way
       //Assert.assertEquals(selectAlabama.getFirstSelectedOption().getText(), "Alabama", "State select Verification FAILED!!!");

        //2.way
        WebElement currentSelectedOption = selectAlabama.getFirstSelectedOption();

        String actualSelectedOption= currentSelectedOption.getText();
        String expectedSelectedOption = "Alabama";

        Assert.assertEquals(actualSelectedOption,expectedSelectedOption);


    }



}
