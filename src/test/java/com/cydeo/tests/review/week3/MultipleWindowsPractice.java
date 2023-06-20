package com.cydeo.tests.review.week3;

import com.cydeo.tests.base.TestBase;
import org.testng.annotations.Test;

public class MultipleWindowsPractice extends TestBase {



    @Test
    public void multiple_windows_handling_test(){

        // TC : Windows handle practice
        //    1. Open browser
        //    2. Go to website: https://demoqa.com/browser-windows
        driver.get("https://demoqa.com/browser-windows");

        //    3. Click on New Tab button
        //    4. Click on New Window button
        //    5. Click on New Window Message button
        //    6. Store parent window handle id in a variable
        //    7. Store all window handle ids in to a Set
        //    9. Print out each window title
    }
}
