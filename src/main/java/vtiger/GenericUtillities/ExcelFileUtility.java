package vtiger.GenericUtillities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File;

/**
 * This class contains generic method related to excel file
 * 
 * @author palla
 *
 */

public class ExcelFileUtility {

	public String readDataFromExcel(String sheet, int row, int cell) throws IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet SHEET = wb.getSheet(sheet);
		Row ROW = SHEET.getRow(row);
		Cell CELL = ROW.getCell(cell);
		String value = CELL.getStringCellValue();
		
		return value;
		
		
	}	
	
	/*public String readDataFromExcel(String sheet, int row, int cell) throws IOException {
		FileInputStream fis = new FileInputStream(IConstantsUtility.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheet);
		Row rw = sh.getRow(row);
		Cell cel = rw.getCell(cell);
		String str = cel.getStringCellValue();
		wb.close();
		return str;
	}*/

	/**
	 * This method will give the total count of rows.
	 * 
	 * @param sheet
	 * @param row
	 * @param cell
	 * @param value
	 * @return
	 * @throws IOException
	 */
	public int getRowCount(String sheet, int row, int cell) throws IOException {
		FileInputStream fis = new FileInputStream(IConstantsUtility.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheet);
		int rowCount = sh.getLastRowNum();
		wb.close();
		return rowCount;

	}

	/**
	 * This method will help to add value to the excel sheet
	 * 
	 * @param sheet
	 * @param row
	 * @param cell
	 * @param value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeDataIntoExcel(String sheet, int row, int cell, String value)
			throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(IConstantsUtility.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Row rw = wb.getSheet(sheet).getRow(row);
		rw.createCell(cell).setCellValue(value);

		FileOutputStream fos = new FileOutputStream(IConstantsUtility.excelFilePath);
		wb.write(fos);
		System.out.println("Data added -->" + value);
		wb.close();
	}
	
	public Object[][] readMultipleData(String sheetNamae ) throws IOException {
		
		FileInputStream fis = new FileInputStream(IConstantsUtility.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetNamae);
		int lastRow = sh.getLastRowNum();
		int laseCell=sh.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[lastRow][laseCell];
		
		for (int i = 0; i < lastRow; i++) {
			
			for (int j = 0; j < laseCell; j++) {
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			}
			
		}
		
		return data;
		
	}

}
