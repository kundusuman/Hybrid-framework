package reuseablecomponent;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author suman
 * @Date 31/08/2018
 * @purpose this class contains the component that can be used through out the whole framework
 *
 */
public class BaseClass {

	//default driver used through the whole framework
	public static WebDriver driver;
	public static WebDriverWait EWait=null;
	//constructor to set driver
	public BaseClass(WebDriver driver) {
		BaseClass.driver = driver;
		EWait=new WebDriverWait(BaseClass.driver, 20);
	}

	//default implicit wait
	public static void ImpWait()
	{
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	public static void HardWait10()
	{
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
		}
	}
	public static void HardWait5()
	{
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
	}
	public static void HardWait3()
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}
	}
	public static void HardWait0()
	{
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
		}
	}

}
