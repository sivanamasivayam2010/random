package testCaseCorporateWellnessPage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pages.BaseUI;
import pages.CorporateWellnessPage;
import utilities.ReadPropertiesFile;

//clicks on Corporate Wellness option from For Providers tab
public class SelectCorporateWellnessOptionTest extends CorporateWellnessPage {

	@BeforeMethod(alwaysRun = true)
	public void openBrowser() {
		log.info("Select CorporateWellness option Test");
		BaseUI.openBrowser();
	}

	@Test(retryAnalyzer = utilities.RerunFailedTestCase.class, groups = { "smoke" })
	public void corporateWellnessFunctionalityTest() {
		CorporateWellnessPage cw = new CorporateWellnessPage();
		BaseUI.logger = BaseUI.report.createTest("SelectCorporateWellnessOptionTest");
		BaseUI.logger.log(Status.INFO, ReadPropertiesFile.getBrowser() + " is opened successfully ");
		BaseUI.logger.log(Status.INFO, "Practo website is launched ");

		cw.clickForProviders();
		cw.clickCorporateWellness();
	}

	@AfterMethod(alwaysRun = true)
	public void closeBrowser() {
		BaseUI.closeBrowser();
	}
}
