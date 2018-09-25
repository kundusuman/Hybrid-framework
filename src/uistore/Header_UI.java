package uistore;

import org.openqa.selenium.By;
/**
 * @author Suman Kundu(M1047073)
 * @Date 10/9/2018
 * @purpose this class store the locator of header
 */
public class Header_UI
{
	//locators
	protected static By Home_Page_Link=By.xpath("//a[contains(text(),'Home')]");
	protected static By Register_Link=By.xpath("//a[contains(text(),'Register')]");
	protected static By Login_Link=By.xpath("//li[@class='nav-item']//a[contains(text(),'Login')]");
	protected static By Contact_Us_Link=By.xpath("//a[contains(text(),'Contact Us')]");
	protected static By About_Us_Link=By.xpath("//a[contains(text(),'About Us')]");
	
}
