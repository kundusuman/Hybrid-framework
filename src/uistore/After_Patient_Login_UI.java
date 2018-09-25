package uistore;

import org.openqa.selenium.By;
/**
 * @author Suman Kundu(M1047073)
 * @Date 10/9/2018
 * @purpose this class store the locator of the home page of a patient after login
 */
public class After_Patient_Login_UI 
{
	//locators
	public static By getUserIdentity(String name)
	{
		By UserIdentity=By.xpath("//a[@class='nav-link' and contains(text(),'"+ name +"')]");
		return UserIdentity;
	}
	protected static By LogOut_Link=By.xpath("//a[@class='nav-link' and contains(text(),'LogOut')]");
	protected static By LogOut_Button = By.xpath("//button[@class='swal2-confirm swal2-styled' and contains(text(),'Log Out!')]");
	

}
