package com.redbus.testcases;



import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.redbus.base.TestBase;
import com.redbus.pages.SignInPage;
import com.redbus.util.TestUtil;

public class SignInPageTest extends TestBase {
	
	TestUtil testUtil;
	SignInPage signinPage;
	
	public SignInPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		signinPage= new SignInPage();
	}
	
	@Test(priority=1)
	public void validSignInTest() throws InterruptedException {
		
		Assert.assertTrue(signinPage.validSignin("7083472946"));
		
	}
	
	@Test(priority=2)
	public void invalidSignInTest() throws InterruptedException {
		
		Assert.assertTrue(signinPage.invalidSignin("4567"),"Assertion Failed, Element not present");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
