package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.PageUtility;

public class PushNotificationsPage {
WebDriver driver;
PageUtility pageutility;
	
	@FindBy (xpath = "//input[@id='title']")
	private WebElement titleElement;
	@FindBy (xpath = "//input[@id='description']")
	private WebElement descriptionElement;
	@FindBy (xpath = "//button[@class='btn btn-block-sm btn-info']")
	private WebElement sendButton;
	@FindBy(xpath = "//button[@class='close']")
	private WebElement closeButtonAlertPushNotification;
	@FindBy(xpath = "//a[@class='btn btn-default btn-fix']")
	private WebElement resetButtonElement;
	@FindBy(xpath = "//button[@class='close']")
	private WebElement alertCloseButton;

	
	public PushNotificationsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterTitle(String title)
	{
		titleElement.sendKeys(title);
	}
	
	public void enterDescription(String description)
	{
		descriptionElement.sendKeys(description);
	}
	
	public void clickOnSendButton()
	{
		sendButton.click();
	}
	
	public void clickOnResetButton() 
	{
		resetButtonElement.click();
	}
	
	public void sendNotification(String title,String description) 
	{
		enterTitle(title);
		enterDescription(description);
		clickOnSendButton();
	}
	
	public boolean alert_PushCloseButtonDisplayed()
	{
		pageutility=new PageUtility(driver); 
		boolean displayed=pageutility.is_Displayed(closeButtonAlertPushNotification);
		return displayed;
	}
	
	public void resetButtonWithTextClick(String title,String description) 
	{
		enterTitle(title);
		enterDescription(description);
		clickOnResetButton();
	}
	
	public boolean resetAlertMessage(String title,String description) 
	{
		resetButtonWithTextClick(title,description);
		pageutility=new PageUtility(driver); 
		boolean closebuttondispalyed=pageutility.is_Displayed(alertCloseButton);
		return closebuttondispalyed;
	}
	


}
