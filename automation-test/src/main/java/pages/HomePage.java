package pages;

import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import driverPage.PageBase;

public class HomePage extends PageBase {

	@FindBy(xpath = ".//*[@type='submit']")
	WebElement submitButton;

	@FindBy(xpath = ".//*[@name='rooms']")
	private WebElement tabHead;

	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void verifyTitle() {
		String title = driver.getTitle();
		String expectedTitle = "Calculating Paint Amount";
		Assert.assertEquals(expectedTitle, title);
	}

	public void verifyURL() {
		String url = driver.getCurrentUrl();
		String expectedUrl = "http://127.0.0.1:5000/";
		Assert.assertEquals(expectedUrl, url);
	}

	public void verifyHeader1() {
		String header1 = driver.findElement(By.xpath(".//*[text()='Calculating Paint Required']")).getText();
		String expectedHeader = "Calculating Paint Required";
		Assert.assertEquals(expectedHeader, header1);
	}

	public void verifyHeader2() {
		String header2 = driver.findElement(By.xpath(".//*[text()='Enter the number of rooms']")).getText();
		String expectedText = "Enter the number of rooms";
		Assert.assertEquals(expectedText, header2);
	}

	public void verifyFooter1() {
		String verifyFooter1 = driver
				.findElement(By.xpath(".//*[text()='1 gallon of paint is required for every 400ft of surface.']"))
				.getText();
		String expectedText = "1 gallon of paint is required for every 400ft of surface.";
		Assert.assertEquals(expectedText, verifyFooter1);
	}

	public void verifyFooter2() {
		String verifyFooter2 = driver.findElement(By.xpath(".//footer/p[2]")).getText();
		String expectedText = "The surface area to paint is ((Length * 2) + (Width * 2)) * Height";
		Assert.assertEquals(expectedText, verifyFooter2);
	}

	public void verifyFooter3() {
		String verifyFooter3 = driver.findElement(By.xpath(".//footer/p[3]")).getText();
		String expectedText = "Gallons required will be rounded up.";
		Assert.assertEquals(expectedText, verifyFooter3);
	}

	public void pageSourceLength() {
		String pageSource = driver.getPageSource();
		int sourceLength = pageSource.length();
		System.out.println("Total length of the Pgae Source is : " + sourceLength);
	}

	public void verifySubmitButtonDisplay() {

		if (submitButton.isDisplayed() == true) {
			System.out.println("SUBMIT button displayed");
		} else {
			System.out.println("SUBMIT button did not display");
		}
	}

	public void verifySubmitButtonEnable() {

		if (submitButton.isEnabled() == true) {
			System.out.println("SUBMIT button is enabled");
		} else {
			System.out.println("SUBMIT button is disabled");
		}
	}

	public void entPosNum(String Num) {
		tabHead.sendKeys(Num);
		submitButton.click();
		String vNum = driver.findElement(By.xpath(".//*[@class='table']/tbody/tr[2]/td[1]")).getText();
		if (vNum.equals(Num)) {
			System.out.println("The number entered display correctly");
		} else {
			System.out.println("The number entered does not match");
		}
	}

	public void verifyBackButtonAndClearBox(String Num1, String Num2) {
		tabHead.sendKeys(Num1);
		tabHead.clear();
		tabHead.sendKeys(Num2);
		submitButton.click();
		String vNum = driver.findElement(By.xpath(".//*[@class='table']/tbody/tr[2]/td[1]")).getText();
		if (vNum.equals(Num2)) {
			System.out.println("The number entered display correctly");
		} else {
			System.out.println("The number entered does not match");
		}
		driver.navigate().back();
		String header2 = driver.findElement(By.xpath(".//*[text()='Enter the number of rooms']")).getText();
		String expectedText = "Enter the number of rooms";
		Assert.assertEquals(expectedText, header2);
	}

	public void verifyNumOfRows(String Num) {
		tabHead.sendKeys(Num);
		submitButton.click();
		List<WebElement> rows = driver.findElements(By.xpath(".//*[@class='table']/tbody/tr[position()>1]"));
		System.out.println("The number of rooms " + rows.size() + " match the table.");
	}

	public void verifyNegativeNum(String Num) {
		tabHead.sendKeys(Num);
		submitButton.click();
		if (tabHead.isDisplayed() == true) {
			System.out.println("Passed: negative numbers are Not acceptable");
		} else {
			System.out.println("Failed: negative numbers are acceptable");
		}
	}

