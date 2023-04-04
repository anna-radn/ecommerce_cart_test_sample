package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.asserts.SoftAssert;

public class CartPage extends BasePage {

	WebDriver driver;
	SoftAssert sa=new SoftAssert();

	public CartPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//title[contains(text(), 'WebstaurantStore Cart')]")
	WebElement CART_PAGE_TITLE;
	@FindBy(how = How.XPATH, using = "//button[@class='emptyCartButton btn btn-mini btn-ui pull-right']")
	WebElement EMPTY_CART_BUTTON_ELEMENT;
	@FindBy(how=How.XPATH, using="//button[@type='button']/parent::footer") WebElement CONFIRM_EMPTY_CART_BUTTON_ELEMENT;
	

	public void verifyPageTitle(String pageTitle) {
		String foundPageTitle=CART_PAGE_TITLE.getText();
		sa.assertEquals(foundPageTitle, pageTitle);
}
	public void emptyCart() {
		clickElement(EMPTY_CART_BUTTON_ELEMENT);
		waitForElementToBeClickable(driver, EMPTY_CART_BUTTON_ELEMENT);
	}
	public void confirmEmptyCart() {
		clickElement(CONFIRM_EMPTY_CART_BUTTON_ELEMENT);
		takeScreenshot(driver);
	}
}