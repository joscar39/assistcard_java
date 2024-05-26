package StepsDefinitions;

import com.qa.assistcard.pom.Pages.ProductPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class ProductTest {

    public ProductPage productPage;

    public ProductTest(){
        WebDriver driver;
        driver = Hooks.driver;

        productPage = new ProductPage(driver);
    }

    @Step
    @When("seleccionar producto de tipo: {string}")
    public void seleccionar_producto_de_tipo(String Producto) throws Throwable {
        productPage.selectProduct(Producto);
    }
    @Step
    @Then("Validar visualizacion de pagina Pasajero mostrando el producto {string} seleccionado")
    public void validarVisualizacionDePaginaPasajeroMostrandoElProductoYCantidadDePasajerosSeleccionado(String Producto) {
        productPage.ValidateDisplayNextPage(Producto);
        productPage.getActions().capturarPantalla("Verificado producto de compra");
    }


}
