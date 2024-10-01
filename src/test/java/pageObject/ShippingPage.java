package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import testBase.BasePage;

public class ShippingPage extends BasePage {

	@FindBy(xpath = "//input[@id='first-name']")
	private WebElement firstName;

	@FindBy(xpath = "//input[@id='last-name']")
	private WebElement lastName;

	@FindBy(xpath = "//input[@id='address-input']")
	private WebElement address;

	@FindBy(xpath = "//input[@id='city']")
	private WebElement city;

	@FindBy(xpath = "//select[@id='state']")
	private WebElement state;

	@FindBy(xpath = "//input[@id='postalCode']")
	private WebElement zipcode;

	@FindBy(xpath = "//input[@id='user.emailAddress']")
	private WebElement email;

	@FindBy(xpath = "//input[@id='user.phone']")
	private WebElement phone;

	@FindBy(xpath = "//section[@class='contact-information']")
	private WebElement contactInfoSection;

	@FindBy(xpath = "//button[contains(.,'Continue to Payment Information')]")
	private WebElement continuetopayment;

	@FindBy(xpath = "//input[@name='phone']")
	private WebElement cardNumber;

	@FindBy(xpath = "//img[@alt='Mastercard']")
	private WebElement cardselection;

	@FindBy(xpath = "//button[@data-track='Place your Order - Contact Card']")
	private WebElement placeOrder;

	@FindBy(xpath = "//p[contains(text(),'Please enter a valid card number.')]")
	private WebElement verifycard;

	public ShippingPage() {
		PageFactory.initElements(driver, this);
	}

	public void shippingDetails() throws Exception {

		scroll();
		scroll();
		email.sendKeys("nandhitha1996@gmail.com");
		phone.sendKeys("9045677890");
		scrollToElement(continuetopayment);
		continuetopayment.click();
		Thread.sleep(3000);
		cardNumber.sendKeys("1223 6116 9009 3445");

		firstName.sendKeys("Nandhitha");
		lastName.sendKeys("Vijaykumar");
		address.sendKeys("3a17 add 99087");
		city.sendKeys("APO");
		Select stateValue = new Select(state);
		stateValue.selectByValue("AP");
		zipcode.sendKeys("60098");
		scrollToElement(placeOrder);

		placeOrder.click();

	}



	public String cardinfo() {
		return verifycard.getText();
	}
}
