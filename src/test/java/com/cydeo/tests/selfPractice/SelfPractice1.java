package com.cydeo.tests.selfPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelfPractice1 {
    public static void main(String[] args) {


        //open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //go to https://instagram.com
        driver.navigate().to("https://instagram.com");

        //verify url contains
        String expectedURL= "instagram";
        String actualURL= driver.getCurrentUrl();

        if(expectedURL.contains(expectedURL)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }

        //verify title
        String expectedTitle= "Instagram";
        String actualTitle=driver.getTitle();

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }




    }
}
