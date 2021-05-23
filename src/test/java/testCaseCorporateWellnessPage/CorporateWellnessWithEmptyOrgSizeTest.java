package testCaseCorporateWellnessPage;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pages.BaseUI;
import pages.CorporateWellnessPage;
import utilities.ReadPropertiesFile;
import utilities.TestDataProvider;

//checks whether a demo can be scheduled when Organization Size field is left empty
public class CorporateWellnessWithEmptyOrgSizeTest extends CorporateWellnessPage{

	@BeforeMethod(alwaysRun=true)
    public void openBrowser()
    {
		log.info("CorporateWellness form with empty Organization size Test");
	 BaseUI.openBrowser();
    }
 
 @Test(dataProvider="getCWEmptyOrgSize",retryAnalyzer = utilities.RerunFailedTestCase.class,groups = { "regression" })
 public void EmptyOrgSizeTest(Hashtable<String, String > dataTable) 
	{
		BaseUI.logger = BaseUI.report.createTest("CorporateWellnessWithEmptyOrgsizeTest");
		BaseUI.logger.log(Status.INFO,ReadPropertiesFile.getBrowser()+" is opened Successfully ");
		BaseUI.logger.log(Status.INFO,"Practo website is launched ");
		CorporateWellnessPage cw = new CorporateWellnessPage();
		
		cw.clickForProviders();
		cw.clickCorporateWellness();
		cw.enterName(dataTable.get("Name"));
		cw.enterOrgName(dataTable.get("OrgName"));
		cw.enterOfflEmail(dataTable.get("OffEmail"));
		cw.enterContactNum(dataTable.get("ContactNo"));
		cw.clickScheduleBtn();
		//thread.sleep can be used if the user needs to solve captcha when Schedule a demo button is clicked
//		try {
//			Thread.sleep(100000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		cw.captureAlert();		
		try {
			Assert.assertEquals(cw.alertMsg(), "Please Enter Organization size");
			BaseUI.logger.log(Status.INFO,"Obtained Alert Message : "+cw.alertMsg());
			BaseUI.reportPass(cw.alertMsg()+" is printed successfully ");
			log.info(cw.alertMsg()+" is printed successfully ");
		} catch (Exception e) {
			BaseUI.reportFail(e.getMessage());
		}
	}
	@DataProvider
	public Object[][] getCWEmptyOrgSize(){
		return TestDataProvider.getTestData("testData.xlsx", "testData", "Valid Data");
	}
	@AfterMethod(alwaysRun=true)
	public void closeBrowser() {
		BaseUI.closeBrowser();
	}
}
