package pages;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Random;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class BasePage {
	
	public BasePage() {
		
	}
	public static WebDriver driver;
	
	public void init() {
		  System.setProperty("webdriver.chrome.driver", "drivers\\geckodriver.exe");
		  driver = new FirefoxDriver();
		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
	}

	public int generateRandomNumber(int boundaryNumber) {
		Random rnd = new Random();
		int generatedNum = rnd.nextInt(boundaryNumber);
		return generatedNum;
	}

	 public void takeScreenshot(WebDriver driver) {
		 TakesScreenshot ts=(TakesScreenshot)driver;
		 File sourceFile=ts.getScreenshotAs(OutputType.FILE);
		 SimpleDateFormat formatter=new SimpleDateFormat("MMddyy_HHmmss");
		 Date date=new Date();
		 String label=formatter.format(date);
		 try {
			FileUtils.copyFile(sourceFile, new File(System.getProperty("user.dir")+"/screenshot/"+label+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	 }
	 public void clickElement(WebElement element) {
	        element.click();
	    }
	
	   public void enterInput(WebElement element, String input) {
	        element.sendKeys(input);
	    }
	 
	public void selectFromDropdown(WebElement element, String text) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	
	public WebElement waitForElementToBeClickable(WebDriver driver, WebElement element) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    WebElement el = wait.until(ExpectedConditions.elementToBeClickable(element));
	    return el;
	  }
	
	 public WebElement waitForPresenceOfElement(WebDriver driver, WebElement element) {
	     WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
	     WebElement el=wait.until(ExpectedConditions.visibilityOf(element));
	     return el;
		 
	    }
}
