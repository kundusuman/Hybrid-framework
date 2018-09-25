package executionclasses;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageobject.Footer_Page;
import pageobject.HealthForum_Page;
import reuseablecomponent.BaseClass;
import utility.Log4j;

@Listeners({utility.ExtentReportListener.class,utility.ProgressBarListener.class})

public class HealthForumPage_Test 
{
	@Test
	public void clickOnHealthForumLink()
	{
		Log4j.warn("visiting Health Forum page");
		BaseClass.HardWait3();
		Footer_Page.clickOnHealthForum();
		BaseClass.HardWait3();
		String pageTitle=BaseClass.driver.getCurrentUrl();
		String ExpectedPageTitle="https://wehealuiqa.azurewebsites.net/forum";
		Log4j.warn("checking that wheather it is a valid page or not");
		Assert.assertEquals(ExpectedPageTitle, pageTitle);
		
	}
	@Test(dependsOnMethods = { "clickOnHealthForumLink" })
	public void checkHealthForumPage()
	{
		Log4j.warn("checking Health Forum Link");
		String result=HealthForum_Page.getCategoryText();
		Assert.assertEquals("Categories :",result);
	}
	

}
