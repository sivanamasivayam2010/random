package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import utilities.DriverSetup;
import utilities.ReadPropertiesFile;

public class HomePage extends DriverSetup {

	public static WebElement location, searchbox;

	public String locationSearchXPath = "//input[@placeholder='Search location']";

	public String searchBoxXPath = "//input[@placeholder='Search doctors, clinics, hospitals, etc.']";
	public static Logger log = LogManager.getLogger(HomePage.class);

	// method to verify whether the webelement is clickable or not. It returns
	// boolean value.
	public boolean isClickAble(WebElement webe) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.elementToBeClickable(webe));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// method to click on Location search box
	public void locationSearchClick() {
		try {
			location = driver.findElement(By.xpath(locationSearchXPath));
			location.click();
			BaseUI.reportPass("Location Search box is clicked Successfully ");
			log.info("Location Search box is clicked Successfully ");
		} catch (Exception e) {
			BaseUI.reportFail(e.getMessage());
			log.info("Location Search box is not clicked Successfully ");
		}
	}

	// method to click on Use my Location option from the search box
	public void useMyLocation() {
		locationSearchClick();
		try {
			driver.findElement(By.xpath("//div[contains(text(),'Use my location')]")).click();
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.attributeToBe(location, "value", "Near Me"));
			BaseUI.reportPass("Use my location is clicked Successfully ");
			log.info("Use my location is clicked Successfully ");
		} catch (Exception e) {
			BaseUI.reportFail(e.getMessage());
			log.info("Use my location is not clicked Successfully ");
		}
	}

	// method to clear anything typed on the Location search box
	public void locationSearchClear() {
		try {
			location = driver.findElement(By.xpath(locationSearchXPath));
			locationSearchClick();
			location.clear();
			BaseUI.reportPass("location Search Box is cleared Successfully ");
			log.info("location Search Box is cleared Successfully ");
		} catch (Exception e) {
			BaseUI.reportFail(e.getMessage());
			log.info("location Search Box is not cleared Successfully ");
		}
	}

	// method to search for a location
	public void locationSearch() {
		location = driver.findElement(By.xpath(locationSearchXPath));
		locationSearchClear();

		// gets the location from Config.propeties file
		location.sendKeys(ReadPropertiesFile.getLocation());
		BaseUI.logger.log(Status.INFO,
				ReadPropertiesFile.getLocation() + " is entered in Location Search box Successfully ");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.attributeToBe(location, "value", ReadPropertiesFile.getLocation()));
		try {
			driver.findElement(By.xpath("//div[contains(text(),'" + ReadPropertiesFile.getLocation() + "')]")).click();
			BaseUI.reportPass(ReadPropertiesFile.getLocation() + " is clicked Sucessfully ");
			log.info(ReadPropertiesFile.getLocation() + " is clicked Successfully ");
		} catch (Exception e) {
			BaseUI.reportFail(e.getMessage());
			log.info(ReadPropertiesFile.getLocation() + " is not clicked Successfully ");
		}
	}

	// method to click Search in entire city suggestion
	public void searchInEntireCity() {
		locationSearch();
		locationSearchClick();
		try {
			driver.findElement(By.xpath("//div[contains(text(),'Search in entire ')]")).click();
			BaseUI.reportPass("Search in entire " + ReadPropertiesFile.getLocation() + " is clicked Successfully ");
			log.info("Search in entire " + ReadPropertiesFile.getLocation() + " is clicked Successfully ");
		} catch (Exception e) {
			BaseUI.reportFail(e.getMessage());
			log.info("Search in entire " + ReadPropertiesFile.getLocation() + " is not clicked Successfully ");
		}
	}

	// method to check whether the typed in location from Config.properties file is
	// chosen
	public void suggestionLocationCheck() {
		locationSearch();
		locationSearchClick();
		try {
			driver.findElement(By.xpath("//div[contains(text(),'" + ReadPropertiesFile.getSuggestedLocation() + "')]"))
					.click();
			BaseUI.reportPass(ReadPropertiesFile.getSuggestedLocation() + " is clicked Successfully ");
			log.info("Search in entire " + ReadPropertiesFile.getLocation() + " is clicked Successfully ");
		} catch (Exception e) {
			BaseUI.reportFail(e.getMessage());
			log.info("Search in entire " + ReadPropertiesFile.getLocation() + " is not clicked Successfully ");
		}
	}

	// method to use search box on the Hospital search page using PageFactory
	public HospitalSearch searchBox(String hospital) {
		try {
			searchbox = driver.findElement(By.xpath(searchBoxXPath));
			searchBoxClick();
			searchbox.sendKeys(hospital);
			driver.findElement(By.xpath("//div[contains(text(),'" + ReadPropertiesFile.getSearchBoxTitle() + "')]"))
					.click();
			BaseUI.reportPass(ReadPropertiesFile.getSearchBoxTitle() + " is clicked Successfully ");
			log.info(ReadPropertiesFile.getSearchBoxTitle() + " is clicked Successfully ");
		} catch (Exception e) {
			BaseUI.reportFail(e.getMessage());
			log.info(ReadPropertiesFile.getSearchBoxTitle() + " is not clicked Successfully ");
		}
		return PageFactory.initElements(driver, HospitalSearch.class);
	}

	// method to click search box on the hospital search page
	public void searchBoxClick() {

		try {
			searchbox = driver.findElement(By.xpath(searchBoxXPath));
			searchbox.click();
			BaseUI.reportPass("Search box is clicked Successfully ");
			log.info("Search box is clicked Successfully ");
		} catch (Exception e) {
			BaseUI.reportFail(e.getMessage());
			log.info("Search box is not clicked Successfully ");
		}
	}

	// method to clear search box on the hospital search page
	public void searchBoxClear() {
		try {
			searchbox = driver.findElement(By.xpath(searchBoxXPath));
			searchBoxClick();
			searchbox.sendKeys(ReadPropertiesFile.getSearchBoxTitle());
			searchbox.clear();
			BaseUI.reportPass("Search Box is cleared Successfully ");
			log.info("Search Box is cleared Successfully ");
		} catch (Exception e) {
			BaseUI.reportFail(e.getMessage());
			log.info("Search Box is not cleared Successfully ");
		}
	}

	// method to check whether the entered name is selected from the suggestions
	public void suggestionCheck() {
		searchBoxClick();
		try {
			driver.findElement(
					By.xpath("//div[contains(text(),'" + ReadPropertiesFile.getSuggestedSearchBoxTitle() + "')]"))
					.click();
			BaseUI.reportPass(ReadPropertiesFile.getSuggestedSearchBoxTitle() + " is clicked Successfully ");
			log.info(ReadPropertiesFile.getSuggestedSearchBoxTitle() + " is clicked Successfully ");
		} catch (Exception e) {
			BaseUI.reportFail(e.getMessage());
			log.info(ReadPropertiesFile.getSuggestedSearchBoxTitle() + " is not clicked Successfully ");
		}
	}
}
