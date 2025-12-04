package com.hgk.OrangeHRM_Automate.OrangeHRM_E2E;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DynamicWebTableHandling 
{
	WebDriver driver;
	@Test
public void webTableHandle()
{
		String browser="Chrome";
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://practice.expandtesting.com/Dynamic-table");
		List<WebElement> firstColumn=driver.findElements(By.xpath("//div[contains(@class,'table')]//tr//td[1]"));
//		WebElement ele=driver.findElement(By.xpath("//td[text()='Chrome']/following-sibling::td[contains(text(),'%')]"));
//		System.out.println(ele.getText());
		for(int i=0;i<firstColumn.size();i++)
		{
			
			if(firstColumn.get(i).getText().equalsIgnoreCase(browser))
			{
				//System.out.println(firstColumn.get(i));
				WebElement ele=driver.findElement(By.xpath("//td[text()='"+browser+"']/following-sibling::td[contains(text(),'%')]"));
	
				System.out.println("Text is:"+ele.getText());
				
			
			}
		}
}
}
