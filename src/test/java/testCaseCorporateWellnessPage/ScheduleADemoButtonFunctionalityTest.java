package testCaseCorporateWellnessPage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pages.BaseUI;
import pages.CorporateWellnessPage;
import utilities.ReadPropertiesFile;

//checks the functionality of Scedule a demo button
public class ScheduleADemoButtonFunctionalityTest extends CorporateWellnessPage {

	@BeforeMethod(alwaysRun = true)
	public void openBrowser() {
		log.info("Schedule a demo button functionality Test");
		BaseUI.openBrowser();
	}

	@Test(retryAnalyzer = utilities.RerunFailedTestCase.class, groups = { "smoke" })
	public void scheduleButtonFunctionalityTest() {
		CorporateWellnessPage cw = new CorporateWellnessPage();
		BaseUI.logger = BaseUI.report.createTest("ScheduleButtonFunctionalityTest");
		BaseUI.logger.log(Status.INFO, ReadPropertiesFile.getBrowser() + " is opened successfully ");
		BaseUI.logger.log(Status.INFO, "Practo website is launched ");

		cw.clickForProviders();
		cw.clickCorporateWellness();
		cw.clickScheduleBtn();
	}

	@AfterMethod(alwaysRun = true)
	public void closeBrowser() {
		BaseUI.closeBrowser();
	}
}