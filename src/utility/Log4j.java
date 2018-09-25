package utility;
/**
 * @author suman
 * @date 31/08/31
 * @purpose this method is for recording log through the framework and project
 *
 */

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class Log4j {
	// Initialize Log4j logs
	     private static Logger Log = Logger.getLogger(Log4j.class.getName());
	     private static boolean temp=false;
	     
	// This is to print log for the beginning of the test case, as we usually run so many test cases as a test suite
	public static void startTestCase(String sTestCaseName){
	    
	    if(temp==false)
	    {
	    	PropertyConfigurator.configure("./log4j.properties");
	    	temp=true;
	    }
	    Log.info("                                                                                               ");
	    Log.info("                                                                                               ");
	    Log.info("****************            "+ sTestCaseName + "      --START--" + "      *********************");
	}
	 
	    //This is to print log for the ending of the test case
	public static void endTestCase(String sTestCaseName){
	    Log.info("****************            " + sTestCaseName + "       -E---N---D-" + "      *********************");
	    Log.info("                                                                                               ");
	    Log.info("                                                                                               ");
	    }
	 
	    // Need to create these methods, so that they can be called  
	//creating function to log all level of log4j
	public static void info(String message) {
	        Log.info(message);
	        }
	public static void warn(String message) {
	    Log.warn(message);
	    }
	public static void error(String message) {
	    Log.error(message);
	    }
	public static void fatal(String message) {
	    Log.fatal(message);
	    }
	public static void debug(String message) {
	    Log.debug(message);
	    }
	public static void trace(String message) {
	    Log.trace(message);
	}
}