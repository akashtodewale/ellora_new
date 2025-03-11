

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.ellora.Utilities.WaitUtil;

import java.time.Duration;
import java.util.Random;

public class CedogrowTest {

    public static void main(String[] args) {
        // Set up Chrome options for headless mode
       ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Enables headless mode
        options.addArguments("--disable-gpu"); // Disables GPU acceleration (useful for some environments)
        //options.addArguments("--window-size=1920,1080"); // Sets the window size (optional)
        options.addArguments("--no-sandbox"); // Bypass OS security model
        options.addArguments("--disable-dev-shm-usage"); // Overcomes limited resource issues in some environments

        // Initialize WebDriver with options
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://cedogrow.com/");

        for (int i = 0; i < 25; i++) {
            String name = generateRandomName();
            String email = generateRandomEmail(name);
            String phone = generateRandomPhoneNumber();
            String comment = generateRandomComment();

            WebElement enquiry = driver.findElement(By.xpath("//a[@id='hid-on-mob']"));
            WebElement Webname = driver.findElement(By.xpath("//input[@id='name']"));
            WebElement Email = driver.findElement(By.xpath("//input[@id=\"email\"]"));
            WebElement Phone = driver.findElement(By.xpath("//input[@id=\"phone\"]"));
            WebElement Comments = driver.findElement(By.xpath("//textarea[@name=\"Comments\"]"));
            WebElement Submit = driver.findElement(By.xpath("//input[@value=\"Submit\"]"));

            enquiry.click();
            Webname.sendKeys(name);
            Email.sendKeys(email);
            Phone.sendKeys(phone);
            Comments.sendKeys(comment);
            Submit.click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
            driver.navigate().refresh();
        }

        // Close the driver after execution
        driver.quit();
    }

    private static final String[] FIRST_NAMES = {
        "Dagadu", "Praju", "prajwal gf", "Bob", "Charlie", "Dave", "Eve", "Frank", "Grace", "Hank"
    };

    private static final String[] LAST_NAMES = {
        "Smith", "Johnson", "Williams", "Brown", "Jones", "Miller", "Davis", "Garcia", "Rodriguez", "Martinez"
    };

    private static final String[] EMAIL_DOMAINS = {
        "@gmail.com", "@yahoo.com", "@outlook.com", "@hotmail.com", "@example.com"
    };

    private static final String[] COMMENTS = {
        "kay re kay kartoy khali", "why are you sitting in owr room", "yeda pisa founder", 
        "Maze paise de", "turf book kar ", "bhik magu nako",
        "prajwal chya gandit "
    };

    private static final Random RANDOM = new Random();

    public static String generateRandomName() {
        return FIRST_NAMES[RANDOM.nextInt(FIRST_NAMES.length)] + " " +
               LAST_NAMES[RANDOM.nextInt(LAST_NAMES.length)];
    }

    public static String generateRandomEmail(String name) {
        return name.toLowerCase().replace(" ", ".") + EMAIL_DOMAINS[RANDOM.nextInt(EMAIL_DOMAINS.length)];
    }

    public static String generateRandomPhoneNumber() {
        return String.format("+1-%03d-%03d-%04d", 
                RANDOM.nextInt(900) + 100, 
                RANDOM.nextInt(900) + 100, 
                RANDOM.nextInt(9000) + 1000);
    }

    public static String generateRandomComment() {
        return COMMENTS[RANDOM.nextInt(COMMENTS.length)];
    }
}
