package com.cydeo.tests.day11_pom_explicit_waits;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class T2_to_T6_Actions_Practices {

    @BeforeMethod
    public void setupMethod(){

        //1. Go to https://practice.cydeo.com/drag_and_drop_circles
        Driver.getDriver().get("https://practice.cydeo.com/drag_and_drop_circles");
    }

    @AfterMethod
    public void teardownMethod(){
        BrowserUtils.sleep(3);
       // Driver.closeDriver();
    }

    @Test
    public void test2_default_value_verification(){

        //TC2 #: Drag and drop default value verification

        //2. Verify big circle default text is as below.
        WebElement bigCircle= Driver.getDriver().findElement(By.id("droptarget"));

        //3. Assert:
        //-Text in big circle changed to: “Drag the small circle here.”
        String expectedText="Drag the small circle here.";
        String actualText = bigCircle.getText();

        assertEquals(actualText,expectedText); //After import ; import static org.testng.Assert.assertEquals; we don not need to write Assert.assertEquals(actualText,expectedText);

    }

    @Test
    public void test3_drop_into_the_big_circle(){

        //TC3 #: Drag and drop into the big circle

        //Locating the circle web elements
        WebElement bigCircle= Driver.getDriver().findElement(By.id("droptarget"));
        WebElement smallCircle=Driver.getDriver().findElement(By.id("draggable"));

        //Creating the Actions object to do our actions
        Actions actions = new Actions(Driver.getDriver());

       //2. Drag and drop the small circle to bigger circle.
       // actions.dragAndDrop(smallCircle,bigCircle).perform(); 1.way

        actions.clickAndHold(smallCircle)   //2.way
                .pause(1000)
                .moveToElement(bigCircle)
                .pause(1000)
                .release()
                .perform();


        //3. Assert:
        //-Text in big circle changed to: “You did great!”
        String expectedText="You did great!";
        String actualText = bigCircle.getText();

        assertEquals(actualText,expectedText);

    }

    @Test
    public void test4_click_and_hold_small_circle(){

        //TC4 #: Click and hold


        //Locating the circle web elements
        WebElement bigCircle= Driver.getDriver().findElement(By.id("droptarget"));
        WebElement smallCircle=Driver.getDriver().findElement(By.id("draggable"));

        //Creating the Actions object to do our actions
        Actions actions = new Actions(Driver.getDriver());

        //2. Click and hold the small circle.
        // actions.dragAndDrop(smallCircle,bigCircle).perform(); 1.way

        actions.clickAndHold(smallCircle)
                .pause(1000)
                .moveToElement(Driver.getDriver().findElement(By.linkText("CYDEO")))
                .perform();   //2.way

        //3. Assert:
        //-Text in big circle changed to: “Drop here.”
        String expectedText="Drop here.";
        String actualText = bigCircle.getText();

        assertEquals(actualText,expectedText);




    }

    @Test
    public void test5_drop_outside_of_big_circle(){

       // TC5 #: Drag and drop outside of the big circle


        //Locating the circle web elements
        WebElement bigCircle= Driver.getDriver().findElement(By.id("droptarget"));
        WebElement smallCircle=Driver.getDriver().findElement(By.id("draggable"));

        //Creating the Actions object to do our actions
        Actions actions = new Actions(Driver.getDriver());

        //2. Drag and drop the small circle to bigger circle.
        // actions.dragAndDrop(smallCircle,bigCircle).perform(); 1.way

        actions.clickAndHold(smallCircle)
                .pause(1000)
                .moveToElement(Driver.getDriver().findElement(By.linkText("CYDEO")))
                .pause(1000)
                .release()
                .perform();   //2.way

        //3. Assert:
        //-Text in big circle changed to: “Try again!”
        String expectedText="Try again!";
        String actualText = bigCircle.getText();

        assertEquals(actualText,expectedText);




    }

    @Test
    public void test6_big_circle_hovering_text_verify(){

        //TC6 #: Drag and hover


        //Locating the circle web elements
        WebElement bigCircle= Driver.getDriver().findElement(By.id("droptarget"));
        WebElement smallCircle=Driver.getDriver().findElement(By.id("draggable"));

        //Creating the Actions object to do our actions
        Actions actions = new Actions(Driver.getDriver());

        //2. Drag the small circle on top of the big circle, hold it, and verify.
        // actions.dragAndDrop(smallCircle,bigCircle).perform(); 1.way

        actions.clickAndHold(smallCircle)
                .pause(1000)
                .moveToElement(bigCircle)
                .pause(1000)
                .perform();   //2.way

        //3. Assert:
        //-Text in big circle changed to: “Now drop…”
        String expectedText="Now drop...";
        String actualText = bigCircle.getText();

        assertEquals(actualText,expectedText);




    }

}
