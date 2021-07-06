package com.redbus.testcases;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.redbus.base.TestBase;
import com.redbus.pages.BusHirePage;
import com.redbus.pages.HomePage;
import com.redbus.util.ExcelFileUtils;
import com.redbus.util.TestUtil;

public class BusHirePageTest extends TestBase{
	
	TestUtil testUtil;
	BusHirePage bushirepage ;
	HomePage homepage;
	ExcelFileUtils reader;	
	String sheetName = "BusHirePageTestData";
	
	
	public BusHirePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		bushirepage= new BusHirePage();
		homepage = new HomePage();
		homepage.clickOnBusHireLink();
		reader = new ExcelFileUtils(prop.getProperty("excelfile"));
	}
	
	@Test(priority=1)
	public void validDataOnOutstation() throws Exception {
		
		String testName = "validDataOnOutstation";
		
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		String expectedResult = testData.get("ExpectedResult");
		String executionRequired = testData.get("ExecutionRequired").toLowerCase();
		String pickupLocation = testData.get("Pickup Location");
		String destinationLocation = testData.get("Destination Location");
		String fromDate = testData.get("From Date and Time");
		String tillDate = testData.get("Till Date and Time");
		String passengers = testData.get("Number of Passengers");
		
		// if execution required field is no
		testUtil.toCheckExecutionRequired(executionRequired);
		
		
		bushirepage.clickOnOutstation();
		
		bushirepage.enterPickUpLocation(pickupLocation);
		
		bushirepage.enterDestination(destinationLocation);
		
		bushirepage.selectDateAndTime(fromDate, tillDate);
		
		bushirepage.enterPassengersNumber(passengers);
		
		Thread.sleep(1000);
		
		bushirepage.clickOnProceed();
		
		Thread.sleep(2000);
		
		Assert.assertTrue(bushirepage.outstationSuccess(),"Assertion failed, element not founded");
		
	}
	
	@Test(priority=2)
	public void invalidpickUpLocationOnOutstation() throws Exception {
		
		String testName = "invalidpickUpLocationOnOutstation";
		
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		String expectedResult = testData.get("ExpectedResult");
		String executionRequired = testData.get("ExecutionRequired").toLowerCase();
		String pickupLocation = testData.get("Pickup Location");
		String destinationLocation = testData.get("Destination Location");
		String fromDate = testData.get("From Date and Time");
		String tillDate = testData.get("Till Date and Time");
		String passengers = testData.get("Number of Passengers");
		
		// if execution required field is no
		testUtil.toCheckExecutionRequired(executionRequired);
		
		bushirepage.clickOnOutstation();
		
		bushirepage.enterDestination(destinationLocation);
		

		bushirepage.selectDateAndTime(fromDate, tillDate);
		
		bushirepage.enterPassengersNumber(passengers);
		
		bushirepage.clickOnProceed();
		
		Assert.assertTrue(bushirepage.pickUpEmptyWarning());
	}
	
	@Test(priority=3)
	public void invalidDestinationOnOutstation() throws Exception {
		
		String testName = "invalidDestinationOnOutstation";
		
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		String expectedResult = testData.get("ExpectedResult");
		String executionRequired = testData.get("ExecutionRequired").toLowerCase();
		String pickupLocation = testData.get("Pickup Location");
		String destinationLocation = testData.get("Destination Location");
		String fromDate = testData.get("From Date and Time");
		String tillDate = testData.get("Till Date and Time");
		String passengers = testData.get("Number of Passengers");
		
		// if execution required field is no
		testUtil.toCheckExecutionRequired(executionRequired);
	
		bushirepage.clickOnOutstation();
		
		bushirepage.enterPickUpLocation(pickupLocation);
		
		bushirepage.selectDateAndTime(fromDate, tillDate);
		
		bushirepage.enterPassengersNumber(passengers);
		
		bushirepage.clickOnProceed();
		
		Thread.sleep(2000);
		
		Assert.assertTrue(bushirepage.destinationEmptyWarning());
		
	}
	
	@Test(priority=4)
	public void invalidFromWhenDataOnOutstation() throws Exception {
		
		String testName = "invalidFromWhenDataOnOutstation";
		
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		String expectedResult = testData.get("ExpectedResult");
		String executionRequired = testData.get("ExecutionRequired").toLowerCase();
		String pickupLocation = testData.get("Pickup Location");
		String destinationLocation = testData.get("Destination Location");
		String fromDate = testData.get("From Date and Time");
		String tillDate = testData.get("Till Date and Time");
		String passengers = testData.get("Number of Passengers");
		
		// if execution required field is no
		testUtil.toCheckExecutionRequired(executionRequired);
		
		
		bushirepage.clickOnOutstation();
		
		bushirepage.enterPickUpLocation(pickupLocation);
		
		bushirepage.selectDateAndTime(fromDate, tillDate);
		
		bushirepage.enterPassengersNumber(passengers);
		
		bushirepage.clickOnProceed();
		
		Thread.sleep(2000);
		
		Assert.assertTrue(bushirepage.wrongDate());
		
	}
	
	@Test(priority=5)
	public void invalidPassengerNumber() throws Exception {
		
		String testName = "invalidPassengerNumber";
		
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		String expectedResult = testData.get("ExpectedResult");
		String executionRequired = testData.get("ExecutionRequired").toLowerCase();
		String pickupLocation = testData.get("Pickup Location");
		String destinationLocation = testData.get("Destination Location");
		String fromDate = testData.get("From Date and Time");
		String tillDate = testData.get("Till Date and Time");
		String passengers = testData.get("Number of Passengers");
		
		// if execution required field is no
		testUtil.toCheckExecutionRequired(executionRequired);
		
		bushirepage.clickOnOutstation();
		
		bushirepage.enterPickUpLocation(pickupLocation);
		
		bushirepage.enterDestination(destinationLocation);
		
		bushirepage.selectDateAndTime(fromDate, tillDate);
		
		bushirepage.enterPassengersNumber(passengers);
		
		Thread.sleep(1000);
		
		Assert.assertTrue(bushirepage.wrongPassengerNumber());
		
	}
	
	@Test(priority=6)
	public void validationOfAirportLink() throws InterruptedException {
		
		String testName = "validationOfAirportLink";
		
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		String expectedResult = testData.get("ExpectedResult");
		String executionRequired = testData.get("ExecutionRequired").toLowerCase();
		
		// if execution required field is no
		testUtil.toCheckExecutionRequired(executionRequired);
		
		bushirepage.clickOnAirport();
		
		Thread.sleep(1000);
		
		Assert.assertEquals(bushirepage.airportText(), expectedResult);
		
	}
	
	@Test(priority=7)
	public void validationOfLocalLink() throws Exception {
		
		String testName = "validationOfLocalLink";
		
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		String expectedResult = testData.get("ExpectedResult");
		String executionRequired = testData.get("ExecutionRequired").toLowerCase();
		
		// if execution required field is no
		testUtil.toCheckExecutionRequired(executionRequired);
		
		bushirepage.clickOnLocal();
		
		Assert.assertEquals(bushirepage.localText(), expectedResult);
		
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	

}
