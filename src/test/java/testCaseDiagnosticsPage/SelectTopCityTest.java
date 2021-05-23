package testCaseDiagnosticsPage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pages.BaseUI;
import pages.DiagnosticsPage;
import utilities.ReadPropertiesFile;

//selects a city displayed under Top cities title
public class SelectTopCityTest extends DiagnosticsPage {

	@BeforeMethod(alwaysRun = true)
	public void openBrowser() {
		log.info("Select Top city Test");
		BaseUI.openBrowser();
	}

	@Test(retryAnalyzer = utilities.RerunFailedTestCase.class, groups = { "regression" })
	public void selectTopCityTest() {
		BaseUI.logger = BaseUI.report.createTest("SelectTopCityTest");
		BaseUI.logger.log(Status.INFO, ReadPropertiesFile.getBrowser() + " is opened successfully ");
		BaseUI.logger.log(Status.INFO, "Practo website is launched ");
		DiagnosticsPage.diagnosticsButtonClick();
		DiagnosticsPage.selectTopCity();
	}

	@AfterMethod(alwaysRun = true)
	public void closeBrowser() {
		BaseUI.closeBrowser();
	}
}
