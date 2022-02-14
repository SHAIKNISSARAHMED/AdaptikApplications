package com.adaptikPolicyAndBilling.qa.pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.adaptikPolicyAndBilling.qa.base.TestBase;

public class RemittanceBatchPage extends TestBase {

	
	@FindBy(xpath="//div/label[contains(text(),'Bank')]//ancestor::tr//td[2]//select")
	@CacheLookup
	WebElement BankDropDownList;
	
	@FindBy(xpath="//div/label[contains(text(),'Payment Type')]//ancestor::td//following-sibling::td//select")
	@CacheLookup
	WebElement PaymentTypeDropDownList;
	
	
	
	//@FindBy(xpath="//div/label[contains(text(),'Total Amount')]//ancestor::td//following-sibling::td//div[input]")
	@FindBy(xpath="//td[@id='U1_1_Q_30000_558_C']//div//input[@type='text']")
	@CacheLookup
	WebElement TotalAmountTextField;
//	
	@FindBy(xpath="//td[@id='U1_1_Q_30000_557_C']//div//input[@type='text']")
	@CacheLookup
	WebElement NumberOfItemsTextField;
	
	@FindBy(xpath="//button[@id='U1_1_L43_L_1_C']/span[contains(text(),'Post Batch')]")
	@CacheLookup
	WebElement PostBatchButton;
	
	@FindBy(xpath="//button[contains(text(),'Add')]")
	@CacheLookup
	WebElement AddButton;
	
	@FindBy(xpath="//button/span[contains(text(),'Save')]")
	@CacheLookup
	WebElement SaveButton;
	
	@FindBy(xpath="//input[@id='U3_-1_Q_30002_52_C_2_C']")
	@CacheLookup
	WebElement PaymentID;
	
	@FindBy(xpath="//input[@id='U3_-1_Q_30002_73_L_3_C']")
	@CacheLookup
	WebElement RemittanceAmount;
	
	@FindBy(xpath="//div/label[contains(text(),'Allocation Level')]//ancestor::td//following-sibling::td[1]//div/select[@id='U3_-1_Q_30002_171_C_4_C']")
	@CacheLookup
	WebElement AllocationLevel;
	
	@FindBy(xpath="//input[@id='U3_-1_Q_30002_103_C_20_C']")
	@CacheLookup
	WebElement AccountCode;
	
	@FindBy(xpath="//button[contains(text(),'Save')]")
	@CacheLookup
	WebElement SaveRemittance;
	
	
	public RemittanceBatchPage() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		PageFactory.initElements(driver, this);
	}
	
	
	public RemittanceBatchPage RemittanceDetails(String BankValue, String PaymentTypeValue, String TotalAmount, String NumberOfItems,String PaymentIDValue,String AllocationLevelByValue,String AccountCodeNumber) throws InterruptedException {
		 Select Bank = new Select(BankDropDownList);
		 Thread.sleep(3000);
		 Bank.selectByValue(BankValue);
		 
		 Select PaymentType = new Select(PaymentTypeDropDownList);
		 Thread.sleep(3000);
		 PaymentType.selectByValue(PaymentTypeValue);
		 Thread.sleep(3000);
		 TotalAmountTextField.sendKeys(TotalAmount);
		 Thread.sleep(3000);
		 NumberOfItemsTextField.sendKeys(NumberOfItems);
		 Thread.sleep(3000);
		 SaveButton.click();
		 Thread.sleep(3000);
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 Thread.sleep(3000);
		 js.executeScript("window.scrollBy(0,1000)");
		 Thread.sleep(3000);
		 AddButton.click();		 
	
		 Thread.sleep(30000);
		
		 PaymentID.sendKeys(PaymentIDValue);
		 Thread.sleep(3000);
		 RemittanceAmount.sendKeys(TotalAmount);
		 Thread.sleep(3000);
		 Select Allocation = new Select(AllocationLevel);
		 Allocation.selectByValue(AllocationLevelByValue);
		 Thread.sleep(5000);
		 AccountCode.sendKeys(AccountCodeNumber);
		 
		 Thread.sleep(5000);
		 SaveRemittance.click();
		 
		 Thread.sleep(5000);
		 
		 PostBatchButton.click();
		 
		 return new RemittanceBatchPage();
		 
	}
	
	
}
