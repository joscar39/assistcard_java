package com.qa.assistcard.pom.Functions;

import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CreateDriver {


    public static WebDriver setUpConfig() throws IOException {
        WebDriver driver;
        Properties props = new Properties();
        FileInputStream inputStream = new FileInputStream("src/test/resources/config/config.properties");
        props.load(inputStream);

        System.out.println("################");
        System.out.println("[ POM CONFIGURACION  ] - Lee la configuracion de propiedades basicas de config.properties");
        System.out.println("################");
        String browser = props.getProperty("browser");
        String os = props.getProperty("os");

        System.out.println("[ POM CONFIGURACION ] - OS: "+ os +" | Browser: "+ browser +" |" );
        System.out.println("#################");

        driver = WebDriverFactory.createNewWebDriver(browser, os);

        return driver;

    }

}
