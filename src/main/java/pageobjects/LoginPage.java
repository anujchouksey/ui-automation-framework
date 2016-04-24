package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.codewitme.readers.PropertiesCache;
import com.codewitme.utilis.WebUtils;


public class LoginPage  {

	private WebDriver driver;
	private By username = By.name("userName");
	private By password = By.name("password");
	private By signin = By.name("login");
	
	
	public LoginPage(WebDriver driver){
		String url = driver.getCurrentUrl();
		if(!url.contains("newtours.demoaut.com"))
		{
			System.out.println("Failed:This is not the Login page");
		}
		this.driver=driver;
	}

	public LoginPage setUsername(String input){
		WebElement usernameElement = driver.findElement(username);
		usernameElement.sendKeys(input);
		return this;
	}
	
	public LoginPage setPassword(String input){
		WebElement passwordElement = driver.findElement(password);
		passwordElement.sendKeys(input);	
		return this;
	}

	public WelcomePage clickSignIn(){
		WebElement signinElement = driver.findElement(signin);
		WebUtils.click(new WebDriverWait(driver,Integer.parseInt(PropertiesCache.getInstance().getProperty("explicitTime"))), driver, signinElement);
		return new WelcomePage(driver);
	}
}
