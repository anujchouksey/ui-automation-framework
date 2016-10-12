package com.codewitme.journeytests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.log4testng.Logger;

import com.codewitme.readers.ExcelReader;
import com.codewitme.readers.PropertiesReader;


public class Hooks {

	WebDriver driver;
	PropertiesReader propReader;
	final static Logger logger=Logger.getLogger(Hooks.class);
	
	@BeforeClass
	public void BeforeThisClass(){
		Boolean f = logger.isInfoEnabled();
		logger.info("Executing Before class");
	}
	@BeforeMethod
	public void BeforeTest() throws IOException{
		String browserChoice=System.getProperty("browser");
		Boolean f = logger.isInfoEnabled();
		logger.info("Executing Before class");
		System.out.println("BeforeTest");
		String url=propReader.getInstance().getProperty("url");
		if(browserChoice.equalsIgnoreCase("FIREFOX"))
		{
			driver = new FirefoxDriver();
		}
		else if(browserChoice.equalsIgnoreCase("CHROME")){
			driver = new ChromeDriver();
		}
		driver.get(url);
		
	}
	
	@AfterMethod
	public void AfterTest(){
		System.out.println("AfterTest");
		driver.close();
		driver.quit();
		
	}
}
