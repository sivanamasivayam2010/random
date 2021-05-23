package pages;

import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import utilities.DriverSetup;

public class CorporateWellnessPage extends DriverSetup {

	String alertMsg;
	String title;
	public static Logger log = LogManager.getLogger(CorporateWellnessPage.class);

	// method to click For Providers tab in practo.com website
	public void clickForProviders() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'For Providers')]")));
			log.info("For Providers tab is clickable");
			BaseUI.reportPass("For Providers tab is clickable");
		} catch (Exception e) {
			BaseUI.reportFail(e.getMessage());
			log.info("For Providers tab is not clickable");
		}
		try {
			driver.findElement(By.xpath("//span[contains(text(),'For Providers')]")).click();
			BaseUI.reportPass("For Providers tab is clicked successfully ");
			log.info("For Providers tab is clicked successfully ");
		} catch (Exception e) {
			BaseUI.reportFail(e.getMessage());
			log.info("For Providers tab is not clicked successfully ");
		}
	}

	// method to click Corporate Wellness from For Providers tab of practo.com
	// website
	public void clickCorporateWellness() {
		try {
			driver.findElement(By.linkText("Corporate wellness")).click();
			BaseUI.reportPass("Corporate wellness option is clicked successfully ");
			log.info("Corporate wellness option is clicked successfully ");
		} catch (Exception e) {
			BaseUI.reportFail(e.getMessage());
			log.info("Corporate wellness option is not clicked successfully ");
		}
		// Using Set and iterate to traverse between windows
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();

		String homepage = itr.next();
		String corpWellness = itr.next();
		driver.switchTo().window(corpWellness);
		title = driver.getTitle();
		try {
			Assert.assertEquals(corporateWellnessPageTitle(),
					"Employee Health | Corporate Health & Wellness Plans | Practo");
			log.info("Corporate Wellness option is clickable from dropdown.");
			BaseUI.reportPass("Corporate Wellness Page is opened.");
			log.info("Corporate Wellness Page is opened.");
		} catch (Exception e) {
			BaseUI.reportFail(e.getMessage());
			log.info("Corporate Wellness Page is not opened.");
		}
	}

	// method to verify whether driver is on Corporate Wellness page
	public String corporateWellnessPageTitle() {
		BaseUI.logger.log(Status.INFO, "Obtained Page Title :" + title);
		return title;
	}

	// method to capture alert and print the same
	public void captureAlert() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 180);
			wait.until(ExpectedConditions.alertIsPresent());
			alertMsg = driver.switchTo().alert().getText();
			driver.switchTo().alert().accept();
			BaseUI.reportPass("Alert is captured successfully ");
			log.info("Warning message is captured from the alert ");
		} catch (Exception e) {
			BaseUI.reportFail(e.getMessage());
			log.info("Warning message is not captured from the alert ");
		}
	}

	// method to return the alert message
	public String alertMsg() {
		return alertMsg;
	}

	// method to enter name taken from DataProvider on the Name field
	public void enterName(String name) {
		driver.findElement(By.id("name")).sendKeys(name);
		BaseUI.logger.log(Status.INFO, name + " is entered in name field");
		log.info(name + " is entered in name field");
	}

	// method to enter organization name taken from DataProvider on the Organization
	// name field
	public void enterOrgName(String OrgName) {
		driver.findElement(By.id("organization_name")).sendKeys(OrgName);
		BaseUI.logger.log(Status.INFO, OrgName + " is entered in organization name field");
		log.info(OrgName + " is entered in organization name field");
	}

	// method to enter email ID taken from DataProvider on the Official Email ID
	// field
	public void enterOfflEmail(String OfflEmail) {
		driver.findElement(By.id("official_email_id")).sendKeys(OfflEmail);
		BaseUI.logger.log(Status.INFO, OfflEmail + " is entered in Official Email field");
		log.info(OfflEmail + " is entered in Offical Email field");
	}

	// method to enter contact number taken from DataProvider on the Official Phone
	// No field
	public void enterContactNum(String ContactNum) {
		driver.findElement(By.id("official_phone_no")).sendKeys(ContactNum);
		BaseUI.logger.log(Status.INFO, ContactNum + " is entered in Contact Number field");
		log.info(ContactNum + " is entered in Contact Number field");
	}

	// method to select organization size from the dropdown
	public void enterOrgSize() {
		WebElement OrgSize = driver.findElement(By.id("organization_size"));
		Select select = new Select(OrgSize);
		select.selectByValue("5001-10000");
		BaseUI.logger.log(Status.INFO, "5001-10000 is  selected from organization size dropdown");
		log.info("Organization Size Dropdown is selectable");
	}

	// method to click Schedule a demo button
	public void clickScheduleBtn() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(By.id("button-style")));
			log.info("Schedule a demo button is clickable");
			BaseUI.reportPass("Schedule a demo button is clickable");
		} catch (Exception e) {
			BaseUI.reportFail(e.getMessage());
			log.info("Schedule a demo button is not clickable");
		}
		try {
			driver.findElement(By.id("button-style")).click();
			BaseUI.reportPass("Schedule a demo button is clicked Successfully ");
			log.info("Schedule a demo button is clicked Successfully ");
		} catch (Exception e) {
			BaseUI.reportFail(e.getMessage());
			log.info("Schedule a demo button is not clicked Successfully ");
		}
	}

	// method to return Thank you message after demo is successfully scheduled
	public String thankYouMessage() {
		return driver.findElement(By.id("thankyou-section")).getText();
	}
}
