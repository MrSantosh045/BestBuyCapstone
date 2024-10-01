package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pageObject.CountryPage;
import pageObject.LoginPage;

public class LoginPageTest extends LoginPage {

	@BeforeTest
	public void testDetails() {
		testName = "TC002_accountLogin";
		testDescription = "Validating the login page of Best buy with valid credentials";
		testAuthor = "Santosh Sonawane";
	}
	
	
	@Test 
	public void TC002_accountLogin() throws Exception {
		CountryPage countryPage = new CountryPage();
		countryPage.selectCountry();
		LoginPage loginpage = new LoginPage();
		loginpage.login();
		Assert.assertEquals(loginpage.signinText(), "Hi Nandhitha");
		takeScreenshot("TC002_accountLogin");
		if(loginpage.signinText().contains("Hi")) {
			test.log(Status.PASS, "Account login with valid credentials test passed");
		}
		else
			test.log(Status.FAIL,  "Account login with valid credentials test failed");
	}
}
