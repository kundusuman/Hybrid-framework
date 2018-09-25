package executionclasses;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageobject.Contact_Us_Page;
import pageobject.Footer_Page;
import pageobject.Header_Page;
import pageobject.Login_Patient_Page;
import reuseablecomponent.BaseClass;
import utility.ExcelUtils;
import utility.Log4j;
/**
 * @author Suman Kundu(M1047073)
 * @Date 10/9/2018
 * @purpose this class is used to login in a page using valid user email and password
 */
@Listeners({utility.ExtentReportListener.class,utility.ProgressBarListener.class})
public class LoginPatientPage_Test extends End_Test
{
	
	@Test
	public void visit_Patient_LogIN_Page()
	{
		//opening the log in page
		Log4j.info("visiting login page");
		BaseClass.HardWait3();
		Log4j.warn("error may occur during visiting");
		Header_Page.clickOnLogin();
		BaseClass.HardWait3();
		String pageTitle=BaseClass.driver.getCurrentUrl();
		String ExpectedPageTitle="https://wehealuiqa.azurewebsites.net/login";
		Log4j.warn("checking that wheather it is a valid page or not");
		Assert.assertEquals(ExpectedPageTitle, pageTitle);
		
	}
	@Test(dependsOnMethods = { "visit_Patient_LogIN_Page" })
	public void LogIN()
	{
		//login using valid credintial
		BaseClass.HardWait3();
		Log4j.info("inserting a useremail and password crediential"); 
		Login_Patient_Page.putEmail(ExcelUtils.getViaTEST("RegisterAsAPatientPage_Test", "EMAIL"));
		Login_Patient_Page.putPassword(ExcelUtils.getViaTEST("LoginPatientPage_Test", "PASSWORD"));
		Login_Patient_Page.clickLogin();
		
	}
@Test(dependsOnMethods = { "LogIN" })
	public void LogOut()
	{
		//login using valid credintial
		BaseClass.HardWait3();
		Log4j.info("logging out from a account");
		try {
		Login_Patient_Page.clickLogoutLink();
		Login_Patient_Page.clickLogoutButton();
		BaseClass.HardWait0();
		Login_Patient_Page.clickOkButtonAfterLogout();
		}
		catch(Exception e)
		{
			Log4j.error("Login was not sucessfull for that log out fails");
		}
		
		
	}

}
