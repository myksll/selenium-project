package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_Registration_Form {


    @Test
    public void registration_form(){

        //TC#1: Registration form confirmation
        //1. Open browser
        //2. Go to website: https://practice.cydeo.com/registration_form
        // Driver.getDriver();---> will return "driver"
        //Driver.getDriver().get("https://practice.cydeo.com/registration_form");
        Driver.getDriver().get(ConfigurationReader.getProperty("registration.form.url"));  //re-usable, simple, in one line

        //3. Enter first name
        WebElement inputFirstName=Driver.getDriver().findElement(By.xpath("//input[@name='firstname']"));
         inputFirstName.sendKeys("JANE");

        BrowserUtils.sleep(2);
        //4. Enter last name
        WebElement inputLastName= Driver.getDriver().findElement(By.xpath("//input[@name='lastname']"));
        inputLastName.sendKeys("DOE");

        BrowserUtils.sleep(2);
        //5. Enter username
        WebElement inputUserName= Driver.getDriver().findElement(By.xpath("//input[@name='username']"));
        inputUserName.sendKeys("janedoe58");

        BrowserUtils.sleep(1);
        //6. Enter email address
        WebElement inputEmail= Driver.getDriver().findElement(By.xpath("//input[@name='email']"));
        inputEmail.sendKeys("janedoe@example.com");

        BrowserUtils.sleep(1);
        //7. Enter password
        WebElement inputPassword= Driver.getDriver().findElement(By.xpath("//input[@name='password']"));
        inputPassword.sendKeys("124567890");

        //8. Enter phone number
        WebElement inputPhoneNumber= Driver.getDriver().findElement(By.xpath("//input[@name='phone']"));
        inputPhoneNumber.sendKeys("014-625-7845");

        //9. Select a gender from radio buttons
        WebElement radioButtonFemale = Driver.getDriver().findElement(By.xpath("//input[@value='female']"));
        radioButtonFemale.click();

        //10. Enter date of birth
        WebElement inputDateOfBirth =Driver.getDriver().findElement(By.xpath("//input[@name='birthday']"));
        inputDateOfBirth.sendKeys("10/12/1990");

        //11. Select Department/Office
        Select departmentDropdown = new Select(Driver.getDriver().findElement(By.name("department")));
        departmentDropdown.selectByVisibleText("Department of Engineering");

        //12. Select Job Title
        Select jobTitleDropdown = new Select(Driver.getDriver().findElement(By.name("job_title")));
        jobTitleDropdown.selectByVisibleText("SDET");

        //13. Select programming language from checkboxes
        WebElement javaCheckbox = Driver.getDriver().findElement(By.xpath("//input[@value='java']"));
        javaCheckbox.click();

        //14. Click to sign up button
        WebElement signUpButton = Driver.getDriver().findElement(By.id("wooden_spoon"));
        signUpButton.click();

        //15. Verify success message “You’ve successfully completed registration.” is
        //displayed.
        WebElement successMessage = Driver.getDriver().findElement(By.xpath("//div[@role='alert']"));

        Assert.assertTrue(successMessage.isDisplayed());



        //Driver.getDriver().quit();we don't use this method anymore.Because we want to assign the value back to null
        //So if we have another test , our code can continue executing
        Driver.closeDriver();   // or ---> Driver.getDriver().close();
    }








}
