package executionclasses;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.Assert;
import reuseablecomponent.BaseClass;
import utility.Log4j;
/**
 * @author M1047073
 *
 */
@Listeners({utility.ExtentReportListener.class,utility.ProgressBarListener.class})
public class VisitHomePage_Test extends Start_Test
{
	@Test
	public void checkHomePage()
	{
		//Waiting for Home page to be load
		BaseClass.HardWait10();
		//visiting about us page
		Log4j.debug("visiting contact us spage");
		String pageTitle=BaseClass.driver.getCurrentUrl();
		String ExpectedPageTitle="https://wehealuiqa.azurewebsites.net/home";
		Assert.assertEquals(ExpectedPageTitle, pageTitle);
		
		
		
	}

}
