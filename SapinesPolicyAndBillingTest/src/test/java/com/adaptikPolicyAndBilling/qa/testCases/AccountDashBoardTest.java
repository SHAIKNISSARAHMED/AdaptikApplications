package com.adaptikPolicyAndBilling.qa.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.adaptikPolicyAndBilling.qa.base.TestBase;
import com.adaptikPolicyAndBilling.qa.pages.AccountDashBoard;
import com.adaptikPolicyAndBilling.qa.pages.AdjustmentDetailsPage;
import com.adaptikPolicyAndBilling.qa.pages.AdjustmentsPage;
import com.adaptikPolicyAndBilling.qa.pages.LoginPage;
import com.adaptikPolicyAndBilling.qa.pages.SearchPage;
import com.adaptikPolicyAndBilling.qa.util.TestUtil;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class AccountDashBoardTest extends TestBase {

	LoginPage loginPage;
	
	SearchPage searchPage;
		
	AccountDashBoard accountDashBoard;
	
	
	AdjustmentDetailsPage adjustmentsDetail;
	
	AdjustmentsPage adjustmentsPage;
	
	String sheetName = "AccountSearchOverlay";
	
	public AccountDashBoardTest() {
		super();
	}
	
	@BeforeMethod()
	public void setupTest() {
		Initilization();
		
	loginPage = new LoginPage();
	searchPage =loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	
	}

@DataProvider
public Object[][] getTestData() {
	Object[][] data = TestUtil.getTestData(sheetName);
	return data;
	
}

@Test(priority=1,description = "verifying AccountDashBoard Page Title")
@Severity(SeverityLevel.MINOR)
@Description("Test Case Description: verify AccountDashBoard Page Title")
@Story("Story Name: To check Page Title")
public void accountDashBoardPageTitleTest() {
	accountDashBoard = new AccountDashBoard();
	String title = accountDashBoard.validatePageTitle();
	Assert.assertEquals(title, "Billing - Nissar s (nissars) - ohihlxqadbil001.adaptik.net");
}


@Test(priority=2,dataProvider="getTestData", description = "verifying MakeAdjustment Functionality")
@Severity(SeverityLevel.BLOCKER)
@Description("Test Case Description: verify MakeAdjustment")
@Story("Story Name: To check MakeAdjustment functionality")
public void MakeAdjustmentTest(String AccountID,String TypeOfAdjustment) {
	 accountDashBoard = searchPage.AccountSearch(AccountID);
	 adjustmentsDetail = accountDashBoard.clickOnMakeAdjustment();
	 adjustmentsPage = adjustmentsDetail.clickOnPostAdjustmentButton(TypeOfAdjustment);
	 adjustmentsPage.clickOnReverseAdjustment();
	 
	
}

@AfterMethod()
public void closeBrowser()
{
	
	driver.quit();
}

}
