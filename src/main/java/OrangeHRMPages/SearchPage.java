package OrangeHRMPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import ActionClass.Action;

public class SearchPage extends Action
{
//list of pages 
	private By pageList=By.cssSelector(".oxd-main-menu li");
	//Search box
	private By searchbox=By.cssSelector("input[placeholder='Search']");
	
	public void searchPage(String SearchPageName) throws InterruptedException
	{
		System.out.println("Welcome to Search Page.");
		List<WebElement> pages=findsBy(pageList);
		for(int i=0;i<pages.size();i++)
		{
			String page=pages.get(i).getText();
			System.out.println("Pages:"+page);
			if(page.equalsIgnoreCase(SearchPageName))
			{
				sendKeys(searchbox, page);
				Thread.sleep(2000);
				driver.findElements(By.tagName("a")).get(i).click();
				break;
			}
		}
	}
}
