package com.seleniumDocker;

import com.google.common.util.concurrent.Uninterruptibles;
import com.seleniumDocker.Test.utils.Config;
import com.seleniumDocker.Test.utils.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public abstract class BaseTest {


    protected WebDriver driver;

    @BeforeSuite
    public void setupConfig()
    {
        Config.inilized();
    }

    @BeforeTest
   // @Parameters({"browser"})
    public void setDriver() throws MalformedURLException {

       if(Boolean.parseBoolean(Config.get(Constants.GRID_ENABLED)))
       {
           this.driver = getRemotedriver();
       }
       else {
           this.driver = getLocaldriver();
       }



     //OLD CODE
      /*
       if(Boolean.getBoolean("selenium.grid.enable"))
       {
        this.driver = getRemotedriver();
       }
       else
       {
       this.driver = getLocaldriver();
       }*/
    }

    private WebDriver getRemotedriver() throws MalformedURLException {

        //OLD CODE
     /*   Capabilities capabilities;
       if(System.getProperty("browser").equalsIgnoreCase("chrome"))
        {
            capabilities = new ChromeOptions();
        }
        else {
            capabilities = new FirefoxOptions();
        }
        return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);*/

        //UPDATED CODE

        Capabilities capabilities = new ChromeOptions();
        if(Constants.FIREFOX.equalsIgnoreCase(Config.get(Constants.BROWSER)))
        {
            capabilities = new FirefoxOptions();
        }
        String URLFormat = Config.get(Constants.GRID_URL_Format);
        String hubHost = Config.get(Constants.GRID_HUB_HOST);
        String url = String.format(URLFormat,hubHost);
       // System.out.println(url);
        //return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);

       return new RemoteWebDriver(new URL(url),capabilities);




    }

    private WebDriver getLocaldriver()
    {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    @AfterTest
    public void quit()
    {
        this.driver.quit();
    }

    @AfterMethod
    public void sleep()
    {
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));
    }
}
