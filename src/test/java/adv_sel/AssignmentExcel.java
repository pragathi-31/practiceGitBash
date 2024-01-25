package adv_sel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class AssignmentExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx"); 

		Workbook wb = WorkbookFactory.create(fis);
		
		int lastRow = wb.getSheet("Data2").getLastRowNum();
		short lastCell = wb.getSheet("Data2").getRow(0).getLastCellNum();
		Sheet sh = wb.getSheet("one");
		
		
		String brand_name="Nokia";
		
		for(int i=1;i<lastRow;i++) {
			for(int j=0;j<lastCell;j++) {
				String name = wb.getSheet("Data2").getRow(i).getCell(j).getStringCellValue();
				if(name.contains(brand_name)) {
					String price = wb.getSheet("Data2").getRow(i).getCell(j+1).getStringCellValue();
					System.out.println("Price of the brand: "+price);
					break;
				}
			}
		}
	}

}
