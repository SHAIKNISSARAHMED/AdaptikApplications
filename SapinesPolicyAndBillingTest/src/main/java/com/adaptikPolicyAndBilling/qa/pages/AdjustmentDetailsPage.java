package com.adaptikPolicyAndBilling.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.adaptikPolicyAndBilling.qa.base.TestBase;

import io.qameta.allure.Step;

public class AdjustmentDetailsPage extends TestBase {

	@FindBy(xpath="//select[@id='U1_77_Q_30011_3_C_4_C']")
	@CacheLookup
	WebElement TypeDropDownList;
	
	@FindBy(xpath="//button[contains(text(),'Post Adjustment')]")
	@CacheLookup
	WebElement PostAdjustmentButton;
	
	public AdjustmentDetailsPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	@Step("clicking on Post Adjustment Button")
	public AdjustmentsPage clickOnPostAdjustmentButton(String TypeOfAdjustment) {
		Select sel = new Select(TypeDropDownList);
		sel.selectByValue(TypeOfAdjustment);
	PostAdjustmentButton.click();
	
	return new AdjustmentsPage();
		
	}
	
}
