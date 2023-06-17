package com.cydeo.utilities;

/*
This class will store the method related to CRM
 */


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CRM_Utilities {


    /*
    This method will log in using below credentials.
    @username : "marketing10@cybertekschool.com"
    @password : "UserUser"
     */

    public static void login_crm(WebDriver driver){

        // Enter valid username
        WebElement inputUsername = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        inputUsername.sendKeys("marketing10@cybertekschool.com");

        // Enter valid password
        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputPassword.sendKeys("UserUser");



        // Click to`LogIn`button
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();

    }

    public static void login_crm(WebDriver driver, String username, String password){

        // Enter valid username
        WebElement inputUsername = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        inputUsername.sendKeys(username);

        // Enter valid password
        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputPassword.sendKeys(password);

        // Click to`LogIn`button
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();

    }





}
//TC #5: Create utility method
//1. Create a new method for login
//2. Create a method to make Task3 logic re-usable
//3. When method is called, it should simply login
//This method should have at least 2 overloaded versions.
//Method #1 info:
//• Name: login_crm()
//• Return type: void
//• Arg1: WebDriver
//Method #2 info:
//• Name: login_crm()
//• Return type: void
//• Arg1: WebDriver
//• Arg2: String username
//• Arg3: String password