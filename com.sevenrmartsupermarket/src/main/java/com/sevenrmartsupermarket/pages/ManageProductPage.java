package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;

public class ManageProductPage {
	WebDriver driver;
	Select select;
	PageUtility pageutility;
	GeneralUtility generalutility;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	private WebElement newButtonElement;
	@FindBy(xpath="//input[@id='title']")
	private WebElement titleFieldElement;
	@FindBy(xpath="(//label[@class='radio-inline'])[2]")
	private WebElement productTypeNonVegElement;
	@FindBy(xpath="//input[@id='tag']")
	private WebElement tagElement;
	

}
