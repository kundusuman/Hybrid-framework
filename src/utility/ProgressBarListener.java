package utility;
/**
 * @author suman
 * @Date 31/08/2018
 * @purpose creating j progressbar using listener
 *
 */
import javax.swing.JLabel;
import javax.swing.JProgressBar;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class ProgressBarListener implements ISuiteListener,ITestListener
{

	
	static int size=0;
	static int inc=0;
	static int rVal=0;
	@Override
	public void onTestStart(ITestResult result) {
		Test_ShowListener.set(result.getName());
		
	}

	//increase value on test success
	@Override
	public void onTestSuccess(ITestResult result) {
		rVal=rVal+inc;
		GetProgressBar.set(rVal);
		Test_ShowListener.end();
	}
	//increase value on test failure
	@Override
	public void onTestFailure(ITestResult result) {
		rVal=rVal+inc;
		GetProgressBar.set(rVal);
		Test_ShowListener.end();
	}
	//increase value on test skip
	@Override
	public void onTestSkipped(ITestResult result) {
		rVal=rVal+inc;
		GetProgressBar.set(rVal);
		Test_ShowListener.end();
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
	}

	//starting progressbar on the start of a suite
	@Override
	public void onStart(ISuite suite) {
	
		if(size==0)
		{
		size=suite.getAllMethods().size()+2 ;
		GetProgressBar.Init(size);
		if(size>2)
		inc=100/size;
		else 
			inc=50;
		}
		rVal=rVal+inc;
		GetProgressBar.set(rVal);
		
		
	}

	//stopping progressbar on the start of a suite
	@Override
	public void onFinish(ISuite suite) {
		GetProgressBar.set(100);
		GetProgressBar.end();
		
	}

}
