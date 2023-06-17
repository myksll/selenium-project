package com.cydeo.tests.day03_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T1_locators_getText {
    public static void main(String[] args) throws InterruptedException{

        //TC #1: NextBaseCRM, locators and getText() practice
        //1- Open a Chrome browser

        // WebDriverManager.chromedriver().setup(); --> 1.way
        // WebDriver driver = new ChromeDriver();

        WebDriver driver= WebDriverFactory.getDriver("chrome"); //--> 2.way
        driver.manage().window().maximize();

        //2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");
        Thread.sleep(1000);

        //3- Enter incorrect username: “incorrect”
        WebElement inputUsername = driver.findElement(By.className("login-inp"));//we can use also name locator.
        inputUsername.sendKeys("incorrect");
        Thread.sleep(1000);

        //4- Enter incorrect password: “incorrect”
        WebElement inputPassword = driver.findElement(By.name("USER_PASSWORD"));//we can use also classname locator.
        inputPassword.sendKeys("incorrect");
        Thread.sleep(1000);

        //5- Click to Login button.
        WebElement loginButton = driver.findElement(By.className("login-btn"));
        loginButton.click();

        //6- Verify error message text is as expected:
        //Expected: Incorrect login or password
       String expectedErrorText="Incorrect login or password";
       String actualErrorText= driver.findElement(By.className("errortext")).getText();

       if(actualErrorText.equals(expectedErrorText)){
           System.out.println("Error text verification Passed!!");
       }else {
           System.out.println("Error text verification Failed!!");

       }



        driver.close();
    }
}
