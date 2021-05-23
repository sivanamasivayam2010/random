package pages;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import utilities.DriverSetup;
import utilities.ReadPropertiesFile;

public class DiagnosticsPage extends DriverSetup {

	public static Logger log = LogManager.getLogger(DiagnosticsPage.class);
	public static WebElement buttonElement, selectCity, topCitiesDisplay, topCity, selectedLocation;

	// method to check whether a webelement is clickable or not
	public static boolean isClickAble(WebElement webe) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.elementToBeClickable(webe));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// method to check the visibility of Diagnostics button
	public static void diagnosticsButtonVisible() {

		buttonElement = driver.findElement(By.xpath("//div[contains(text(),'Diagnostics')]"));
	}

	public static void diagnosticsButtonClick() {
		try {
			buttonElement = driver.findElement(By.xpath("//div[contains(text(),'Diagnostics')]"));
			buttonElement.click();
			BaseUI.reportPass("diagnostics Tab is clicked Successfully ");
			log.info("diagnostics Tab is clicked Successfully ");
		} catch (Exception e) {
			BaseUI.reportFail(e.getMessage());
			log.info("diagnostics Tab is not clicked Successfully ");
		}
	}

	// method to select the City search bar
	public static void selectCitySearchBar() {
		selectCity = driver.findElement(By.xpath("//input[@class=\"c-search__input citylist\"]"));
		selectCity.sendKeys(ReadPropertiesFile.getLocation());
		BaseUI.logger.log(Status.INFO, ReadPropertiesFile.getLocation() + " is  entered in City Search bar");
		log.info(ReadPropertiesFile.getLocation() + " is  entered in City Search bar");
		try {
			Assert.assertEquals(DiagnosticsPage.selectCity.getAttribute("value"), ReadPropertiesFile.getLocation(),
					"Text can't be entered inside the search box");
			BaseUI.reportPass(ReadPropertiesFile.getLocation() + " is  entered Successfully ");
			log.info(ReadPropertiesFile.getLocation() + " is  entered Successfully ");
		} catch (Exception e) {
			BaseUI.reportFail(e.getMessage());
			log.info(ReadPropertiesFile.getLocation() + " is  not entered Successfully ");
		}
	}

	// method to list and display the Top Cities mentioned on the Diagnostics page
	public static void topCitiesDisplay() {
		topCitiesDisplay = driver.findElement(By.xpath("//div[contains(text(),'TOP CITIES')]"));
	}

	public static void getAllTitles() throws IOException {
		List<String> topCities = new ArrayList<String>();
		log.info("Top cities are printed in TopCities.txt on the testoutput folder.");
		// using FileWriter to store the obtained list on TopCities.txt file present on
		// the testoutput folder
		FileWriter write = new FileWriter(System.getProperty("user.dir") + "//testoutput//TopCities.txt");
		try {
			List<WebElement> elementName = driver
					.findElements(By.xpath("//div[@class='u-margint--standard o-f-color--primary']"));

			for (int i = 0; i < elementName.size(); i++) {
				topCities.add(elementName.get(i).getText());
			}
			write.write("Top cities are " + topCities);
			BaseUI.reportPass("Top cities is Displayed Successfully ");
			log.info("Top cities is Displayed Successfully ");
		} catch (Exception e) {
			BaseUI.reportFail(e.getMessage());
			log.info("Top cities is not Displayed Successfully ");
		}
		write.close();
	}

	// method to select top city and display the result as per search citeria
	public static void selectTopCity() {
		topCity = driver.findElement(By.xpath("//div[contains(text(),'" + ReadPropertiesFile.getLocation()
				+ "') and @class='u-margint--standard o-f-color--primary']"));
		selectedLocation = driver.findElement(By.xpath("//input[@id='locationInput']"));
		try {
			Assert.assertTrue(DiagnosticsPage.isClickAble(DiagnosticsPage.topCity));
			DiagnosticsPage.topCity.click();
			BaseUI.reportPass(
					"Diagonstics Page :" + ReadPropertiesFile.getLocation() + " City is clicked Successfully ");
			log.info("Diagonstics Page  :" + ReadPropertiesFile.getLocation() + " City is clicked Successfully ");
			Assert.assertEquals(DiagnosticsPage.selectedLocation.getAttribute("value"),
					ReadPropertiesFile.getLocation(), "Results for selected location is not displayed");
			log.info("Results for selected location is displayed");
			BaseUI.reportPass("Results for selected location is displayed");
		} catch (Exception e) {
			BaseUI.reportFail(e.getMessage());
			log.info("Diagonstics Page  :" + ReadPropertiesFile.getLocation() + " City is not clicked Successfully ");
		}
	}

}
