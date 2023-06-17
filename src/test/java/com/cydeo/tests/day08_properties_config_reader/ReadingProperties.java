package com.cydeo.tests.day08_properties_config_reader;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadingProperties {

    @Test
    public void reading_from_properties_test() throws IOException {

        //Steps to read from properties type of file
        //1-Create object of properties
        Properties properties = new Properties();

        //2-We need to open the file in the Java memory
        FileInputStream file = new FileInputStream("configuration.properties");

        //3-Load the properties file in the Properties object
        properties.load(file);

        //4-Use the properties object to read value from the file
        System.out.println("properties.getProperty(\"browser\") = " + properties.getProperty("browser"));  // chrome

        System.out.println("properties.getProperty(\"env\") = " + properties.getProperty("env")); //https://login1.nnestbasecrm.com

        System.out.println("properties.getProperty(\"username\") = " + properties.getProperty("username")); //helpdesk1@cydeo.com

        System.out.println("properties.getProperty(\"password\") = " + properties.getProperty("password"));  //UserUser




    }
}