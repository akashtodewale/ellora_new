

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
@Test
public class mouseHover {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
		        // Setup ChromeDriver using WebDriverManager
		      //  WebDriverManager.chromedriver().setup();
		        
		        // Initialize WebDriver
		        WebDriver driver = new ChromeDriver();
		       

		        try {
		            // Open a website
		        	driver.get("https://www.amazon.in/"); // Change to your target URL

		            // Locate the element to hover over
		            WebElement hoverElement = driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]")); // Change locator to your specific element

		            // Create an Actions object
		            Actions actions = new Actions(driver);

		            // Perform the hover action
		            actions.moveToElement(hoverElement).perform();

		            // Hover for a specific amount of time (e.g., 5 seconds)
		            Thread.sleep(5000); // 5000 milliseconds = 5 seconds

		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        } finally {
		            // Close the browser
		            driver.quit();
		        }
		    }
		
		
		
		
		
		
		
		
	}

	
	


