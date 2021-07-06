package com.redbus.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.redbus.base.TestBase;
import com.redbus.util.TestUtil;

public class HomePage extends TestBase {
	
	TestUtil testUtil;
	
	
	/*********************Elements****************/
	@FindBy(how = How.XPATH, using = "//*[@class = \"redbus-logo home-redirect\"]")
	WebElement redBusLogo;

	@FindBy(how = How.ID, using = "redBus")
	WebElement busTicketsLink;

	@FindBy(how = How.ID, using = "cars")
	WebElement rPoolLink;

	@FindBy(how = How.ID, using = "redBus Bus Hire")
	WebElement busHireLink;

	@FindBy(how = How.LINK_TEXT, using = "Help")
	WebElement helpLink;
	
	@FindBy(how = How.XPATH, using = "//div[@id='safetyplusClick']")
	WebElement safetyplusKnowMore;
	
	
	//search buses elements
	@FindBy(how = How.ID, using = "src")
	WebElement fromLocation;

	@FindBy(how = How.ID, using = "dest")
	WebElement toLocation;

	@FindBy(how = How.ID, using = "onward_cal")
	WebElement dateEle;

	@FindBy(how = How.XPATH, using = "rb-calendar_onward_cal")
	WebElement calendar ;

	@FindBy(how = How.XPATH, using = "//*[text()='Search Buses']")
	private WebElement searchBusesButton;
	


	
	public HomePage() {
		PageFactory.initElements(driver, this);
		testUtil = new TestUtil();
		
	}

	public void clickOnRedBusLogo() {

		redBusLogo.click();
	}

	public void clickOnBusTicketsLink() {

		busTicketsLink.click();
	}

	public void clickOnBusHireLink() {

		busHireLink.click();
	}

	public void clickOnRPoolLink() {

		rPoolLink.click();
	}

	public void clickOnHelpLink() {

		helpLink.click();
	}
	
	public void clickOnKnowMore() {
		
		safetyplusKnowMore.click();
	}
	
	public void enterFromLocation(String location) throws InterruptedException {
		
		fromLocation.sendKeys(location);
		
		Thread.sleep(1000);
		
		fromLocation.sendKeys(Keys.DOWN);
		fromLocation.sendKeys(Keys.UP);
		
		fromLocation.sendKeys(Keys.ENTER);
		
	}
	
	public void enterToLocation(String location) throws InterruptedException {
		
		toLocation.sendKeys(location);
		
		Thread.sleep(1000);
		
		toLocation.sendKeys(Keys.DOWN);
		toLocation.sendKeys(Keys.UP);
		toLocation.sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
	}
	
	public void enterDate(String date) throws InterruptedException {
		
		dateEle.click();
		
		testUtil.selectDateThroughCalendarOnSearchPage(driver, dateEle, date);
		
		
		
		Thread.sleep(1000);
		
	}
	
	public void clickOnSearchButton() throws InterruptedException {
		
		
		//JavascriptExecutor jse = (JavascriptExecutor)driver;
		//jse.executeScript("arguments[0].click()", searchBusesButton);
		
		searchBusesButton.click();
		Thread.sleep(2000);
	}
	
	public String SearchResult(String locationFrom,String locationto) {
		
		WebElement result = driver.findElement(By.xpath("//h1[contains(text(),'"+locationFrom+" to "+locationto+" Bus')]"));
		
		return result.getText();
	}
	
	public boolean invalidCaseResult() {
		
		return searchBusesButton.isDisplayed();
		
	}
	
}


