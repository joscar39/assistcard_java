package StepsDefinitions;

import com.qa.assistcard.pom.Functions.BaseFunctions;
import com.qa.assistcard.pom.Functions.CreateDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Hooks {

    public static WebDriver driver;

    Scenario scenario = null;

    @Before
    public void setUp(Scenario scenario) throws IOException {

        System.out.println("################");
        System.out.println("[  CONFIGURACION  ] - Inicializando la configuracion del controlador");
        System.out.println("################");

        Properties props = new Properties();
        FileInputStream inputStream = new FileInputStream("src/test/resources/config/config.properties");
        props.load(inputStream);
        String url = props.getProperty("URL_ARGENTINA");

        driver = CreateDriver.setUpConfig();

        BaseFunctions baseFunctions = new BaseFunctions(driver);
        baseFunctions.getActions().visit(url);
        this.scenario = scenario;
        System.out.println("################");
        System.out.println("[  SCENARIO  ] - "+ scenario.getName());
        System.out.println("################");

    }

    @After
    public void tearDown(Scenario scenario) throws IOException{
        if(scenario.isFailed()){
            try {
//              byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
                Allure.addAttachment("Error Capturado", new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));

            }catch (WebDriverException e){
                System.err.println(e.getMessage());
            }
        }

        System.out.println("################");
        System.out.println("[  DRIVER STATUS  ] - Limpiando y cerrando instancia del controlador");
        System.out.println("################");
        driver.quit();
    }

}
