package pageobject;

import org.openqa.selenium.WebElement;

import reuseablecomponent.BaseClass;
import uistore.Contact_Us_UI;
/**
 * @author Suman Kundu(M1047073)
 * @Date 10/9/2018
 * @purpose this class store the methods contact us
 */
public class Contact_Us_Page extends Contact_Us_UI
{
	
	private static WebElement element=null;
	public static String returnContactUsTitle()
	{
		
		element=BaseClass.driver.findElement(Contact_Us_Title);
		return element.getText();
		
	}

}
