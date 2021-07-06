package com.redbus.pages;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.redbus.base.TestBase;
import com.redbus.util.TestUtil;

public class SignInPage extends TestBase {
	
	TestUtil testutil;

	//Locators
	@FindBy(id="signin-block")
	WebElement signin;
	
	@FindBy(id="signInLink")
	WebElement signInLink;
	
	 @FindBy(how = How.XPATH, using ="//*[@id=\"mobileNoInp\"]") 
	 WebElement mobileNoField;
	 
	 @FindBy(className="nsm7Bb-HzV7m-LgbsSe-BPrWId")
	 WebElement googleButton;
	 
	 @FindBy(xpath="//span[contains(text(),'Please enter valid mobile number')]")
	 WebElement errorMessage;
	 
	 @FindBy(id="rc-anchor-container")
	 WebElement captcha;
	 
	 @FindBy(className="modalIframe")
	 WebElement signInFrame;
	 
	 @FindBy(xpath="//body/div[@id='signIn']/div[@id='signInView']"
	 		+ "/div[2]/div[1]/div[1]/div[5]/div[1]/div[1]/iframe[1]")
	 WebElement captchaFrame;
	
	public SignInPage() {
		PageFactory.initElements(driver, this);
		testutil = new TestUtil();
	}
	
	public boolean invalidSignin(String number) throws InterruptedException {
		
		signin.click();
		signInLink.click();
		
		driver.switchTo().frame(driver.findElement(By.className("modalIframe")));
		
		Thread.sleep(2000);
		
		mobileNoField.sendKeys(number);
		
		//driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@title,'Sign in with Google Button')]")));
		
		return errorMessage.isDisplayed();
	}
	
	public boolean validSignin(String number) throws InterruptedException {
		
		signin.click();
		signInLink.click();
		
		testutil.switchToFrame(signInFrame);
		
		Thread.sleep(2000);
		
		mobileNoField.sendKeys(number);
		
		testutil.switchToFrame(captchaFrame);
		
		return captcha.isDisplayed();
	}
}
