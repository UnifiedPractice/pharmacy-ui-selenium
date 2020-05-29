package ListenersPackage;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import BaseTest.BaseTest;



public class TestsListener extends BaseTest implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getMethod().getMethodName() + " started executing");

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getMethod().getMethodName() + " has successfully been executed");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test" + result.getMethod().getMethodName() + " failed");
		takeScreenshot(result.getMethod().getMethodName(), "failed_");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test" + result.getMethod().getMethodName() + " skipped");
		takeScreenshot(result.getMethod().getMethodName(), "skipped_");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
