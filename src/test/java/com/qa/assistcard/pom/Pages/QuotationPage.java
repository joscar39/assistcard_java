package com.qa.assistcard.pom.Pages;

import com.qa.assistcard.pom.Functions.BaseFunctions;
import com.qa.assistcard.pom.Functions.Locators;

import org.openqa.selenium.WebDriver;

public class QuotationPage extends BaseFunctions {

   
    public QuotationPage(WebDriver driver) {
        super(driver);
    }


    public void selectDestiny(String Destiny){

        String newDestiny = getActions().obtainCountryDestination(Destiny);
        getActions().selectInput(Locators.destinylocator, "value", newDestiny);

    }

    public void selectStartDate(String startday, String startmonth, String startyear){

    	getActions().selectDateInDatePicker_ByRange(Locators.inputCalendarStart,Locators.dateMonthLocator,Locators.dateYearLocator,
    			Locators.nextPageLocator,startday, startmonth, startyear);

    }

    public void selectEndDate(String endday, String endmonth, String endyear){
    	getActions().selectDateInDatePicker_ByRange(Locators.inputCalendarEnd,Locators.dateMonthLocator,Locators.dateYearLocator,
    			Locators.nextPageLocator,endday, endmonth, endyear);
    }

    public void selectPassengerAndAge(String age){
    	getActions().addPassengerAndSendAge(Locators.addNewPassengerLocator, age);

    }

    public void clickContinue(){
    	getActions().clickOnElement(Locators.buttonContinuar);
    }

    public void ValidateRangeOfQuotation(String StartDay, String StartMonth, String StartYear, String EndDay, String EndMonth, String EndYear){

        long difference = getActions().obtainsDiferenceBetweenDates(StartDay, StartMonth, StartYear, EndDay, EndMonth, EndYear);
        getActions().findElementIsVisibleByText("Productos con vigencia de "+ difference +" días");

    }


}
