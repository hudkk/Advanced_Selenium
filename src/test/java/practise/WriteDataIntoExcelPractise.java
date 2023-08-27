package practise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcelPractise {

	public static void main(String[] args) throws IOException {
		//step 1:open the document in java readable format
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		//step 2:create a workbook
		Workbook wb=WorkbookFactory.create(fis);
		
		//step 3:get control of sheet
	    Sheet sh=wb.getSheet("Contacts");
		
		//step 4:get control of row
	      Row rw= sh.getRow(4);
		
		//step 5:Create a cell in that row
	    Cell ce=rw.createCell(8);
	    
	    //Step 6:Set the valuve to the cell
		ce.setCellValue("wasa");
		
		//step 7:open the document in write mode
		FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		//Step8: write the data
		wb.write(fos);
		System.out.println("data added");
	

	}

}
