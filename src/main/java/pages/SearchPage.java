package pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SearchPage extends BasePage {

	WebDriver driver;

	public SearchPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//input[@id='searchval']")
	WebElement SEARCH_BAR_ELEMENT;
	@FindBy(how = How.XPATH, using = "//button[@value='Search']")
	WebElement SEARCH_BUTTON_ELEMENT;
	@FindBy(how = How.XPATH, using = "//h1[@class='page-header search--title']")
	WebElement SEARCH_RESULT_ELEMENT;
	@FindBy(how = How.XPATH, using = "//li[@class='inline-block leading-4 align-top rounded-r-md']/ancestor::nav")
	WebElement NEXT_PAGE_BUTTON_ELEMENT;
	//@FindBy(how = How.XPATH, using = "(//*[@class='btn btn-cart btn-small'])[58]")
	//WebElement ADD_TO_CART_BUTTON_ELEMENT;
	@FindBy(how = How.XPATH, using = "//button[@type='submit'][contains(text(), 'Add To Cart')]")
	WebElement ADD_TO_CART_CONFIRM_BUTTON_ELEMENT;
	@FindBy(how = How.XPATH, using = "//div/child::a[@class='btn btn-small btn-primary']")
	WebElement VIEW_CART_BUTTON_ELEMENT;
	@FindBy(how=How.XPATH, using="(//*[@id='ProductBoxContainer'])[60]") WebElement LAST_FOUND_PRODUCT_ELEMENT;

	public void enterTextIntoSearchBar(String text) {
		enterInput(SEARCH_BAR_ELEMENT, text);
	}

	public void clickOnSearchButton() {
		clickElement(SEARCH_BUTTON_ELEMENT);
	}

	public void verifySearchResult(String searchedItem) {

		String result = SEARCH_RESULT_ELEMENT.getText();
		System.out.println(result);
		
		//creating list of all products from each page
		List<WebElement> productList = driver.findElements(By.xpath("//a[@data-testid='itemDescription']"));
		
		//creating list of products' names so only those that contain searched item will be added to list
		List<String> names = new ArrayList<String>();
		for (WebElement productNames : productList) {
			if (productNames.getText().contains(searchedItem)) {
				names.add(productNames.getText());
			}
		}
		//looping through pages. total number of pages returned=9
		for (int i = 1; i < 9; i++) {
			
			clickElement(NEXT_PAGE_BUTTON_ELEMENT);
			waitForElementToBeClickable(driver, NEXT_PAGE_BUTTON_ELEMENT);
			
			productList = driver.findElements(By.xpath("//a[@data-testid='itemDescription']"));
			
			if(i==8) {
			for (int retry = 0; retry < 3; i++) {
				try {
					driver.findElements(By.xpath("//a[@data-testid='itemDescription']"));
				break;
				} catch (StaleElementReferenceException e) {
					System.out.println(e.toString());
				}
			}
				for (WebElement productNames : productList) {
					if (productNames.getText().contains(searchedItem)) {
						names.add(productNames.getText());
					}
				}
				NEXT_PAGE_BUTTON_ELEMENT.click();//clicking next button after each page 
				waitForElementToBeClickable( driver, NEXT_PAGE_BUTTON_ELEMENT);
				}
			}

			for (String name : names) {
				System.out.println(name);
			}
			
		int numberOfProducts = names.size();
		System.out.println("Total number of products containing Table is: " + numberOfProducts);
		//getting last product's name that contains "stainless steel table"
		System.out.println("Last found product that contains 'Table' is: "+names.get(names.size()-1));

	}

	public void addLastFoundItemToCart() {
		waitForPresenceOfElement(driver, LAST_FOUND_PRODUCT_ELEMENT);
		driver.findElements(By.xpath("//*[@class='btn btn-cart btn-small']")).get(44).click();

		clickElement(VIEW_CART_BUTTON_ELEMENT);

	}

}
