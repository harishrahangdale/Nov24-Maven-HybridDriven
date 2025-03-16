package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ControlActions;

public class CreateAssessmentPage extends ControlActions {

	private String selectElementLocator = "//li[text()='%s']";

	private String selectSkillLocator = "//p[text()='%s']";

	@FindBy(css = "div#select-value-Job")
	WebElement jobInputElement;

	@FindBy(css = "div#select-value-Experience")
	WebElement experienceInputElement;

	@FindBy(css = "div[id='select-value-Job Role']")
	WebElement jobRoleInputElement;

	@FindBy(css = "input[placeholder='Search Skills']")
	WebElement skillsInputElement;

	@FindBy(xpath = "//button[text()='Next']")
	WebElement nextButtonLocator;

	public CreateAssessmentPage() {
		PageFactory.initElements(driver, this);
	}

	public void selectJob(String jobName) {
		setText(jobInputElement, true, jobName);
		String locator = String.format(selectElementLocator, jobName);
		clickOnElement(LocatorType.XPATH, locator, true);
	}

	public void selectExperience(String experience) {
		setText(experienceInputElement, true, experience);
		String locator = String.format(selectElementLocator, experience);
		clickOnElement(LocatorType.XPATH, locator, true);
	}

	public void selectJobRole(String jobRole) {
		setText(jobRoleInputElement, true, jobRole);
		String locator = String.format(selectElementLocator, jobRole);
		clickOnElement(LocatorType.XPATH, locator, true);
	}

	public void selectSkills(List<String> skillsToSelect) {
		for (String skill : skillsToSelect) {
			setText(skillsInputElement, true, skill);
			String locator = String.format(selectSkillLocator, skill);
			clickOnElement(LocatorType.XPATH, locator, true);
			clearText(skillsInputElement, true);
		}
	}

	public AutoTestPage_TestDetailsTab clickOnNextBtn() {
		clickOnElement(nextButtonLocator, false);
		return new AutoTestPage_TestDetailsTab();
	}
}
