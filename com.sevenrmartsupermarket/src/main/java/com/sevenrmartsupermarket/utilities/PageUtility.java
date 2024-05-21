package com.sevenrmartsupermarket.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	
	WebDriver driver;
	JavascriptExecutor js;
	
	public PageUtility(WebDriver driver)
	{
		this.driver=driver;
		js=(JavascriptExecutor) driver;
	}
	
	public void select_ByIndex(WebElement element, int index)
	{
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	
	public void select_ByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	public void select_ByVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByValue(text);
	}

	public boolean is_Selected(WebElement element) {
		return element.isSelected();
	}

	public boolean is_Displayed(WebElement element) {
		return element.isDisplayed();
	}

	public boolean is_Enabled(WebElement element) {
		return element.isEnabled();
	}

	public void alert_Accept() {
		driver.switchTo().alert().accept();
	}

	public void alert_Dismiss() {
		driver.switchTo().alert().dismiss();
	}

	public void alert_GetText() {
		driver.switchTo().alert().getText();
	}

	public void alert_SendKeys(String key) {
		driver.switchTo().alert().sendKeys(key);
	}

	public void scrollAndClick(WebElement element) {
		int y = 0;
		while (clickStatus(element)) {
			js.executeScript("window.scrollBy(0," + y + ")");
			y = y + 5;
		}

	}

	public boolean clickStatus(WebElement element) {
		try {
			element.click();
			return false;
		} catch (Exception e) {
			return true;
		}
	}
}
