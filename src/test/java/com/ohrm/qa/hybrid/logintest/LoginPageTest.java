package com.ohrm.qa.hybrid.logintest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ohrm.qa.hybrid.base.TestBase;
import com.ohrm.qa.hybrid.pages.HomePage;
import com.ohrm.qa.hybrid.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	public LoginPageTest(){
		
		super();
	}
	@BeforeMethod
	public void setup(){
		initialiazation();
		loginpage=new LoginPage();
		
		
	}
	@Test(priority=1)
	public void logintest(){
		String Title=loginpage.ValidateLoginpageTitle();
		Assert.assertEquals(Title, "OrangeHRM");
	}
		@Test(priority=2)
		public void OHRMlogoTest(){
			boolean flag=loginpage.ValidateLogo();
			Assert.assertTrue(flag);
		}
		@Test(priority=3)
		public void LoginTest(){
			homepage= loginpage.Login(prop.getProperty("Username"), prop.getProperty("Password"));
			
		}
		
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	

}
