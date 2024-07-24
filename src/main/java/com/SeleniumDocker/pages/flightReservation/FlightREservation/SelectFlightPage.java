package com.SeleniumDocker.pages.flightReservation.FlightREservation;
import com.SeleniumDocker.pages.AbstractPage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class SelectFlightPage extends AbstractPage{


    @FindBy(name="departure-flight")
    private List<WebElement> DepartureFlight;

    @FindBy(name="arrival-flight")
    private List<WebElement> ArrivalFlight;

    @FindBy(id="confirm-flights")
    private WebElement ConfirmFlightbutton;

    public SelectFlightPage(WebDriver driver)

    {
        super(driver);
    }


    @Override
    public boolean isAT() {

        this.wait.until(ExpectedConditions.visibilityOf(this.ConfirmFlightbutton));
        return this.ConfirmFlightbutton.isDisplayed();
    }

    public void Selectflight()
    {
        int random = ThreadLocalRandom.current().nextInt(0,DepartureFlight.size());
        this.DepartureFlight.get(random).click();
        this.ArrivalFlight.get(random).click();
    }

    public void Confirmflight()
    {

        this.ConfirmFlightbutton.click();
       /* JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scroll(0, 250)");
        this.wait.until(ExpectedConditions.visibilityOf(this.ConfirmFlightbutton));
        Actions action = new Actions(driver);
        action.moveToElement(ConfirmFlightbutton).click().perform();*/

    }
}
