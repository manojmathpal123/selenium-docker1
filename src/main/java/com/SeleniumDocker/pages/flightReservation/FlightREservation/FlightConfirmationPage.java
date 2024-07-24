package com.SeleniumDocker.pages.flightReservation.FlightREservation;
import com.SeleniumDocker.pages.AbstractPage;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FlightConfirmationPage extends  AbstractPage{

    private static final Logger log = Logger.getLogger(FlightConfirmationPage.class);


    @FindBy(css="#flights-confirmation-section .card-body  .row:nth-child(3)  .col:nth-child(2)")
    private WebElement Flighttotalprice;

    @FindBy(css="#flights-confirmation-section .card-body  .row:nth-child(1)  .col:nth-child(2)")
    private WebElement Flightconfirmation;


    public FlightConfirmationPage(WebDriver driver)
    {
        super(driver);
    }
    @Override
    public boolean isAT() {

        this.wait.until(ExpectedConditions.visibilityOf(this.Flightconfirmation));
        return this.Flightconfirmation.isDisplayed();
    }

    public String getPrice()
    {
        String Confirmation = this.Flightconfirmation.getText();
        String price = this.Flighttotalprice.getText();
        log.info(Confirmation);
        log.info(price);

        return price;
    }
}
