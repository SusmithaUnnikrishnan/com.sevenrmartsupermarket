package com.sevenrmartsupermarket.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.constants.Constants;
import com.sevenrmartsupermarket.utilities.WaitUtility;

public class LoginPage {
	WebDriver driver;
	HomePage homepage;
	Properties properties=new Properties();
	
	@FindBy(xpath="//input[@name=\"username\"]")
	private WebElement userNameField;
	@FindBy(xpath="//input[@name=\"password\"]")
	private WebElement passwrodField;
	@FindBy(xpath="//button[text()=\"Sign In\"]")
	private WebElement loginButton;
	@FindBy(xpath = "//button[@class='close']")
	private WebElement alertCloseButton;
	@FindBy(xpath = "//div[@class='login-logo']//a//b")
	private WebElement loginHeaderLogo;
	@FindBy(xpath = "//label[@for='remember']")
	private WebElement remembermeElement;
	
	By homePageWaitElement=By.xpath("//a[@class='d-block']");
	

	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		try {
			FileInputStream fs=new FileInputStream(Constants.CONFIG_FILE_PATH);
			properties.load(fs);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public void enterUserName(String userName)
	{
		userNameField.sendKeys(userName);
	}
	
	public void enterPassword(String password)
	{
		passwrodField.sendKeys(password);
	}
	
	public void clickOnLoginButton()
	{
		loginButton.click();
	}
	
	public void login()
	{
		WaitUtility waitutility=new WaitUtility(driver);
		String userName = properties.getProperty("userName");
		String password = properties.getProperty("password");
		enterUserName(userName);
		enterPassword(password);
		clickOnLoginButton();
		waitutility.waitForElementToBeVisible(homePageWaitElement, 10);
	}
	
	public void login(String userName, String password)
	{
		enterUserName(userName);
		enterPassword(password);
		clickOnLoginButton();	
	}

	
	public boolean getErrorMessageAlert() {
		 boolean closebuttondisplayed=alertCloseButton.isDisplayed();
		 return  closebuttondisplayed;

		}
	
	public String logoText() {
			String actuallogo= loginHeaderLogo.getText();
			return actuallogo;
		}
		
	public String useridText() {
			String actualText= userNameField.getAttribute("placeholder");
			return actualText;
		}
		
	public String remembermeText() {
			String actualText= remembermeElement.getText();
			return actualText;
		}


}
