package uistore;

import org.openqa.selenium.By;
/**
 * @author Suman Kundu(M1047073)
 * @Date 10/9/2018
 * @purpose this class store the locator of login of a patient
 */
public class LogIn_Patient_UI
{
	//locators
	protected static By Email_TextBox=By.xpath("//input[@formcontrolname='email']");
	protected static By Password_TextBox=By.xpath("//input[@formcontrolname='password']");
	//error message return a list of div contains error message
	protected static By Error_Message=By.xpath("//div[@class='alert alert-danger']");
	protected static By Login_Button=By.xpath("//button[@class='btn_3 medium' and contains(text(),'Login')]");
	protected static By Logout_link=By.xpath("//a[contains(text(),'LogOut')]");
	protected static By Logout_Button=By.xpath("//button[@class='swal2-confirm swal2-styled' and contains(text(),'Log Out!')]");
	protected static By Ok_Button=By.xpath("//button[@class='swal2-confirm swal2-styled' and contains(text(),'OK')]");
}
