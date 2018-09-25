package pageobject;

import reuseablecomponent.BaseClass;
import uistore.Footer_UI;
/**
 * @author Suman Kundu(M1047073)
 * @Date 10/9/2018
 * @purpose this class store the methods of footer
 */
public class Footer_Page extends Footer_UI
{

	public static void clickOnLoginAsPatient()
	{
		
		BaseClass.driver.findElement(LogIn_As_Patient_Link).click();;
	}
	public static void clickOnHealthForum()
	{
		BaseClass.driver.findElement(Health_forum).click();
	}
}
