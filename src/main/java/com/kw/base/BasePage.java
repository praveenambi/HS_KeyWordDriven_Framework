/**
 * 
 */
package com.kw.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author PRAAMBI
 * This is the Base class where ,
 * the driver intialise and configuration properties are defines
 */
public class BasePage {

	public WebDriver driver;
	public Properties props;


	public WebDriver  init_driver(String  browserName) {

		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().version("86").setup();
			if (props.getProperty("headless").equals("yes")) {
				ChromeOptions options  = new ChromeOptions();
				options.addArguments("--headless");
				driver = new ChromeDriver(options);

			}
			else {
				driver= new ChromeDriver();

			}

		}

		if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		return driver;

	}

	public Properties init_properties() {

		props = new Properties();
		FileInputStream file;
		try {

			file = new FileInputStream("C:\\Users\\PRAAMBI\\eclipse-workspace\\KeywordDriven_HubSpot\\src\\main\\java\\com\\kw\\config\\config.properties");
			try {
				props.load(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return props;


	}


}
