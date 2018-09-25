package uistore;

import org.openqa.selenium.By;

/**
 * @author Suman Kundu(M1047073)
 * @Date 10/9/2018
 * @purpose this class store the locator of registration of a patient
 */
public class Register_As_A_Patient_UI 
{
	//locators
	protected static By Home_Page_Link=By.xpath("//a[contains(text(),'Home')]");
	protected static By Patient_Name=By.xpath("//input[@id='patient-name']");;
	protected static By Patient_Email=By.id("patient-email");
	protected static By Patient_PhoneNo=By.id("patient-phonenumber");
	protected static By Password=By.id("password1");
	//return a array list of div contains error messages
	protected static By Error_Message=By.xpath("//div[@class='ng-star-inserted']");
	/*Error Message
	 * 1:- Name is required!
	 * 2:- Email is required!
	 * 3:- Contact is required!
	 * 4:- Password is required!
	 */
	protected static By Submit_Button=By.xpath("//button[@class='btn_3 medium' and contains(text(),'Submit')]");
	
	protected static By Ok_Button=By.xpath("//button[@class='swal2-confirm swal2-styled' and contains(text(),'OK')]");
	
	
}
