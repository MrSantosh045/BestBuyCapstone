package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import testBase.BasePage;

public class HomePage extends BasePage {

	public HomePage() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@class='search-input']")
	private WebElement searchBar;

	@FindBy(xpath = "//a[text()='Top Deals']")
	private WebElement topDeallink;

	@FindBy(xpath = "//a[contains(text(),'Deal of the Day')]")
	private WebElement dealofthedaylink;

	@FindBy(linkText = "Yes, Best Buy Sells That")
	private WebElement bestbuysellslink;

	@FindBy(xpath = "//li//a[contains(@data-lid,'hdr_my_best_buy_memberships')]")
	private WebElement membershipsLink;

	@FindBy(linkText = "Apple - Pre-Owned iPhone 13 Pro Max 5G 128GB (Unlocked) - Graphite")
	private WebElement product;

	@FindBy(xpath = "//button[@data-button-state='ADD_TO_CART']")
	private WebElement addtocart;

	@FindBy(xpath = "(//button[@data-button-state='ADD_TO_CART'])[4]")
	private WebElement addtocartBtn;

	@FindBy(xpath = "//button[@title='submit search']")
	private WebElement searchButton;

	@FindBy(xpath = "//span[@class='added-to-cart']")
	private WebElement addedtocart;

	@FindBy(xpath = "//button[@data-t='hamburger-navigation-button']")
	private WebElement menuButton;

	@FindBy(xpath = "//button[contains(text(),'TV & Home Theater')]")
	private WebElement tvMenu;

	@FindBy(xpath = "//a[text()='Sony TVs']")
	private WebElement sonyBrand;

	@FindBy(xpath = "//button[contains(text(),'TVs by Brand')]")
	private WebElement tvBrand;

	@FindBy(xpath = "//a[text()='Sony - 65\" class BRAVIA XR A75L OLED 4K UHD Smart Google TV']")
	private WebElement tvModel;

	@FindBy(xpath = "//button[contains(text(),'Brands')]")
	private WebElement brands;

	@FindBy(xpath = "//a[text()='HP']")
	private WebElement hpBrand;

	@FindBy(xpath = "//a[starts-with(text(),'HP monitors')]")
	private WebElement hpMonitors;

	@FindBy(linkText = "HP - 21.5\" IPS LED Full HD FreeSync Monitor (HDMI, VGA) - Silver & Black")
	private WebElement monitorModel;

	@FindBy(xpath = "//a[text()='Apple - AirPods with Charging Case (2nd generation) - White']")
	private WebElement productName;

	@FindBy(linkText = "Go to cart")
	private WebElement gotocart;

	@FindBy(xpath = "//button[contains(text(),'Checkout')]")
	private WebElement checkoutButton;

	@FindBy(xpath = "//button[text()='Continue as Guest']")
	private WebElement continueAsGuest;

	@FindBy(xpath = "//button[contains(text(),'Switch to shipping')]")
	private WebElement switchtoShipping;

	@FindBy(linkText = "Accessibility")
	private WebElement accessibilityLink;

	@FindBy(linkText = "Terms & Conditions")
	private WebElement termsLink;

	@FindBy(linkText = "Health Data Privacy")
	private WebElement dataPrivacyLink;

	@FindBy(linkText = "CA Supply Chain Transparency Act")
	private WebElement supplyChainLink;

	public void topDealMenuClick() {
		wait(topDeallink);
		topDeallink.click();

	}

	public void dealOfTheDayMenuClick() {
		dealofthedaylink.click();
	}

	public void bestbuysellsMenuClick() {
		bestbuysellslink.click();
	}

	public void membershipsMenuClick() {
		membershipsLink.click();
	}

	public void addtocart() {
		addtocart.click();
	}

	public void checkBottomLinks() {
		scrollToElement(accessibilityLink);
		accessibilityLink.click();
		Assert.assertEquals(driver.getTitle(), "Accessibility - Best Buy");
		scrollToElement(termsLink);
		termsLink.click();
		Assert.assertEquals(driver.getTitle(), "BestBuy.com Terms and Conditions");
		scrollToElement(dataPrivacyLink);
		dataPrivacyLink.click();
		Assert.assertEquals(driver.getTitle(), "Health Data Privacy Information - Best Buy");
		scrollToElement(supplyChainLink);
		supplyChainLink.click();
		Assert.assertEquals(driver.getTitle(), "California Supply Chain Transparency Act - Best Buy");
	}

	public void searchProduct(String productName) {
		searchBar.sendKeys(productName);
		searchButton.click();
		product.click();
		scroll();
		wait(addtocart);
		addtocart();
		elementvisiblitywait(addedtocart);
	}

	public void menuLinksNavigation() {
		topDealMenuClick();
		Assert.assertEquals(driver.getTitle(), "Top Deals and Featured Offers on Electronics - Best Buy");
		dealOfTheDayMenuClick();
		Assert.assertEquals(driver.getTitle(), "Deal of the Day: Electronics Deals - Best Buy");
		bestbuysellsMenuClick();
		Assert.assertEquals(driver.getTitle(), "Yes, Best Buy Sells That – Best Buy");
		membershipsMenuClick();
		Assert.assertEquals(driver.getTitle(), "My Best Buy Memberships");
	}

	public String addedtocart() {
		wait(addedtocart);
		return addedtocart.getText();
	}

	public void shopByBrand() {
		wait(menuButton);
		menuButton.click();
		tvMenu.click();
		tvBrand.click();
		sonyBrand.click();
		scroll();
		tvModel.click();
		scrollToElement(addtocart);
		wait(addtocart);
		addtocart.click();
		elementvisiblitywait(addedtocart);
	}

	public void shopByDepartment() {
		Actions action = new Actions(driver);
		action.moveToElement(menuButton).click().build().perform();
		wait(brands);
		brands.click();
		Actions action1 = new Actions(driver);
		action1.scrollToElement(hpBrand).build().perform();
		hpBrand.click();
		scroll();
		hpMonitors.click();
		scroll();
		monitorModel.click();
		scroll();
		wait(addtocart);
		addtocart.click();
		elementvisiblitywait(addedtocart);

	}

	public void productCheckout() throws InterruptedException {

		searchBar.sendKeys("iphone");
		searchButton.click();
		productName.click();
		scroll();
		scroll();
		addtocartBtn.click();
		gotocart.click();
		checkoutButton.click();
		wait(continueAsGuest);
		continueAsGuest.click();
		Thread.sleep(5000);
	}
}
