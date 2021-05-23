package testCaseDiagnosticsPage;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pages.BaseUI;
import pages.DiagnosticsPage;
import utilities.ReadPropertiesFile;

//clicks on Diagnostics button on practo.com homepage
public class DiagnosticsOptionClickTest extends DiagnosticsPage {

	@BeforeMethod(alwaysRun = true)
	public void openBrowser() {
		log.info("Diagnostics option click Test");
		BaseUI.openBrowser();
	}

	@Test(retryAnalyzer = utilities.RerunFailedTestCase.class, groups = { "smoke" })
	public void diagnosticsButtonClickTest() {
		BaseUI.logger = BaseUI.report.createTest("DiagnosticsOptionClickTest");
		BaseUI.logger.log(Status.INFO, ReadPropertiesFile.getBrowser() + " is opened successfully ");
		BaseUI.logger.log(Status.INFO, "Practo website is launched ");
		DiagnosticsPage.diagnosticsButtonVisible();
		Assert.assertEquals(DiagnosticsPage.isClickAble(DiagnosticsPage.buttonElement), true, "Diagnostics Option is not clickable");
		DiagnosticsPage.diagnosticsButtonClick();
	}

	@AfterMethod(alwaysRun = true)
	public void closeBrowser() {
		BaseUI.closeBrowser();
	}

}
