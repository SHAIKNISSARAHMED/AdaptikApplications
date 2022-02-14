package com.adaptikPolicyAndBilling.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.adaptikPolicyAndBilling.qa.base.TestBase;

public class AdjustmentsPage extends TestBase {

	@FindBy(xpath="//button[contains(text(),'Reverse Adjustment')]")
	@CacheLookup
	WebElement ReverseAdjustmentButton;
	
	public AdjustmentsPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public AdjustmentsPage clickOnReverseAdjustment() {
		ReverseAdjustmentButton.click();
		
		return new AdjustmentsPage();
	}
}
