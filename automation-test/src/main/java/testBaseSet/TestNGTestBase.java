package testBaseSet;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import applicationController.ApplicationPage;
import driverPage.PageBase;
import java.util.concurrent.TimeUnit;

public class TestNGTestBase extends PageBase {

	ApplicationPage applicationPage;

	@BeforeMethod
	public void setUp() {
		String DriverPath = System.getProperty("user.dir");
		// String CHpath = DriverPath+"\\Drivers\\CH\\chromedriver_win.exe";
		String CHpath = DriverPath + "//Drivers/chromedriver_mac";
		System.setProperty("webdriver.chrome.driver", CHpath);
		driver = new ChromeDriver();
		driver.navigate().to("http://127.0.0.1:5000/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	public static String getChromeDriverPath() {
		String OS = System.getProperty("os.name");

		if (OS.contains("Mac")) {
			return "Drivers/chromedriver_mac";
		} else {
			return "Drivers/chromedriver_win";
		}
	}

	public ApplicationPage getApplicationPage() {
		if (applicationPage == null) {
			applicationPage = new ApplicationPage(driver);
		}
		return applicationPage;
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.close();
			driver.quit();
		}
		if (applicationPage != null) {
			applicationPage = null;
		}
	}

}
