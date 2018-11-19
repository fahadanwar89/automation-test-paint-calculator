package applicationController;

import org.openqa.selenium.WebDriver;

import driverPage.PageBase;
import pages.HomePage;

public class ApplicationPage extends PageBase {

	private HomePage homePage;

	public ApplicationPage(WebDriver driver) {
		super(driver);

	}

	public HomePage getHomePage() {
		if (homePage == null) {
			homePage = new HomePage(driver);
		}
		return homePage;
	}
}
