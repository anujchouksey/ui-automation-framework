package com.codewitme.journeytests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.codewitme.readers.PropertiesCache;


public class Hooks {

	WebDriver driver;
	PropertiesCache propReader;
	
	@BeforeClass
	public void BeforeThisClass(){
		System.out.println("BeforeClass");
		
		
	}
	@BeforeMethod
	public void BeforeTest() throws IOException{
		String browser="chrome";
		System.out.println("BeforeTest");
		String url=propReader.getInstance().getProperty("url");
		if(browser.equalsIgnoreCase("FIREFOX"))
		{
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("CHROME")){
			System.setProperty("webdriver.chrome.driver", "K:\\downloads\\chromedriver_win32\\chromedriver.exe");
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
