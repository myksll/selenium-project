package com.cydeo.tests.day07_webtables_utilities_javafaker;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.CRM_Utilities;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T4_CRM_LoginTask {

    WebDriver driver;


    @BeforeMethod
    public void setupMethod(){
        //1. Create new test and make setups
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2. Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");
    }

    @Test
    public void test1_crm_login(){

        CRM_Utilities.login_crm(driver,"marketing10@cybertekschool.com","UserUser");  //use CRM utilities to log in

        //6. Verify title is as expected:
        // Expected: Portal
        // We are waiting 3 secs for title to be loaded to "(2) Portal"
        BrowserUtils.sleep(3);
        BrowserUtils.verifyTitle(driver, "(1) Portal");

    }


//hr1@cybertekschool.com,
//hr100@cybertekschool.com,
//helpdesk1@cybertekschool.com,
//helpdesk45@cybertekschool.com
//marketing10@cybertekschool.com
//marketing 74@cybertekschool.com







}
