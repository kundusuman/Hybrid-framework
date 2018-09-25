package pageobject;

import reuseablecomponent.BaseClass;
import uistore.LogIn_Patient_UI;
/**
 * @author Suman Kundu(M1047073)
 * @Date 10/9/2018
 * @purpose this class store the methods of login page of a patient
 */
public class Login_Patient_Page extends LogIn_Patient_UI
{
	public static void putEmail(String email)
	{
		BaseClass.driver.findElement(Email_TextBox).sendKeys(email);
		
	}
	public static void putPassword(String password)
	{
		BaseClass.driver.findElement(Password_TextBox).sendKeys(password);
	}
	public static void clickLogin()
	{
		BaseClass.driver.findElement(Login_Button).click();
	}
	public static void clickLogoutLink()
	{
		BaseClass.driver.findElement(Logout_link).click();
	}
	public static void clickLogoutButton()
	{
		BaseClass.driver.findElement(Logout_Button).click();
		
	}
	public static void clickOkButtonAfterLogout()
	{
		BaseClass.driver.findElement(Ok_Button).click();
		
	}

}
