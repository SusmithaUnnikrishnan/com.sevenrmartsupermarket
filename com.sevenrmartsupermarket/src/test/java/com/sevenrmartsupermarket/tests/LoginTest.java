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
	
	@Test(groups={"sanity","smoke"},retryAnalyzer=com.sevenrmartsupermarket.listeners.RetryAnalyzer.class)
	public void verifyValidUserLogin() 
	{
		loginpage = new LoginPage(driver);		
		homepage = new HomePage(driver);
		loginpage.login();
		String expectedProfileName = "Admin";
		String actualProfileName = homepage.getProfileName();
		Assert.assertEquals(actualProfileName, expectedProfileName);		
	}
	
	@Test(groups="sanity")
	public void verifyInvalidUserLogin() 
	{
		loginpage=new LoginPage(driver);
		String name=GeneralUtility.getRandomFullname();
		loginpage.login(name,"xyz");
		boolean expectedMessage=loginpage.getErrorMessageAlert();
		Assert.assertTrue(expectedMessage);	
	}
	
	@Test(groups="sanity")
	public void verifyLogoText() 
	{
		loginpage=new LoginPage(driver);
		String actualLogo=loginpage.logoText();
		String expectedLogo="7rmart supermarket";
		Assert.assertEquals(actualLogo, expectedLogo);
	}
	
	@Test(groups="smoke")
	public void verifyUsernameFieldLabel() 
	{
		loginpage=new LoginPage(driver);
		String actualText=loginpage.usernameFieldLabel();
		String expectedText="Username";
		Assert.assertEquals(actualText, expectedText);
	}
	
	@Test(groups="smoke")
	public void verifyRemembermeText() 
	{
		loginpage=new LoginPage(driver);
		String actualText=loginpage.remembermeText();
		String expectedText="Remember Me";
		Assert.assertEquals(actualText, expectedText);
	}
	
	@Test(groups="smoke",retryAnalyzer=com.sevenrmartsupermarket.listeners.RetryAnalyzer.class)
	public void verifyNewlyCreatedUserLogin() 
	{
		loginpage = new LoginPage(driver);		
		homepage = new HomePage(driver);
		loginpage.login("steffy", "abcdef");
		String expectedProfileName = "Steffy";
		String actualProfileName = homepage.getProfileName();
		Assert.assertEquals(actualProfileName, expectedProfileName);	
	}
	
	@Test(dataProvider = "NewLoginCredentials",dataProviderClass = DataProviders.class,groups="smoke")
	public void verifyLoginUsingDataProvider(String userName,String password) 
	{
		loginpage=new LoginPage(driver);
		homepage = new HomePage(driver);
		loginpage.login(userName,password);
		String actualProfileName = homepage.getProfileName();
		String expectedProfileName = userName;
		Assert.assertEquals(actualProfileName, expectedProfileName);
	}

}
