package utilities;

import net.rcarz.jiraclient.BasicCredentials;
import net.rcarz.jiraclient.Field;
import net.rcarz.jiraclient.Issue;
import net.rcarz.jiraclient.Issue.FluentCreate;
import net.rcarz.jiraclient.JiraClient;
import net.rcarz.jiraclient.JiraException;

public class JiraServiceProvider {

	public JiraClient jira;
	public String helioscript;

	public JiraServiceProvider(String jiraURL, String username, String password, String helioscript) {
			BasicCredentials credentials = new BasicCredentials(username, password);
			jira = new JiraClient(jiraURL, credentials);
			this.helioscript = helioscript;
	}
	
	public void createTicket(String issueType, String summary, String description, String reporterName) {
		
		try {
			FluentCreate fluentCreate = jira.createIssue(helioscript, issueType);
			fluentCreate.field(Field.SUMMARY, summary);
			fluentCreate.field(Field.DESCRIPTION, description);
			Issue newIssue = fluentCreate.execute();
			System.out.println("New issue has been created with ID: " + newIssue);
		} catch (JiraException e) {
			e.printStackTrace();
		}
	}
}