	public void verifyZero(String Num) {
		tabHead.sendKeys(Num);
		submitButton.click();
		if (tabHead.isDisplayed() == true) {
			System.out.println("Passed: zero is NOT acceptable");
		} else {
			System.out.println("Failed: zero is acceptable");
		}
	}

	public void verifyEmptyValue(String Num) {
		tabHead.sendKeys(Num);
		submitButton.click();
		if (tabHead.isDisplayed() == true) {
			System.out.println("Passed: Entering empty value is NOT acceptable");
		} else {
			System.out.println("Failed: Entering empty value is acceptable");
		}
	}

	public void verifyOperations(String Oper) {
		tabHead.sendKeys(Oper);
		submitButton.click();
		if (tabHead.isDisplayed() == true) {
			System.out.println("Passed: addition and subtraction are NOT acceptable");
		} else {
			System.out.println("Failed: addition and subtraction are acceptable");
		}
	}

	public void verifyAlph(String Char) {
		tabHead.sendKeys(Char);
		submitButton.click();
		if (tabHead.isDisplayed() == true) {
			System.out.println("Passed: alphabet characters are NOT acceptable");
		} else {
			System.out.println("Failed: alphabet characters are acceptable");
		}
	}

	public void verifyTableHeaders(String Num) {
		tabHead.sendKeys(Num);
		submitButton.click();
		List<WebElement> headers = driver.findElements(By.xpath("//table/tbody//th"));
		String[] expectedheaders = { "Room Number", "Length", "Width", "Height" };
		String[] actualHeaders = new String[headers.size()];
		int count = 0;
		for (WebElement element : headers) {
			actualHeaders[count] = element.getText();
			count++;
		}
		Assert.assertArrayEquals(expectedheaders, actualHeaders);
	}

	public void verifyCalculation(String length, String width, String height) {

		tabHead.sendKeys("1");
		submitButton.click();
		WebElement lengthBox = driver.findElement(By.xpath("//table//td[2]/input"));
		WebElement widthBox = driver.findElement(By.xpath("//table//td[3]/input"));
		WebElement heightBox = driver.findElement(By.xpath("//table//td[4]/input"));
		lengthBox.sendKeys(length);
		widthBox.sendKeys(width);
		heightBox.sendKeys(height);
		submitButton.click();
		WebElement amountToFeetToPaint = driver.findElement(By.xpath("//tbody/tr[2]/td[2]"));
		String amount = amountToFeetToPaint.getText();
		double amountFromUI = Double.parseDouble(amount);
		double calculatedAmount = ((Double.parseDouble(length) * 2) + (Double.parseDouble(width) * 2))
				* Double.parseDouble(height);

		System.out.println("Amount from UI:  " + amount);
		System.out.println("Amount from calculation:  " + calculatedAmount);

		boolean same = (calculatedAmount == amountFromUI);
		Assert.assertTrue(same);
	}

	public void verifyGallonCalculation(String length, String width, String height) {

		tabHead.sendKeys("1");
		submitButton.click();
		WebElement lengthBox = driver.findElement(By.xpath("//table//td[2]/input"));
		WebElement widthBox = driver.findElement(By.xpath("//table//td[3]/input"));
		WebElement heightBox = driver.findElement(By.xpath("//table//td[4]/input"));
		lengthBox.sendKeys(length);
		widthBox.sendKeys(width);
		heightBox.sendKeys(height);
		submitButton.click();
		WebElement amountOfFeetToPaint = driver.findElement(By.xpath("//tbody/tr[2]/td[2]"));
		String amount = amountOfFeetToPaint.getText();
		String amountOfGallonToPaint = driver.findElement(By.xpath("//tbody/tr[2]/td[3]")).getText();

		double dAmount = Double.parseDouble(amount);
		System.out.println(dAmount);
		int gallonFound = Integer.parseInt(amountOfGallonToPaint);
		System.out.println(gallonFound);
		double gallonNeeded = dAmount / 400;
		System.out.println(gallonNeeded);
		int gallon = 0;
		if (gallonNeeded < 1) {
			gallon = 0;
			boolean same = (gallon == gallonFound);
			Assert.assertTrue(same);
		} else {
			gallon = (int) Math.round(gallonNeeded);
			boolean same = (gallon == gallonFound);
			Assert.assertTrue(same);
		}
	}

