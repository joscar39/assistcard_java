package StepsDefinitions;

import com.qa.assistcard.pom.Pages.QuotationPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class QuotationTest {

    WebDriver driver;

    public QuotationPage quotationPage;


    @Step
    @Given("que estoy en la página de cotizacion")
    public void queEstoyEnLaPáginaDeCotizacion() throws Throwable{
        driver = Hooks.driver;
        quotationPage = new QuotationPage(driver);

    }
    @Step
    @When("Seleccionar un lugar de destino: {string}")
    public void seleccionarUnLugarDeDestino(String Destiny) throws Throwable {
        quotationPage.selectDestiny(Destiny);
    }
    @Step
    @When("Enviar fecha de inicio de viaje :{string}, {string}, {string}")
    public void enviarFechaDeInicioDeViaje(String StartDay, String StartMonth, String StartYear) {
        quotationPage.selectStartDate(StartDay, StartMonth, StartYear);
    }
    @Step
    @When("Enviar fecha de finalizacion de viaje :{string}, {string}, {string}")
    public void enviarFechaDeFinalizacionDeViaje(String EndDay, String EndMonth, String EndYear) throws Throwable {
        quotationPage.selectEndDate(EndDay, EndMonth, EndYear);
    }
    @Step
    @When("Seleccionar cantidad de pasajeros y edades: {string}")
    public void seleccionarCantidadDePasajerosYEdades(String YearsOld) throws Throwable {
        quotationPage.selectPassengerAndAge(YearsOld);
    }
    @Step
    @When("Click en boton cotizar")
    public void clickEnBotonCotizar() throws Throwable {
        quotationPage.clickContinue();
    }
    @Step
    @Then("Validar visualizacion de pantalla de cotizacion dado los siguientes datos: {string}, {string}, {string}, {string}, {string}, {string}")
    public void validarVisualizacionDePantallaDeCotizacionDadoLosSiguientesDatos(String StartDay, String StartMonth, String StartYear, String EndDay, String EndMonth, String EndYear) throws Throwable {
        quotationPage.ValidateRangeOfQuotation(StartDay, StartMonth, StartYear, EndDay, EndMonth, EndYear);
    }


}
