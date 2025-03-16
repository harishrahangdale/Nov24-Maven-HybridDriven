package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ControlActions;

public class AutoTestPage_TestDetailsTab extends ControlActions {

	@FindBy(css = "input[id='Test Name-id']")
	WebElement testNameInputElement;

	@FindBy(css = "div[id='select-value-Job Role']")
	WebElement jobRoleInputElement;

	@FindBy(css = "div#select-value-Experience")
	WebElement experienceInputElement;

	public AutoTestPage_TestDetailsTab() {
		PageFactory.initElements(driver, this);
	}

	public String getTestName() {
		return getInputElementText(testNameInputElement, true);
	}

	public String getJobRole() {
		return getElementText(jobRoleInputElement, true);
	}

	public String getExperience() {
		return getElementText(experienceInputElement, true);
	}

}
