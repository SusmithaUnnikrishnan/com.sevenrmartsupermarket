package com.sevenrmartsupermarket.tests;

import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.AdminUsersPage;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManageOrdersPage;
import com.sevenrmartsupermarket.utilities.DataProviders;

public class ManageOrdersTest extends Base{
	LoginPage loginpage;
	HomePage homepage;
	AdminUsersPage adminuserspage;
	ManageOrdersPage  manageorderspage;
	
	@Test(dataProvider = "OrderDetails",dataProviderClass = DataProviders.class)
	public void searchDetailsOfOrder(String orderId)
	{
		loginpage = new LoginPage(driver);		
		homepage = new HomePage(driver);
		adminuserspage=new AdminUsersPage(driver);
		manageorderspage=new ManageOrdersPage(driver);
		loginpage.login();
		homepage.clickOnManageOrders();
		manageorderspage.searchProduct(orderId);
	}

}
