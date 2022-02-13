package com.adaptikPolicyAndBilling.qa.testCases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.adaptikPolicyAndBilling.qa.base.TestBase;
import com.adaptikPolicyAndBilling.qa.pages.LoginPage;
import com.adaptikPolicyAndBilling.qa.pages.SearchPage;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	SearchPage searchPage;
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setupTest() {
		Initilization();
		
		 loginPage = new LoginPage();
	}
	
	
	@Test(priority = 1, description = "verifying login page title test")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Case Description: Verify login page title test on Login Page")
	@Story("Story Name: To check login page title")
	
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Login");
	} 
	
	
	
	@Test(priority = 2, description = "verifying login to Application test")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test Case Description: verify login into application with correct credentials")
	@Story("Story Name: To check login functionality")
	public void loginTest() {
		searchPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@AfterMethod
	public void tearDownTest() {
		driver.quit();
	}
}
