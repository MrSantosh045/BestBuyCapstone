package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.BasePage;

public class CountryPage extends BasePage {

	public CountryPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='us-link']")
	public static WebElement country;

	public void selectCountry() {
		wait(country);
		country.click();
	}

}
