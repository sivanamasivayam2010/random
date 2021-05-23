package testCaseHomePage;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pages.BaseUI;
import pages.HomePage;
import utilities.ReadPropertiesFile;

//checks whether the result is based on the suggested location or not
public class SuggestionLocationCheckTest extends HomePage {

	HomePage HP = new HomePage();

	@BeforeMethod(alwaysRun = true)
	public void openBrowser() {
		log.info("Location Search suggestion Test");
		BaseUI.openBrowser();
	}

	@Test(retryAnalyzer = utilities.RerunFailedTestCase.class, groups = { "regression" })
	public void suggestionLocationCheckTest() {
		BaseUI.logger = BaseUI.report.createTest("SuggestionLocationCheckTest");
		BaseUI.logger.log(Status.INFO, ReadPropertiesFile.getBrowser() + " is opened successfully ");
		BaseUI.logger.log(Status.INFO, "Practo website is launched ");
		HP.suggestionLocationCheck();
		Assert.assertEquals(HomePage.location.getAttribute("value"), ReadPropertiesFile.getSuggestedLocation(),
				"Suggested Location is not selected ");
	}

	@AfterMethod(alwaysRun = true)
	public void closeBrowser() {
		BaseUI.closeBrowser();
	}

}
