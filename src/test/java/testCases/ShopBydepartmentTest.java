package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pageObject.CountryPage;
import pageObject.HomePage;
import testBase.BasePage;

public class ShopBydepartmentTest extends BasePage {

	@BeforeTest
	public void testDetails() {
		testName = "TC008_shopByDepartment";
		testDescription = "Validating if a product could be added to cart by selecting the Shop by department in the menu options";
		testAuthor = "Santosh Sonawaner";
	}
	
	@Test
	public void TC008_shopByDepartment() throws IOException {
		CountryPage countryPage = new CountryPage();
		countryPage.selectCountry();
		HomePage homepage = new HomePage();
		homepage.shopByDepartment();
		Assert.assertEquals(homepage.addedtocart(), "Added to cart");
		takeScreenshot("TC008_shopByDepartment");
		if(homepage.addedtocart().contains("Added to cart")){
			test.log(Status.PASS, "Shop By Department test passed");
		}
		else
			test.log(Status.FAIL, "Shop By Department test failed");
	}

}
