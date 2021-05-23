package testCaseHospitalSearch;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pages.BaseUI;
import pages.HomePage;
import pages.HospitalSearch;
import utilities.ReadPropertiesFile;

//checks the visibility of Filters section
public class FiltersSectionVisibilityCheck extends HomePage {
	HomePage home = new HomePage();
	HospitalSearch hospitals;

	@BeforeMethod(alwaysRun = true)
	public void openBrowser() {
		log.info("Hospital Search - Filters section visibility Check");
		BaseUI.openBrowser();
		BaseUI.logger = BaseUI.report.createTest("FiltersSectionVisibilityCheck");
		BaseUI.logger.log(Status.INFO, ReadPropertiesFile.getBrowser() + " is opened successfully ");
		BaseUI.logger.log(Status.INFO, "Practo website is launched ");
		home.locationSearch();
		hospitals = home.searchBox("Hospital");
	}

	@Test(retryAnalyzer = utilities.RerunFailedTestCase.class, groups = { "smoke" })
	public void filtersSectionVisibilityTest() {
		hospitals.filtersSectionCheck();
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		BaseUI.closeBrowser();
	}
}
