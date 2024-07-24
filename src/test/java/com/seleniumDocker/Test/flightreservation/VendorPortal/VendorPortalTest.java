package com.seleniumDocker.Test.flightreservation.VendorPortal;

import org.testng.annotations.*;
import org.testng.AssertJUnit;
import com.SeleniumDocker.pages.flightReservation.FlightREservation.Vendorportal.DashboardPage;
import com.SeleniumDocker.pages.flightReservation.FlightREservation.Vendorportal.LoginPage;
import com.seleniumDocker.BaseTest;
import com.seleniumDocker.Test.flightreservation.VendorPortal.model.VendorPortalTestData;
import com.seleniumDocker.Test.utils.Config;
import com.seleniumDocker.Test.utils.Constants;
import com.seleniumDocker.Test.utils.JsonUtils;
import org.testng.Assert;
import org.testng.annotations.Test;



public class VendorPortalTest extends BaseTest {

    private LoginPage loginPage;
    private DashboardPage dashboardPage;

    private VendorPortalTestData testData;

    @BeforeTest
    @Parameters("testdatapath")
    public void setPage(String testdatapath) {
        this.loginPage = new LoginPage(driver);
        this.dashboardPage = new DashboardPage(driver);
        this.testData = JsonUtils.getTestData(testdatapath);
    }

    @Test
    public void logintest()
    {
        loginPage.Goto(Config.get(Constants.VENDOR_PORTAL_URL));
        AssertJUnit.assertTrue(loginPage.isAT());
        loginPage.setLoginbutton(testData.getUsername(),testData.getPassword());
    }

    @Test(dependsOnMethods = "logintest")
    public void dashbaordtest()
    {
        AssertJUnit.assertTrue(dashboardPage.isAT());


        AssertJUnit.assertEquals(dashboardPage.earningmonthly(),testData.getMonthlyEarning());
        AssertJUnit.assertEquals(dashboardPage.earningannualy(),testData.getAnnualEarning());
        AssertJUnit.assertEquals(dashboardPage.profitmargin(),testData.getProfitmargin());
        AssertJUnit.assertEquals(dashboardPage.avilableinventory(),testData.getAvilableinventory());



        dashboardPage.searchorderhistory(testData.getSearchkeyword());

        AssertJUnit.assertEquals(dashboardPage.getcountentries(),testData.getSearchresultcount());
    }

    @Test(dependsOnMethods = "dashbaordtest")
    public void logout()
    {
        dashboardPage.logout();
        AssertJUnit.assertTrue(loginPage.isAT());

    }

}
