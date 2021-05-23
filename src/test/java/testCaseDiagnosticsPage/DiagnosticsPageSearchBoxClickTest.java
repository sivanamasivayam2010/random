package testCaseDiagnosticsPage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pages.BaseUI;
import pages.DiagnosticsPage;
import utilities.ReadPropertiesFile;

//checks the fuctionality of Search box on Diagnostics page
public class DiagnosticsPageSearchBoxClickTest extends DiagnosticsPage{

	
	@BeforeMethod(alwaysRun=true)
	public void openBrowser()
	{
		log.info("Diagnostics Page Search box click Test");
		BaseUI.openBrowser();
	}
	
	@Test(retryAnalyzer = utilities.RerunFailedTestCase.class,groups = { "smoke" })
	public void selectCitySearchBoxClickTest()
	{
		BaseUI.logger = BaseUI.report.createTest("DiagnosticPageSearchBoxClickTest");
		BaseUI.logger.log(Status.INFO,ReadPropertiesFile.getBrowser()+" is opened successfully ");
		BaseUI.logger.log(Status.INFO,"Practo website is launched ");
		DiagnosticsPage.diagnosticsButtonClick();
		DiagnosticsPage.selectCitySearchBar();
	}
	
	@AfterMethod(alwaysRun=true)
	public void closeBrowser()
	{
		BaseUI.closeBrowser();
	}
}

