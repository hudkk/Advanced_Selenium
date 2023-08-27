package vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
  * This class contains generic methods
  * @author Vijayalakshmi S
  */
public class ExcelFileUtility {
	
	/**
	 * This method will read data from excel sheet based on row and cell value
	 * @param sheet
	 * @param row
	 * @param cel
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExcel(String sheet,int row,int cel) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IConstantsUtility.ExcelFilePath);
	   Workbook wb = WorkbookFactory.create(fis);
	    Sheet sh= wb.getSheet(sheet);
	      Row rw = sh.getRow(row);
	     Cell ce = rw.getCell(cel);
		String value=ce.getStringCellValue();
		return value;
	}
	/**
	 * 
	 * @param sheet
	 * @return0
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getRowCount(String sheet) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IConstantsUtility.ExcelFilePath);
	   Workbook wb = WorkbookFactory.create(fis);
	   Sheet sh = wb.getSheet(sheet);
	   int rowCount=sh.getLastRowNum();
	   wb.close();
	    return rowCount;
	}
	
	/**
	 * This method will write the data int the excel sheet
	 * @param sheet
	 * @param row
	 * @param cel
	 * @param value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeDataIntoExcel1(String sheet,int row,int cel,String value) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IConstantsUtility.ExcelFilePath);
	  Workbook wb = WorkbookFactory.create(fis);
	  Row rw = wb.getSheet(sheet).getRow(row);
	   rw.createCell(cel).setCellValue(value);
		 
		 FileOutputStream fos=new FileOutputStream(IConstantsUtility.ExcelFilePath);
		 wb.write(fos);
		 System.out.println("data added");
		 wb.close();
	}
	
	}

	