package testCaseCorporateWellnessPage;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pages.BaseUI;
import pages.CorporateWellnessPage;
import utilities.ReadPropertiesFile;
import utilities.TestDataProvider;

//checks whether a demo can be scheduled when invalid details are entered
public class CorporateWellnessWithInvalidDetailsTest extends CorporateWellnessPage {

	@BeforeMethod(alwaysRun = true)
	public void openBrowser() {

		log.info("CorporateWellness form with invalid details Test");
		BaseUI.openBrowser();
	}

	// runs twice as we use the same method to check 2 invalid details
	// 1. Invalid Email ID
	// 2. Invalid Contact number
	@Test(dataProvider = "getCWInvalidDetails", retryAnalyzer = utilities.RerunFailedTestCase.class, groups = {
			"regression" })
	public void InvalidTest(Hashtable<String, String> dataTable) {

		CorporateWellnessPage cw = new CorporateWellnessPage();
		BaseUI.logger = BaseUI.report
				.createTest("CorporateWellnessWithInValidDetailsTest " + dataTable.get("Comments"));
		log.info("CorporateWellness form with invalid details Test : " + dataTable.get("Comments"));
		BaseUI.logger.log(Status.INFO, ReadPropertiesFile.getBrowser() + " is opened Successfully ");
		BaseUI.logger.log(Status.INFO, "Practo website is launched ");
		cw.clickForProviders();
		cw.clickCorporateWellness();
		cw.enterName(dataTable.get("Name"));
		cw.enterOrgName(dataTable.get("OrgName"));
		cw.enterOfflEmail(dataTable.get("OffEmail"));
		cw.enterContactNum(dataTable.get("ContactNo"));
		cw.enterOrgSize();
		cw.clickScheduleBtn();
		//thread.sleep can be used if the user needs to solve captcha when Schedule a demo button is clicked
//		try {
//			Thread.sleep(100000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		cw.captureAlert();
		try {
			BaseUI.logger.log(Status.INFO, "Obtained Alert Message : " + cw.alertMsg());
			BaseUI.reportPass(cw.alertMsg() + " is printed successfully ");
			log.info(cw.alertMsg() + " is printed successfully ");
		} catch (Exception e) {
			BaseUI.reportFail(e.getMessage());
		}
	}

	@DataProvider
	public Object[][] getCWInvalidDetails() {
		return TestDataProvider.getTestData("testData.xlsx", "testData", "Invalid Data");
	}

	@AfterMethod(alwaysRun = true)
	public void closeBrowser() {
		BaseUI.closeBrowser();
	}
}
