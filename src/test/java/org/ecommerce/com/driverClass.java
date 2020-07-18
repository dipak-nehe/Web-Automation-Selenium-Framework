package org.ecommerce.com;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.commonUtility.com.BusinessFunctions;
import org.commonUtility.com.BusinessFunctions.locator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class driverClass {
	private static WebDriver driver;
    private static final boolean HEADLESS = true;

	
	@BeforeSuite
	public static void setupDriver()
	{
		System.setProperty("webdriver.chrome.driver", BusinessFunctions.pathToChromeDriver);
		ChromeOptions chromeOptions = new ChromeOptions();
        if (HEADLESS) {
            chromeOptions.addArguments("--headless");
        }

	    driver = new ChromeDriver(chromeOptions);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.get(BusinessFunctions.urlForWeb);
	    //Set<String> handles= driver.getWindowHandles();
	   
	    }
	
	@Test(enabled=true,priority=1)
	public static void verifyWebTitle()
	{
		String actualTitle =driver.getTitle();
		Assert.assertEquals(actualTitle, BusinessFunctions.expectedTitle);
		
	}
	
	@Test(enabled=true,priority=2)
	public static void login()
	{
		   //get widnows handles and switch to current window
		   Set<String> handles= driver.getWindowHandles();
		    for(String handle : handles)
		    {
		    	System.out.println("handle"+handle);
			    driver.switchTo().window(handle);

		    }
		    
		  //  driver.switchTo().window("6EA247F171B7C741C7CD9EE623D9EEBF");
		//find and set the value of the login
		BusinessFunctions.setTextInTxtBox(BusinessFunctions.getWebElementByLocator(locator.name.name().toUpperCase(), driver,LoginPage.loginTxtBoxName),LoginPage.getLoginValue());
		
		//find and set the value of the password
		BusinessFunctions.setTextInTxtBox(BusinessFunctions.getWebElementByLocator(locator.name.name().toUpperCase(), driver,LoginPage.passwdTxtBoxName), LoginPage.getPasswordValue());
			
		//Click on Submit button
		BusinessFunctions.clickOnElement(BusinessFunctions.getWebElementByLocator(locator.name.name().toUpperCase(), driver,LoginPage.submitButtonName));

		//Assert.assertEquals(driver.getTitle(),BusinessFunctions.loggedInPageTitle,"user did not logged in successfuly");
		
	}
	
	@Test(enabled=true,priority=3)
	public static void clickOnFlightsLink()
	{
		
		//get widnows handles and switch to current window
		   Set<String> handles= driver.getWindowHandles();
		    for(String handle : handles)
		    {
		    	System.out.println("handle"+handle);
			    driver.switchTo().window(handle);

		    }
		//Click on Submit button
		BusinessFunctions.clickOnElement(BusinessFunctions.getWebElementByLocator(locator.linkText.name().toUpperCase(), driver,HomePage.FlightLinkTxt));
		Assert.assertEquals(driver.getTitle(),BusinessFunctions.findFlighPageTitle,"user is not on find a flight");
	}

	@Test(enabled=true,priority=4,dataProvider = "FlightReservation")
	public static void oneWayTrip(String numPass,String fromCity,String fromMonth,String fromDay,String toCity,String toMonth,String toDay,String airlineName)
	{
		//get widnows handles and switch to current window
		   Set<String> handles= driver.getWindowHandles();
		    for(String handle : handles)
		    {
		    	System.out.println("handle"+handle);
			    driver.switchTo().window(handle);

		    }
		//trip type selection
		BusinessFunctions.clickOnElement(BusinessFunctions.getWebElementByLocator(locator.xpath.name().toUpperCase(), driver,FlightsReservationPage.onewayTypeValueXpath));
		//Passanger number selection
		BusinessFunctions.selectValueFromDropDown(BusinessFunctions.getSelectElement(locator.name.name().toUpperCase(), driver,FlightsReservationPage.Passanger),numPass);
		
		//from passange select
		BusinessFunctions.selectValueFromDropDown(BusinessFunctions.getSelectElement(locator.name.name().toUpperCase(), driver,FlightsReservationPage.fromPortName),fromCity);
       //from month
		BusinessFunctions.selectValueFromDropDown(BusinessFunctions.getSelectElement(locator.name.name().toUpperCase(), driver,FlightsReservationPage.fromMonthName),fromMonth);
      //from Day
		BusinessFunctions.selectValueFromDropDown(BusinessFunctions.getSelectElement(locator.name.name().toUpperCase(), driver,FlightsReservationPage.fromDayName),fromDay);


		//to passange select
		BusinessFunctions.selectValueFromDropDown(BusinessFunctions.getSelectElement(locator.name.name().toUpperCase(), driver,FlightsReservationPage.toPortName),toCity);
       //to month
		BusinessFunctions.selectValueFromDropDown(BusinessFunctions.getSelectElement(locator.name.name().toUpperCase(), driver,FlightsReservationPage.toMonthName),toMonth);
      //to Day
		BusinessFunctions.selectValueFromDropDown(BusinessFunctions.getSelectElement(locator.name.name().toUpperCase(), driver,FlightsReservationPage.toDayName),toDay);

		//service class
		BusinessFunctions.clickOnElement(BusinessFunctions.getWebElementByLocator(locator.xpath.name().toUpperCase(), driver,FlightsReservationPage.serviceClassValueXpath));
	
		//airline select
		BusinessFunctions.selectValueFromDropDownByVisibleText(BusinessFunctions.getSelectElement(locator.name.name().toUpperCase(), driver,FlightsReservationPage.perfAirlineName),airlineName);
   
		//click on the find flight buttons
		BusinessFunctions.clickOnElement(BusinessFunctions.getWebElementByLocator(locator.name.name().toUpperCase(), driver,FlightsReservationPage.findFlightButton));
		
		//click on flights page
	    for(String handle : handles)
	    {
	    	System.out.println("handle"+handle);
		    driver.switchTo().window(handle);

	    }
		BusinessFunctions.clickOnElement(BusinessFunctions.getWebElementByLocator(locator.linkText.name().toUpperCase(), driver,HomePage.FlightLinkTxt));

	}
	
	@AfterSuite
	public static void cleanUp()
	{
		driver.quit();
	}
		
	@DataProvider(name="FlightReservation", parallel = false)
	public static Object[][] dataProviderMethodLogin() {
	return new Object[][]{
	{"1", "London","7","17","New York","7","18","Pangea Airlines"},
	{"2", "New York","8","18","London","8","18","Unified Airlines"},
	{"3", "Frankfurt","9","19","Paris","9","19","Pangea Airlines"},
	{"4", "Paris","10","20","New York","10","20","No Preference"},
	{"3", "Acapulco","11","21","Portland","11","21","Pangea Airlines"},
	{"2", "Sydney","12","22","San Francisco","12","23","Pangea Airlines"},
	{"4", "Zurich","12","22","San Francisco","12","23","Pangea Airlines"}

	};
	}
	
}
