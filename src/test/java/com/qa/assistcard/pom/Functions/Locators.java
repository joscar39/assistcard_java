package com.qa.assistcard.pom.Functions;

import org.openqa.selenium.By;

public class Locators {
	
	 
    //Product
    public static final By productClassicLocator = By.xpath("//div[@class='d-grid gap-2 mt-5']//a[@id='buyBtn5I']");
    public static final By productPrivilegedLocator = By.xpath("//div[@class='d-grid gap-2 mt-5']//a[@id='buyBtn4P']");
    public static final By productPremiumLocator = By.xpath("//div[@class='d-grid gap-2 mt-5']//a[@id='buyBtn5L']");
    public static final By productInfinityLocator = By.xpath("//div[@class='d-grid gap-2 mt-5']//a[@id='buyBtnA16']");
    public static final By productMillionLocator = By.xpath("//div[@class='d-grid gap-2 mt-5']//a[@id='buyBtn0Z']");
    public static final By nextPageLocator = By.xpath("//a[contains(@class, 'ui-datepicker-next')]");
    public static final By addNewPassengerLocator = By.xpath("//body/section[1]/div[1]/div[1]/div[2]/form[1]/div[4]/div[2]/div[2]/i[1]");

    //Quotation
    public static final By destinylocator = By.xpath("//select[@id='IdDestination']");
    public static final By inputCalendarStart = By.xpath("//input[@id='txtStartDate']");
    public static final By inputCalendarEnd = By.xpath("//input[@id='txtEndDate']");
    public static final By dateMonthLocator = By.xpath("//span[contains(@class, 'ui-datepicker-month')]");
    public static final By dateYearLocator = By.xpath("//span[contains(@class, 'ui-datepicker-year')]");
    public static final By buttonContinuar = By.xpath("//button[contains(text(),'Cotizar ahora') or contains(text(),'Quote now')]");
    
    //Passenger
    
    public static final By locatorInputName = By.xpath("//input[@id='txtName_1']");
    public static final By locatorInputLastname = By.xpath("//input[@id='txtApellido_1']");
    public static final By locatorSelectDocuments = By.xpath("//select[@id='ddlDocumentTypeP_1']");
    public static final By locatorNumberDocument = By.xpath("//input[@id='txtNroDocumentoP_1']");
    public static final By locatorDayBirth = By.xpath("//input[@id='txtDias_1']");
    public static final By locatorSelectMonthBirth = By.xpath("//select[@id='ddlMeses_1']");
    public static final By locatorYearBirth = By.xpath("//input[@id='txtAnios_1']");
    public static final By locatorValidateCorrectlyPassenger = By.xpath("//p[contains(text(),'Pasajero ingresado correctamente.') or contains(text(),'Passenger entered correctly.')]");
    public static final By locatorButtonUpdateAgePassenger = By.xpath("div[@class='msg-warning-container']//p[@class='pax-msg-warning']//a[contains(text(), 'Aceptar') or contains(text(), 'OK')]");
    public static final By locatorSelectOfGender = By.xpath("//select[@id='ddlGenero_1']");
    public static final By locatorinputEmail = By.xpath("//input[@id='emailP']");
    public static final By locatorConfirmationEmailInput = By.xpath("//input[@id='confemailP']");
    public static final By inputSelectOfTypePhonelocator = By.xpath("\"//select[@id='tipoTelefono']\"");
    public static final By locatorSendNumberPhone = By.xpath("//input[@id='txtNumTelefono']");
    public static final By locatorButtonContinue = By.xpath("//button[@id='btn_continue']");
    
    public static final String alertInvalidPassenger = "La fecha de nacimiento no corresponde";
    public static final String ValidateNextPage = "COVID EXTRA";
    
    

}
