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
public void verify_GraphicElements() {
	loginpage=new LoginPage(driver);
	homePage=new HomePage(driver);
	loginpage.login();
	int actualsize=homePage.graphicElementsSize();
	int expectedsize=16;
	Assert.assertEquals(actualsize,expectedsize);
}
}
