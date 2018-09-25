package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import reuseablecomponent.BaseClass;
import uistore.Header_UI;
/**
 * @author Suman Kundu(M1047073)
 * @Date 10/9/2018
 * @purpose this class store the methods of header
 */
public class Header_Page extends Header_UI
{
	private static WebElement element=null;
	public static void clickOnAboutUs()
	{
		
		element=BaseClass.driver.findElement(About_Us_Link);
		element.click();
	}
	public static void clickOnContactUs()
	{
		
		element=BaseClass.driver.findElement(Contact_Us_Link);
		element.click();
	}
	public static void clickOnHome()
	{
		
		element=BaseClass.driver.findElement(Home_Page_Link);
		element.click();
	}
	public static void clickOnLogin()
	{
		element=BaseClass.driver.findElement(Login_Link);
		element.click();
	}
	public static void clickOnSignUp()
	{
		element=BaseClass.driver.findElement(Register_Link);
		element.click();
	}
	

}
