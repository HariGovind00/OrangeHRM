package ActionClass;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Action {
	public static WebDriver driver;
	ExtentReports report=new ExtentReports();

	public WebElement findBy(By locator) {
		return driver.findElement(locator);

	}
	
	public List<WebElement> findsBy(By locator)
	{
		List<WebElement> ele=driver.findElements(locator);
		return ele;
	}
	
	public void click(By locator)
	{
		findBy(locator).click();
	}
	
	public void sendKeys(By locator,String val)
	{
		findBy(locator).sendKeys(val);
	}
	
	public String getText(By locator)
	{
		return findBy(locator).getText();
	}
	
	public void selectOpt(By locator,String OptionSearch)
	{
		Select sel=new Select(findBy(locator));
		sel.selectByVisibleText(OptionSearch);
		
	}
	public void visibilityOfElement(WebElement locator)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(locator));
	}
	
	public String screenshot(String captureScreenshot) throws IOException
	{
		TakesScreenshot screen=(TakesScreenshot)driver;
		File src=screen.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\Screenshot\\"+captureScreenshot+".jpg"));
		return System.getProperty("user.dir")+"\\Screenshot\\"+captureScreenshot+".jpg";
	}
	
	public ExtentReports extentReportClass()
	{
		String file=System.getProperty("user.dir")+"\\ReportFile\\OrangeHRMReport.html";
		ExtentSparkReporter extent=new ExtentSparkReporter(file);
		extent.config().setDocumentTitle("TestNG Extent Report");
		extent.config().setReportName("OrangeHRM Report");	
		report.attachReporter(extent);
		report.setSystemInfo("Hari", "Test Automation");
		return report;
		
	}
	
}
