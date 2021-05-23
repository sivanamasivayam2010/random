package utilities;

import java.util.Hashtable;

public class TestDataProvider {

	public static Object[][] getTestData(String dataFileName, String sheetName, String testName) {
		ReadExcelDataFile readData = new ReadExcelDataFile(
				System.getProperty("user.dir") + "\\src\\main\\resources\\" + dataFileName);

		// finds the row at which Testcase starts
		int startRowNum = 1;
		while (!(readData.getCellData(sheetName, 0, startRowNum).equals(testName))) {
			startRowNum++;
		}

		// finds the number of rows in a Testcase
		int startTestColumn = startRowNum + 1;
		int startTestRow = startRowNum + 2;
		int rows = 0;
		while (!(readData.getCellData(sheetName, 0, startTestRow).equals(""))) {
			rows++;
			startTestRow++;
		}

		// finds number of columns in a Testcase
		int columns = 0;
		while (!(readData.getCellData(sheetName, columns, startTestColumn).equals(""))) {
			columns++;
		}

		Object[][] dataSet = new Object[rows][1];
		Hashtable<String, String> dataTable = null;
		int dataRowNum = 0;
		for (int rowNum = startRowNum + 2; rowNum < (startRowNum + 2 + rows); rowNum++) {
			dataTable = new Hashtable<String, String>();
			for (int colNum = 0; colNum < columns; colNum++) {
				String key = readData.getCellData(sheetName, colNum, startTestColumn);
				String value = readData.getCellData(sheetName, colNum, rowNum);
				dataTable.put(key, value);
			}
			dataSet[dataRowNum][0] = dataTable;
			dataRowNum++;
		}
		return dataSet;
	}
}
