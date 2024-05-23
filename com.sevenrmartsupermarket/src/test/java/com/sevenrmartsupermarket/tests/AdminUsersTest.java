package com.sevenrmartsupermarket.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.AdminUsersPage;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.ScreenshotCapture;

public class AdminUsersTest extends Base {
	LoginPage loginpage;
	HomePage homepage;
	AdminUsersPage adminuserspage;
	
	
	@Test(groups="sanity")
	public void verifyUsernameAlreadyExistAlertMessage()
	{
		//ScreenshotCapture screenshotcapture=new ScreenshotCapture();
		loginpage = new LoginPage(driver);		
		homepage = new HomePage(driver);
		adminuserspage=new AdminUsersPage(driver);
		loginpage.login();
		homepage.clickOnAdminUsers();
		//screenshotcapture.takeScreenshot(driver, "screenshot1");
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
		loginpage.login();
		homepage.logout();
		loginpage.login("steffy", "abcdef");
		homepage.clickOnAdminUsers();
		boolean expectedUserProfileName=adminuserspage.newAdminLogoIsDisplayed();
		Assert.assertTrue(expectedUserProfileName);	
		
	}
	
	@Test(groups="smoke")
	public void verifyNewAdminUserCreated()
	{
		loginpage = new LoginPage(driver);		
		homepage = new HomePage(driver);
		adminuserspage=new AdminUsersPage(driver);
		loginpage.login();
		homepage.clickOnAdminUsers();				
		boolean newUserDisplayedStatus=adminuserspage.newlyCreatedUserIsDisplayed("steffy");
		Assert.assertTrue(newUserDisplayedStatus);	
		
	}
	
	@Test
	public void verifyUserDeactivation()
	{
		loginpage = new LoginPage(driver);	
		homepage = new HomePage(driver);
		adminuserspage=new AdminUsersPage(driver);
		loginpage.login();
		homepage.clickOnAdminUsers();
		adminuserspage.deactivateUser("Mr. Leonore MarksDamion Jakubowski");
	}
	
	@Test
	public void verifyEditUserDetailsFunctionality()
	{
		loginpage = new LoginPage(driver);		
		homepage = new HomePage(driver);
		adminuserspage=new AdminUsersPage(driver);
		loginpage.login();
		homepage.clickOnAdminUsers();	
		adminuserspage.editUserDetails("Olivia", "123456", "Partner");
		homepage.logout();
		loginpage.login("Olivia", "123456");
		String expectedUserProfileName=" Olivia";
		String actualUserProfileName=adminuserspage.userProfileElement();
		Assert.assertEquals(actualUserProfileName, expectedUserProfileName);
		
	}
	
	@Test(retryAnalyzer=com.sevenrmartsupermarket.listeners.RetryAnalyzer.class)
	public void verifyUserProfileDeletion() //how to handle alert???
	{
		loginpage = new LoginPage(driver);		
		homepage = new HomePage(driver);
		adminuserspage=new AdminUsersPage(driver);
		loginpage.login();
		homepage.clickOnAdminUsers();
		adminuserspage.deleteUser("Nitheesha73412.59384017003");
		homepage.logout();
		loginpage.login("Nitheesha73412.59384017003", "Password59846.181409");
		boolean expectedMessage=loginpage.getErrorMessageAlert();
		Assert.assertTrue(expectedMessage);
	}
	
	
	
	

}
