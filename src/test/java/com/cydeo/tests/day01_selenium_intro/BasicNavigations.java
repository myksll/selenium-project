package com.cydeo.tests.day01_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigations {
    public static void main(String[] args) throws InterruptedException {

        //SETUP BROWSER DRIVER
        WebDriverManager.chromedriver().setup();

        //Create instance of Chrome browser
        WebDriver driver= new ChromeDriver();


        //This line will maximize currently opened browser
        driver.manage().window().maximize();
        //driver.manage().window().fullscreen();

        //Go to tesla.com
        driver.get("https://www.tesla.com");

        //use .getCurrentUrl() method  to print out  current url
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

        //get title of the page
        //System.out.println("driver.getTitle() = " + driver.getTitle());
        String currentTitle=driver.getTitle();
        System.out.println("currentTitle = " + currentTitle);

        //user navigate back() to go back
        driver.navigate().back();

        //Stop execution for 3 second
        Thread.sleep(3000);

        //user navigate forward() to go forward
        driver.navigate().forward();

        //Stop execution for 3 second
        Thread.sleep(1000);

        //user refreshes the page using refresh()
        driver.navigate().refresh();

        //Stop execution for 3 second
        Thread.sleep(1000);

        //navigate to google.com using navigate.to()
        driver.navigate().to("https://google.com");

        //use .getCurrentUrl() method  to print out  current url
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

        //get title of the page
         //System.out.println("driver.getTitle() = " + driver.getTitle());//driver.getTitle() = Google

        currentTitle=driver.getTitle();
        System.out.println("currentTitle = " + currentTitle);


        //closes only the currently focused window/tab
        driver.close();

        //closing all-of-the opened browsers
        driver.quit();









    }
}
