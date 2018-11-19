package driverPage;

import org.openqa.selenium.WebDriver;

public class PageBase {

	protected WebDriver driver;

	public PageBase() {
	}

	public PageBase(WebDriver driver) {
		this.driver = driver;
	}

}
