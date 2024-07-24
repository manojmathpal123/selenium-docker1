package com.SeleniumDocker.pages.flightReservation.FlightREservation;
import com.SeleniumDocker.pages.AbstractPage;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class FlightSearchPage extends AbstractPage{



    @FindBy(id="passengers")
    private WebElement NUmberOfPassengers;

    @FindBy(id="oneway")
    private WebElement Onewayflight;

    @FindBy(id="twoway")
    private WebElement RoundTrip;

    @FindBy(id="depart-from")
    private WebElement DepartFrom;

    @FindBy(id="service-class3")
    private WebElement Serviceclass;

    @FindBy(id="arrive-in")
    private WebElement ArriveIn;

    @FindBy(id="search-flights")
    private WebElement SearchFlightbutton;

    public FlightSearchPage(WebDriver driver)
    {
        super(driver);
    }
    @Override
    public boolean isAT() {
        this.wait.until(ExpectedConditions.visibilityOf(this.DepartFrom));
        return this.DepartFrom.isDisplayed();
    }


    public void SelectTRip()
    {
        this.Onewayflight.click();
    }

    public void ArrivalIn(String arrivecity)
    {
        Select select = new Select(this.ArriveIn);
        select.selectByVisibleText(arrivecity);
    }

    public void SerachFlightResult() throws InterruptedException {
        /*Thread.sleep(300);
        this.wait.until(ExpectedConditions.visibilityOf(this.SearchFlightbutton));
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scroll(0, 250)");
        this.wait.until(ExpectedConditions.visibilityOf(this.SearchFlightbutton));
        Actions action = new Actions(driver);*/
      //  action.moveToElement(SearchFlightbutton).click().perform();
        this.SearchFlightbutton.click();



    }




}
