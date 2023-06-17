package com.cydeo.tests.day02_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HWP1_Etsy_Search_Title {
    public static void main(String[] args) throws InterruptedException {


        //HWP #1: Etsy Title Verification
        //1. Open Chrome browser
        //Setting up our chromedriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        //Setting a new ChromeDriver and storing it in "driver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2. Go to https://www.etsy.com
         driver.get("https://www.etsy.com");
        Thread.sleep(3000);

        //3. Click "I agree" or "Accept" button that appears when Etsy displays its terms of service or privacy policy
        driver.findElement(By.cssSelector("[class= 'wt-btn wt-btn--filled wt-mb-xs-0']")).click();


        //4. Search for “wooden spoon”
        WebElement searchBox = driver.findElement(By.id("global-enhancements-search-query"));
        searchBox.sendKeys("wooden spoon"+ Keys.ENTER);
        Thread.sleep(3000);


        //4. Verify title:
        //Expected: “Wooden spoon - Etsy DE”
        String expectedTitle = "Wooden spoon - Etsy DE";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title verification PASSED!");
        }else {
            System.out.println("Title verification FAILED!");
        }


        // close the browser
        driver.close();
    }

}
