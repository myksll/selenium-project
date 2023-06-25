package com.cydeo.pages;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VytrackLoginPage {

    public VytrackLoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id="prependedInput")
    public WebElement userName;


    @FindBy(xpath="//input[@id='prependedInput2']")
    public WebElement password;

    @FindBy(xpath="//button[.='Log in']")
    public WebElement loginButton;

    public void loginAsDriver () {//I do not want to write always these 3 Codes
        userName.sendKeys(ConfigurationReader.getProperty("driver_username"));
        password.sendKeys(ConfigurationReader.getProperty("driver_password"));
        loginButton.click();
    }

    public void loginAsSalesManager(){
        userName.sendKeys(ConfigurationReader.getProperty("salesmanager_username"));
        password.sendKeys(ConfigurationReader.getProperty("salesmanager_password"));
        loginButton.click();
    }

    public void loginAsStoreManager(){
        userName.sendKeys(ConfigurationReader.getProperty("storemanager_username"));
        password.sendKeys(ConfigurationReader.getProperty("storemanager_password"));
        loginButton.click();
    }





}
