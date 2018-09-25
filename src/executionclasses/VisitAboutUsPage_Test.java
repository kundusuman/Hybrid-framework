package executionclasses;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import org.testng.Assert;
import pageobject.About_Us_Page;
import pageobject.Contact_Us_Page;
import pageobject.Header_Page;
import reuseablecomponent.BaseClass;
import utility.Log4j;
/**
 * @author Suman Kundu(M1047073)
 * @Date 10/9/2018
 * @purpose this class is used to visit and validate about us page
 */
@Listeners({utility.ExtentReportListener.class,utility.ProgressBarListener.class})
public class VisitAboutUsPage_Test
{
	
	@Test
	public void visit_About_Us_Page()
	{
		//visiting about us page
		Log4j.debug("visiting aboutus spage");
		BaseClass.HardWait5();
		Header_Page.clickOnAboutUs();
		String pageTitle=BaseClass.driver.getCurrentUrl();
		String ExpectedPageTitle="https://wehealuiqa.azurewebsites.net/aboutus";
		Log4j.warn("comparing the page url to validate the page");
		Assert.assertEquals(ExpectedPageTitle, pageTitle);
		
	}
	@Test(dependsOnMethods = { "visit_About_Us_Page" })
	public void checkAboutUsPage()
	{
		//validating page content
		Log4j.info("picking the value of title header of a iframe to validate the page");
		BaseClass.HardWait5();
		String checkContent=About_Us_Page.returnAboutUsTitle();
		String ExpectedContains="About Us";
		Assert.assertEquals(ExpectedContains,checkContent);

		
	}
	

}
