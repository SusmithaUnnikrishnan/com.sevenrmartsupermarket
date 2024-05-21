package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class LoginTest extends Base {
	
	LoginPage loginpage;
	HomePage homepage;
	
	@Test
	public void verifyLogin() {
	 loginpage=new LoginPage(driver);
	 loginpage.login();
	}
	
	@Test
	public void verifyValidUserLogin() {
		
		loginpage = new LoginPage(driver);		
		homepage = new HomePage(driver);
		loginpage.login();
		String expectedProfileName = "Admin";
		String actualProfileName = homepage.getProfileName();
		Assert.assertEquals(actualProfileName, expectedProfileName);	
		
	}
	
	@Test
	public void verifyInvalidUserLogin() {
	loginpage=new LoginPage(driver);
	String a=GeneralUtility.getRandomFullname();
	loginpage.login(a,"kkkk");
	boolean expectedMessage=loginpage.getErrorMessageAlert();
	Assert.assertTrue(expectedMessage);
		
	}
	
	@Test
	public void verifyLogoText() {
	loginpage=new LoginPage(driver);
	String actualLogo=loginpage.logoText();
	String expectedLogo="7rmart supermarket";
	Assert.assertEquals(actualLogo, expectedLogo);
	}
	
	@Test
	public void verifyUseridText() {
	loginpage=new LoginPage(driver);
	String actualText=loginpage.useridText();
	String expectedText="Username";
	Assert.assertEquals(actualText, expectedText);
	}
	
	@Test
	public void verifyRemembermeText() {
		loginpage=new LoginPage(driver);
	String actualText=loginpage.remembermeText();
	String expectedText="Remember Me";
	Assert.assertEquals(actualText, expectedText);
	}
	
	@Test
	public void verifyNewlyCreatedUserLogin() {
		
		loginpage = new LoginPage(driver);		
		homepage = new HomePage(driver);
		loginpage.login("steffy", "abcdef");
		String expectedProfileName = "Steffy";
		String actualProfileName = homepage.getProfileName();
		Assert.assertEquals(actualProfileName, expectedProfileName);	
		
	}

}
