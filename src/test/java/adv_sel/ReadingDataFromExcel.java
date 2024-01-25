package adv_sel;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadingDataFromExcel {

	public static void main(String[] args) throws Exception {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx"); 

		Workbook wb = WorkbookFactory.create(fis);
		
		int lastRow = wb.getSheet("Data").getLastRowNum();
		short lastCell = wb.getSheet("Data").getRow(0).getLastCellNum();
		
		for(int i=1;i<lastRow;i++) {
			for(int j=0;j<lastCell;j++) {
				String data = wb.getSheet("Data").getRow(i).getCell(j).getStringCellValue();
				System.out.print(data+" ");
				
			}
			System.out.println();
		}
		
	}

}
