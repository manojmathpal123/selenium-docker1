package com.SeleniumDocker.pages.flightReservation.FlightREservation;
import com.SeleniumDocker.pages.AbstractPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class REgistrationPage extends AbstractPage{

    @FindBy(id = "firstName")
    private WebElement FirstName;

    @FindBy(id="lastName")
    private WebElement LastName;

    @FindBy(id="email")
    private WebElement Email;

    @FindBy(id="password")
    private WebElement Password;

    @FindBy(name="street")
    private WebElement StreetName;

    @FindBy(name="city")
    private WebElement City;

    @FindBy(id="inputState")
    private WebElement State;

    @FindBy(name="zip")
    private WebElement Zip;

    @FindBy(id="register-btn")
    private WebElement Registerbtn;



    public REgistrationPage(WebDriver driver)
    {
        super(driver);

    }

    @Override
    public boolean isAT() {
        this.wait.until(ExpectedConditions.visibilityOf(this.FirstName));
        return this.FirstName.isDisplayed();
    }

    public void goTo(String url)
    {
        this.driver.get(url);
        this.driver.manage().window().maximize();
    }

    public void EnterUserDetails(String firstname, String lastname)
    {
        this.FirstName.sendKeys(firstname);
        this.LastName.sendKeys(lastname);
    }

    public void EnterUserCredentials(String email,String password)
    {
        this.Email.sendKeys(email);
        this.Password.sendKeys((password));
    }

    public void EnterUserAddress(String Street,String city)
    {
        this.StreetName.sendKeys(Street);
        this.City.sendKeys(city);
    }

    public void EnterStatedetails(String statedata)
    {
        Select select = new Select(this.State);
        select.selectByVisibleText(statedata);
    }

    public void EnterZipcode(String zipcode)
    {
        this.Zip.sendKeys(zipcode);
    }

    public void ClickOnRegsitrationbutton() throws InterruptedException {
        Thread.sleep(300);
        this.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        this.wait.until(ExpectedConditions.visibilityOf(this.Registerbtn));
        this.Registerbtn.click();
    }


}
