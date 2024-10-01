package testCases;

import java.net.HttpURLConnection;
import java.net.URL;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import testBase.BasePage;

public class CheckBrokenUrlTest extends BasePage {

	@BeforeTest
	public void testDetails() {
		testName = "TC003_checkBrokenUrl";
		testDescription = "Checking if the BestBuy website url is broken or not";
		testAuthor = "Santosh Sonawane";
	}
	
	@Test
	public void TC003_checkBrokenUrl() throws Exception {
		String url = readProperty("url");
		
			URL link = new URL(url);
			HttpURLConnection httpURLConnection = (HttpURLConnection) link.openConnection();
			httpURLConnection.setConnectTimeout(3000); // Set connection timeout to 3 seconds
			httpURLConnection.connect();

			if (httpURLConnection.getResponseCode() == 200) {
				System.out.println(url + " - " + httpURLConnection.getResponseMessage());
			} else {
				System.out.println(url + " - " + httpURLConnection.getResponseMessage() + " - " + "is a broken link");
			}
		takeScreenshot("TC003_checkBrokenUrl");
		if (httpURLConnection.getResponseCode() == 200) {
			test.log(Status.PASS,"Checking broken url test passed");
		}
		else
			test.log(Status.FAIL,"Checking broken url test failed");
	}
}
