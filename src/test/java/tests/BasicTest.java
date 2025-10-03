package tests;


import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class BasicTest {
	//IMPORTANT: Please download a Chrome driver and set this variable to the full path to the file
	private WebDriver driver;

	@BeforeTest
	@Parameters({"browser", "driverPath"})
	public void setUp(@Optional("chrome") String browser, @Optional("") String driverPath) {
		if (browser.equalsIgnoreCase("chrome")) {
			if (!driverPath.isEmpty()) {
				System.setProperty("webdriver.chrome.driver", driverPath);
			}
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			if (!driverPath.isEmpty()) {
				System.setProperty("webdriver.gecko.driver", driverPath);
			}
			driver = new FirefoxDriver();
		} else {
			throw new IllegalArgumentException("Unsupported browser: " + browser);
		}
	}

	// Add your test cases here

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}