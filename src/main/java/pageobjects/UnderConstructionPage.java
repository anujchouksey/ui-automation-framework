package pageobjects;

import org.openqa.selenium.WebDriver;

public class UnderConstructionPage {
	private WebDriver driver;

	public UnderConstructionPage(WebDriver driver) {
		String url = driver.getCurrentUrl();
		if(!url.endsWith("mercuryunderconst.php"))
		{
			this.driver=driver;
			System.out.println("Failed:This is not the Under construction page");
		}
	}
}
