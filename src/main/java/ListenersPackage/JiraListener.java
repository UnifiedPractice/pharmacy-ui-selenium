package ListenersPackage;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import utilities.Jira;
import utilities.JiraServiceProvider;

public class JiraListener implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Jira jira = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Jira.class);
		boolean ticketReady = jira.logTicketReady();
		if(ticketReady) {
			// Create Jira ticket
			System.out.println("");
			JiraServiceProvider jiraServiceProvider = new JiraServiceProvider("https://unifiedp.atlassian.net", "username", "c61CVuz99RoIwzhhNQil6C40", "PHA"); 
			String issueSummary = result.getMethod().getConstructorOrMethod().getMethod().getName() + "Failed due to assertions or exception";
			String issueDescription = result.getThrowable().getMessage();
			issueDescription.concat(ExceptionUtils.getFullStackTrace(result.getThrowable()));
			jiraServiceProvider.createTicket("BUG", issueSummary, issueDescription, "QA");
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
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
