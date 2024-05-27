package com.sevenrmartsupermarket.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.AdminUsersPage;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.PageUtility;
import com.sevenrmartsupermarket.utilities.ScreenshotCapture;

public class AdminUsersTest extends Base {
	LoginPage loginpage;
	HomePage homepage;
	AdminUsersPage adminuserspage;
	PageUtility pageutility;
	
	@Test(groups="sanity")
	public void verifyUsernameAlreadyExistAlertMessage()
	{
		loginpage = new LoginPage(driver);		
		homepage = new HomePage(driver);
		adminuserspage=new AdminUsersPage(driver);
		loginpage.login();
		homepage.clickOnAdminUsers();
		adminuserspage.adminUsersInfomation("steffy", "abcdef","Admin");
		boolean expectedMessage=adminuserspage.usernameAleardyExistAlertMessageIsDisplayed();
		Assert.assertTrue(expectedMessage);		
	}
	
	@Test(groups="sanity")
	public void verifyNewlyCreatedAdminLogo()
	{
		loginpage = new LoginPage(driver);		
		homepage = new HomePage(driver);
		adminuserspage=new AdminUsersPage(driver);
		loginpage.login("steffy", "abcdef");
		boolean expectedUserProfileName=adminuserspage.newAdminLogoIsDisplayed();
		Assert.assertTrue(expectedUserProfileName);	
	}
	
	@Test
	public void verifyUserDeactivation()
	{
		loginpage = new LoginPage(driver);	
		homepage = new HomePage(driver);
		adminuserspage=new AdminUsersPage(driver);
		loginpage.login();
		homepage.clickOnAdminUsers();
		adminuserspage.deactivateUser("Yolonda");
		String expectedColour="rgba(220, 53, 69, 1)";
		String actualColour=adminuserspage.getAdminUserDeactivationButtonColor("Yolonda");
		Assert.assertEquals(actualColour, expectedColour);
	}
	
	@Test
	public void verifyEditUserDetailsFunctionality()
	{
		loginpage = new LoginPage(driver);		
		homepage = new HomePage(driver);
		adminuserspage=new AdminUsersPage(driver);
		loginpage.login();
		homepage.clickOnAdminUsers();	
		adminuserspage.editUserDetails("Zayn","zayn123", "Staff");
		homepage.logout();
		loginpage.login("Zayn", "zayn123");
		String expectedUserProfileName=" Zayn";
		String actualUserProfileName=adminuserspage.userProfileElement();
		Assert.assertEquals(actualUserProfileName, expectedUserProfileName);
	}
	
	@Test(retryAnalyzer=com.sevenrmartsupermarket.listeners.RetryAnalyzer.class)
	public void verifyUserProfileDeletion()
	{
		loginpage = new LoginPage(driver);		
		homepage = new HomePage(driver);
		adminuserspage=new AdminUsersPage(driver);
		loginpage.login();
		homepage.clickOnAdminUsers();
		adminuserspage.deleteUser("Mozell Mitchell");
		pageutility=new PageUtility(driver);
		pageutility.alert_Accept();
		boolean expectedMessage=adminuserspage.userDeletionAlertMessage();
		Assert.assertTrue(expectedMessage);
	}
	
}
