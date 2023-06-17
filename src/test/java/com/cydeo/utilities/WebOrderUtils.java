package com.cydeo.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class WebOrderUtils {

    //Method #1 info:
    //• Name: returnOrderDate ()
    //• Return type: String
    //• Arg1: WebDriver driver
    //• Arg2: String costumerName
    //This method should accept a costumerName and return the costumer order date
    //as a String.

    public static String returnOrderDate(WebDriver driver,String costumerName ){


        //1.way
        String locator= "//td[.='"+costumerName+"']/following-sibling::td[3]" ; //for example: "//table[@class='SampleTable']//td[.='Bob Martin']"
        WebElement customerDateCell = driver.findElement(By.xpath(locator));
        return customerDateCell.getText();

        //2.way
        //we can write this code in one line
        //return  driver.findElement(By.xpath("//td[.='"+customerName+"']/following-sibling::td[3]")).getText();

        /*      example:
        String middleName="L";
        String fullName="Samuel" +middleName+"Jackson";
        System.out.println("fullName = " + fullName);  //-->Samuel L Jackson
    */

    }

    public static void orderVerify(WebDriver driver, String costumerName, String expectedOrderDate){

        String locator ="//td[.='"+costumerName+"']/following-sibling::td[3]";
        WebElement customerDateCell = driver.findElement(By.xpath(locator));

        String actualOrderDate = customerDateCell.getText();

        Assert.assertEquals(actualOrderDate,expectedOrderDate);


    }
}
//Method #2 info:
//• Name: orderVerify ()
//• Return type: void
//• Arg1: WebDriver driver
//• Arg2: String costumerName
//• Arg3: String expectedOrderDate
//This method should accept above mentioned arguments and internally assert
//expectedOrderDate matching actualOrderDate.