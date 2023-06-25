package com.cydeo.tests.review.week4;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class Guru99_Upload_Test  {
    @Test
    public void testUploadGuru99() {
        // TC: Guru99 Upload Test
        //1. Go to  “https://demo.guru99.com/test/upload”
        Driver.getDriver().get("https://demo.guru99.com/test/upload");

        //reject/handle all cookies [We have to change the frame (iframe !! for privacy settings)]

        Driver.getDriver().switchTo().frame(Driver.getDriver().findElement(By.xpath("//*[@id='gdpr-consent-notice']")));

        WebElement acceptAll = Driver.getDriver().findElement(By.xpath("//button[@id='save']"));
        acceptAll.click();

        // back to the main html/frame
        Driver.getDriver().switchTo().defaultContent();

        //Find some small file from your computer, and get the path of it.
        File file = new File("/Users/mesut/Desktop/some-file.txt");
        Assert.assertTrue(file.exists());

        //2. Upload file into Choose File
        WebElement uploadInput = Driver.getDriver().findElement(By.xpath("//input[@id= 'uploadfile_0']"));
        uploadInput.sendKeys("/Users/i.etga/Desktop/UploadPractice.txt");

        //3. Click terms of service check box
        WebElement checkboxTermsOfService = Driver.getDriver().findElement(By.xpath("//input[@id='terms']"));
        checkboxTermsOfService.click();

        //4. Click Submit File button
        WebElement submitButton = Driver.getDriver().findElement(By.xpath("//button[@id='submitbutton']"));
        submitButton.click();

        BrowserUtils.sleep(4);

        //5. Verify expected message appeared.
        // Expected: “1 file
        // has been successfully uploaded."

        WebElement uploadedMessage = Driver.getDriver().findElement(By.xpath("//center[.='1 file has been successfully uploaded.']"));

        String expectedText = "1 file\n" + "has been successfully uploaded.";
        String actualText = uploadedMessage.getText();


        Assert.assertTrue(uploadedMessage.isDisplayed());
        Assert.assertEquals(actualText,expectedText);

    }
    }



