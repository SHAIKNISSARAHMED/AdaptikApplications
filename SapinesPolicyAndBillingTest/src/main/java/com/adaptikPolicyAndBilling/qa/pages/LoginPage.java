package com.adaptikPolicyAndBilling.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.adaptikPolicyAndBilling.qa.base.TestBase;

import io.qameta.allure.Step;

public class LoginPage extends TestBase {
	
//PageFactory i.e Object Repository 
	
	@FindBy(name="username")
	@CacheLookup
	WebElement username;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement password;
	
	@FindBy(xpath="//button[@id='submitLogin']")
	@CacheLookup
	WebElement LoginButton;
	
public LoginPage() {
	PageFactory.initElements(driver, this);
}

@Step("getting login page title step....")
public String validateLoginPageTitle() {
	return driver.getTitle();
	
}
@Step("login with username: {0} and password: {1} step...")
public SearchPage login(String un, String pwd) {
username.sendKeys(un);
password.sendKeys(pwd);
password.sendKeys(Keys.TAB);
LoginButton.click();

return new SearchPage();
}


}