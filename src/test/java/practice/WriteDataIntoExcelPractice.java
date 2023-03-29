package practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcelPractice {

	public static void main(String[] args) throws IOException {

		// Step1: Open the document on java readable format

		FileInputStream file = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");

		// Step2: create workbook
		Workbook wb = WorkbookFactory.create(file);

		// Step3: Get control of Sheet

		Sheet sht = wb.getSheet("Contact");

		// step4: get control of row
		Row row = sht.getRow(1);

		// step5: Create a cell in the row
		Cell c = row.createCell(6);

		// step6: set the value to the cell
		c.setCellValue("wasa3");

		// Step7: Open the document in the write mode

		FileOutputStream f = new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");

		// step8: Write the data
		wb.write(f);
		System.err.println("data added");
	}
}
