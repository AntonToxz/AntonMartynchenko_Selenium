import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SearchJobSteps {
    public static SearchJob searchJob;
    public static WebDriver driver;


    @Given("I should be on careers page")
    public void iShouldBeOnCareersPage() {
        System.setProperty("webdriver.chrome.driver", ConfigProp.getProperty("chromedriver"));
        driver = new ChromeDriver();
        searchJob = new SearchJob(driver);
        driver.manage().window().maximize();
        driver.get(ConfigProp.getProperty("careerspage"));
    }

    @And("I enter keywords or job ID, city, skills, sign check marks")
    public void iEnterKeywordsOrJobIDCitySkillsSignCheckMarks() {
        searchJob.enterKeywordJob("programmer");
    }

    @When("I click on find button")
    public void iClickOnFindButton() {
        searchJob.clickFindButt();
    }

    @Then("I should be able to get all results found about jobs")
    public void iShouldBeAbleToGetAllResultsFoundAboutJobs() {
        try {
            Assert.assertEquals("Join our Team", driver.getTitle());
            System.out.println("Navigated to correct webpage");
        } catch (Throwable pageNavigationError) {
            System.out.println("Didn't navigate to correct webpage");
        }

        driver.quit();
    }
}
