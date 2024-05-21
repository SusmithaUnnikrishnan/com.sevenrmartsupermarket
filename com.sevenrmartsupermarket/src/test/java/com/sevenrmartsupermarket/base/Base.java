package com.sevenrmartsupermarket.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.sevenrmartsupermarket.constants.Constants;
import com.sevenrmartsupermarket.utilities.ScreenshotCapture;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public WebDriver driver;
	Properties properties=new Properties();
	ScreenshotCapture screenshotcapture=new ScreenshotCapture();
	
	
	/**Base Constructor**/
	public Base()
	{
	try {
		FileInputStream fs=new FileInputStream(Constants.CONFIG_FILE_PATH);
		properties.load(fs);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**initializing browser**/
	public void initialize(String browser,String url)
	{
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT));	
	}
	
	@BeforeMethod
	public void launchBrowser()
	{
		String browser=properties.getProperty("browser");
		String url=properties.getProperty("url");
		initialize(browser,url);
	}
	
	@AfterMethod
	public void terminateBrowser(ITestResult itestresult)
	{
		if(itestresult.getStatus()==ITestResult.FAILURE)
		{
			screenshotcapture.takeScreenshot(driver, itestresult.getName());
		}
	}

}
