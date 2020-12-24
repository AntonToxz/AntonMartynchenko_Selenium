import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class FeedbackSteps {
    public static Feedback feedback;

    public FeedbackSteps() {
        DriverStatic.init();
        feedback = new Feedback(DriverStatic.driver);
    }

    @Given("I should be on {string} page")
    public void iShouldBeOnPage(String arg0) {
        DriverStatic.driver.get(ConfigProp.getProperty("contactpage"));
    }

    @When("I enter every field with information")
    public void iEnterEveryFieldWithInformation() {
        feedback.enterFirstName("A");
        feedback.enterLastName("M");
        feedback.enterEmail("testing22@gmail.com");
        //feedback.enterLocation("Ukraine");
        feedback.enterPhone("0553535");
    }

    @And("I click on two check marks")
    public void iClickOnTwoCheckMarks() {
        //feedback.clickCheckbox1();
        //feedback.clickCheckbox2();
    }

    @And("I click on submit button")
    public void iClickOnSubmitButton() {
        feedback.clickSubmitButt();
    }

    @Then("I should stay on same page")
    public void iShouldStayOnSamePage() {
        try {
            Assert.assertEquals("Search", DriverStatic.driver.getTitle());
            System.out.println("Navigated to correct webpage");
        } catch (Throwable pageNavigationError) {
            System.out.println("Didn't navigate to correct webpage");
        }

        DriverStatic.driver.quit();
    }
}
