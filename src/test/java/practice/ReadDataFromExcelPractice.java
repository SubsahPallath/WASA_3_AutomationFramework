//data read from the excel sheet.

package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelPractice {

	public static void main(String[] args) throws IOException {

		// Step1: Open the document on java readable format

		FileInputStream file = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");

		// Step2: create workbook
		Workbook wb = WorkbookFactory.create(file);

		// Step3: Get control of Sheet

		Sheet sht = wb.getSheet("Contact");

		// step4: get control of row
		Row row = sht.getRow(1);
		// step5: get control of cell
		Cell cell = row.getCell(2);
		// step6: read the data inside the cell.
		System.err.println(cell.getStringCellValue());

	}

}
