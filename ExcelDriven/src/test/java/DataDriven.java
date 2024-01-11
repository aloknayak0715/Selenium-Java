import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.streaming.SXSSFRow.CellIterator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class DataDriven {

	// aftre you grab purchae test case row = pull all data of row and feed into test
	public ArrayList<String> getData(String testCaseName) throws IOException {
		// TODO Auto-generated method stub
		ArrayList<String> al = new ArrayList<String>();
		System.out.println(System.getProperty("user.dir")+"Data//Book1.xslx");
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//Data//Book1.xlsx");
//		FileInputStream fis = new FileInputStream("C:/Eclipse/Book1.xlsx"); working
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int sheet = workbook.getNumberOfSheets();
		
		for(int i=0;i<sheet;i++) {
			if(workbook.getSheetName(i).equalsIgnoreCase("Sheet1")) {
				XSSFSheet fsheet = workbook.getSheetAt(i);
				//Identify testcases column by scanning entire 1st row
				Iterator<Row> rows = fsheet.iterator(); // sheet is collection of row
				Row firstRow = rows.next();
				Iterator<Cell> cell = firstRow.cellIterator(); // row is collection of cells
				int k =0;
				int column =0;
				
				while(cell.hasNext()) {
					Cell value = cell.next();
					if(value.getStringCellValue().equalsIgnoreCase("Testcases")) {
						column = k;
					}
					k++;
				}
				System.out.println("Column: "+column);
				
				//Once column identify then scan entire test column to identiy purchase order testcase row
				while(rows.hasNext()) {
					Row row = rows.next();
					if(row.getCell(column).getStringCellValue().equalsIgnoreCase(testCaseName)) {
						Iterator<Cell> ce = row.cellIterator();
						while(ce.hasNext()) {
							System.out.println(ce.next().getStringCellValue());
							Cell c = ce.next();
							if(c.getCellTypeEnum() == CellType.STRING) {
								
								al.add(c.getStringCellValue());	
							}
							else {
							 String text =	NumberToTextConverter.toText(c.getNumericCellValue());
								al.add(text);
								
							}
						}
					}
				}
				
			}
		}
		return al;
	}

	
}
