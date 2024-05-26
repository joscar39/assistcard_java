package com.qa.assistcard.pom.Functions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class WebDriverFactory {

    private static String resourceFolder;


    public static WebDriver createNewWebDriver(String browser, String os) throws IOException {
        WebDriver driver;
        Properties props = new Properties();
        FileInputStream inputStream = new FileInputStream("src/test/resources/config/config.properties");
        props.load(inputStream);
        resourceFolder = props.getProperty("resourceFolder");
        // Directly access headless property
        boolean isHeadless = Boolean.parseBoolean(props.getProperty("headless"));

        if ("FIREFOX".equalsIgnoreCase(browser)){
            if("WINDOWS".equalsIgnoreCase(os)){
                System.setProperty("webdriver.gecko.driver", resourceFolder+"/geckodriver.exe");
            }else {
                System.setProperty("webdriver.gecko.driver", resourceFolder+"/geckodriver");
            }
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            if (isHeadless) {
                firefoxOptions.addArguments("--headless");
            }

            driver = new FirefoxDriver(firefoxOptions);
        }

        /******** The driver selected is Chrome ***********/

        else if ("CHROME".equalsIgnoreCase(browser)) {
            if ("WINDOWS".equalsIgnoreCase(os)){
                System.setProperty("webdriver.chrome.driver", resourceFolder+"/chromedriver.exe");
            }else {
                System.setProperty("webdriver.chrome.driver", resourceFolder+"/chromedriver");

            }
            ChromeOptions chromeOptions = new ChromeOptions();
            if (isHeadless) {
                chromeOptions.addArguments("--headless");
            }
            driver = new ChromeDriver(chromeOptions);

        }

        /******** The driver selected is Internet Explorer ***********/

        else if ("INTERNET EXPLORER".equalsIgnoreCase(browser)) {
            System.setProperty("webdriver.ie.driver", resourceFolder +"/IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }

        /******** The driver is not selected ***********/

        else {
            System.out.println("El driver no esta seleccionado en las propiedades, nombre invalido: "+browser+", "+ os);
            return null;

        }
        driver.manage().window().maximize();
        return driver;


    }
}
