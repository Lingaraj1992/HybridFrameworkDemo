package com.ohrm.qa.hybrid.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ohrm.qa.hybrid.base.TestBase;

public class LoginPage extends TestBase {
	
	@FindBy(id="txtUsername")
	WebElement username;
	
	@FindBy(id="txtUsername")
	WebElement password;
	
	@FindBy(id="btnLogin")
	WebElement loginbtn;
	
	@FindBy(id="forgotPasswordLink")
	WebElement forgotlink;
	
	@FindBy(id="divLogo")
	WebElement hrmlogo;
	
	public LoginPage(){
		
	PageFactory.initElements(driver, this);
		
	}
	
	public String ValidateLoginpageTitle(){
		
		return driver.getTitle();
	}
	public boolean ValidateLogo(){
		return hrmlogo.isDisplayed();
	}
	
	public HomePage Login(String un,String pwd){
		
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginbtn.click();
		return new HomePage();
		
	}
	

}
