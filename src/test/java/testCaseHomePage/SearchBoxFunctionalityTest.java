package testCaseHomePage;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pages.BaseUI;
import pages.HomePage;
import utilities.ReadPropertiesFile;
import utilities.ScreenShot;

//checks the functionality of Search box
public class SearchBoxFunctionalityTest extends HomePage {

	HomePage HP = new HomePage();

	@BeforeMethod(alwaysRun = true)
	public void openBrowser() {
		log.info("Search box functionality Test");
		BaseUI.openBrowser();
	}

	@Test(retryAnalyzer = utilities.RerunFailedTestCase.class, groups = { "smoke" })
	public void searchBoxTest() {
		BaseUI.logger = BaseUI.report.createTest("SearchBoxFunctionalityTest");
		BaseUI.logger.log(Status.INFO, ReadPropertiesFile.getBrowser() + " is opened successfully ");
		BaseUI.logger.log(Status.INFO, "Practo website is launched ");
		HP.locationSearch();
		HP.searchBox(ReadPropertiesFile.getSearchBoxTitle());
		ScreenShot.clickScreenshot(driver, "Searchbox");
		try {
			Assert.assertEquals(driver.getTitle(),
					"Best Hospitals in " + ReadPropertiesFile.getLocation()
							+ " - Book Appointment Online, View Fees, Reviews | Practo",
					"Hospital Search is not redirected ");
			BaseUI.reportPass("Results for selected Titles is displayed");
		} catch (Exception e) {
			BaseUI.reportFail(e.getMessage());
		}

	}

	@AfterMethod(alwaysRun = true)
	public void closeBrowser() {
		BaseUI.closeBrowser();
	}
}
