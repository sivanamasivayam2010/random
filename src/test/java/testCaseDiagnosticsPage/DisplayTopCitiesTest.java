package testCaseDiagnosticsPage;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pages.BaseUI;
import pages.DiagnosticsPage;
import utilities.ReadPropertiesFile;
import utilities.ScreenShot;

//stores and displays Top cities displayed on the Diagnostics page
public class DisplayTopCitiesTest extends DiagnosticsPage {

	@BeforeMethod(alwaysRun = true)
	public void openBrowser() {
		log.info("Display Top cities Test");
		BaseUI.openBrowser();
	}

	@Test(retryAnalyzer = utilities.RerunFailedTestCase.class, groups = { "regression" })
	public void displayTopCitiesTest() {
		BaseUI.logger = BaseUI.report.createTest("DisplayTopCitiesTest");
		BaseUI.logger.log(Status.INFO, ReadPropertiesFile.getBrowser() + " is opened successfully ");
		BaseUI.logger.log(Status.INFO, "Practo website is launched ");
		DiagnosticsPage.diagnosticsButtonClick();
		DiagnosticsPage.topCitiesDisplay();
		Assert.assertEquals(DiagnosticsPage.topCitiesDisplay.getText(), "TOP CITIES", "Top Cities are not displayed");
		ScreenShot.clickScreenshot(driver, "Top Cities Display");
		try {
			DiagnosticsPage.getAllTitles();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@AfterMethod(alwaysRun = true)
	public void closeBrowser() {
		BaseUI.closeBrowser();
	}
}
