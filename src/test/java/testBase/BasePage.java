package testBase;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import utility.Utils;

public class BasePage extends Utils {

	@BeforeSuite
	public void startReport() {
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		ExtentHtmlReporter reporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/target/result-" + timeStamp + ".html");
		reporter.setAppendExisting(false);
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}

	@BeforeClass
	public void detail() {
		test = extent.createTest(testName, testDescription);
		test.assignAuthor(testAuthor);
	}

	@BeforeMethod()
	public void setup() throws Exception {
		LaunchBrowser(readProperty("browser"));
		launch(readProperty("url"));

	}

	@AfterMethod()
	public void tearDown() {
		closeBrowser();
	}

	@AfterSuite
	public void endReport() {
		extent.flush();
	}
}
