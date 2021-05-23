package utilities;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.aventstack.extentreports.Status;

import pages.BaseUI;

import org.openqa.selenium.OutputType;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShot extends BaseUI {
	
	// method to click screenshot
	public static void clickScreenshot(WebDriver driver, String name) {

		try {
			TakesScreenshot ss = (TakesScreenshot) driver;
			File source = ss.getScreenshotAs(OutputType.FILE);

			String datetime = new SimpleDateFormat("yyyy.MM.dd HH.mm.ss").format(new Date());
			// stores the current date and time in datetime string
			String filePath = System.getProperty("user.dir") + "\\screenshots\\ " + name + " Screenshot " + datetime
					+ ".png";

			File Dest = new File(filePath);

			FileHandler.copy(source, Dest);
			log.info("Screenshot is taken Successfully ");
			BaseUI.logger.log(Status.INFO, "Screenshot is taken Successfully ");
			// copies the screenshot.png from source location to destination location: screenshots folder.

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}