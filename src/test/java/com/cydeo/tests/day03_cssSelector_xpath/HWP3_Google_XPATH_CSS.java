package com.cydeo.tests.day03_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HWP3_Google_XPATH_CSS {

    public static void main(String[] args) {


        //TC #3: Back and forth navigation
        //1- Open a Chrome browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2- Go to: https://google.com
        driver.get("https://google.com");

        //driver.findElement(By.cssSelector("div[class='QS5gu sy4vM']")).click(); -->#1
        driver.findElement(By.cssSelector("button[id='L2AGLb']")).click();  //-->#2

        //3- Click to Gmail from top right.


        //4- Locating the Gmail Link using "xpath" locator
        // Xpath Syntax#1 : //tagName[@attribute='value']
        // WebElement gmailLink = driver.findElement(By.xpath("//a[@data-pid ='23']"));

        // Using the text of the web element with XPATH locator
        // Xpath Syntax#2 :tagName[text()='value'] -> or //tagName[.='textValue']
        //WebElement gmailLink = driver.findElement(By.xpath("//a[. ='Gmail']"));
        //WebElement gmailLink = driver.findElement(By.xpath("//a[text() ='Gmail']"));

        // locating the Gmail link using "cssSelector" locator
        // WebElement gmail= driver.findElement(By.cssSelector("a.gb_v"));
        // cssSelector Syntax: tagName[attribute='value']

        WebElement gmailLink = driver.findElement(By.cssSelector("a[href='https://mail.google.com/mail/&ogbl']"));
        gmailLink.click();

        //4- Verify title contains:
        //Expected: Gmail
        String expectedTitle ="Gmail";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitle)){
            System.out.println("Title verification PASSED!!");
        }else{
            System.out.println("Title verification Failed!!");
        }

        //5- Go back to Google by using the .back();
        driver.navigate().back();

        //6- Verify title equals:
        //Expected: Google
        expectedTitle="Google";
        actualTitle =driver.getTitle();

        if (actualTitle.contains(expectedTitle)){
            System.out.println("Title verification PASSED!!");
        }else{
            System.out.println("Title verification Failed!!");
        }

        driver.quit();
    }
}
