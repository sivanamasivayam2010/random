package testCaseHospitalSearch;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pages.BaseUI;
import pages.HomePage;
import pages.HospitalSearch;
import utilities.ReadPropertiesFile;
import utilities.ScreenShot;

//checks whether high rating hospitals are displayed and prints them to a file
public class SearchHospitalsTest extends HomePage {
	HomePage home = new HomePage();
	HospitalSearch hospitals;

	@BeforeMethod(alwaysRun = true)
	public void openBrowser() {
		log.info("Hospital Search - Search Hospitals Test");
		BaseUI.openBrowser();
		BaseUI.logger = BaseUI.report.createTest("SearchHospitalsTest");
		BaseUI.logger.log(Status.INFO, ReadPropertiesFile.getBrowser() + " is opened successfully ");
		BaseUI.logger.log(Status.INFO, "Practo website is launched ");
		home.locationSearch();
		hospitals = home.searchBox("Hospital");
	}

	@Test(retryAnalyzer = utilities.RerunFailedTestCase.class, groups = { "regression" })
	public void highRatingHospitalsTest() {
		hospitals.clickOpen24x7Filter();
		hospitals.pageRefreshWait();
		hospitals.clickHasParkingFilter();
		try {
			hospitals.printHighRatingHospitals();
		} catch (IOException e) {
			e.printStackTrace();
		}
		ScreenShot.clickScreenshot(driver, "Search Hospitals");
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		BaseUI.closeBrowser();
	}
}
