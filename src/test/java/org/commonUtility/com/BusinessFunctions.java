package org.commonUtility.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.openqa.selenium.support.ui.Select;


public class BusinessFunctions {
	public static String urlForWeb="http://demo.guru99.com/test/newtours/index.php";
	//"http://automationpractice.com/index.php";
	public static String pathToChromeDriver="C:\\Users\\dipak\\eclipse-workspace\\selenium-web\\src\\test\\resources\\chromedriver.exe";
	public static String expectedTitle="Welcome: Mercury Tours";//"My Store";
	public static boolean falseValue=false;
	public static String loggedInPageTitle="Login: Mercury Tours";
	public static String findFlighPageTitle="Find a Flight: Mercury Tours:";

	
	public static enum locator 
	{ 
	    name, xpath, Id,ClassName,cssSelector,linkText,partialLinkText,tagName; 
	} 
	  
	
	
	//get element based on locator type
	public static WebElement getWebElementByLocator(String locator,WebDriver driver,String locatorValue)
	{
		WebElement element=null;
		
		 switch (locator) 
		 {
         	case "XPATH":
         		  element=driver.findElement(By.xpath(locatorValue));

                  break;
         	case "ID":  
       		  element=driver.findElement(By.id(locatorValue));

                  break;
         	case "NAME":
         		  element=driver.findElement(By.name(locatorValue));
                  break;    
           	case "LINKTEXT":
       		  element=driver.findElement(By.linkText(locatorValue));
                break; 
         	default:
                  break;
         }
		return element;
		
	}
	
	//Select type
	public static Select getSelectElement(String locator,WebDriver driver,String locatorValue)
	{
		Select element=null;
		
		 switch (locator) 
		 {
         	case "XPATH":
         		  element=new Select(driver.findElement(By.xpath(locatorValue)));

                  break;
         	case "ID":  
       		  element=new Select(driver.findElement(By.id(locatorValue)));

                  break;
         	case "NAME":
         		  element=new Select(driver.findElement(By.name(locatorValue)));
                  break;    
           	case "LINKTEXT":
       		  element=new Select(driver.findElement(By.linkText(locatorValue)));
                break; 
         	default:
                  break;
         }
		 
		return element;
		
	}
	
	
	//set  txt in a input text box 
	public static void setTextInTxtBox(WebElement element, String keysToSend)
	{
		System.out.println("Inserting login value:"+element.toString()+" with value-> "+keysToSend);
		
		if(element.isEnabled())
		{
		element.sendKeys(keysToSend);
		}
		else
		{
			Assert.assertFalse(falseValue, "TxtBpx: "+element.getText()+" not enabled");
			
		}
		
	}
	
	
	//click on submit button
		public static void clickOnElement(WebElement element)
		{
			if(element.isEnabled())
			{
			element.click();
			}
			else
			{
				Assert.assertFalse(falseValue, "Submit Button: "+element.getText()+" not enabled");
				
			}
			
		}

		//select radio button
		public static void selectRadioButton(WebElement element)
		{
			if(element.isEnabled())
			{
			element.click();
			}
			else
			{
				Assert.assertFalse(falseValue, "radio Button: "+element.getText()+" not enabled");
				
			}
		}
		
		//drop down select
		public static void selectValueFromDropDown(Select select,String value)		
		{
			select.selectByValue(value);
			
		}
		
		//drop down select
		public static void selectValueFromDropDownByVisibleText(Select select,String value)		
		{
			select.selectByVisibleText(value);
			
		}
		
	
}  
