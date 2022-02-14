package com.adaptikPolicyAndBilling.qa.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.adaptikPolicyAndBilling.qa.base.TestBase;
import com.adaptikPolicyAndBilling.qa.pages.AccountDashBoard;
import com.adaptikPolicyAndBilling.qa.pages.LoginPage;
import com.adaptikPolicyAndBilling.qa.pages.RemittanceBatchPage;
import com.adaptikPolicyAndBilling.qa.pages.SearchPage;
import com.adaptikPolicyAndBilling.qa.util.TestUtil;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class RemittanceBatchPageTest extends TestBase{
	
	LoginPage loginPage;
	
	SearchPage searchPage;
	
	RemittanceBatchPage remittanceBatchPage;
	
	String sheetName = "RemittanceDetails";
	
	public RemittanceBatchPageTest() {
		super();
	}

	//
	
	@BeforeMethod()
	public void setupTest() {
		Initilization();
		
	loginPage = new LoginPage();
	searchPage =loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	searchPage.RemittanceSearch();
	remittanceBatchPage = new RemittanceBatchPage();
	}

@DataProvider
public Object[][] getTestData() {
	Object[][] data = TestUtil.getTestData(sheetName);
	return data;
	
}


@Test(priority=1,dataProvider="getTestData", description = "verifying Remittance Flow test")
@Severity(SeverityLevel.BLOCKER)
@Description("Test Case Description: verifying Remittance Flow test")
@Story("Story Name: Remittance Flow")
public void remittanceBatchDetailsTest(String BankValue, String PaymentTypeValue, String TotalAmount, String NumberOfItems,String PaymentIDValue,String AllocationLevelByValue,String AccountCodeNumber) throws InterruptedException {
	 
	remittanceBatchPage.RemittanceDetails(BankValue, PaymentTypeValue, TotalAmount, NumberOfItems, PaymentIDValue, AllocationLevelByValue, AccountCodeNumber);
}

@AfterMethod()
public void closeBrowser()
{
	
	driver.quit();
}

}

//

