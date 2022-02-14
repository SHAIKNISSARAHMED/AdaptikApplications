package com.adaptikPolicyAndBilling.qa.pages;

import static org.testng.Assert.assertThrows;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.adaptikPolicyAndBilling.qa.base.TestBase;

import io.qameta.allure.Step;

public class AccountDashBoard extends TestBase {


	@FindBy(xpath="//button[contains(text(),'Make Adjustment')]")
	@CacheLookup
	WebElement MakeAdjustmentButton;
	
	@FindBy(xpath="//button[contains(text(),'Return Premium')]")
	@CacheLookup
	WebElement ReturnPremiumButton;
	
	@FindBy(xpath="//p[contains(text(),'Credit Receivable')]//parent::div//preceding-sibling::div")
	@CacheLookup
	WebElement CreditReceivable;
	public AccountDashBoard() {
		PageFactory.initElements(driver, this);
	}
	
	@Step("getting AccountDashBoard page title step....")
	public String validatePageTitle() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		return driver.getTitle();
	
	}
	
	@Step("Clicking on Make Adjustment Button")
	public AdjustmentDetailsPage clickOnMakeAdjustment( ) {
	CreditReceivable.click();
	MakeAdjustmentButton.click();
	return new AdjustmentDetailsPage();
	}
	
	@Step("Clicking on RetrunPremium Button")
	public RetrunPremiumDetailsPage clickOnRetrunPremium() {
		ReturnPremiumButton.click();
		return new RetrunPremiumDetailsPage();
	}
	
	
	
}
