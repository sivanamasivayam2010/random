package testCaseHomePage;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pages.BaseUI;
import pages.HomePage;
import utilities.ReadPropertiesFile;

//clicks on Location search box
public class LocationSearchClickTest extends HomePage {

	HomePage HP = new HomePage();

	@BeforeMethod(alwaysRun = true)
	public void openBrowser() {
		log.info("Location Search click Test");
		BaseUI.openBrowser();
	}

	@Test(retryAnalyzer = utilities.RerunFailedTestCase.class, groups = { "smoke" })
	public void locationSearchClickTest() {
		BaseUI.logger = BaseUI.report.createTest("LocationSearchClickTest");
		BaseUI.logger.log(Status.INFO, ReadPropertiesFile.getBrowser() + " is opened successfully ");
		BaseUI.logger.log(Status.INFO, "Practo website is launched ");
		HP.locationSearchClick();
		Assert.assertEquals(HP.isClickAble(HomePage.location), true, "Location Search is not clickable");
	}

	@AfterMethod(alwaysRun = true)
	public void closeBrowser() {
		BaseUI.closeBrowser();
	}
}
