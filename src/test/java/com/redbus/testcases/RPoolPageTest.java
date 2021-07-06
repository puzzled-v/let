package com.redbus.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.redbus.base.TestBase;
import com.redbus.pages.HomePage;
import com.redbus.pages.RPoolPage;
import com.redbus.pages.SignInPage;
import com.redbus.util.TestUtil;

public class RPoolPageTest extends TestBase {


	TestUtil testUtil;
	HomePage homePage;
	RPoolPage rPoolPage;
	
	public RPoolPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		homePage= new HomePage();
		rPoolPage = new RPoolPage();
		
		homePage.clickOnRPoolLink();
	}
	
	@Test(priority=1)
	public void validationOfGooglePlayButton() {
		
		rPoolPage.clickOnGooglePlayButton();
		String currentUrl = driver.getCurrentUrl();
		
		Assert.assertEquals(currentUrl, "https://play.google.com/store/apps/details?id=in.redbus.android&amp;hl=en");
		
	}
	
	@Test(priority=2)
	public void validationOfAppStoreButton() {
		
		rPoolPage.clickOnAppStoreButton();
		String currentUrl = driver.getCurrentUrl();
		
		Assert.assertEquals(currentUrl, "https://apps.apple.com/in/app/redbus/id733712604");
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
