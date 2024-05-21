package com.sevenrmartsupermarket.pages;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.constants.Constants;
import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class HomePage {
	WebDriver driver;
	GeneralUtility generalUtility;
	
	@FindBy (xpath = "//a[@class='d-block']")
	private WebElement userProfileElement;//private is used to  encapsulate data. we can only call it through method
	@FindBy(xpath="(//a[@class='nav-link'])[2]")
	private WebElement adminLogoElement;
	@FindBy(xpath="(//a[@class='dropdown-item'])[2]")
	private WebElement logoutElement;
	@FindBy(xpath = "//ul//li[6]")
	private WebElement pushNotificationElement;
	@FindBy(xpath = "//div[@class='col-lg-3 col-6']")
	private List <WebElement> dashboardElements;
	@FindBy(xpath="//section[@class='content']//div[2]//a")
	private WebElement adminUsersMoreInfoElement;
	@FindBy(xpath="(//a[@class='small-box-footer'])[10]")
	private WebElement manageOrdersMoreInfoElement;
	
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void logout()
	{
		 adminLogoElement.click();
		 logoutElement.click(); 
	}
	
	public void clickOnPushNotification() 
	{
		pushNotificationElement.click();
	}
	
	public String getProfileName()
	{
		return userProfileElement.getText();
	}
	
	public int graphicElementsSize()
	{
		generalUtility=new GeneralUtility();
		List<String> items = new ArrayList<String>();
		items=generalUtility.get_TextOfElements(dashboardElements);
		int a=items.size();
		return a;
	}
	
	public void clickOnAdminUsers() {
		adminUsersMoreInfoElement.click();
	}
	
	public void clickOnManageOrders()
	{
		manageOrdersMoreInfoElement.click();
	}
}
