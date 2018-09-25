package executionclasses;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.Assert;
import pageobject.Contact_Us_Page;
import pageobject.Header_Page;
import reuseablecomponent.BaseClass;
import utility.Log4j;
/**
 * @author Suman Kundu(M1047073)
 * @Date 10/9/2018
 * @purpose this class is used to visit and validate contact us page
 */
@Listeners({utility.ExtentReportListener.class,utility.ProgressBarListener.class})
public class VisitContactUsPage_Test
{
	@Test
	public void visit_Contact_Us_Page()
	{
		//visiting about us page
		Log4j.debug("visiting contact us spage");
		Header_Page.clickOnContactUs();
		BaseClass.HardWait5();
		String pageTitle=BaseClass.driver.getCurrentUrl();
		String ExpectedPageTitle="https://wehealuiqa.azurewebsites.net/contactus";
		Assert.assertEquals(ExpectedPageTitle, pageTitle);
		
	}
	@Test(dependsOnMethods = { "visit_Contact_Us_Page" })
	public void checkContactUsPage()
	{
		//validating page content
		Log4j.info("picking the value of title header of a iframe to validate the page");
		String checkContent=Contact_Us_Page.returnContactUsTitle();
		String ExpectedContains="Contact Us";
		Assert.assertEquals(ExpectedContains,checkContent);
		
	}


}
