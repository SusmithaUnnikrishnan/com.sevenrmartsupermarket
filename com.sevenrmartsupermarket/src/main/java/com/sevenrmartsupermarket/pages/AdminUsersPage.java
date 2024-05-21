package com.sevenrmartsupermarket.pages;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.sevenrmartsupermarket.constants.Constants;
import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;

public class AdminUsersPage {
	WebDriver driver;
	Select select;
	PageUtility pageutility;
	GeneralUtility generalutility;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	private WebElement newButtonElement;
	@FindBy(xpath="//input[@id='username']")
	private WebElement userNameFieldElement;
	@FindBy(xpath="//input[@id='password']")
	private WebElement passwordFieldElement;
	@FindBy(xpath="//select[@id='user_type']")
	private WebElement userTypeElement;
	@FindBy(xpath="(//button[@class='btn btn-block-sm btn-danger'])[2]")
	private WebElement saveButton;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement alertMessageElement;
	@FindBy(xpath="//tbody//tr//td[1]")
	List<WebElement> userNameColumnElements;
	@FindBy(xpath="//a[@class='d-block']")
	private WebElement adminLogoElement;
	@FindBy(xpath="//button[@name='Update']")
	private WebElement updateButton;
	
	public AdminUsersPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnNewButton()
	{
		newButtonElement.click();
	}
	
	public void enterUserName(String userName)
	{
		userNameFieldElement.sendKeys(userName);
	}
	
	public void enterPassword(String password)
	{
		passwordFieldElement.sendKeys(password);
	}
	
	public void clickOnSaveButton()
	{
		saveButton.click();
	}
	
	public void selectUserType(String userType)
	{
		select=new Select(userTypeElement);
		select.selectByVisibleText(userType);;
	}

	public void adminUsersInfomation(String userName,String password,String userType)
	{
		clickOnNewButton();
		enterUserName(userName);
		enterPassword(password);
		selectUserType(userType);
		clickOnSaveButton();
	}
	
	public boolean usernameAleardyExistAlertMessageIsDisplayed()
	{
		return alertMessageElement.isDisplayed();
	}
	
	public boolean newAdminLogoIsDisplayed()
	{
		return adminLogoElement.isDisplayed();
	}

	public void deactivateUser(String userName)
	{
		pageutility=new PageUtility(driver);
		generalutility=new GeneralUtility();
		List<String> namesList = new ArrayList();
		namesList = generalutility.get_TextOfElements(userNameColumnElements);
		/*  for (WebElement uerName : userNameColumnElements) {
			if
			{
			System.out.println(uerName.getText());
			}
		}*/
		int index = 0;
		for (index = 0; index< namesList.size(); index++) 
		{
			if (namesList.get(index).equals(userName)) 
			{
				index++;
				break;
			}
		}
		WebElement deactivateButton = driver.findElement(By.xpath("//table//tr[" + index + "]//td[5]//a[1]"));
		pageutility.scrollAndClick(deactivateButton);
	}
	
	
	public boolean newlyCreatedUserIsDisplayed(String userName)//!!!!username is not in first page 
	{
		pageutility=new PageUtility(driver);
		generalutility=new GeneralUtility();
		List<String> namesList = new ArrayList();
		namesList = generalutility.get_TextOfElements(userNameColumnElements);
		int index = 0;
		for (index = 0; index< namesList.size(); index++) 
		{
			if (namesList.get(index).equals(userName)) 
			{
				index++;
				break;
			}
		}
		WebElement newlyCreatedUser=driver.findElement(By.xpath("//table//tbody//tr[" + index + "]//td[1]"));
		boolean newUserDisplayed=newlyCreatedUser.isDisplayed();
		return newUserDisplayed;
	}
	
	public void clickOnEditButton(String userName)
	{
		pageutility=new PageUtility(driver);
		generalutility=new GeneralUtility();
		List<String> namesList = new ArrayList();
		namesList = generalutility.get_TextOfElements(userNameColumnElements);
		int index = 0;
		for (index = 0; index< namesList.size(); index++) 
		{
			if (namesList.get(index).equals(userName)) 
			{
				index++;
				break;
			}
		}
		WebElement editButton=driver.findElement(By.xpath("//table//tr[" + index + "]//td[5]//a[2]"));
		pageutility.scrollAndClick(editButton);
	}
	
	public void clearPassword()
	{
		passwordFieldElement.clear();
	}
	
	
	public void enterEditedPassword(String editedPassword)
	{
		passwordFieldElement.sendKeys(editedPassword);
	}
	
	public void selectEditedUserType(String editedUserType)
	{
		select=new Select(userTypeElement);
		select.selectByVisibleText(editedUserType);;
	}
	
	public void clickOnUpdateButton()
	{
		updateButton.click();
	}
	
	public void editUserDetails(String userName,String editedPassword,String editedUserType)
	{
		clickOnEditButton(userName);
		clearPassword();
		enterEditedPassword(editedPassword);
		selectEditedUserType(editedUserType);
		clickOnUpdateButton();
		
	}
	
	public String userProfileElement()
	{
		String userProfileName=adminLogoElement.getAttribute("text");
		return userProfileName;
	}
	
	public void deleteUser(String userName)
	{
		pageutility=new PageUtility(driver);
		generalutility=new GeneralUtility();
		List<String> namesList = new ArrayList();
		namesList = generalutility.get_TextOfElements(userNameColumnElements);
		int index = 0;
		for (index = 0; index< namesList.size(); index++) 
		{
			if (namesList.get(index).equals(userName)) 
			{
				index++;
				break;
			}
		}
		WebElement deleteButton=driver.findElement(By.xpath("//table//tr[" + index + "]//td[5]//a[3]"));
		pageutility.scrollAndClick(deleteButton);
	}
	

	
}
	


