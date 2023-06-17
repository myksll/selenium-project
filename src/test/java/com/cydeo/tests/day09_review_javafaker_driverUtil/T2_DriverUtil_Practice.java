package com.cydeo.tests.day09_review_javafaker_driverUtil;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;


import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T2_DriverUtil_Practice {

    @Test
    public void bing_search_test() {
        // Go to: https://bing.com
        Driver.getDriver().get(ConfigurationReader.getProperty("bingURL"));

        // Write “apple” in search box
        WebElement searchBox = Driver.getDriver().findElement(By.xpath("//input[@name='q']"));
        searchBox.sendKeys(ConfigurationReader.getProperty("searchValue") + Keys.ENTER);

        // Verify title: Expected: apple - Search
        BrowserUtils.sleep(2);
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = ConfigurationReader.getProperty("searchValue") + " - Search";

        Assert.assertEquals(actualTitle, expectedTitle);
    }
}







