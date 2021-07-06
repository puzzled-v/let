package com.redbus.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.redbus.base.TestBase;
import com.redbus.util.TestUtil;

public class RPoolPage extends TestBase{
	
	TestUtil testUtil;
	
	@FindBy(how = How.XPATH, using = "//body/div[@id='reactContentMount']"
			+ "/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/a[1]/img[1]")
	WebElement googlePlay;
	
	@FindBy(how = How.XPATH, using = "//body/div[@id='reactContentMount']/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/a[1]/img[1]")
	WebElement appStore;
	
	public RPoolPage() {
		PageFactory.initElements(driver, this);
		testUtil = new TestUtil();
		
	}
	
	public void clickOnGooglePlayButton() {
		
		googlePlay.click();
		
		testUtil.switchToChildWindow();
	}
	
	public void clickOnAppStoreButton() {
		
		appStore.click();
		
		testUtil.switchToChildWindow();
		
	}
	

}
