package com.adaptikPolicyAndBilling.qa.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.adaptikPolicyAndBilling.qa.base.TestBase;
import com.adaptikPolicyAndBilling.qa.pages.AccountDashBoard;
import com.adaptikPolicyAndBilling.qa.pages.LoginPage;
import com.adaptikPolicyAndBilling.qa.pages.SearchPage;
import com.adaptikPolicyAndBilling.qa.util.TestUtil;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class SearchPageTest extends TestBase {
	
	LoginPage loginPage;
	
	SearchPage searchPage;
	
	AccountDashBoard accountDashBoard;
	
	String sheetName = "AccountSearchOverlay";
	
	public SearchPageTest() {
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
	
	@Test(priority=0)
	public void SearchPageTitleTest() {
		
		String title = searchPage.validateSearchPageTitle();
		Assert.assertEquals(title, "Billing - Nissar s (nissars) - ohihlxqadbil001.adaptik.net");
	}
	
	@Test(priority=1,dataProvider="getTestData", description = "verifying AccountSearch with AccountID test")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test Case Description: verify AccountSearch with MCID")
	@Story("Story Name: To check Search functionality")
	public void AccountSearch(String AccountID) {
		 accountDashBoard = searchPage.AccountSearch(AccountID);
		
	}
	
	@AfterMethod()
	public void closeBrowser()
	{
		
		driver.quit();
	}

}
