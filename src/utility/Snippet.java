package utility;
  
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import reuseablecomponent.BaseClass;

/**
 * @author suman
 * @Date 27/8/2018
 * @purpose take screen sort and share date time
 */
public class Snippet {
	//	//this method is to save the current screen's screenshot and  return the address  as a string
	public static String takeScreenShot() {
			final WebDriver driver = BaseClass.driver;
			TakesScreenshot screen = (TakesScreenshot) driver;
			File src = screen.getScreenshotAs(OutputType.FILE);
			FileReader reader;
			String scrAddr="D://Automation_Reports_screensort//screenshots//";
			Properties p;
			try {
			reader = new FileReader("./CustomizeThings.properties");
    	    p=new Properties();  
    	    p.load(reader);
    	    //checking property file for custom screen sort saving path
    	    if(p.getProperty("screensortfolder")!=null)
    	    	scrAddr=p.getProperty("screensortfolder");
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			String dest =scrAddr + getcurrentdateandtime()+".jpg";
			File target = new File(dest);
			//saving screensort
			try {
				FileUtils.copyFile(src, target);
			} catch (IOException e) {
				Log4j.error("taking screen sort fail");
				e.printStackTrace();
			}
			return dest;
		}
	//this method is to return the current time stamp as a string
	public static String getcurrentdateandtime(){
		String str = null;
		try{
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss:SSS");
		Date date = new Date();
		str= dateFormat.format(date);
		str = str.replace(" ", "_").replaceAll("/", "_").replaceAll(":", "_");
		}
		catch(Exception e){e.printStackTrace();}
		return str;
	}
	
}
