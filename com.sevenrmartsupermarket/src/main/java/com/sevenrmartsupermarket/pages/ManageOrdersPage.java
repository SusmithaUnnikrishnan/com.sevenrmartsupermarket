package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;

public class ManageOrdersPage {
	WebDriver driver;
	Select select;
	PageUtility pageutility;
	GeneralUtility generalutility;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
	WebElement searchButton;
	@FindBy(xpath="//input[@id='od']")
	WebElement orderIdField;
	@FindBy(xpath="//button[@class='btn btn-danger btn-fix']")
	WebElement searchSubmitButton;
	
	public ManageOrdersPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickOnSearchButton()
	{
		searchButton.click();
	}
	
	public void enterOrderId(String orderId)
	{
		orderIdField.sendKeys(orderId);
	}
	
	public void clickOnSearchSubmitButton()
	{
		searchSubmitButton.click();
	}
	
	public void searchProduct(String orderId)
	{
		clickOnSearchButton();
		enterOrderId(orderId);
		clickOnSearchSubmitButton();
	}
	
	
	
	
	

	
	

}
