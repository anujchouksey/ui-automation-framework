package browserfactory;

import org.openqa.selenium.WebDriver;

public class BrowserFactory {
 public static WebDriver createBrowser(BrowserType browser){
	switch (browser) {
	case CHROME:		
		return new ChromeBrowser().getBrowser();
	case FIREFOX:		
		return new FirefoxBrowser().getBrowser();		 	
	default:
		return null;
	}
	 
	
 }
}
