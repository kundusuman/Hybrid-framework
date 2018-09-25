package utility;

import java.io.File;
import java.util.List;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
/**
 * @author Suman Kundu
 * @purpose Creating Extend Report
 * @Date 22/08/2018
 */
public class ExtentReportListener implements ISuiteListener,ITestListener {
	private ExtentReports exReport = null;
	private ExtentTest exTest = null;
	private String repo=null;
	private  int totalTest=0;
	private  int passTest=0;
//closing extend report when suite stops
	public void onFinish(ISuite arg0) {
		try {
			
			int val=0;
			if(totalTest>0)
			val=(int)(passTest/totalTest*100);
			if(val>=60)
			{
				exReport.addSystemInfo("Build Status", val +"% SUCCESS -->(permitted for next build)");
			}
			else
			{
				
				exReport.addSystemInfo("Build Status", val +"% FAIL -->(not permitted for next build)");
			}
			exReport.flush();
		} finally {
			exReport.close();
			
			new TestSendMail(System.getProperty("user.dir")+ repo.substring(1));
		//	this method and constructor is for opening report after execution but in vm it does not work thats why it is committed
			new OpenReport(System.getProperty("user.dir")+ repo.substring(1));
			OpenReport.open();
			TestSendMail.sendMain();
			
		}
	}
//starting extend report when suite start
	public void onStart(ISuite suite) {
		repo=".\\report\\"	+ "ExtendReport" + Snippet.getcurrentdateandtime() +".html";
		exReport = new ExtentReports(repo);
		exReport.loadConfig(new File(".\\report.xml"));
		totalTest=suite.getAllMethods().size();
	}
//end test when test finish
	public void onFinish(ITestContext test) {
		exReport.endTest(exTest);
	}
//start test when test start
	public void onStart(ITestContext test) {
		exTest = exReport.startTest(test.getName());
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
	}
//when test fails
	public void onTestFailure(ITestResult test) {
		exTest.log(LogStatus.FAIL, "  <a href='" + Snippet.takeScreenShot() + "'>" + test.getName() + "</a>");
	}
//when test skips
	public void onTestSkipped(ITestResult test) {
		exTest.log(LogStatus.SKIP, "  <a href='" + Snippet.takeScreenShot() + "'>" + test.getName() + "</a>");
	}
	public void onTestStart(ITestResult arg0) {
	}
//when test success
	public void onTestSuccess(ITestResult test) {
		exTest.log(LogStatus.PASS,  "  <a href='" + Snippet.takeScreenShot() + "'>" + test.getName() + "</a>" );
		passTest++;
	}
}
