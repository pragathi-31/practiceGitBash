package adv_sel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WritingDataIntoexcel {

	public static void main(String[] args) throws Exception {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx"); 
		
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet("sheet1").createRow(0).createCell(0).setCellValue("name");
		wb.getSheet("sheet1").getRow(0).createCell(1).setCellValue("department");
		//wb.getSheet("sheet1").createRow(0).createCell(2).setCellValue("salary");
		
		FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		wb.write(fos);
		wb.close();
		
		
	}

}
