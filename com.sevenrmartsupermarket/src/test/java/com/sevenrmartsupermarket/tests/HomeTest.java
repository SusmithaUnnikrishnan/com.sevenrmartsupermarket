package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;

public class HomeTest extends Base {
	LoginPage loginpage;
	HomePage homePage;
	
	@Test
	public void verifyNumberOfDashboardElementsPresent() 
	{
		loginpage=new LoginPage(driver);
		homePage=new HomePage(driver);
		loginpage.login();
		int actualNumber=homePage.dashboardElements();
		int expectedNumber=8;
		Assert.assertEquals(actualNumber,expectedNumber);
	}
	
}
