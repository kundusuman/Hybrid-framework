
package utility;
/**
 * @author suman
 * @Date 31/08/2018
 * @Purpose opening a html file like extent report
 *
 */
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class OpenReport
{
	public static String addr;
	//setting the address of the html file
	public OpenReport(String addr)
	{
		this.addr=addr;
	}
	//opening the html file
	public static void open()
	{
		Properties p=OpenReport.loadproperty();
		if(p.getProperty("openreport").equalsIgnoreCase("yes"))
		{
			File htmlFile = new File(addr);
			try {
				Desktop.getDesktop().browse(htmlFile.toURI());
			} catch (IOException e) {
				Log4j.error("opening report fails");
				
			}
		}
	}
	private static Properties loadproperty() 
	{
		FileReader reader=null;
		Properties p=null;
		try {
			reader = new FileReader("./CustomizeThings.properties");
			p=new Properties();  
			p.load(reader);
		} catch (FileNotFoundException e) {
			Log4j.error("property file load fail  | message send fail");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			Log4j.error("property file load fail  | message send fail");
		} 
	    return p;
	}

}

