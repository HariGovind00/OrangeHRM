package com.hgk.OrangeHRM_Automate.OrangeHRM_E2E;

import org.testng.annotations.Test;

import ActionClass.Action;
import OrangeHRMPages.LoginPage;
import OrangeHRMPages.SearchPage;
import OrangeHRM_Listerner.RetryBeforeFailing;
import orangeHRM_E2E.BrowserInIt.BrowserInItPage;

public class TestRunBaseClass extends Action

{
	LoginPage login=new LoginPage();
	BrowserInItPage browser=new BrowserInItPage();
	SearchPage page=new SearchPage();
@Test(retryAnalyzer = RetryBeforeFailing.class)
public void loginPageTest() throws Exception
{
	browser.browser();
	
	login.loginPage("Admin","admin123");
	page.searchPage("PIM");
}
}
