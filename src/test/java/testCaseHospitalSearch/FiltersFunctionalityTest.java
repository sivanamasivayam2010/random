package testCaseHospitalSearch;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pages.BaseUI;
import pages.HomePage;
import pages.HospitalSearch;
import utilities.ReadPropertiesFile;

//checks the functionality of filters present one by one
public class FiltersFunctionalityTest extends HomePage {
	HomePage home = new HomePage();
	HospitalSearch hospitals;

	@BeforeMethod(alwaysRun = true)
	public void openBrowser() {
		log.info("Hospital Search - Filters functionality Test");
		BaseUI.openBrowser();
	}

	// checks the functionality of Online Booking filter
	@Test(retryAnalyzer = utilities.RerunFailedTestCase.class, groups = { "regression" })
	public void onlineBookingFunctionality() {
		log.info("Hospital Search - Filters functionality Test : onlineBooking");
		BaseUI.logger = BaseUI.report.createTest("FiltersFunctionalityTest : onlineBooking");
		BaseUI.logger.log(Status.INFO, ReadPropertiesFile.getBrowser() + " is opened successfully ");
		BaseUI.logger.log(Status.INFO, "Practo website is launched ");
		home.locationSearch();
		hospitals = home.searchBox("Hospital");
		hospitals.isClickable(hospitals.onlineBooking);
	}

	// checks the functionality of Accredited filter
	@Test(retryAnalyzer = utilities.RerunFailedTestCase.class, groups = { "regression" })
	public void accreditedFunctionality() {
		log.info("Hospital Search - Filters functionality Test : accredited");
		BaseUI.logger = BaseUI.report.createTest("FiltersFunctionalityTest : accredited");
		BaseUI.logger.log(Status.INFO, ReadPropertiesFile.getBrowser() + " is opened successfully ");
		BaseUI.logger.log(Status.INFO, "Practo website is launched ");
		home.locationSearch();
		hospitals = home.searchBox("Hospital");
		hospitals.isClickable(hospitals.accredited);
	}

	// checks the functionality of Open 24x7 filter
	@Test(retryAnalyzer = utilities.RerunFailedTestCase.class, groups = { "regression" })
	public void open24x7Functionality() {
		log.info("Hospital Search - Filters functionality Test : open24x7");
		BaseUI.logger = BaseUI.report.createTest("FiltersFunctionalityTest : open24x7");
		BaseUI.logger.log(Status.INFO, ReadPropertiesFile.getBrowser() + " is opened successfully ");
		BaseUI.logger.log(Status.INFO, "Practo website is launched ");
		home.locationSearch();
		hospitals = home.searchBox("Hospital");
		hospitals.isClickable(hospitals.open24x7);
	}

	// checks the functionality of Has Parking filter
	@Test(retryAnalyzer = utilities.RerunFailedTestCase.class, groups = { "regression" })
	public void hasParkingFunctionality() {
		log.info("Hospital Search - Filters functionality Test : hasParking");
		BaseUI.logger = BaseUI.report.createTest("FiltersFunctionalityTest : hasParking");
		BaseUI.logger.log(Status.INFO, ReadPropertiesFile.getBrowser() + " is opened successfully ");
		BaseUI.logger.log(Status.INFO, "Practo website is launched ");
		home.locationSearch();
		hospitals = home.searchBox("Hospital");
		hospitals.clickAllFilters();
		hospitals.isClickable(hospitals.hasParking);
	}

	// checks the functionality of Diagnostic Lab services filter
	@Test(retryAnalyzer = utilities.RerunFailedTestCase.class, groups = { "regression" })
	public void diagnosticLabServicesFunctionality() {
		log.info("Hospital Search - Filters functionality Test : diagnosticLabServices");
		BaseUI.logger = BaseUI.report.createTest("FiltersFunctionalityTest : diagnosticLabServices");
		BaseUI.logger.log(Status.INFO, ReadPropertiesFile.getBrowser() + " is opened successfully ");
		BaseUI.logger.log(Status.INFO, "Practo website is launched ");
		home.locationSearch();
		hospitals = home.searchBox("Hospital");
		hospitals.clickAllFilters();
		hospitals.isClickable(hospitals.diagnosticLabServices);
	}

	// checks the functionality of Pharmacy filter
	@Test(retryAnalyzer = utilities.RerunFailedTestCase.class, groups = { "regression" })
	public void pharmacy24x7Functionality() {
		log.info("Hospital Search - Filters functionality Test : pharmacy24x7");
		BaseUI.logger = BaseUI.report.createTest("FiltersFunctionalityTest : pharmacy24x7");
		BaseUI.logger.log(Status.INFO, ReadPropertiesFile.getBrowser() + " is opened successfully ");
		BaseUI.logger.log(Status.INFO, "Practo website is launched ");
		home.locationSearch();
		hospitals = home.searchBox("Hospital");
		hospitals.clickAllFilters();
		hospitals.isClickable(hospitals.pharmacy24x7);
	}

	// checks the functionality of Cafeteria filter
	@Test(retryAnalyzer = utilities.RerunFailedTestCase.class, groups = { "regression" })
	public void cafeteriaFunctionality() {
		log.info("Hospital Search - Filters functionality Test : cafeteria ");
		BaseUI.logger = BaseUI.report.createTest("FiltersFunctionalityTest : cafeteria ");
		BaseUI.logger.log(Status.INFO, ReadPropertiesFile.getBrowser() + " is opened successfully ");
		BaseUI.logger.log(Status.INFO, "Practo website is launched ");
		home.locationSearch();
		hospitals = home.searchBox("Hospital");
		hospitals.clickAllFilters();
		hospitals.isClickable(hospitals.cafeteria);
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		BaseUI.closeBrowser();
	}
}
