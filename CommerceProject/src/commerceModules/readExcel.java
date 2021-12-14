package commerceModules;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class readExcel {

		
		public void readExcel() throws BiffException, IOException {
			String FilePath = "C:\\Users\\meenakshi.r\\Desktop\\testdata.xls";
			FileInputStream fs = new FileInputStream(FilePath);
			Workbook wb = Workbook.getWorkbook(fs);
			Sheet sh = wb.getSheet("Sheet1");
			int totalNoOfRows = sh.getRows();
			int totalNoOfCols = sh.getColumns();
			for (int row = 0; row < totalNoOfRows; row++) {

				for (int col = 0; col < totalNoOfCols; col++) {
					System.out.print(sh.getCell(col, row).getContents() + "\t");
				}
				System.out.println();
			}
		}
	

public static void main(String args[]) throws BiffException, IOException {
	readExcel DT = new readExcel();
	DT.readExcel();
}
}
	



