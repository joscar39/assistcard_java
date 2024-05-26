package com.qa.assistcard.pom.Pages;

import com.qa.assistcard.pom.Functions.BaseFunctions;
import com.qa.assistcard.pom.Functions.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PassengerPage extends BaseFunctions {

    public PassengerPage(WebDriver driver) {
        super(driver);
    }


    public void insertNameUser(String name) {
        getActions().sendText(Locators.locatorInputName, name);

    }

    public void insertLastnameUser(String lastname) {
        getActions().sendText(Locators.locatorInputLastname, lastname);

    }

    public void selectDocumentUser(String type_document) {
        String value = getActions().obtainTypeDocumentInInputSelect(type_document);
        getActions().selectInput(Locators.locatorSelectDocuments, "value", value);

    }

    public void insertNumberDocument(String NumberDocument) {
        getActions().sendText(Locators.locatorNumberDocument, NumberDocument);
    }


    public void insertDayOfBirth(String Day) {
        getActions().sendText(Locators.locatorDayBirth, Day);

    }

    public void selectMonthOfBirth(String Month) {
        String number_month = getActions().obtain_number_month(Month);
        getActions().selectInput(Locators.locatorSelectMonthBirth,"value", number_month);
    }

    public void insertYearOfBirth(String Year) {
        getActions().sendText(Locators.locatorYearBirth, Year);
    }

    public void validateAlertOfBirthdayCorrect() {
        getActions().findElementIsDisplayed(Locators.locatorValidateCorrectlyPassenger);
    }

    public void validateAlertOfBirthDayIncorrect() {
        getActions().findElementIsVisibleByText(Locators.alertInvalidPassenger);
    }

    public void updateAgeOfPassenger() {
        getActions().clickOnElement(Locators.locatorButtonUpdateAgePassenger);
    }

    public void selectGender(String Gender) {

        String newGender = getActions().obtainValueOfGenderInSelect(Gender);
        getActions().selectInput(Locators.locatorSelectOfGender, "value", newGender);
    }

    public void insertEmailVoucher(String Email) {
        getActions().scrollToElement(Locators.locatorinputEmail);
        getActions().sendText(Locators.locatorinputEmail, Email);
    }

    public void confirmationEmailVoucher(String Email) {
        getActions().sendText(Locators.locatorConfirmationEmailInput, Email);
    }

    public void selectTypePhone(String TypePhone) {
        String NewTypePhone = getActions().capitalize(TypePhone);
        getActions().selectInput(Locators.inputSelectOfTypePhonelocator, "text", NewTypePhone);

    }

    public void selectCodeCountry(int Code) {
        getActions().clickOnElement(By.xpath(String.format("//div[@id='dllPais']//input[@value='%d']", Code)));
    }

    public void sendNumberPhone(int NumberPhone) {
        getActions().sendNumber(Locators.locatorSendNumberPhone, NumberPhone);
    }

    public void clickOnButtonContinue() {
        getActions().clickOnElement(Locators.locatorButtonContinue);
    }

    public void ValidateNextPageAdditional() {
        getActions().findElementIsVisibleByText(Locators.ValidateNextPage);

    }

}
