package com.cydeo.tests.review.week4;

import com.cydeo.pages.DashboardPage;
import com.cydeo.pages.VytrackLoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DashboardMenuHoverOverTest {
    @Test
    public void dashboard_menu_hover_over_test(){

        // TC: Vytrack app main menus test as Salesmanager
        // 1- Open a chrome browser
        // 2- Go to: https://qa3.vytrack.com/user/login
        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack.url"));
        // 3. Enter username salesmanager120
        // 4. Enter password UserUser123
        // 5. Click to Login button
        VytrackLoginPage vytrackLoginPage=new VytrackLoginPage();
        vytrackLoginPage.loginAsSalesManager();

        BrowserUtils.sleep(3);

        // 6. Hover over each main menu //by one by , it will check the subtitles on Dashboard

        Actions actions=new Actions(Driver.getDriver());

        DashboardPage dashboardPage=new DashboardPage();
       // List<WebElement> mainmenus = dashboardPage.main_menus; for(WebElement each : mainmenus)  or look below

        BrowserUtils.sleep(3);
        for(WebElement eachMenu: dashboardPage.main_menus){
            actions.moveToElement(eachMenu).perform();
        }



    }
}
