package pageobject;

import org.openqa.selenium.WebElement;

import reuseablecomponent.BaseClass;
import uistore.About_Us_UI;
/**
 * @author Suman Kundu(M1047073)
 * @Date 10/9/2018
 * @purpose this class store the methods of aboutus page of a patient
 */
public class About_Us_Page extends About_Us_UI
{
	private static WebElement element=null;
	public static String returnAboutUsTitle()
	{
		
		element=BaseClass.driver.findElement(About_Us_Title);
		return element.getText();
		
	}
	

}
