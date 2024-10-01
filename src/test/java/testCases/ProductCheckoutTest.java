package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pageObject.CountryPage;
import pageObject.HomePage;
import pageObject.ShippingPage;
import testBase.BasePage;

public class ProductCheckoutTest extends BasePage {

	@BeforeTest
	public void testDetails() {
		testName = "TC009_productCheckout";
		testDescription = "Validating if a product could be added to cart and checkout the product for placing an order";
		testAuthor = "Santosh Sonawane";
	}
	
	@Test
	public void TC007_productCheckout() throws Exception {
		CountryPage countryPage = new CountryPage();
		countryPage.selectCountry();
		HomePage homepage = new HomePage();
		homepage.productCheckout();
		ShippingPage shippage = new ShippingPage();
		shippage.shippingDetails();
		Assert.assertEquals(shippage.cardinfo(), "Please enter a valid card number.");
		takeScreenshot("TC009_productCheckout");
		if(shippage.cardinfo().contains("Please enter a valid card number."))
				{
			test.log(Status.PASS, "Product checkout test passed");
				}
		else
			test.log(Status.FAIL, "Product checkout test failed");
	}
}
