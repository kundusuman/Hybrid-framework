package executionclasses;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageobject.Header_Page;
import pageobject.Register_As_A_Patient_Page;
import reuseablecomponent.BaseClass;
import utility.ExcelUtils;
import utility.Log4j;
/**
 * @author Suman Kundu(M1047073)
 * @Date 10/9/2018
 * @purpose this class is used to Register in a page using valid crediantial
 */
@Listeners({utility.ExtentReportListener.class,utility.ProgressBarListener.class})
public class RegisterAsAPatientPage_Test
{
	//this string hold the class name
	String KeyVal=this.getClass().getName().substring(this.getClass().getName().indexOf(".")+1);
	@Test
	public void visit_Register_Page()
	{
		//visiting signup page
		BaseClass.HardWait5();
		Log4j.info("clicking in the signup link");
		Header_Page.clickOnSignUp();
		BaseClass.HardWait5();
		String pageTitle=BaseClass.driver.getCurrentUrl();
		String ExpectedPageTitle="https://wehealuiqa.azurewebsites.net/signup";
		Log4j.warn("comparing the value to check wheather this page is signup page or not");
		Assert.assertEquals(ExpectedPageTitle, pageTitle);
		
	}
	@Test(dependsOnMethods = { "visit_Register_Page" })
	public void Register_New_User()
	{
		//giving valid crediantial to signup
		Log4j.info("giving valid crediantial to signup");
		Log4j.warn("error may occure due to excel sheet failure");
		
		Register_As_A_Patient_Page.putName(ExcelUtils.getViaTEST("RegisterAsAPatientPage_Test", "USERNAME"));
		Register_As_A_Patient_Page.putEmail(ExcelUtils.getViaTEST("RegisterAsAPatientPage_Test", "EMAIL"));
		Register_As_A_Patient_Page.putPassword(ExcelUtils.getViaTEST("RegisterAsAPatientPage_Test", "PASSWORD"));
		Register_As_A_Patient_Page.putPhoneno(ExcelUtils.getViaTEST("RegisterAsAPatientPage_Test", "MOBILENO"));
		Register_As_A_Patient_Page.clickSubmit();
		BaseClass.HardWait5();
		Register_As_A_Patient_Page.clickOkButton();
		BaseClass.HardWait3();
	}

}
