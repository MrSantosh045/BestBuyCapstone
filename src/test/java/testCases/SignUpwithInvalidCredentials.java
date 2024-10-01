package testCases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.CountryPage;
import pageObject.SignUpPage;
import testBase.BasePage;

public class SignUpwithInvalidCredentials extends BasePage {

	@BeforeTest
	public void testDetails() {
		testName = "TC009_signUpInvalid";
		testDescription = "Validating the BestBuy signup page with invalid credentials";
		testAuthor = "Santosh Sonawane";
	}

	@Test
	public void TC009_signUpInvalid() throws IOException, InterruptedException {
		CountryPage countryPage = new CountryPage();
		countryPage.selectCountry();
		SignUpPage signUpPage = new SignUpPage();
		signUpPage.signUpInvalid();
		assert (signUpPage.signInerrortext().contains("Please enter your last name."));
		takeScreenshot("TC009_signUpInvalid");
		if(signUpPage.signInerrortext().contains("Please enter your last name.")) {
			test.pass("SignUp with invalid credentials test passed");
		}
		else
			test.fail("SignUp with invalid credentials test failed");
	}
}