	public void verifyResultsTableHeaders(String length3, String width3, String height3) throws InterruptedException {
		tabHead.sendKeys("1");
		submitButton.click();
		Thread.sleep(1000);
		WebElement lengthBox = driver.findElement(By.xpath("//table//td[2]/input"));
		WebElement widthBox = driver.findElement(By.xpath("//table//td[3]/input"));
		WebElement heightBox = driver.findElement(By.xpath("//table//td[4]/input"));
		lengthBox.sendKeys(length3);
		widthBox.sendKeys(width3);
		heightBox.sendKeys(height3);
		submitButton.click();
		List<WebElement> headers = driver.findElements(By.xpath(".//*[@name='Results']/tbody//th"));
		String[] expectedheaders = { "Room #", "Amount of Feet to Paint", "Gallons Required" };
		String[] actualHeaders = new String[headers.size()];
		int count = 0;
		for (WebElement element : headers) {
			actualHeaders[count] = element.getText();
			count++;
		}
		Assert.assertArrayEquals(expectedheaders, actualHeaders);
	}

	public boolean verifyTotGallons(String length, String width, String height) {
		tabHead.sendKeys("1");
		submitButton.click();
		WebElement lengthBox = driver.findElement(By.xpath("//table//td[2]/input"));
		WebElement widthBox = driver.findElement(By.xpath("//table//td[3]/input"));
		WebElement heightBox = driver.findElement(By.xpath("//table//td[4]/input"));
		lengthBox.sendKeys(length);
		widthBox.sendKeys(width);
		heightBox.sendKeys(height);
		submitButton.click();
		String amountOfGallonToPaint = driver.findElement(By.xpath("//tbody/tr[2]/td[3]")).getText();
		String totalGallons = driver.findElement(By.xpath("//body/div/h5")).getText();
		System.out.println(totalGallons);
		return totalGallons.contains(amountOfGallonToPaint);
	}

	public void verifyHomeButtonEnable(String length, String width, String height) {
		tabHead.sendKeys("1");
		submitButton.click();
		WebElement lengthBox = driver.findElement(By.xpath("//table//td[2]/input"));
		WebElement widthBox = driver.findElement(By.xpath("//table//td[3]/input"));
		WebElement heightBox = driver.findElement(By.xpath("//table//td[4]/input"));
		lengthBox.sendKeys(length);
		widthBox.sendKeys(width);
		heightBox.sendKeys(height);
		submitButton.click();
		WebElement homeButton = driver.findElement(By.xpath("//form/input"));
		if (homeButton.isEnabled() == true) {
			System.out.println("HOME button is enabled");
		} else {
			System.out.println("HOME button is disabled");
		}
	}

	public void verifyHomeButton(String length, String width, String height) {
		tabHead.sendKeys("1");
		submitButton.click();
		WebElement lengthBox = driver.findElement(By.xpath("//table//td[2]/input"));
		WebElement widthBox = driver.findElement(By.xpath("//table//td[3]/input"));
		WebElement heightBox = driver.findElement(By.xpath("//table//td[4]/input"));
		lengthBox.sendKeys(length);
		widthBox.sendKeys(width);
		heightBox.sendKeys(height);
		submitButton.click();
		WebElement homeButton = driver.findElement(By.xpath("//form/input"));
		homeButton.click();
		String title = driver.getTitle();
		String expectedTitle = "Calculating Paint Amount";
		Assert.assertEquals(expectedTitle, title);
	}

	public boolean verifyGallonTotalSum(String length, String width, String height, String length1, String width1,
			String height1) {

		tabHead.sendKeys("2");
		submitButton.click();
		WebElement lengthBox = driver.findElement(By.xpath("//table//td[2]/input"));
		WebElement widthBox = driver.findElement(By.xpath("//table//td[3]/input"));
		WebElement heightBox = driver.findElement(By.xpath("//table//td[4]/input"));
		WebElement lengthBox1 = driver.findElement(By.xpath("//tbody/tr[3]/td[2]/input"));
		WebElement widthBox1 = driver.findElement(By.xpath("//tbody/tr[3]/td[3]/input"));
		WebElement heightBox1 = driver.findElement(By.xpath("//tbody/tr[3]/td[4]/input"));
		lengthBox.sendKeys(length);
		widthBox.sendKeys(width);
		heightBox.sendKeys(height);
		lengthBox1.sendKeys(length1);
		widthBox1.sendKeys(width1);
		heightBox1.sendKeys(height1);
		submitButton.click();
		String amountOfGallonToPaint1 = driver.findElement(By.xpath("//tbody/tr[2]/td[3]")).getText();
		String amountOfGallonToPaint2 = driver.findElement(By.xpath("//tbody/tr[3]/td[3]")).getText();
		String total = amountOfGallonToPaint1 + amountOfGallonToPaint2;
		String totalGallons = driver.findElement(By.xpath("//body/div/h5")).getText();
		System.out.println(totalGallons);
		return total.contains(totalGallons);
	}
}
