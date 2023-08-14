package automationFramework;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFromExcel {
	private static XSSFWorkbook wb;
	private static XSSFSheet sheet;
	private static XSSFCell cell;
	
	public static String[][] getData(String filePath, String sheetName) throws IOException {
		
		String[][] dataArray = new String[4][3];
		
		FileInputStream excelFile = new FileInputStream(filePath);
		wb = new XSSFWorkbook(excelFile);
		sheet = wb.getSheet(sheetName);
		
		for (int r = 0; r < dataArray.length; r++) {

			for (int c = 0; c < dataArray[r].length; c++) {

				dataArray[r][c] = getCellData(r,c);
				
			}				

		}
		System.out.println("sell data is: " + dataArray);
		return dataArray;
	}
	
	public static String getCellData(int row, int column) {
		System.out.println("read row is : " + row + "   " + sheet.getRow(row));
		cell = sheet.getRow(row).getCell(column);
		
		String cellData = cell.getStringCellValue();
		
		return cellData;
	}
}