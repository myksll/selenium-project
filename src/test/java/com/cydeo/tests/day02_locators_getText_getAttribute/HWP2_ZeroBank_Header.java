package com.cydeo.tests.day02_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HWP2_ZeroBank_Header {

    public static void main(String[] args) throws InterruptedException {

        //HWP #2: Zero Bank header verification
        //1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        //2. Go to http://zero.webappsecurity.com/login.html
        driver.get("http://zero.webappsecurity.com/login.html");
        Thread.sleep(3000);

        //3. Verify header text
        WebElement headerText = driver.findElement(By.tagName("h3"));

        //Expected: “Log in to ZeroBank”
        String expectedHeader= "Log in to ZeroBank";
        String actualHeader = headerText.getText();

        //verification of actual vs expected
        if(actualHeader.equals(expectedHeader)){
            System.out.println("Header text verification Passed!!");
        }else{
            System.out.println("Header text verification Failed!!");
        }
    }
}
