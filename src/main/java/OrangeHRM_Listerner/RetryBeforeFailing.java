package OrangeHRM_Listerner;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryBeforeFailing implements IRetryAnalyzer
{

	int maxTry=2;
	int count=0;
	
	public boolean retry() 
	{
		while(count<maxTry)
		{
			count++;
			return true;
		}
			
		return false;
	}

	@Override
	public boolean retry(ITestResult arg0) {
		// TODO Auto-generated method stub
		return false;
	}

}
