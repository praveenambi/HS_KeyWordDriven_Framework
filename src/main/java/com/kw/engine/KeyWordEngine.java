/**
 * 
 */
package com.kw.engine;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.kw.base.BasePage;

/**
 * @author PRAAMBI
 * 
 * This class contains all the requires methods and 
 * functions for driving the keywords and excel file reading
 *
 */
public class KeyWordEngine {

	public WebDriver driver ;
	public Properties props;
	public static Workbook wbook;
	public static org.apache.poi.ss.usermodel.Sheet sheet;
	public BasePage basepage;
	public WebElement webelement;
	public WebDriverWait explicitwait ;



	public final String scenario_sheet_path = "C:\\Users\\PRAAMBI\\eclipse-workspace\\KeywordDriven_HubSpot\\src\\main\\java\\com\\kw\\scenarios\\auto_scenarios.xlsx";


	public void startexecution(String sheetName) {
		FileInputStream xlfile = null;
		try {
			xlfile = new FileInputStream(scenario_sheet_path);
			wbook = WorkbookFactory.create(xlfile);
			sheet = wbook.getSheet(sheetName);


		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		int k=0;
		for (int i = 0; i < sheet.getLastRowNum(); i++) {

			try {
				String locatorType = sheet.getRow(i+1).getCell(k+1).toString().trim();
				String locatorValue = sheet.getRow(i+1).getCell(k+2).toString().trim();
				String action = sheet.getRow(i+1).getCell(k+3).toString().trim();
				String value = sheet.getRow(i+1).getCell(k+4).toString().trim();

				switch (action) {
				case "open browser":
					basepage = new  BasePage();
					props = basepage.init_properties();
					if (value.isEmpty()|| value.equals("NA")) {
						driver = basepage.init_driver(props.getProperty("browserName"));
					}else {
						driver = basepage.init_driver(value);
					}
					break;

				case "enter URL":
					if (value.isEmpty()|| value.equals("NA")) {
						driver.get(props.getProperty("URL"));
					}else {
						driver.get(value);
						driver.manage().window().maximize();
						Thread.sleep(9000);
					}
					break;

				case "quit":
					driver.quit();
					break;

				default:
					break;
				}


				switch (locatorType) {
				case "id":
					webelement = driver.findElement(By.id(locatorValue));
					if (action.equalsIgnoreCase("sendkeys")) {
						webelement.clear();
						webelement.sendKeys(value);
					}else if (action.equalsIgnoreCase("click")) {
						webelement.click();
					}else if (action.equalsIgnoreCase("isDisplayed")) {
						webelement.isDisplayed();
						
					}else if (action.equalsIgnoreCase("getText")) {
						String element_text = webelement.getText();
						System.out.println("The element text is  "+ element_text);
						
					}
					locatorType=null;
					break;
					
					
				case "name":
					webelement = driver.findElement(By.name(locatorValue));
					if (action.equalsIgnoreCase("sendkeys")) {
						webelement.clear();
						webelement.sendKeys(value);
					}else if (action.equalsIgnoreCase("click")) {
						webelement.click();
					}else if (action.equalsIgnoreCase("isDisplayed")) {
						webelement.isDisplayed();
						
					}else if (action.equalsIgnoreCase("getText")) {
						String element_text = webelement.getText();
						System.out.println("The element text is  "+ element_text);
					}
					locatorType=null;
					break;
					
				case "xpath":
					webelement = driver.findElement(By.xpath(locatorValue));
					if (action.equalsIgnoreCase("sendkeys")) {
						webelement.clear();
						webelement.sendKeys(value);
					}else if (action.equalsIgnoreCase("click")) {
						webelement.click();
					}else if (action.equalsIgnoreCase("isDisplayed")) {
						webelement.isDisplayed();
						
					}else if (action.equalsIgnoreCase("getText")) {
						String element_text = webelement.getText();
						System.out.println("The element text is  "+ element_text);
						
					}
					locatorType=null;
					break;


				case "linkText":
					webelement = driver.findElement(By.linkText(locatorValue));
					if (action.equalsIgnoreCase("sendkeys")) {
						webelement.clear();
						webelement.sendKeys(value);
					}else if (action.equalsIgnoreCase("click")) {
						webelement.click();
					}else if (action.equalsIgnoreCase("isDisplayed")) {
						webelement.isDisplayed();
						
					}else if (action.equalsIgnoreCase("getText")) {
						String element_text = webelement.getText();
						System.out.println("The element text is  "+ element_text);
						
					}
					locatorType=null;
					break;
					
				case "className":
					webelement = driver.findElement(By.className(locatorValue));
					if (action.equalsIgnoreCase("sendkeys")) {
						webelement.clear();
						webelement.sendKeys(value);
					}else if (action.equalsIgnoreCase("click")) {
						webelement.click();
					}else if (action.equalsIgnoreCase("isDisplayed")) {
						webelement.isDisplayed();
						
					}else if (action.equalsIgnoreCase("getText")) {
						String element_text = webelement.getText();
						System.out.println("The element text is  "+ element_text);
						
					}
					locatorType=null;
					break;
				
				case "cssSelector":
					webelement = driver.findElement(By.cssSelector(locatorValue));
					if (action.equalsIgnoreCase("sendkeys")) {
						webelement.clear();
						webelement.sendKeys(value);
					}else if (action.equalsIgnoreCase("click")) {
						webelement.click();
					}else if (action.equalsIgnoreCase("isDisplayed")) {
						webelement.isDisplayed();
						
					}else if (action.equalsIgnoreCase("getText")) {
						String element_text = webelement.getText();
						System.out.println("The element text is  "+ element_text);
						
					}
					locatorType=null;
					break;


				default:
					break;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}


		}








	}











}
