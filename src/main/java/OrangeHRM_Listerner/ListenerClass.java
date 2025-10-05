package OrangeHRM_Listerner;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import ActionClass.Action;

public class ListenerClass extends Action implements ITestListener
{
	ExtentReports extent=extentReportClass();
	ExtentTest test;
	ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result) {
		result.getMethod().getMethodName();
		test=extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS,"Script Successfully Passed.");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		extentTest.get().log(Status.FAIL,"Script Failed.");
		try {
			String filePath=screenshot(result.getMethod().getMethodName());
			extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	@Override
	public void onFinish(ITestContext context) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extent.flush();
		driver.quit();
	}
}
