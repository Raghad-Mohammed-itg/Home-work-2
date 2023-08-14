package automationFramework;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class WriteOnExcel {

	@Test
	public static void createExcelData() throws FileNotFoundException, IOException {
		// create excel file
		XSSFWorkbook wb = new XSSFWorkbook();
		//XSSFSheet sheet=wb.getSheet("HW");

		// create excel sheet
		XSSFSheet sheet = wb.createSheet("HW2");
		System.out.println("sheet is: "+ sheet.getSheetName());

		Object data[][] = { { "Email", "Password", "message"},
				{"test4@gmail.com","test@1234", "invalid password"},
				{"test24@gmail.com","", "invalid credentials"},
				{"test@gmail.com","Test@123", "valid credentials"}
		};

		for (int r = 0; r < data.length; r++) {

			// create excel row
			XSSFRow row = sheet.createRow(r);
			System.out.println("row is: " + row);

			for (int c = 0; c < data[0].length; c++) {

				// create excel column
				XSSFCell cell = row.createCell(c);
				//System.out.println("cell is: " + cell);
				// write in column
				cell.setCellValue(data[r][c].toString());
				System.out.print("cell is: " + cell);
			}
		}

		// save file
		wb.write(new FileOutputStream("HW.xlsx"));

		// close file
		wb.close();
	}

}
