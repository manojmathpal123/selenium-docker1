package com.seleniumDocker.Test.flightreservation;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import com.SeleniumDocker.pages.flightReservation.FlightREservation.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FlightReservationTest {

    private WebDriver driver;
    private String expectedresult;

    @BeforeTest
    @Parameters({"expectedresult"})
    public void setDriver(String expectedresult) {
        this.expectedresult = expectedresult;
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
    }

    @Test
    public void UserRegistrationTest() throws InterruptedException {
        REgistrationPage rEgistrationPage = new REgistrationPage(driver);
        rEgistrationPage.goTo("https://d1uh9e7cu07ukd.cloudfront.net/selenium-docker/reservation-app/index.html#");
        AssertJUnit.assertTrue(rEgistrationPage.isAT());
        rEgistrationPage.EnterUserDetails("manoj", "mathpal");
        rEgistrationPage.EnterUserCredentials("dockerselenium@gmail.com", "abc@123");
        rEgistrationPage.EnterUserAddress("pampauri", "delhi");
        rEgistrationPage.EnterStatedetails("California");
        rEgistrationPage.EnterZipcode("234567");
        rEgistrationPage.ClickOnRegsitrationbutton();

    }

    @Test(dependsOnMethods = "UserRegistrationTest")
    public void RegistrationConfirmationTest() {
        RegistrationConfirmationPage registrationConfirmationPage = new RegistrationConfirmationPage(driver);
        AssertJUnit.assertTrue(registrationConfirmationPage.isAT());
        registrationConfirmationPage.GoToFlightSearch();
    }

    @Test(dependsOnMethods = "RegistrationConfirmationTest")
    public void FlightSearchTest() throws InterruptedException {
        Thread.sleep(3000);
        FlightSearchPage flightSearchPage = new FlightSearchPage(driver);
        AssertJUnit.assertTrue(flightSearchPage.isAT());
        //flightSearchPage.SelectTRip();
       // flightSearchPage.ArrivalIn("London");
        flightSearchPage.SerachFlightResult();
    }

    @Test(dependsOnMethods = "FlightSearchTest")
    public void selectFlightConfirmationTest() throws InterruptedException {
        Thread.sleep(3000);
        SelectFlightPage selectFlightPage = new SelectFlightPage(driver);
        AssertJUnit.assertTrue(selectFlightPage.isAT());
        selectFlightPage.Selectflight();
        selectFlightPage.Confirmflight();
    }

    @Test(dependsOnMethods = "selectFlightConfirmationTest")
    public void FlightConfirmationTest() throws InterruptedException {
        Thread.sleep(3000);
        FlightConfirmationPage flightConfirmationPage = new FlightConfirmationPage(driver);
        AssertJUnit.assertTrue(flightConfirmationPage.isAT());
        AssertJUnit.assertEquals(flightConfirmationPage.getPrice(), expectedresult);

    }

    @AfterTest
    public void closeTest() {
        this.driver.quit();
    }
}

