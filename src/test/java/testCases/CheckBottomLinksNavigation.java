package testCases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pageObject.CountryPage;
import pageObject.HomePage;
import testBase.BasePage;

public class CheckBottomLinksNavigation extends BasePage {

	@BeforeTest
	public void testDetails() {
		testName = "TC005_bottomMenuLinksNavigation";
		testDescription = "Checking the bottom links on the homepage of Best buy website";
		testAuthor = "Santosh Sonawane";
	}
	
	@Test
	public void TC005_bottomMenuLinksNavigation() throws IOException {
		CountryPage countryPage = new CountryPage();
		countryPage.selectCountry();
		HomePage homepage = new HomePage();
		homepage.checkBottomLinks();
		takeScreenshot("TC005_bottomMenuLinksNavigation");
		if(driver.getTitle().contains("California Supply Chain Transparency Act - Best Buy")) {
			test.log(Status.PASS, "Bottom menu links Navigation test passed");
		}
		else
			test.log(Status.FAIL, "Bottom menu links Navigation test failed");
	}
}
