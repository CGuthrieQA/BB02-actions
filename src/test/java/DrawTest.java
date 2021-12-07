import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import pom.PainterPage;

public class DrawTest {

	private static RemoteWebDriver driver;
	Actions action = new Actions(driver);
	PainterPage pp = PageFactory.initElements(driver, PainterPage.class);

	@BeforeAll
	public static void setup() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver = new ChromeDriver(chromeCfg());
	}

	@Test
	public void draw() throws InterruptedException {
		System.out.println("nav to page");
		driver.get(PainterPage.URL);
		System.out.println("grab the paint brush");
		pp.chooseBrush();
		WebElement canvas = driver.findElement(By.cssSelector("#catch"));
		
		System.out.println("drawing the 'C'");
		// C
		action.moveToElement(canvas).clickAndHold().moveByOffset(200, -200).moveByOffset(100, 0).moveByOffset(100,200).build().perform();

		Thread.sleep(3000);
		
		//G
		action.moveToElement(canvas).moveByOffset(100, 0).clickAndHold().moveByOffset(-10, -140).build().perform();

		Thread.sleep(3000);
		}

	@AfterAll
	public static void tearDown() {
		driver.quit();
		System.out.println("driver closed");
	}

	// Designed to return ChromeOptions to configure new ChromeDrivers in Selenium
	public static ChromeOptions chromeCfg() {
		Map<String, Object> prefs = new HashMap<String, Object>();
		ChromeOptions cOptions = new ChromeOptions();

		// Settings
		prefs.put("profile.default_content_setting_values.cookies", 2);
		prefs.put("network.cookie.cookieBehavior", 2);
		prefs.put("profile.block_third_party_cookies", true);

		// Create ChromeOptions to disable Cookies pop-up
		cOptions.setExperimentalOption("prefs", prefs);

		return cOptions;
	}

}
