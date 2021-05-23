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
import utilities.ScreenShot;
import utilities.TestDataProvider;

//checks whether the user can succesully schedule a demo
public class CorporateWellnessWithValidDetailsTest extends CorporateWellnessPage {

	 @BeforeMethod(alwaysRun=true)
	    public void openBrowser()
	    {
			log.info("CorporateWellness form with valid details Test");
	    	BaseUI.openBrowser();
	    }
	@Test(dataProvider="getCWValidData",retryAnalyzer = utilities.RerunFailedTestCase.class,groups = { "regression" })
	public void ValidDetailsTest(Hashtable<String, String > dataTable) 
	{
		CorporateWellnessPage cw = new CorporateWellnessPage();
		BaseUI.logger = BaseUI.report.createTest("CorporateWellnessWithValidDetailsTest");
		BaseUI.logger.log(Status.INFO,ReadPropertiesFile.getBrowser()+" is opened successfully ");
		BaseUI.logger.log(Status.INFO,"Practo website is launched ");
		cw.clickForProviders();
		cw.clickCorporateWellness();
		cw.enterName(dataTable.get("Name"));
		cw.enterOrgName(dataTable.get("OrgName"));
		cw.enterOfflEmail(dataTable.get("OffEmail"));
		cw.enterContactNum(dataTable.get("ContactNo"));
		cw.enterOrgSize();
		cw.clickScheduleBtn();
		//thread.sleep can be used if the user needs to solve captcha when Schedule a demo button is clicked
		try {
			Thread.sleep(100000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//		WebDriverWait wait = new WebDriverWait(driver,90);
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("thankyou-section")));
		BaseUI.logger.log(Status.INFO,cw.thankYouMessage()+" is printed " );
		try {
			Assert.assertEquals(cw.thankYouMessage(), "Thank You. Our team will get in touch with you shortly.");
			ScreenShot.clickScreenshot(driver,"Corporate Wellness form with Valid Details");
			log.info("Testcase passed. successfully scheduled a demo.");
			BaseUI.reportPass("Testcase passed. successfully scheduled a demo. ");
		} catch (Exception e) {
			BaseUI.reportFail(e.getMessage());
			log.info("TestCase Failed: Cannot Schedule a demo");
		}
	}
	@DataProvider
	public Object[][] getCWValidData(){
		return TestDataProvider.getTestData("testData.xlsx", "testData", "Valid Data");
	}
	@AfterMethod(alwaysRun=true)
	public void closeBrowser()
	{
		BaseUI.closeBrowser();
	}
}