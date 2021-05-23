package utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

//method to setup driver as per the user requirement
public class DriverSetup {

	public static WebDriver driver;

	// gets the web driver name as mentioned by the user
	public static WebDriver getWebDriver(String browser) {
		if (browser.equalsIgnoreCase("chrome"))
			driver = setChromeDriver();
		else if (browser.equalsIgnoreCase("firefox"))
			driver = setFirefoxDriver();
		else if (browser.equalsIgnoreCase("opera"))
			driver = setOperaDriver();
		else if (browser.equalsIgnoreCase("edge"))
			driver = setEdgeDriver();
		else
			System.out.println("Invalid browser. Try again with valid browsers.");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		return driver;
	}

	public static WebDriver setChromeDriver() // method to set properties of Chrome driver
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
	}

	public static WebDriver setFirefoxDriver() // method to set properties of Firefox driver
	{
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		return driver;
	}

	public static WebDriver setOperaDriver() // method to set properties of Opera driver
	{
		System.setProperty("webdriver.opera.driver", System.getProperty("user.dir") + "\\drivers\\operadriver.exe");
		driver = new OperaDriver();
		return driver;
	}

	public static WebDriver setEdgeDriver() // method to set properties of Edge driver
	{
		System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "\\drivers\\msedgedriver.exe");
		driver = new EdgeDriver();
		return driver;
	}

}
