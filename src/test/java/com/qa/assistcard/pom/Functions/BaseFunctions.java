package com.qa.assistcard.pom.Functions;

import org.openqa.selenium.*;

public class BaseFunctions {

    public WebDriver driver;
    public ElementActions actions;
    public Locators location;

    public BaseFunctions(WebDriver driver){
        this.driver = driver;
        actions = new ElementActions(driver);
    }

    public ElementActions getActions() {
        return actions;
    }

    public WebDriver getDriver() {
        return driver;
    }


    

}

