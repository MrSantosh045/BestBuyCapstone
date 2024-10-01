package testCases;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import com.aventstack.extentreports.Status;

import pageObject.CountryPage;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.ShippingPage;
import pageObject.SignUpPage;
import testBase.BasePage;
import utility.Utils;

public class ProductAddtoCartTest extends BasePage {

	@BeforeTest
	public void testDetails() {
		testName = "TC006_addToCart";
		testDescription = "Validating if a product could be added to cart";
		testAuthor = "Santosh Sonawane";
	}
	
	@Test
	public void TC006_addToCart() throws IOException {
		CountryPage countryPage = new CountryPage();
		countryPage.selectCountry();
		HomePage homepage = new HomePage();
		homepage.searchProduct("iphone");
		Assert.assertEquals(homepage.addedtocart(), "Added to cart");
		takeScreenshot("TC006_addToCart");
		if(homepage.addedtocart().contains("Added to cart")){
			test.log(Status.PASS, "Product add to cart test passed");
		}
		else
			test.log(Status.FAIL, "Product add to cart test failed");
	}

}
