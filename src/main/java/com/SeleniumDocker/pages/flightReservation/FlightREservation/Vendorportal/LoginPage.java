package com.SeleniumDocker.pages.flightReservation.FlightREservation.Vendorportal;
import com.SeleniumDocker.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class LoginPage extends AbstractPage {

    @FindBy(id="username")
    private WebElement username;

    @FindBy(id="password")
    private WebElement password;

    @FindBy(id="login")
    private WebElement loginbutton;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAT() {
       this.wait.until(ExpectedConditions.visibilityOf(this.loginbutton));
       return this.loginbutton.isDisplayed();
    }

    public void setLoginbutton(String username, String password)
    {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        this.loginbutton.click();
    }

    public void Goto(String url)
    {
        this.driver.get(url);
        this.wait.until(ExpectedConditions.visibilityOf(this.username));
    }
}
