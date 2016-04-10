package com.codewitme.journeytests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.LoginPage;
import pageobjects.WelcomePage;

public class RegressionTest extends Hooks{

	LoginPage loginPage;
	WelcomePage welcomePage;
	
	@Test
	public void VerifySuccessfullLogin(){
		String[]expectedPassengerList = {"1","2","3","4"};
		System.out.println("VerifySuccessfullLogin");
		loginPage = new LoginPage(driver);
		loginPage.setUsername(propReader.getInstance().getProperty("username"));
		loginPage.setPassword(propReader.getInstance().getProperty("password"));
		loginPage.clickSignIn();
		welcomePage=new WelcomePage(driver);
		String[] actualPassengerList=welcomePage.getPassengerList();
		Assert.assertEquals(actualPassengerList, expectedPassengerList);
		
	}
}
