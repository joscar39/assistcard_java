package com.qa.assistcard.pom.Pages;

import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
public class HomePage {


    private WebDriver driver;

    @Given("que estoy en la página de inicio de Assist Card")
    public void que_estoy_en_la_página_de_inicio_de_Assist_Card() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriverlinux");
        driver = new ChromeDriver();
        driver.get("https://wwwqa.assistcard.com/");
    }

    @Then("se muestra la página de inicio de Assist Card")
    public void se_muestra_la_página_de_inicio_de_Assist_Card() {
        String pageTitle = driver.getTitle();
        assert pageTitle.contains("ASSIST CARD");
        driver.quit();
    }
}

