package com.qa.assistcard.pom.Pages;

import com.qa.assistcard.pom.Functions.BaseFunctions;
import com.qa.assistcard.pom.Functions.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BaseFunctions {

    int t = 350;

    
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void selectProduct(String producto) throws InterruptedException {
        producto = producto.toLowerCase();
        if ("classic ar abm".contains(producto)) {
            // Click en producto Classic
        	getActions().scrollToElement(Locators.productClassicLocator);
            Thread.sleep(t);
            getActions().clickOnElement(Locators.productClassicLocator);
        } else if ("privileged".contains(producto)) {  // Click en producto privileged
        	getActions().scrollToElement(Locators.productPrivilegedLocator);
            Thread.sleep(t);
            getActions().clickOnElement(Locators.productPrivilegedLocator);
        } else if ("premium".contains(producto)) {  // Click en producto premium
        	getActions().scrollToElement(Locators.productPremiumLocator);
            Thread.sleep(t);
            getActions().clickOnElement(Locators.productPremiumLocator);
        } else if ("infinity".contains(producto)){
        	getActions().scrollToElement(Locators.productInfinityLocator);
            Thread.sleep(t);
            getActions().clickOnElement(Locators.productInfinityLocator);
        } else if ("million".contains(producto)){
        	getActions().scrollToElement(Locators.productMillionLocator);
            Thread.sleep(t);
            getActions().clickOnElement(Locators.productMillionLocator);
        }else {
            assert false;
        }
    }

    public void ValidateDisplayNextPage(String Producto){
        String productotoUpper = Producto.toUpperCase();
        By locatorNextPage = By.xpath("//h6[@class='fw-bold mb-0' and span[contains(text(),'"+productotoUpper+"')] and contains(text(),' adulto') or contains(text(),'menor')]");
        getActions().findElementIsDisplayed(locatorNextPage);

    }
}
