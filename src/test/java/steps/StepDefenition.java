package steps;

import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.BasePage;
import pages.CartPage;
import pages.SearchPage;

public class StepDefenition extends BasePage {

	SearchPage sp;
	CartPage cp;

	@Before
	public void pre() {
		init();
		sp = PageFactory.initElements(driver, SearchPage.class);
		cp = PageFactory.initElements(driver, CartPage.class);
	}

	@Given("^Customer is on Webstaurant home page$")
	public void customer_is_on_Webstaurant_home_page() {

		driver.get("https://www.webstaurantstore.com/");
	}

	@Given("^Customer enters <\"([^\"]*)\"> into search box$")
	public void customer_enters_into_search_box(String arg1) {

		sp.enterTextIntoSearchBar("stainless work table");
	}

	@Given("^Customer clicks on <\"([^\"]*)\"> button$")
	public void customer_clicks_on_button(String arg1) {

		sp.clickOnSearchButton();
	}

	@Given("^Customer should verify that all found products contain the word <\"([^\"]*)\">$")
	public void customer_should_verify_that_all_found_products_contain_the_word(String arg1) {

		sp.verifySearchResult("Table");
	}

	@Then("^Customer should be able to add last found product to cart$")
	public void customer_should_be_able_to_add_last_found_product_to_cart() {

		sp.addLastFoundItemToCart();
	}

	@Then("^Customer verifies he lands on cart page$")
	public void customer_verifies_he_lands_on_cart_page() {

		cp.verifyPageTitle("WebstaurantStore Cart");
	}

	@Then("^Customer clicks on the <\"([^\"]*)\"> button$")
	public void customer_clicks_on_the_button(String arg1) {

		cp.emptyCart();
	}
	@Then("Customer confirms and clicks on <{string}> button")
	public void customer_confirms_and_clicks_on_button(String string) {
	    
	    cp.confirmEmptyCart();
	}
	@After
	public void tearDown() {

		driver.close();
		driver.quit();
	}

}
