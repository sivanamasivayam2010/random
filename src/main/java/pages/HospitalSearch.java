package pages;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utilities.DriverSetup;

public class HospitalSearch extends DriverSetup {

	public static Logger log = LogManager.getLogger(HospitalSearch.class);

	public HospitalSearch(WebDriver driver) {
		HospitalSearch.driver = driver;
	}

	// the locators are initialised with their respective webelements
	@FindBy(xpath = "//span[contains(text(),'Online Booking')]")
	public WebElement onlineBooking;

	@FindBy(xpath = "//span[contains(text(),'Accredited')]")
	public WebElement accredited;

	@FindBy(xpath = "//span[contains(text(),'Open 24X7')]")
	public WebElement open24x7;

	@FindBy(xpath = "//span[contains(text(),'All Filters')]")
	public WebElement allFilters;

	@FindBy(xpath = "//span[contains(text(),'Amenities')]")
	public WebElement amenities;

	@FindBy(xpath = "//span[contains(text(),'Has Parking')]")
	public WebElement hasParking;

	@FindBy(xpath = "//span[contains(text(),'Diagnostic Lab Services')]")
	public WebElement diagnosticLabServices;

	@FindBy(xpath = "//span[contains(text(),'24x7 Pharmacy')]")
	public WebElement pharmacy24x7;

	@FindBy(xpath = "//span[contains(text(),'Cafeteria')]")
	public WebElement cafeteria;

	@FindBy(xpath = "//span[contains(text(),'Reset Filters')]")
	public WebElement resetFilters;

	@FindBy(xpath = " //header/div[1]/div[1]/div[1]/label[1]/div[1]")
	public WebElement checkbox;

	@FindBy(className = "c-filter__top__wrapper")
	public WebElement filters;

	// method to check the visibility of filters section
	public void filtersSectionCheck() {
		try {
			Assert.assertTrue(filters.isDisplayed(), "Testcase Failed : Filters section is not visible");
			BaseUI.reportPass("Filters section is visible");
			log.info("Filters section is visible");
		} catch (Exception e) {
			BaseUI.reportFail(e.getMessage());
			log.info("Filters section is not visible");
		}
	}

	// method to check whether amenities tab is displayed or not
	public void amenitiesCheck() {
		try {
			Assert.assertTrue(amenities.isDisplayed(),
					"Testcase Failed : Amenities section is not displayed when All Filters is clicked");
			BaseUI.reportPass("Amenities section is displayed");
			log.info("Amenities section is displayed");
		} catch (Exception e) {
			BaseUI.reportFail(e.getMessage());
			log.info("Amenities section is not displayed");
		}
	}

	// method to click Online Booking filter
	public void clickOnlineBooking() {
		try {
			onlineBooking.click();
			BaseUI.reportPass("Online Booking Filter is Applied successfully");
			log.info("Online Booking Filter is Applied successfully");
		} catch (Exception e) {
			BaseUI.reportFail(e.getMessage());
			log.info("Online Booking Filter is not Applied successfully");
		}
	}

	// method to click Open 24x7 filter
	public void clickOpen24x7Filter() {
		try {
			open24x7.click();
			BaseUI.reportPass("open24x7 Filter is Applied successfully");
			log.info("open24x7 Filter is Applied successfully");
		} catch (Exception e) {
			BaseUI.reportFail(e.getMessage());
			log.info("open24x7 Filter is not Applied successfully");
		}
	}

	// method to click Has Parking filter
	public void clickHasParkingFilter() {
		clickAllFilters();
		try {
			hasParking.click();
			BaseUI.reportPass("hasParking Filter is Applied successfully");
			log.info("hasParking Filter is Applied successfully");
		} catch (Exception e) {
			BaseUI.reportFail(e.getMessage());
			log.info("hasParking Filter is not Applied successfully");
		}
	}

	// method to click All filters
	public void clickAllFilters() {
		try {
			allFilters.click();
			BaseUI.reportPass("allfilters button is Clicked successfully");
			log.info("allfilters button is Clicked successfully");
		} catch (Exception e) {
			BaseUI.reportFail(e.getMessage());
			log.info("allfilters button is not Clicked successfully");
		}
	}

	// method to click Reset filters button
	public void clickResetFilters() {
		try {
			resetFilters.click();
			BaseUI.reportPass("resetfilters is Clicked successfully");
			log.info("resetfilters is Clicked successfully");
		} catch (Exception e) {
			BaseUI.reportFail(e.getMessage());
			log.info("resetfilters is not Clicked successfully");
		}
	}

	// method to check whether a webelement is clickable or not
	public void isClickable(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			BaseUI.reportPass(element.getText() + " Filter is Clickable ");
			log.info(element.getText() + " Filter is clickable");
		} catch (Exception e) {
			BaseUI.reportFail(e.getMessage());
			System.out.println("Testcase failed : " + element.getText() + " Filter is not clickable");
		}
	}

	// method to check whether filters have been reset or not
	public void resetFilterVerify() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(
					ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Reset Filters')]")));
			Assert.fail();
			BaseUI.reportFail("TestCase Failed : Filters are not reset successfully");
			log.info("TestCase Failed : Filters are not reset successfully");
		} catch (Exception e) {
			BaseUI.reportPass("Filters are reset successfully");
			log.info("Filters are reset successfully");
		}
	}

	// method to make the driver wait till the page is refreshed
	public void pageRefreshWait() {
		WebElement elementOldPage = driver.findElement(By.xpath("//header/div[1]/div[1]/div[3]/label[1]/div[1]"));
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.stalenessOf(elementOldPage));
	}

	// method to store and print the Hospitals above 3.5 rating as a list
	public void printHighRatingHospitals() throws IOException {
		pageRefreshWait();
		log.info(
				"Hospitals above 3.5 rating are printed in output_highRatingHospitalsTest.txt on the testoutput folder.");
		FileWriter write = new FileWriter(
				System.getProperty("user.dir") + "//testoutput//output_highRatingHospitalsTest.txt");
		try {
			List<WebElement> rating = driver.findElements(By.xpath("//div[@data-qa-id='star_rating']"));
			List<WebElement> hospitalName = driver.findElements(By.xpath("//h2[@data-qa-id='hospital_name']"));

			Iterator<WebElement> itr1 = rating.iterator();
			Iterator<WebElement> itr2 = hospitalName.iterator();

			write.write(
					"List of Hospitals in Banglore with Rating above 3.5\n\nFilters Applied:Open 24x7, Has Parking\n");

			int count = 1;
			while (itr1.hasNext()) {

				String ratingVal = itr1.next().getText();
				double starRating = Double.parseDouble(ratingVal);

				while (itr2.hasNext()) {

					if (starRating > 3.5) {
						write.write(count + ". " + itr2.next().getText() + "\n");
						count++;
					}
					break;
				}
			}
			BaseUI.reportPass("Hospitals above 3.5 rating is printed successfully");
			log.info("Hospitals above 3.5 rating is printed successfully");
		} catch (Exception e) {
			BaseUI.reportFail(e.getMessage());
			log.info("Hospitals above 3.5 rating is not printed successfully");
		}
		write.close();
	}
}