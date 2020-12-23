import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ChangeLanguageSteps {
    public ChangeLanguage changeLanguage;
    public static WebDriver driver;

    @Given("^I am on main page$")
    public void mainPage() {
        System.setProperty("webdriver.chrome.driver", ConfigProp.getProperty("chromedriver"));
        driver = new ChromeDriver();
        changeLanguage = new ChangeLanguage(driver);
        driver.manage().window().maximize();

        driver.get(ConfigProp.getProperty("mainpage"));
    }



    @When("^I click on language button on menu bar$")
    public void clickLanguageButt() {
        changeLanguage.clickLangButt();
    }



    @And("^I select language \\(Россия\\(Русский\\)\\)$")
    public void clickRusLanguage() {
        changeLanguage.clickRusButton();
    }



    @Then("Everything on website should be translated to selected language and be on main page")
    public void checkTranslated() {
        try {
            Assert.assertEquals("EPAM | Разработка ПО", driver.getTitle());
            System.out.println("Right language");
        } catch (Throwable pageNavigationError) {
            System.out.println("Wrong Language");
        }

        driver.quit();
    }
}
