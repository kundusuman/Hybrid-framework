package pageobject;

import reuseablecomponent.BaseClass;
import uistore.Register_As_A_Patient_UI;
/**
 * @author Suman Kundu(M1047073)
 * @Date 10/9/2018
 * @purpose this class store the methods of registration of a patient
 */
public class Register_As_A_Patient_Page extends  Register_As_A_Patient_UI
{
	public static void putName(String name)
	{
		BaseClass.driver.findElement(Patient_Name).sendKeys(name);
		
	}
	public static void putEmail(String email)
	{
		BaseClass.driver.findElement(Patient_Email).sendKeys(email);
		
	}
	public static void putPassword(String password)
	{
		BaseClass.driver.findElement(Password).sendKeys(password);
	}
	public static void putPhoneno(String no)
	{
		BaseClass.driver.findElement(Patient_PhoneNo).sendKeys(no);
	}
	public static void clickSubmit()
	{
		BaseClass.driver.findElement(Submit_Button).click();
	}
	public static void clickOkButton()
	{
		BaseClass.driver.findElement(Ok_Button).click();
	}

}
