package utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertiesFile {
	private static Properties properties;
	private static final String propertiesFilePath = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\Config.properties";

	// method to read Propertiesfile
	public static Properties ReadPropertiesFiles() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertiesFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Config.properties not found at " + propertiesFilePath);
		}
		return properties;
	}

	static Properties prop = utilities.ReadPropertiesFile.ReadPropertiesFiles();

	public static String getURL() {
		return prop.getProperty("url");
		// returns the url from Config.properties file
	}

	public static String getBrowser() {
		return prop.getProperty("browser");
		// returns the browser from Config.properties file
	}

	public static String getLocation() {
		return prop.getProperty("location");
		// returns the location from Config.properties file
	}

	public static String getSuggestedLocation() {
		return prop.getProperty("Suggestedlocation");
		// returns the Suggestedlocation from Config.properties file
	}

	public static String getSearchBoxTitle() {
		return prop.getProperty("SearchBoxTitle");
		// returns the location from Config.properties file
	}

	public static String getSuggestedSearchBoxTitle() {
		return prop.getProperty("SuggestedSearchBoxTitle");
		// returns the Suggestedlocation from Config.properties file
	}

}
