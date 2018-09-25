package executionclasses;
/**
 * @author suman
 * @date 31/08/2018
 * @purpose storing the after class 
 *
 */
import org.testng.annotations.AfterClass;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import reuseablecomponent.BaseClass;
import utility.Log4j;
import utility.OpenReport;

public class End_Test 
{
	@AfterClass
	public void EndTest()
	{
		//closing driver
		Log4j.endTestCase("WeHealU");
		BaseClass.driver.close();
		
		
	}

}
