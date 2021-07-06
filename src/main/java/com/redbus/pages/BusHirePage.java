package com.redbus.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.redbus.base.TestBase;
import com.redbus.util.TestUtil;

public class BusHirePage extends TestBase{
	
	TestUtil testutil;

	@FindBy(how = How.XPATH, using = "//object")
	WebElement frameWindow;

	//outstation Elements
	@FindBy(how = How.XPATH, using = "//*[text() = 'Outstation']")
	WebElement outStation;

	@FindBy(how = How.ID, using = "locationTextFieldLocal")
	WebElement pickUpPointOnOutstation;

	@FindBy(how = How.ID, using = "local_dest_name")
	WebElement destinationOnOutstation;

	@FindBy(how = How.XPATH, using = "//*[@id='from_datepicker']/div/div/input")
	WebElement fromDateAndTimeForOutstation;

	@FindBy(how = How.XPATH, using = "//*[@id='to_datepicker']/div/div/input")
	WebElement toDateAndTimeForOutstation;

	@FindBy(how = How.ID, using = "numberOfPax")
	WebElement PassengersNo;

	@FindBy(how = How.XPATH, using = "//*[@id = 'proceedButtonOutstation']")
	WebElement proceedButton;
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Fill Contact Details')]")
	WebElement outstationResult;
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Your pickup can not be empty')]")
	WebElement pickUpEmpty;
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Your destination can not be empty')]")
	WebElement destinationEmpty;
	
	@FindBy(how = How.ID, using = "date_error")
	WebElement dateError;
	
	@FindBy(how = How.XPATH, using = "//div[@id='pax_error']")
	WebElement passengerNumberError;

	// local Menu
	@FindBy(how = How.XPATH, using = "//*[text() = 'Local']")
	WebElement local;
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Local')]")
	WebElement localTitle;

	// airport Elements
	@FindBy(how = How.XPATH, using = "//*[text() = 'Airport']")
	WebElement airPort;
	
	@FindBy(how = How.XPATH, using = "//body/div[@id='AirporLeadGen_LandingPage']"
			+ "/div[@id='bodyCont']/div[2]/div[1]/div[1]/div[2]")
	WebElement airportTitle;
	
	
	
	public BusHirePage() {
		PageFactory.initElements(driver, this);
		testutil = new TestUtil();
	}
	
	
	public void clickOnOutstation() throws InterruptedException {

		testutil.switchToFrame(frameWindow);
		outStation.click();
		
		Thread.sleep(2000);
	}
	
	public void enterPickUpLocation(String location) throws InterruptedException {
		
		pickUpPointOnOutstation.sendKeys(location);
		
		Thread.sleep(2000);
		
		pickUpPointOnOutstation.sendKeys(Keys.DOWN);
		pickUpPointOnOutstation.sendKeys(Keys.ENTER);
		
	}
	
	public void enterDestination(String location) throws InterruptedException {
		
		destinationOnOutstation.sendKeys(location);
		
		Thread.sleep(2000);
		
		destinationOnOutstation.sendKeys(Keys.DOWN);
		destinationOnOutstation.sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
	}
	
	public void selectDateAndTime(String fromDateAndTime, String toDateAndTime) throws Exception {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		 
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", fromDateAndTimeForOutstation);
		
		//selecting 'from when' date and time 
		testutil.selectDateAndTimeAtBusHirePage(driver, fromDateAndTime);
		
		toDateAndTimeForOutstation.click();
		
		// selecting 'till when' date and time
		testutil.selectDateAndTimeAtBusHirePage(driver, toDateAndTime);		
		
	}
	
	public void enterPassengersNumber(String noOfPassengers) throws InterruptedException {
		

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
	
		Thread.sleep(100);
		
		PassengersNo.clear();
		PassengersNo.sendKeys(noOfPassengers);
		
	}
	
	public void clickOnProceed() throws InterruptedException {
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", proceedButton);
		
	
			Thread.sleep(1000);
	}
	
	public boolean outstationSuccess() {
		
		return outstationResult.isDisplayed();
	}
	
	public boolean pickUpEmptyWarning() {
		
		 return pickUpEmpty.isDisplayed();
	}
	
	public boolean destinationEmptyWarning() {
		
		return destinationEmpty.isDisplayed();
	}
	
	public boolean wrongDate() {
		
		return dateError.isDisplayed();
	}
	
	public boolean wrongPassengerNumber() {
		
		return passengerNumberError.isDisplayed();
	}
	
	public void clickOnAirport() {
		
		testutil.switchToFrame(frameWindow);
		airPort.click();
	}
	
	public String airportText() {
		return airportTitle.getText();
	}
	
	public void clickOnLocal() throws Exception {
		
		testutil.switchToFrame(frameWindow);
		local.click();
		
		Thread.sleep(2000);
	}
	
	public String localText() {
		return localTitle.getText();
	}

	
}
