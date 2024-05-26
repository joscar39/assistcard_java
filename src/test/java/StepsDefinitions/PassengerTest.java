package StepsDefinitions;

import com.qa.assistcard.pom.Pages.PassengerPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class PassengerTest {



    public PassengerPage passengerPage;

    public PassengerTest(){
        WebDriver driver;
        driver = Hooks.driver;

        passengerPage = new PassengerPage(driver);
    }
    @Step
    @When("Ingresar dato en el campo nombre: {string}")
    public void ingresar_dato_en_el_campo_nombre(String Name) throws Throwable{
        passengerPage.insertNameUser(Name);
    }
    @Step
    @When("Ingresar dato en el campo apellido: {string}")
    public void ingresar_dato_en_el_campo_apellido(String Lastname) throws  Throwable{
        passengerPage.insertLastnameUser(Lastname);
    }
    @Step
    @When("Seleccionar una opcion del campo documento: {string}")
    public void seleccionar_una_opcion_del_campo_documento(String TypeDocument) throws Throwable{
        passengerPage.selectDocumentUser(TypeDocument);
    }
    @Step
    @When("Ingresar numero de documento Valido: {string}")
    public void ingresar_numero_de_documento_valido(String NumberDocument) throws Throwable{
        passengerPage.insertNumberDocument(NumberDocument);
    }
    @Step
    @When("Ingresar Dia de nacimiento: {string}")
    public void ingresar_dia_de_nacimiento(String Day) throws  Throwable{
        passengerPage.insertDayOfBirth(Day);
    }
    @Step
    @When("Seleccionar mes de nacimiento: {string}")
    public void seleccionar_mes_de_nacimiento(String Month) throws Throwable{
        passengerPage.selectMonthOfBirth(Month);
    }
    @Step
    @When("Ingresar Año de nacimiento: {string}")
    public void ingresar_año_de_nacimiento(String Year) {
        passengerPage.insertYearOfBirth(Year);
    }

    @Step
    @When("Seleccionar genero: {string}")
    public void seleccionar_genero(String Gender) throws Throwable{
        passengerPage.selectGender(Gender);
    }
    @Step
    @Then("Validar fecha de nacimiento coincide con edad de pasajero")
    public void validar_fecha_de_nacimiento_coincide_con_edad_de_pasajero() throws Throwable{
        passengerPage.validateAlertOfBirthdayCorrect();
    }
    @Step
    @When("Ingresar correo valido en campo email: {string}")
    public void ingresar_correo_valido_en_campo_email(String Email) throws Throwable{
        passengerPage.insertEmailVoucher(Email);
    }
    @Step
    @Then("Confirmar correo ingresado en el campo confirma tu email: {string}")
    public void confirmar_correo_ingresado_en_el_campo_confirma_tu_email(String Email) throws Throwable{
        passengerPage.confirmationEmailVoucher(Email);

    }
    @Step
    @When("Seleccionar tipo de telefono: {string}")
    public void seleccionar_tipo_de_telefono(String TypePhone) throws Throwable{
        passengerPage.selectTypePhone(TypePhone);
    }
    @Step
    @When("Ingresar numero de telefono valido: {string}")
    public void ingresar_numero_de_telefono_valido(int NumberPhone) throws Throwable{
        passengerPage.sendNumberPhone(NumberPhone);
    }
    @Step
    @When("Click en boton continuar")
    public void click_en_boton_continuar() throws Throwable{
        passengerPage.clickOnButtonContinue();
    }
    @Step
    @Then("Validar que se muestre la pagina de Mejoras y adicionales")
    public void validar_que_se_muestre_la_pagina_de_mejoras_y_adicionales() throws Throwable{
        passengerPage.ValidateNextPageAdditional();
    }



}
