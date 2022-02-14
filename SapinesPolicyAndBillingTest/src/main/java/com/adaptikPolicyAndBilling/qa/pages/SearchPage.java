package com.adaptikPolicyAndBilling.qa.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.adaptikPolicyAndBilling.qa.base.TestBase;

import io.qameta.allure.Step;

public class SearchPage extends TestBase {

	
	@FindBy(xpath="//button/span[contains(text(),'Search')]")
//	@CacheLookup
	WebElement SearchButton;
	
	@FindBy(xpath="//button/span[contains(text(),'New Remittance Batch')]")
//	@CacheLookup
	WebElement NewRemittanceBatchButton;
	
	@FindBy(xpath="//label[contains(text(),'Account Code')]//ancestor::tr//input[@type='text']")
//	@CacheLookup
	WebElement AccountSearchOverlay_AccountCodeTextField;
	
	@FindBy(xpath="//div[@id='ACCT_SEARCH1']//tr//td//button/span/u[contains(text(),'S')]")
//	@CacheLookup
	WebElement AccountSearchOverlay_SearchButton;
	
	@FindBy(xpath="//button[contains(text(),'Account Dash')]")
//	@CacheLookup
	WebElement AccountSearchOverlay_AccountDashBoardButton;
	
	
	public SearchPage() {
		PageFactory.initElements(driver, this);
	}
	@Step("getting Search page title step....")	
	
	public String validateSearchPageTitle() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		return driver.getTitle();
		
	}
	
	@Step("Moving to AccountDashBoard where AccountID is :{0} step....")	
	public AccountDashBoard AccountSearch(String AccountID) {
		SearchButton.click();
		AccountSearchOverlay_AccountCodeTextField.sendKeys(AccountID);
		AccountSearchOverlay_SearchButton.click();
		AccountSearchOverlay_AccountDashBoardButton.click();
		return  new AccountDashBoard();
	}
	
	
	public RemittanceSearchOverLayPage RemittanceSearch() {
		
		NewRemittanceBatchButton.click();
		return new RemittanceSearchOverLayPage();
	}
	
	
}
