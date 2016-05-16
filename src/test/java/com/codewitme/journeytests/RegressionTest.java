package com.codewitme.journeytests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.codewitme.readers.ExcelReader;

import pageobjects.LoginPage;
import pageobjects.WelcomePage;

public class RegressionTest extends Hooks{

	LoginPage loginPage;
	WelcomePage welcomePage;
	@Test(enabled=false)
	public void VerifySuccessfullDefaultLogin() throws IOException{	
		String[]expectedPassengerList = {"1","2","3","5"};
		System.out.println("VerifySuccessfullLogin");
		loginPage = new LoginPage(driver);
		loginPage.setUsername(propReader.getInstance().getProperty("username"));
		loginPage.setPassword(propReader.getInstance().getProperty("password"));
		loginPage.clickSignIn();
		welcomePage=new WelcomePage(driver);
		String[] actualPassengerList=welcomePage.getPassengerList();
		Assert.assertEquals(actualPassengerList, expectedPassengerList);
		
	}
	@Test(dataProvider="custLogin",enabled=true)
	public void VerifySuccessfullMultipleLogin(String userName,String password) throws IOException{	
		String[]expectedPassengerList = {"1","2","3","4"};
		System.out.println("VerifySuccessfullLogin");
		loginPage = new LoginPage(driver);
		loginPage.setUsername(userName);
		loginPage.setPassword(password);
		loginPage.clickSignIn();
		welcomePage=new WelcomePage(driver);
		String[] actualPassengerList=welcomePage.getPassengerList();
		Assert.assertEquals(actualPassengerList, expectedPassengerList);
		
	}
	@Test(dataProvider="allLinks",enabled=false)
	public void VerifySuccessfullLinkClick(String text) throws IOException{	
		driver.findElement(By.linkText(text)).click();
		
	}
	@DataProvider(name="custLogin")
	public Object[][] loginData() throws IOException {
		ExcelReader readr=new ExcelReader();
		Object[][] arrayObject = readr.getData("LoginTest");
		return arrayObject;
	}
	
	@DataProvider(name="allLinks")
	public Object[][] allLinks1() throws IOException {
		BeforeTest();
		List<WebElement> list=driver.findElements(By.tagName("a"));
		int rows=list.size();
		String[][] linkArray=new String[rows][1];
		for(int i=0;i<rows;i++){
			linkArray[i][0]=list.get(i).getText();
		}
		AfterTest();
		return linkArray;
	}
}
