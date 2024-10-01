package testCases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pageObject.CountryPage;
import pageObject.SignUpPage;
import testBase.BasePage;

public class SignUpPageTest extends BasePage {

	@BeforeTest
	public void testDetails() {
		testName = "TC001_signUp";
		testDescription = "Validating the BestBuy signup page with valid credentials";
		testAuthor = "Santosh Sonawane";
	}
	
	@Test(priority = 1)
	public void TC001_signUp() throws IOException, InterruptedException {
		CountryPage countryPage = new CountryPage();
		countryPage.selectCountry();
		SignUpPage signUpPage = new SignUpPage();
		signUpPage.signUp();
		assert (signUpPage.signInText().contains("Hi"));
		takeScreenshot("TC001_signUp");
		if(signUpPage.signInText().contains("Hi")) {
			test.log(Status.PASS,"SignUp with valid details passed");
		}
		else
			test.log(Status.FAIL,"SignUp with valid details failed");
	}
}
