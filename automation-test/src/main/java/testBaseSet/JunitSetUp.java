package testBaseSet;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import applicationController.ApplicationPage;
import driverPage.PageBase;

public class JunitSetUp extends PageBase {

	ApplicationPage applicationPage;

	@Before
	public void setUp() {
		String DriverPath = System.getProperty("user.dir");
		//String CHpath = DriverPath+"\\Drivers\\CH\\chromedriver_win.exe";
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

	@After
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
