package ListenersPackage;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Analyzer implements IRetryAnalyzer {
 //TODO Remove retry functionality from framework. should be done from teamcity
	int counter = 0;
	int retryLimit = 0;

	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(counter < retryLimit) {
			counter++;
			return true;
		}
		return false;
	}

}
