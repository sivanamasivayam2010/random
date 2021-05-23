package pages;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utilities.DriverSetup;
import utilities.ReadPropertiesFile;
import utilities.ScreenShot;

public class BaseUI extends DriverSetup{
	//initializing logg4j
	public static Logger log= LogManager.getLogger(BaseUI.class);
	
	//method to open browser with practo.com website
	public static void openBrowser()
	{
		driver = DriverSetup.getWebDriver(ReadPropertiesFile.getBrowser());
		driver.get(ReadPropertiesFile.getURL());
		log.info("Opening Browser");
		log.info("Practo website is launched ");
	}
	
	//method to close browser
	public static void closeBrowser()
	{
			driver.quit();
			BaseUI.logger.log(Status.INFO,ReadPropertiesFile.getBrowser()+" is closed Successfully ");
			report.flush();
			log.info("Closing Browser \n");
	}	
	
	//method to write pass and fail reports
	public static ExtentReports report = utilities.ExtentReportManager.getReportInstance();
	public static ExtentTest logger;
	
	public static void reportFail(String reportString) {
		logger.log(Status.FAIL, reportString);
		ScreenShot.clickScreenshot(driver,"Failed TestCase");
		Assert.fail(reportString);
	}

	public static void reportPass(String reportString) {
		logger.log(Status.PASS, reportString);
	}
	
}
