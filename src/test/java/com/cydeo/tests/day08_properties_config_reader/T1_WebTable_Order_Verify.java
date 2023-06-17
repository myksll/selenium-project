package com.cydeo.tests.day08_properties_config_reader;

import com.cydeo.utilities.WebDriverFactory;
import com.cydeo.utilities.WebOrderUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T1_WebTable_Order_Verify {

      //TC #1: Web table practice
      WebDriver driver;

      @BeforeMethod
      public void setupMethod(){
        //1. Create new test and make setups
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1. Go to: https://practice.cydeo.com/web-tables
        driver.get("https://practice.cydeo.com/web-tables");
    }

      @Test
      public void order_verify_name_tes (){
        //2. VerifyBob’s name is listed as expected.
        //below locator is locating me the Bob Martin's cell as where it is currently stored.
        //table[@class='SampleTable']/tbody/tr[7]/td[2]

        //locate Bob's cell using its name as the text.
        String locator = "//table[@class='SampleTable']//td[.='Bob Martin']";
        WebElement bobsCell = driver.findElement(By.xpath(locator));

        System.out.println("bobsCell.getText() = " + bobsCell.getText());

        //Expected: “Bob Martin”
        String expectedName = "Bob Martin";
        String actualName = bobsCell.getText();

        Assert.assertEquals(actualName, expectedName, "Names are not matching!");

        //3. Verify BobMartin’s order date is as expected.

        // table[@class='SampleTable']//td[.='12/31/2021'] -->1.way
        // //table[@class='SampleTable']//td[.='Bob Martin']/../td[.='12/31/2021'] -->2.way
        //-> sibling...>3.way
        // WebElement bobsOrderDate = driver.findElement(By.xpath("//table[@class='SampleTable']//td[.='Bob Martin']/../td[.='12/31/2021']");

        WebElement bobsOrderDate= driver.findElement(By.xpath("//table[@class='SampleTable']//td[.='Bob Martin']/following-sibling::td[3]"));

        String expectedDate= "12/31/2021";
        String actualDate=bobsOrderDate.getText();

        Assert.assertEquals(actualDate,expectedDate);


    }

      @Test
      public void test2_use_order_verify_method(){

        //call the utility method we created

          String alexandreGray=  WebOrderUtils.returnOrderDate(driver,"Alexandra Gray");
          System.out.println("Alexandre Gray = " + alexandreGray);


           String bartFisher=WebOrderUtils.returnOrderDate(driver,"Bart Fisher");
           System.out.println("Bart Fisher = " + bartFisher);
       }

      @Test
      public void test3(){

      WebOrderUtils.orderVerify(driver,"Bob Martin", "12/31/2021");

       }
}