package com.redbus.testcases;

import java.util.HashMap;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.redbus.base.TestBase;
import com.redbus.pages.HomePage;
import com.redbus.pages.SignInPage;
import com.redbus.util.ExcelFileUtils;
import com.redbus.util.TestUtil;

public class HomePageTest extends TestBase{
	
	TestUtil testUtil;

	HomePage homepage ;
	
	ExcelFileUtils reader;
	
	String sheetName = "HomePage";
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		homepage= new HomePage();
		reader = new ExcelFileUtils(prop.getProperty("excelfile"));
	}
	
	@Test(priority=1)
	public void validateRedBusLogo() {
		
		String testName = "validateRedBusLogo";
		
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		String expectedResult = testData.get("ExpectedResult");
		String executionRequired = testData.get("ExecutionRequired").toLowerCase();
		
		// if execution required field is no
		testUtil.toCheckExecutionRequired(executionRequired);
		
		homepage.clickOnRedBusLogo();
		
		String actual = driver.getTitle().toLowerCase();
		
		Assert.assertEquals(actual, expectedResult);
		
	}
	
	@Test(priority=2)
	public void validateBusHireLink() {
		
		//reading data from excel file
		String testName = "validateBusHireLink";
		
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		String expectedResult = testData.get("ExpectedResult");
		String executionRequired = testData.get("ExecutionRequired").toLowerCase();
		
		// if execution required field is no
		testUtil.toCheckExecutionRequired(executionRequired);
		
		
		//test
		homepage.clickOnBusHireLink();
		
		String actual = driver.getTitle().toLowerCase();
		
		Assert.assertEquals(actual, expectedResult ,"title is not as expected");
	}
	
	@Test(priority=3)
	public void validateRPoolLink() {
		
		//reading data from excel
		String testName = "validateRPoolLink";
				
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		String expectedResult = testData.get("ExpectedResult");
		String executionRequired = testData.get("ExecutionRequired").toLowerCase();
				
		// if execution required field is no
		testUtil.toCheckExecutionRequired(executionRequired);
		
		//test
		homepage.clickOnRPoolLink();
		
		String actual = driver.getTitle().toLowerCase();
		
		Assert.assertEquals(actual, expectedResult,"title is not as expected");
	}
	
	
	@Test(priority=4)
	public void validateBusTicketLink() {
		
		//reading data from excel file
		String testName = "validateBusTicketLink";
				
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		String expectedResult = testData.get("ExpectedResult");
		String executionRequired = testData.get("ExecutionRequired").toLowerCase();
				
		// if execution required field is no
		testUtil.toCheckExecutionRequired(executionRequired);
		
		//test
		homepage.clickOnBusTicketsLink();
		
		String actual = driver.getTitle().toLowerCase();
		
		Assert.assertEquals(actual, expectedResult);
		
	}
	
	@Test(priority=5)
	public void validateHelpLink() {
		
		//reading data from excel file
		String testName = "validateHelpLink";
						
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		String expectedResult = testData.get("ExpectedResult");
		String executionRequired = testData.get("ExecutionRequired").toLowerCase();
						
		// if execution required field is no
		testUtil.toCheckExecutionRequired(executionRequired);
		
		//test
		homepage.clickOnHelpLink();
		
		testUtil.switchToChildWindow();
		
		String actual = driver.getTitle().toLowerCase();
		
		Assert.assertEquals(actual, expectedResult);
	}
	
	@Test(priority=6)
	public void validateSafetyPlusKnowMoreLink() {
		
		//reading data from excel file
		String testName = "validateSafetyPlusKnowMoreLink";
						
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		String expectedResult = testData.get("ExpectedResult");
		String executionRequired = testData.get("ExecutionRequired").toLowerCase();
								
		// if execution required field is no
		testUtil.toCheckExecutionRequired(executionRequired);
				
		//test
		homepage.clickOnKnowMore();
		
		Assert.assertEquals(driver.getCurrentUrl(), expectedResult);
		
	}
	
	@Test(priority=7)
	public void searchWithValidData() throws InterruptedException {
		
		//reading data from excel file
		String testName = "searchWithValidData";
								
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		String executionRequired = testData.get("ExecutionRequired").toLowerCase();
		String from = testData.get("From");
		String to = testData.get("To");
		String date = testData.get("Date");
										
		// if execution required field is no
		testUtil.toCheckExecutionRequired(executionRequired);
						
		//test
		
		homepage.enterFromLocation(from);
		
		homepage.enterToLocation(to);
		
		homepage.enterDate(date);
		
		homepage.clickOnSearchButton();
		
		
		
		String actual = homepage.SearchResult(from, to);
		
		Assert.assertEquals(actual, from+" To "+to+" Bus");
	}
	
	@Test(priority=8)
	public void searchWithInvalidFromLocation() throws InterruptedException {
		
		//reading data from excel file
		String testName = "searchWithInvalidFromLocation";
										
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		String executionRequired = testData.get("ExecutionRequired").toLowerCase();
		String from = testData.get("From");
		String to = testData.get("To");
		String date = testData.get("Date");
												
		// if execution required field is no
		testUtil.toCheckExecutionRequired(executionRequired);
								
		//test
		homepage.enterFromLocation(from);
		
		homepage.enterToLocation(to);
		
		homepage.enterDate(date);
		
		homepage.clickOnSearchButton();
		
		Assert.assertTrue(homepage.invalidCaseResult());
	}
	
	@Test(priority=9)
	public void searchWithInvalidToLocation() throws InterruptedException {
		
		//reading data from excel file
		String testName = "searchWithInvalidToLocation";
												
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		String executionRequired = testData.get("ExecutionRequired").toLowerCase();
		String from = testData.get("From");
		String to = testData.get("To");
		String date = testData.get("Date");
														
		// if execution required field is no
		testUtil.toCheckExecutionRequired(executionRequired);
										
		//test
		
		homepage.enterFromLocation(from);
		
		homepage.enterToLocation(to);
		
		homepage.enterDate(date);
		
		homepage.clickOnSearchButton();
		
		Assert.assertTrue(homepage.invalidCaseResult());
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
