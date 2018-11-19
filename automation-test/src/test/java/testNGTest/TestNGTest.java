package testNGTest;

import org.testng.annotations.Test;
import testBaseSet.TestNGTestBase;

public class TestNGTest extends TestNGTestBase {

	@Test
	public void verifyTitle() {
		getApplicationPage().getHomePage().verifyTitle();
	}

	@Test
	public void verifyUrl() {
		getApplicationPage().getHomePage().verifyURL();
	}

	@Test
	public void getPageSourceLength() {
		getApplicationPage().getHomePage().pageSourceLength();
	}

	@Test
	public void verifyHeader1() {
		getApplicationPage().getHomePage().verifyHeader1();
	}

	@Test
	public void verifyHeader2() {
		getApplicationPage().getHomePage().verifyHeader2();
	}

	@Test
	public void verifyFooter1() {
		getApplicationPage().getHomePage().verifyFooter1();
	}

	@Test
	public void verifyFooter2() {
		getApplicationPage().getHomePage().verifyFooter2();
	}

	@Test
	public void verifyFooter3() {
		getApplicationPage().getHomePage().verifyFooter3();
	}

	@Test
	public void verifySubmitButtonDisplay() {
		getApplicationPage().getHomePage().verifySubmitButtonDisplay();
	}

	@Test
	public void verifySubmitButtonEnable() {
		getApplicationPage().getHomePage().verifySubmitButtonEnable();
	}

	@Test
	public void verifyTableHeaders() {
		getApplicationPage().getHomePage().verifyTableHeaders("1");
	}

	@Test
	public void enterPositiveNumber() {
		getApplicationPage().getHomePage().entPosNum("1");
	}

	@Test
	public void verifyBackButtonAndClearBox() {
		getApplicationPage().getHomePage().verifyBackButtonAndClearBox("123456789", "1");
	}

	@Test
	public void verifyMultipleNumOfRows() {
		getApplicationPage().getHomePage().verifyNumOfRows("122");
	}

	@Test
	public void verifyNegativeNum() {
		getApplicationPage().getHomePage().verifyNegativeNum("-9-1");
	}

	@Test
	public void verifyZero() {
		getApplicationPage().getHomePage().verifyZero("0");
	}

	@Test
	public void verifyEmptyValue() {
		getApplicationPage().getHomePage().verifyEmptyValue("");
	}

	@Test
	public void verifyOperations() {
		getApplicationPage().getHomePage().verifyOperations("-+");
	}

	@Test
	public void verifyAlph() {
		getApplicationPage().getHomePage().verifyAlph("eee");
	}

	@Test
	public void verifyResultsTableHeaders() throws InterruptedException {
		getApplicationPage().getHomePage().verifyResultsTableHeaders("12", "20", "8");
	}

	// Fails
	@Test
	public void verifyCalculation() {
		getApplicationPage().getHomePage().verifyCalculation("20", "12", "5");
	}

	@Test
	public void verifyGallonCalculation() {
		getApplicationPage().getHomePage().verifyGallonCalculation("8", "6", "5");
	}

	@Test
	public void verifyTotGallons() {
		getApplicationPage().getHomePage().verifyTotGallons("11", "22", "33");
	}

	@Test
	public void verifyHomeButtonEnable() {
		getApplicationPage().getHomePage().verifyHomeButtonEnable("1", "2", "3");
	}

	@Test
	public void verifyHomeButton() {
		getApplicationPage().getHomePage().verifyHomeButton("1", "2", "3");
	}

	@Test
	public void verifyGallonTotalSum() {
		getApplicationPage().getHomePage().verifyGallonTotalSum("11", "22", "33", "11", "22", "33");
	}

}
