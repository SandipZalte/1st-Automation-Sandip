package utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {
	public static String getdata(String name,int row,int cell) throws EncryptedDocumentException, IOException {
		FileInputStream file =new FileInputStream("F:\\TESTING\\AUTOMATION\\Excel Input Data\\Test Data.xlsx");
		String value= WorkbookFactory.create(file).getSheet(name).getRow(row).getCell(cell).getStringCellValue();
		return value;
	
	}

}
