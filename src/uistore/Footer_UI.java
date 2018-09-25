package uistore;

import org.openqa.selenium.By;

/**
 * @author Suman(m1047073)
 * @purpose this class contains the locators of Footer
 * @Date 9/9/2018
 *
 */
public class Footer_UI 
{
	//locator

	protected static By LogIn_As_Patient_Link=By.xpath("//a[contains(text(),'Login as Patient')]");
	protected static By Register_As_Patient=By.xpath("//a[contains(text(),'Register as Patient')]");
	protected static By Login_In_As_Doctor=By.xpath("//a[contains(text(),'Login as Doctor')]");
	protected static By Join_As_Doctor=By.xpath("//a[contains(text(),'Join as a Doctor')]");
	protected static By Health_forum=By.xpath("//a[contains(text(),'Health Forum')]");
}
