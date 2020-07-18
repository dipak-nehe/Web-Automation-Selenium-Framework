package org.ecommerce.com;

public class FlightsReservationPage {
	
	//round trip radio button
	//public static String roundTripTypeValue="tripType";
	public static String roundTripTypeValue="roundtrip";
	public static String onewayTripTypeValue="oneway";
	public static String roundTripTypeValueXpath= "//*[@value=" + "'" + roundTripTypeValue +"']";
	public static String onewayTypeValueXpath= "//*[@value=" + "'" + onewayTripTypeValue +"']";
	public static String Passanger="passCount";
	public static String fromPortName="fromPort";
	public static String fromMonthName="fromMonth";
	public static String fromDayName="fromDay";
	public static String toPortName="toPort";
	public static String toMonthName="toMonth";
	public static String toDayName="toDay";
	public static String serviceClassValue="Business";
	public static String serviceClassValueXpath= "//*[@value=" + "'" + serviceClassValue +"']";
	public static String perfAirlineName="airline";
	public static String findFlightButton="findFlights";


}
