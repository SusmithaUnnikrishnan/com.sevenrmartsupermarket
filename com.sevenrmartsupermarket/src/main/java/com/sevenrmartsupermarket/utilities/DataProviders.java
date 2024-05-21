package com.sevenrmartsupermarket.utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {
	@DataProvider(name="OrderDetails")
	public Object[][] manageOrdersDataProvider()
	{
		return new Object [][] {{"113"},{"111"},{"110"}};
	}

}
