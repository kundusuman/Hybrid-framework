package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import reuseablecomponent.BaseClass;

public class RWD 
{
	
	public static double getWidth(String XPath)
	{
		return BaseClass.driver.findElement(By.xpath(XPath)).getSize().width;
	}
	public static String reSize(int high,int wid,String xPath)
	{
		BaseClass.driver.manage().window().setSize(new Dimension(wid,high));
		Double pre=RWD.getWidth(xPath);
		BaseClass.driver.manage().window().maximize();
		Double aft=RWD.getWidth(xPath);
		if(pre==aft)
			return "RESPONSIVE";
		else
			return "NOTRESPONSIVE";
		
	}
	
}
