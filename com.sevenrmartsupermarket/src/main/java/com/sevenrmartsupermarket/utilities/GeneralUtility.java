package com.sevenrmartsupermarket.utilities;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.github.javafaker.Faker;

public class GeneralUtility {

	public List<String> get_TextOfElements(List<WebElement> elements)
	{
		List<String> data=new ArrayList<String>();
		for(WebElement element : elements)
		{
			data.add(element.getText());
		}
		return data;
	}
	
	public String get_Attribute(WebElement element,String attribute)
	{
		return element.getAttribute(attribute);
	}
	
	public String get_CssValue(WebElement element,String Value)
	{
		return element.getCssValue(Value);
	}
	
	public static String getRandomFullname() {
		Faker faker=new Faker();
		//String name = faker.name().fullName();
		//String firstName = faker.name().firstName();
		//String lastName = faker.name().lastName();
		//String streetAddress = faker.address().streetAddress();
		return faker.name().fullName();
		
	}
	public boolean isTextContains(WebElement element,String expectedtext) {
		return element.getText().contains(expectedtext);
		
	}
}
