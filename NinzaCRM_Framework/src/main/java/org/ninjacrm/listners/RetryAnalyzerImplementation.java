package org.ninjacrm.listners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzerImplementation implements IRetryAnalyzer{

	@Override
	public boolean retry(ITestResult result) {
		
		int num=0;
		int upperLimit=3;
		if (num<upperLimit) {
			num++;
			return true;
			
		}
		
		return false;
	}
	
	

}
