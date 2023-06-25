package com.cydeo.tests.day12_review;

import com.cydeo.pages.W3Page;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_DoubleClick_Practice {

    @Test
    public void t1_double_click_test(){

        //Using W3Page object to reach to the 'paragraph' web element.
        W3Page w3Page = new W3Page();//call the object from W3Page from pages package


        //TC #1: Double Click Test
        //1. Go to
        //https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
        Driver.getDriver().get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");

        //for cookie
        w3Page.cookie.click();  //page/W3Page

        //2. Switch to iframe.
        Driver.getDriver().switchTo().frame("iframeResult"); //(id of Iframe)

        //3. Double-click on the text “Double-click me to change my text color.”

        //w3Page.paragraph.click();     //call the paragraph from W3Page class, but we have to click double , not once
        //Using Actions object to be able to 'double-click' to the given web element.
        Actions actions=new Actions(Driver.getDriver());
        actions.doubleClick(w3Page.paragraph).perform(); //go to paragraph and double click

        //4. Assert: Text’s “style” attribute value contains “red”.
        //style : "color: red;"
        String actualStyleAttribute = w3Page.paragraph.getAttribute("style");
        String expectedInAttributeValue="red";

        Assert.assertTrue(actualStyleAttribute.contains(expectedInAttributeValue));

    }

}
