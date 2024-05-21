package com.sevenrmartsupermarket.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.sevenrmartsupermarket.constants.Constants;

public class ScreenshotCapture {
	TakesScreenshot takesscreenshot;
	
	public void takeScreenshot(WebDriver driver,String imageName)
	{
		try {
			takesscreenshot=(TakesScreenshot) driver;
			File screenShot = takesscreenshot.getScreenshotAs(OutputType.FILE);
			String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());//to take current time
			String path=Constants.SCREENSHOT_FILE_PATH+imageName+"_"+timeStamp+".png";
			File destination=new File(path);
			FileHandler.copy(screenShot, destination);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
