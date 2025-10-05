package orangeHRM_E2E.BrowserInIt;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ActionClass.Action;
import OrangeHRMPages.LoginPage;

public class BrowserInItPage extends Action{

	@BeforeMethod
	public LoginPage browser() throws Exception {
		FileInputStream file = new FileInputStream(
				"E:\\SeleniumAutomationFreshStart\\OrangeHRM_E2E\\PropertiesFile\\PropertiesData");
		Properties prop = new Properties();
		prop.load(file);
		String browsername = prop.getProperty("browser") != null ? prop.getProperty("browser")
				: prop.getProperty("browser");
		if (browsername.equalsIgnoreCase("Chrome")) {
			System.out.println("Script launched in:"+browsername);
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get(prop.getProperty("BrowserURL"));
		} else if (browsername.equalsIgnoreCase("edge")) {
			System.out.println("Script launched in:"+browsername);
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get(prop.getProperty("BrowserURL"));
		} else {
			System.out.println("Sorry, no browser found to run script.");
		}
		return new LoginPage();
	}
	
}
