package com.cydeo.tests.day02_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_CydeoVerifications {

    public static void main(String[] args) {

        //TC #1: Cydeo practice tool verifications
        //1.Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();

        //2. Go to https://practice.cydeo.com
        driver.navigate().to("https://practice.cydeo.com");
        //driver.get("");

        //3. Verify URL contains
        //Expected: cydeo
        String expectedInUrl = "cydeo";
        String actualURL= driver.getCurrentUrl();

        System.out.println("actualURL = " + actualURL);
        System.out.println("expectedInUrl = " + expectedInUrl);

        if(actualURL.contains(expectedInUrl)){
            System.out.println("URL verification PASSED!!!");
        }else{
            System.out.println("URL verification Failed!!!");
        }

        //4.Verify title:
        //Expected: Practice
        String expectedTitle= "Practice";
        String actualTitle =driver.getTitle(); //returns->Practice

        if(expectedTitle.equals(actualTitle)){
            System.out.println("Title verification PASSED!!!");
        }else{
            System.out.println("Title verification FAILED!!");
        }


        if(driver.getTitle().equals("Practice")){
            System.out.println("Pass!");
        }


        //close browser
        driver.close();












    }
}
