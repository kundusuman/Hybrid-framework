package executionclasses;

/**
 * @author suman
 * @Date 31/08/2018
 * @Purpose initialize test suite
 *
 */
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import reuseablecomponent.BaseClass;
import utility.ExcelUtils;
import utility.Log4j;

public class Start_Test {

	@BeforeClass
	public void visitPage() {
		Log4j.startTestCase("WeHealU");
		FileReader reader = null;
		Properties p = null;
		// reading the property file
		try {
			reader = new FileReader("./CustomizeThings.properties");
			p = new Properties();
			p.load(reader);
		} catch (FileNotFoundException e) {
			Log4j.error("property file load fail");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			Log4j.error("property file load fail");
		}
		System.setProperty("webdriver.chrome.driver", ".\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		new BaseClass(driver);
		BaseClass.driver.manage().window().maximize();
		Log4j.debug("maximizing window");
		Log4j.debug("opening url");
		// opening url from propertyfile
		BaseClass.driver.get(p.getProperty("url"));
		try {
			ExcelUtils.setExcelFile(p.getProperty("sheet"));
		} catch (Exception e) {
			Log4j.error("ExcelSheet load fails");
		}

	}
}
