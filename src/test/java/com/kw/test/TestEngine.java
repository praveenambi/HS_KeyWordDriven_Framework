package com.kw.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.kw.base.BasePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class  TestEngine{
	
	public WebDriver driver;
	public Properties props;
	public BasePage  basepage;
	
	
	
	
	public void launchchrome(String browserName) {
		

		if (browserName=="chrome") {
			WebDriverManager.chromedriver().version("86").setup();
			basepage = new  BasePage();
			props = basepage.init_properties();
			if (props.getProperty("headless").equals("yes")) {
				
				ChromeOptions options  = new ChromeOptions();
				options.addArguments("--headless");
				driver = new ChromeDriver(options);
				
			}
			else {
				driver= new ChromeDriver();
				
			}
			
		}
		
		
	
		
	}

	public static void main(String[] args) {
		
		TestEngine testeng = new TestEngine();
		testeng.launchchrome("chrome");
		
	}

}
