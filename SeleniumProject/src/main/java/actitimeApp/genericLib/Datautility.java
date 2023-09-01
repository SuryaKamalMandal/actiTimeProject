package actitimeApp.genericLib;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Datautility {
	
	public String getDataFromProperties(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream(iPathConstant.PropertyPath);
		Properties pp=new Properties();
		pp.load(fis);
		String value=pp.getProperty(key);
		return value;
	}
	
	public String getDataFromExcelSheet(String sheetname,int row,int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(iPathConstant.ExcelPath);
		Workbook book=WorkbookFactory.create(fis);
		Sheet s=book.getSheet(sheetname);
		DataFormatter format=new DataFormatter();
		String value=format.formatCellValue(s.getRow(row).getCell(cell));
		return value;
	}
}