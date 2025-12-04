package com.hgk.OrangeHRM_Automate.OrangeHRM_E2E;

import org.testng.annotations.Test;

import ActionClass.Action;
import OrangeHRMPages.LoginPage;
import OrangeHRMPages.SearchPage;
import OrangeHRM_Listerner.RetryBeforeFailing;
import orangeHRM_E2E.BrowserInIt.BrowserInItPage;

public class TestRunBaseClass extends Action

{
	//Login Page Object Creation.
	LoginPage login=new LoginPage();
	BrowserInItPage browser=new BrowserInItPage();
	SearchPage page=new SearchPage();
@Test(retryAnalyzer = RetryBeforeFailing.class)
public void loginPageTest() throws Exception
{
	
	browser.browser();
	System.out.println("Welcome to login page test method.");
	login.loginPage("Admin","admin123");
	System.out.println("Search page is about to call");
	page.searchPage("PIM");
}
}
