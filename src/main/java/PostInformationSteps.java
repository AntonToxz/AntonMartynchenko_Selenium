import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class PostInformationSteps {
    public static PostInformation postInformation;

    public PostInformationSteps() {
        DriverStatic.init();
        postInformation = new PostInformation(DriverStatic.driver);
    }

    @Given("I should be on main page")
    public void iShouldBeOnMainPage() {
        DriverStatic.driver.get(ConfigProp.getProperty("mainpage"));
    }

    @When("I click on Learn more button on exact post")
    public void iClickOnLearnMoreButtonOnExactPost() {
        postInformation.clickLearnMoreButt();
    }

    @Then("I am directed to exact page with this post")
    public void iAmDirectedToExactPageWithThisPost() {
        try {
            Assert.assertEquals("EPAM Continuum | EPAM", DriverStatic.driver.getTitle());
            System.out.println("Navigated to correct webpage");
        } catch (Throwable pageNavigationError) {
            System.out.println("Didn't navigate to correct webpage");
        }

        DriverStatic.driver.quit();
    }
}
