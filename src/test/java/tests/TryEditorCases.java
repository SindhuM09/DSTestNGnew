package tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;


import pageObject.LoginPageObject;
import pageObject.TryEditorPageObject;

import util.ExcelReader;

public class TryEditorCases {
	
	WebDriver driver = null;
	TryEditorPageObject pageEle = null;
	ExcelReader xcelRead = null;
	final String sheetName = "Sheet1";
	ArrayList<Object> dataList = null;
	ArrayList<Object> data = null;	
	
	public void setUpTryEditor(WebDriver driver) throws IOException {	
		
		pageEle = new TryEditorPageObject(driver);		
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
		xcelRead = new ExcelReader(System.getProperty("user.dir")+"\\TestData\\\\tryeditordata.xlsx");
		System.out.println("LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL"+ xcelRead);
	}	
	
	public void setTextAreaStatement(String SheetName, Integer rowNo) {
				
		dataList = xcelRead.getData(SheetName);
		System.out.println("JJJJJJJJJJJJJJJJJJJJJJJJJ"+dataList.size());
		
		data =  (ArrayList) dataList.get(rowNo);
		System.out.println("datadatadatadatadatadatadatadatadatadatadata"+data.size());
		
		
		String statement = (String) data.get(0);
		
		System.out.println("statementstatementstatementstatementstatementstatementstatement"+statement);
		
		
		pageEle.setTextAreaValue(statement);
		
	}

	

	
	public void clicksRunButton() {
		pageEle.clickRun();
	}

	
	public void executeTryEditor(WebDriver driver)
	{
		TryEditorCases tryEditor = new TryEditorCases();
		try {
			tryEditor.setUpTryEditor(driver);
			tryEditor.setTextAreaStatement("Sheet1", 0);
			tryEditor.clicksRunButton();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}
