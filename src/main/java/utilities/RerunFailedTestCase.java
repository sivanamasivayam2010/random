package utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RerunFailedTestCase implements IRetryAnalyzer {

	private int retryCount = 0;
	private static final int maxRetryCount = 2;

	// method to implement rerun failed testcases
	public boolean retry(ITestResult result) {
		if (retryCount < maxRetryCount) {
			retryCount++;
			return true;
		}
		return false;
	}
}
