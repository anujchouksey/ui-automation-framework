package pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class WelcomePage {

	private WebDriver driver=null;
	By passenger=By.name("passCount");
	
	public WelcomePage(WebDriver driver) {
		String url = driver.getCurrentUrl();
		if(!url.contains("mercuryreservation.php"))
		{
			System.out.println("Failed:This is not the Welcome page");
		}
		this.driver=driver;
	}
	
	public String[] getPassengerList(){
		List<String> al = new ArrayList<String>();
		List<WebElement>  elements=driver.findElement(passenger).findElements(By.tagName("option"));
		for(WebElement element:elements){
			al.add(element.getText().trim());
		}
		return al.toArray(new String[al.size()]);
	}


	
}
