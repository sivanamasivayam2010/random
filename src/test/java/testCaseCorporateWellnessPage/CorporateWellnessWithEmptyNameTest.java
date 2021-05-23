package testCaseCorporateWellnessPage;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pages.BaseUI;
import pages.CorporateWellnessPage;
import utilities.ReadPropertiesFile;

//checks whether a demo can be scheduled when Name field is left empty
public class CorporateWellnessWithEmptyNameTest extends CorporateWellnessPage {

	@BeforeMethod(alwaysRun = true)
	public void openBrowser() {
		log.info("CorporateWellness form with empty name Test");
		BaseUI.openBrowser();
	}

	@Test(retryAnalyzer = utilities.RerunFailedTestCase.class, groups = { "regression" })
	public void EmptyNameTest() {
		BaseUI.logger = BaseUI.report.createTest("CorporateWellnessWithEmptyNameTest");
		BaseUI.logger.log(Status.INFO, ReadPropertiesFile.getBrowser() + " is opened successfully ");
		BaseUI.logger.log(Status.INFO, "Practo website is launched ");
		CorporateWellnessPage cw = new CorporateWellnessPage();

		cw.clickForProviders();
		cw.clickCorporateWellness();
		cw.clickScheduleBtn();
		//thread.sleep can be used if the user needs to solve captcha when Schedule a demo button is clicked
		
//		try {
//			Thread.sleep(100000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		cw.captureAlert();

		try {
			Assert.assertEquals(cw.alertMsg(), "Please Enter Name");
			BaseUI.logger.log(Status.INFO, "Obtained Alert Message : " + cw.alertMsg());
			BaseUI.reportPass(cw.alertMsg() + " is printed Successfully ");
			log.info(cw.alertMsg() + " is printed Successfully ");
		} catch (Exception e) {
			BaseUI.reportFail(e.getMessage());
		}
	}

	@AfterMethod(alwaysRun = true)
	public void closeBrowser() {
		BaseUI.closeBrowser();

	}
}
