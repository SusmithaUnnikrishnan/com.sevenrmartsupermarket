package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.PushNotificationsPage;
import com.sevenrmartsupermarket.utilities.ExcelReader;
import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class PushNotificationsTest extends Base{
	LoginPage loginpage;
	HomePage homepage;
	PushNotificationsPage pushnotificationspage;
	ExcelReader excelread=new ExcelReader();
	
	@Test
	public void sendNotification()
	{
		loginpage=new LoginPage(driver);
		HomePage homepage=new HomePage(driver);
		PushNotificationsPage pushnotificationspage=new PushNotificationsPage(driver);
		loginpage.login();
		excelread.setExcelFile("PushNotificationData", "Notifications"); //workbookname, sheetName
		String title = excelread.getCellData(1, 0);
		title= title+GeneralUtility.getRandomFullname();
		String description = excelread.getCellData(1, 1);
		pushnotificationspage.sendNotification(title, description);
		//pushnotificationspage.sendNotification("title", "hello");
		boolean displayed=pushnotificationspage.alert_PushCloseButtonDisplayed();
		Assert.assertTrue(displayed);	
	}
	
	@Test
	public void verifyReset() 
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		homepage=new HomePage(driver);
		homepage.clickOnPushNotification();
		pushnotificationspage=new PushNotificationsPage(driver);
		excelread.setExcelFile("PushNotificationData", "Notifications"); //workbookname, sheetName
		String title = excelread.getCellData(1, 0);
		String description = excelread.getCellData(1, 1);
		pushnotificationspage.sendNotification(title, description);
		//boolean a=pushnotificationpage.resetAlertMessage("hai", "hello");
		//Assert.assertFalse(a);
	}

}
