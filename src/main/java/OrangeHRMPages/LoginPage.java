package OrangeHRMPages;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import ActionClass.Action;

public class LoginPage extends Action
{
	//username
	private By username=By.name("username");
	//Pass
	private By password=By.name("password");
	//Login button
	private By loginBtn=By.xpath("//button[contains(@class,'login-button')]");
	//Error Message
	private By errorMsg=By.xpath("//p[contains(@class,'oxd-alert')]");
	//Dashboard
	private By dashboardverify=By.xpath("//h6[contains(@class,'header-breadcrumb-module')]");
	
public SearchPage loginPage(String uname,String upass) throws InterruptedException
{
	System.out.println("Welcome Login Page.");
	sendKeys(username, uname);
	sendKeys(password, upass);
	click(loginBtn);
	if(getText(dashboardverify).equalsIgnoreCase("Dashboard"))
	{
		System.out.println("Welcome to Home Page!");
	}
	else
	{
		System.out.println("Login Failed.");
	String ActualErrorText=getText(errorMsg);
	SoftAssert soft=new SoftAssert();
	soft.assertTrue(ActualErrorText.contains(ActualErrorText));
	}
	
	return new SearchPage();
	
	
}
}
