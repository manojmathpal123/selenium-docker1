package com.SeleniumDocker.pages.flightReservation.FlightREservation.Vendorportal;

import com.SeleniumDocker.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DashboardPage extends AbstractPage {

    @FindBy(id="monthly-earning")
    private WebElement MonthlyEarningElement;

    @FindBy(id="annual-earning")
    private WebElement annualEarningElement;

    @FindBy(id="profit-margin")
    private WebElement profitMarginElement;

    @FindBy(id="available-inventory")
    private WebElement availableinventoryElement;

    @FindBy(css="#dataTable_filter input")
    private WebElement SearchInput;

    @FindBy(id="dataTable_info")
    private WebElement datatableinfo;

    @FindBy(css="img.img-profile")
    private WebElement profilepicimage;

    @FindBy(linkText="Logout")
    private WebElement logout;

    @FindBy(css="#logoutModal a")
    private WebElement logoutbutton;


    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAT() {
        this.wait.until(ExpectedConditions.visibilityOf(this.availableinventoryElement));
        return this.availableinventoryElement.isDisplayed();
    }

    public String earningmonthly()
    {
        return this.MonthlyEarningElement.getText();
    }

    public String earningannualy()
    {
        return this.annualEarningElement.getText();
    }

    public String profitmargin()
    {
        return this.profitMarginElement.getText();
    }

    public String avilableinventory()
    {
        return this.availableinventoryElement.getText();
    }


    public int getcountentries()
    {
        String countdata = this.datatableinfo.getText();

        String[] arr = countdata.split(" ");

        int dataentires = Integer.parseInt(arr[5]);

        return dataentires;

    }

     public void searchorderhistory(String keyword)
     {
        this.SearchInput.sendKeys(keyword);

     }
    public void logout()
    {
        this.profilepicimage.click();
        this.wait.until(ExpectedConditions.visibilityOf(this.logout));
        this.logout.click();
        this.wait.until(ExpectedConditions.visibilityOf(this.logoutbutton));
        this.logoutbutton.click();
    }






}
