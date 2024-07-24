package com.SeleniumDocker.pages.flightReservation.FlightREservation;
import com.SeleniumDocker.pages.AbstractPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationConfirmationPage extends AbstractPage {

 private WebDriver driver;

    @FindBy(id="go-to-flights-search")
    private WebElement FlightSearch;



    public RegistrationConfirmationPage(WebDriver driver)
    {
        super(driver);
    }

    @Override
    public boolean isAT() {
        this.wait.until(ExpectedConditions.visibilityOf(this.FlightSearch));
        return this.FlightSearch.isDisplayed();
    }

    public void GoToFlightSearch()
    {
        this.FlightSearch.click();
    }
}
