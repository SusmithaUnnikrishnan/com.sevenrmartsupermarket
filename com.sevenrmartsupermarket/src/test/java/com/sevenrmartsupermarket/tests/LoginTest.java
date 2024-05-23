package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.DataProviders;
import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class LoginTest extends Base {
	
	LoginPage loginpage;
	HomePage homepage;
	
	@Test
	public void verifyLogin() {
	 loginpage=new LoginPage(driver);
	 loginpage.login();
	}
	
	@Test(groups={"sanity","sanity"},retryAnalyzer=com.sevenrmartsupermarket.listeners.RetryAnalyzer.class)
	public void verifyValidUserLogin() {
		
		loginpage = new LoginPage(driver);		
		homepage = new HomePage(driver);
		loginpage.login();
		String expectedProfileName = "Admin";
		String actualProfileName = homepage.getProfileName();
		Assert.assertEquals(actualProfileName, expectedProfileName);	
		
	}
	
	@Test(groups="sanity")
	public void verifyInvalidUserLogin() {
	loginpage=new LoginPage(driver);
	String a=GeneralUtility.getRandomFullname();
	loginpage.login(a,"kkkk");
	boolean expectedMessage=loginpage.getErrorMessageAlert();
	Assert.assertTrue(expectedMessage);
		
	}
	
	@Test(groups="sanity")
	public void verifyLogoText() {
	loginpage=new LoginPage(driver);
	String actualLogo=loginpage.logoText();
	String expectedLogo="7rmart supermarket";
	Assert.assertEquals(actualLogo, expectedLogo);
	}
	
	@Test(groups="smoke")
	public void verifyUseridText() {
	loginpage=new LoginPage(driver);
	String actualText=loginpage.useridText();
	String expectedText="Username";
	Assert.assertEquals(actualText, expectedText);
	}
	
	@Test(groups="smoke")
	public void verifyRemembermeText() {
		loginpage=new LoginPage(driver);
	String actualText=loginpage.remembermeText();
	String expectedText="Remember Me";
	Assert.assertEquals(actualText, expectedText);
	}
	
	@Test(groups="smoke",retryAnalyzer=com.sevenrmartsupermarket.listeners.RetryAnalyzer.class)
	public void verifyNewlyCreatedUserLogin() {
		
		loginpage = new LoginPage(driver);		
		homepage = new HomePage(driver);
		loginpage.login("steffy", "abcdef");
		String expectedProfileName = "Steffy";
		String actualProfileName = homepage.getProfileName();
		Assert.assertEquals(actualProfileName, expectedProfileName);	
		
	}
	

	@Test(dataProvider = "NewLoginCredentials",dataProviderClass = DataProviders.class,groups="smoke")
	public void verifyLoginUsingDataProvider(String user,String password) {
		loginpage=new LoginPage(driver);
		homepage = new HomePage(driver);
		loginpage.login(user,password);
		String actualProfileName = homepage.getProfileName();
		String expectedProfileName = user;
		Assert.assertEquals(actualProfileName, expectedProfileName);
	}

}
