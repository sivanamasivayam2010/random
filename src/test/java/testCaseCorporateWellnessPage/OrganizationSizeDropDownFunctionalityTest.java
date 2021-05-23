package testCaseCorporateWellnessPage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pages.BaseUI;
import pages.CorporateWellnessPage;
import utilities.ReadPropertiesFile;

//checks the functionality of Organization size dropdown box
public class OrganizationSizeDropDownFunctionalityTest extends CorporateWellnessPage {

	@BeforeMethod(alwaysRun = true)
	public void openBrowser() {
		log.info("Organization size dropdown functionality Test");
		BaseUI.openBrowser();
	}

	@Test(retryAnalyzer = utilities.RerunFailedTestCase.class, groups = { "smoke" })
	public void organizationSizeDropDownFunctionalityTest() {
		CorporateWellnessPage cw = new CorporateWellnessPage();
		BaseUI.logger = BaseUI.report.createTest("OrganizationSizeDropDownFunctionalityTest");
		BaseUI.logger.log(Status.INFO, ReadPropertiesFile.getBrowser() + " is opened successfully ");
		BaseUI.logger.log(Status.INFO, "Practo website is launched ");

		cw.clickForProviders();
		cw.clickCorporateWellness();
		cw.enterOrgSize();
		BaseUI.logger.log(Status.INFO, "Testcase passed. Organization Size Dropdown is selectable");
	}

	@AfterMethod(alwaysRun = true)
	public void closeBrowser() {
		BaseUI.closeBrowser();
	}
}