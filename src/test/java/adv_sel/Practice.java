package adv_sel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Practice {
	public static void main(String[] args) throws Exception   {
		
		ArrayList<String> al=new ArrayList<String>();
		al.add("hi");
		al.add("ssup");
		al.add("apple");
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		
		wb.getSheet("Data2").createRow(12).createCell(0).setCellValue("");;
		
		for(int i=0;i<al.size();i++) {
			String data = al.get(i);
			
			wb.getSheet("Data2").getRow(12).createCell(i+1).setCellValue(data);
		}
		
		
		FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		wb.write(fos);
		wb.close();
	}
}
