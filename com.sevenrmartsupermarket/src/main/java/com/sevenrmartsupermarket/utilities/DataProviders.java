package com.sevenrmartsupermarket.utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {
	ExcelReader excelread=new ExcelReader();
	
	@DataProvider(name="OrderDetails")
	public Object[][] manageOrdersDataProvider()
	{
		return new Object [][] {{"113"},{"111"},{"110"}};
	}
	
	@DataProvider(name="LoginCredentials")
	public Object[][] loginCredentialsDataProvider()
	{
		return new Object [][] {{"admin","admin"},{"steffy","abcdef"},{"susmitha123","susmitha@1"}};
	}
	
	@DataProvider(name="NewLoginCredentials")
	public Object[][] loginCredentialsExcelDataProvider()
	{
		excelread.setExcelFile("LoginData", "LoginDetails");
		return excelread.getMultidimentionalData(3, 2);
	}
	
	
}
