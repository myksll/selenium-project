package com.cydeo.tests.day03_cssSelector_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HWP4_Link_XPATH_CSS {
    public static void main(String[] args) throws InterruptedException {



        //TC #4: Practice Cydeo – Class locator practice
        //1- Open a Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        //2- Go to: https://practice.cydeo.com/inputs
        driver.get("https://practice.cydeo.com/inputs");
        Thread.sleep(2000);

        //3- Click to “Home” link
        // PS: Locate “Home” link using “className” locator
        //WebElement homeLink= driver.findElement(By.linkText("Home"));-->1.way
        //WebElement homeLink= driver.findElement(By.xpath("//a[@class='nav-link']")); //-->2.way
        //WebElement homeLink= driver.findElement(By.xpath("//a[text()='Home']")); //-->3.way
        //WebElement homeLink= driver.findElement(By.cssSelector("a[class='nav-link']")); //-->4.way

        WebElement homeLink= driver.findElement(By.cssSelector("a.nav-link")); //-->5.way
        Thread.sleep(1000);
        homeLink.click();

        //4- Verify title is as expected:
        //Expected: Practice

        String expectedTitle= "Practice";
        String actualTitle=driver.getTitle();

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Title verification is Passed!");
        }else{
            System.out.println("Title verification is Failed!");
        }


        //driver.quit();





    }
}
