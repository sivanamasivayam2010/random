package testCaseHomePage;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pages.BaseUI;
import pages.HomePage;
import utilities.ReadPropertiesFile;

//clicks Search in entire city option from the dropdown
public class SearchInEntireCityTest extends HomePage {

	HomePage HP = new HomePage();

	@BeforeMethod(alwaysRun = true)
	public void openBrowser() {
		log.info("Search in entire " + ReadPropertiesFile.getLocation() + " Test");
		BaseUI.openBrowser();
	}

	@Test(retryAnalyzer = utilities.RerunFailedTestCase.class, groups = { "regression" })
	public void searchInEntireCityTest() {
		BaseUI.logger = BaseUI.report.createTest("SearchInEntireCityTest");
		BaseUI.logger.log(Status.INFO, ReadPropertiesFile.getBrowser() + " is opened successfully ");
		BaseUI.logger.log(Status.INFO, "Practo website is launched ");
		HP.searchInEntireCity();
		Assert.assertEquals(HomePage.location.getAttribute("value"), ReadPropertiesFile.getLocation(),
				"Search in Entire " + ReadPropertiesFile.getLocation() + " is not selected ");
	}

	@AfterMethod(alwaysRun = true)
	public void closeBrowser() {
		BaseUI.closeBrowser();
	}
}
