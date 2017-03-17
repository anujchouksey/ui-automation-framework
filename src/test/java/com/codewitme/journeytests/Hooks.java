package com.codewitme.journeytests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.log4testng.Logger;

import com.codewitme.readers.ExcelReader;
import com.codewitme.readers.PropertiesReader;

import browserfactory.BrowserFactory;
import browserfactory.BrowserType;


public class Hooks {

	WebDriver driver;
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	PropertiesReader propReader;
	final static Logger logger=Logger.getLogger(Hooks.class);
	
	
	@BeforeMethod
	public void BeforeTest() throws IOException{
		//this.BeforeTestSuite();
		Boolean f = logger.isInfoEnabled();
		logger.info("Executing Before class");
		System.out.println("BeforeTest");
		String url=propReader.getInstance().getProperty("url");
		driver.get(url);
		
	}
	
	@BeforeClass
	public void BeforeTestSuite(){
		
		String browserChoice=System.getProperty("browser");
		if(browserChoice.equalsIgnoreCase("FIREFOX"))
		{
			driver = BrowserFactory.createBrowser(BrowserType.FIREFOX);
		}
		else if(browserChoice.equalsIgnoreCase("CHROME")){
			driver = BrowserFactory.createBrowser(BrowserType.CHROME);
		}
		this.setDriver(driver);
		
	}
	@AfterClass
	public void AfterTestSuite() throws IOException{
		System.out.println("AfterSuite");
		driver.close();
		driver.quit();
	}
	
	@AfterMethod
	public void AfterTest(){
		System.out.println("AfterTest");
		
		
	}
}
