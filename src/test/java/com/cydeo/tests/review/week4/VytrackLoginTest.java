package com.cydeo.tests.review.week4;

import com.cydeo.pages.VytrackLoginPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VytrackLoginTest {


    VytrackLoginPage vytrackLoginPage;


    @BeforeMethod
    public void setup(){

        // 1- Open a chrome browser
        // 2- Go to: https://qa3.vytrack.com/user/login
        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack.url"));
        vytrackLoginPage=new VytrackLoginPage();
    }

    @Test
    public void vytrack_driver_login_test(){  //very important this part , we will create like that in our job

        // TC: Vytrack app login test as Driver

        // 3. Enter username User1
       // vytrackLoginPage.userName.sendKeys(ConfigurationReader.getProperty("driver_username"));

        // 4. Enter password UserUser123
        //vytrackLoginPage.password.sendKeys(ConfigurationReader.getProperty("driver_password"));

        // 5. Click to Login button
        //vytrackLoginPage.loginButton.click();

        vytrackLoginPage.loginAsDriver();//that is created for these 3 codes (3.,4.,5.)

    }
    @Test
    public void vytrack_salesManager_login_test(){
        vytrackLoginPage.loginAsSalesManager();

    }

    @Test
    public void vytrack_storeManager_login_test(){
        vytrackLoginPage.loginAsStoreManager();

    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }


}
