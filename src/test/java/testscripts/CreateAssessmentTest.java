package testscripts;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.ControlActions;
import base.TestConfigs;
import pages.AutoTestPage_TestDetailsTab;
import pages.CreateAssessmentPage;
import pages.DashboardPage;
import pages.LoginPage;

public class CreateAssessmentTest {

	DashboardPage dashboardPage;
	CreateAssessmentPage createAssessmentPage;
	AutoTestPage_TestDetailsTab autoTestPage_TestDetailsTab;

	@BeforeMethod
	public void setup() {
		System.out.println("PREREQUISITE - Login HireCorrecto using valid credentials and user is on dashboard page.");
		ControlActions.start();
		LoginPage page = new LoginPage();
		dashboardPage = page.login(TestConfigs.VALID_USERNAME, TestConfigs.VALID_PASSWORD);
		dashboardPage.waitForPageLoad("dashboard");
	}

	@Test
	public void verifyCreateAssessment() {
		System.out.println("VERIFY - Create Assessment button is displayed");
		boolean createAssessmentBtnFlag = dashboardPage.isCreateAssessmentButtonDisplayed();
		Assert.assertTrue(createAssessmentBtnFlag, "Create Assessment button was not displayed");

		System.out.println("STEP - Click on Create Assessment button");
		createAssessmentPage = dashboardPage.clickOnCreateAssessmentButton();

		System.out.println("STEP - Select Job Title");
		String jobName = "Automation Test Engineer";
		createAssessmentPage.selectJob(jobName);

		System.out.println("STEP - Select Experience");
		String experience = "Freshers (0 - 1)";
		createAssessmentPage.selectExperience(experience);

		System.out.println("STEP - Select Job Role");
		String jobRole = "Frontend engineer";
		createAssessmentPage.selectJobRole(jobRole);

		System.out.println("STEP - Select Skills");
		List<String> skillsToSelect = Arrays.asList("javascript", "html/css");
		createAssessmentPage.selectSkills(skillsToSelect);

		System.out.println("STEP - Click on Next button");
		autoTestPage_TestDetailsTab = createAssessmentPage.clickOnNextBtn();

		System.out.println("VERIFY - Test Name contains job role");
		String actualTestName = autoTestPage_TestDetailsTab.getTestName();
		Assert.assertTrue(actualTestName.contains(jobRole));

		System.out.println("VERIFY - Job Role");
		String actualJobRole = autoTestPage_TestDetailsTab.getJobRole();
		Assert.assertEquals(actualJobRole, jobRole);

		System.out.println("VERIFY - Experience");
		String actualExperience = autoTestPage_TestDetailsTab.getExperience();
		Assert.assertEquals(actualExperience, experience);

	}
}