package testCaseHomePage;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pages.BaseUI;
import pages.HomePage;
import utilities.ReadPropertiesFile;

//checks the displayed suggestions based on the entered details
public class SearchBoxSuggestionTest extends HomePage {

	HomePage HP = new HomePage();

	@BeforeMethod(alwaysRun = true)
	public void openBrowser() {
		log.info("Search box suggestion Test");
		BaseUI.openBrowser();
	}

	@Test(retryAnalyzer = utilities.RerunFailedTestCase.class, groups = { "regression" })
	public void suggestionCheckTest() {
		BaseUI.logger = BaseUI.report.createTest("SearchBoxSuggestionTest");
		BaseUI.logger.log(Status.INFO, ReadPropertiesFile.getBrowser() + " is opened Successfully ");
		BaseUI.logger.log(Status.INFO, "Practo website is launched ");
		HP.locationSearch();
		HP.suggestionCheck();
		try {
			Assert.assertEquals(driver.getTitle(),
					"Best " + ReadPropertiesFile.getSuggestedSearchBoxTitle()
							+ "s Near Me In Bangalore - Instant Appointment Booking, View Fees, Feedbacks | Practo",
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
