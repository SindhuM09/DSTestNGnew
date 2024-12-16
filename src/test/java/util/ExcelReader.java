package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	XSSFWorkbook workbook = null;
	Logger logg = (Logger) LogManager.getLogger(ExcelReader.class);
	
	public ExcelReader()
	{
		
	}
	
	
	public ExcelReader(String path) 
	{
		try
		{
			FileInputStream inputStream = new FileInputStream(path);		
			 workbook = new XSSFWorkbook(inputStream);
		}catch(Exception e)
		{
			logg.error(e.getMessage());
		}
		
		
	}
		
	public ArrayList<Object> getData(String sheetName)
	{
		ArrayList<Object> valuePairs = new ArrayList<Object>();
		
				
		XSSFSheet sheet = workbook.getSheet(sheetName);
		XSSFRow firstRow = sheet.getRow(0);
					
		int noOfRows = sheet.getLastRowNum();
		int noofCols = firstRow.getLastCellNum();
				
		for(int i=0;i<=noOfRows;i++)
		{
			
			XSSFRow row  = sheet.getRow(i);
			ArrayList<Object> a = new ArrayList<Object>();			
			for(int j=0;j<noofCols;j++)
			{			
				
				String value = row.getCell(j).getStringCellValue();
				a.add(value);				
				
			}				
			valuePairs.add(a);
		}
		
		return valuePairs;
	}
	
	
	
	public String[] getUserPassword(String sheetName, int rowNum)
	{
		String value[]= new String[2];
		ArrayList dataList = getData(sheetName);
		System.out.println("dataListdataListdataListdataListdataListdataListdataList"+dataList.size());
		ArrayList data = (ArrayList<Object>) dataList.get(rowNum);
		System.out.println("datadatadatadatadatadatadatadatadata"+data.size());
		String username = (String) data.get(0);
		System.out.println("usernameusernameusernameusername"+username);
		String password = (String) data.get(1);
		System.out.println("passwordpasswordpasswordpassword"+password);
		value[0] = username;
		value[1] = password;
		
		return value;
	}
	
	
	public String getProperty(String key)
	{String prop = null;
		
		try {
			FileReader fr = new FileReader(System.getProperty("user.dir")+"\\src\\test\\java\\util\\\\config.properties");
			Properties p = new Properties();
			p.load(fr);
			prop = p.getProperty(key);
			System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXx"+prop);
		} catch (FileNotFoundException e) {
			
			logg.error(e.getMessage());
		} catch (IOException e) {
			
			logg.error(e.getMessage());
		}
		return prop;
	}
	
	public void workbookClose() throws IOException
	{
		workbook.close();		
	}
	
	
}


