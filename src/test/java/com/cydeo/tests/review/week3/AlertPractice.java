package com.cydeo.tests.review.week3;

import com.cydeo.tests.base.TestBase;
import com.cydeo.utilities.BrowserUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertPractice extends TestBase {

// TC : Alert practice
// 1. Open browser
// 2. Go to website: https://practice.cydeo.com/javascript_alerts
// 3. Click to “Click for JS Prompt” button
// 4. Send “hello” text to alert
// 5. Click to OK button from the alert
// 6. Verify “You entered: hello” text is displayed.


    @Test
    public void prompt_alert_test(){
        // 2. Go to website: https://practice.cydeo.com/javascript_alerts
        driver.get(" https://practice.cydeo.com/javascript_alerts");

         // 3. Click to “Click for JS Prompt” button
       driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();


        Alert alert=driver.switchTo().alert();


        BrowserUtils.sleep(2);
        //  4. Send “hello” text to alert
        alert.sendKeys("Hello");

        //get text of alert window
        System.out.println("alert.getText() = " + alert.getText());

        //  5. Click to OK button from the alert
        BrowserUtils.sleep(2);
        alert.accept();

        //  6. Verify “You entered: hello” text is displayed.

        String expectedResult="You entered: Hello";
        String actualResult=driver.findElement(By.id("result")).getText();
        Assert.assertEquals(actualResult,expectedResult);

    }
}