package org.ecommerce.com;

public class LoginPage {
	
	//Women tab property
	public static String womenTabLocator = "Women";
	//XPath to find the women tab on home page
	public static String xpathString = "//a[@title=" + "'" + LoginPage.womenTabLocator+"']";
	
	//login txtbox locator value
	public static String loginTxtBoxName = "userName";
	
	//password txtbox locator value
	public static String passwdTxtBoxName = "password";
	
	//password txtbox locator value
	public static String submitButtonValue = "Submit";
	
	//XPath to find the women tab on home page
	public static String submitButtonXpath = "//*[@value=" + "'" + LoginPage.submitButtonValue+"']";
	public static String submitButtonName = "submit";

	
	//login value
	private static String loginValue = "tutorial";

	//password value
	private static String passwordValue = "tutorial";

	//get login value
	public static String getLoginValue()
	{
		return loginValue;
	}
	

	//get login value
	public static String getPasswordValue()
	{
		return passwordValue;
	}



}
