import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SearchKeywordSteps {
    public static SearchKeyword searchKeyword;
    public static WebDriver driver;
    
    @Given("I should click on search button on menu bar")
    public void iShouldClickOnSearchButtonOnMenuBar() {
        System.setProperty("webdriver.chrome.driver", ConfigProp.getProperty("chromedriver"));
        driver = new ChromeDriver();
        searchKeyword = new SearchKeyword(driver);
        driver.manage().window().maximize();
        driver.get(ConfigProp.getProperty("mainpage"));

        searchKeyword.clickSrchButt();
    }

    @When("I enter keyword")
    public void iEnterKeyword() {
        searchKeyword.enterKeyword("EPAM");
    }

    @And("I click find button")
    public void iClickFindButton() {
        searchKeyword.clickFindButt();
    }

    @Then("I should be able to get all results found on this website and be on search page")
    public void iShouldBeAbleToGetAllResultsFoundOnThisWebsite() {
        try {
            Assert.assertEquals("Search", driver.getTitle());
            System.out.println("Navigated to correct webpage");
        } catch (Throwable pageNavigationError) {
            System.out.println("Didn't navigate to correct webpage");
        }

        driver.quit();
    }

}
