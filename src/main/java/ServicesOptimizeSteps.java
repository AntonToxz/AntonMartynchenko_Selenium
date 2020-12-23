import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ServicesOptimizeSteps {
    public static ServicesOptimize servicesOptimize;
    public static WebDriver driver;

    @Given("I should be on optimize page")
    public void iShouldBeOnServicesOptimizePage() {
        System.setProperty("webdriver.chrome.driver", ConfigProp.getProperty("chromedriver"));
        driver = new ChromeDriver();
        servicesOptimize = new ServicesOptimize(driver);
        driver.manage().window().maximize();
        driver.get(ConfigProp.getProperty("optimizepage"));
    }

    @When("I click on buttons")
    public void iClickOnButtons() {
        servicesOptimize.clickDeliveryOptButt();
    }

    @Then("I should get information below buttons")
    public void iShouldGetInformationBelowButtons() {
        try {
            Assert.assertEquals("DELIVERY OPTIMIZATION", driver.findElement(By.xpath("//*[@id=\"main\"]/div[1]/div[2]/section/div[1]/div/div[1]/div/div/div/div[3]/div[1]/div[1]/h2")).getText());
            System.out.println("Navigated to correct webpage");
        } catch (Throwable pageNavigationError) {
            System.out.println("Didn't navigate to correct webpage");
        }
    }

    @But("If click on another button")
    public void ifClickOnAnotherButton() {
        servicesOptimize.clickManagedSerButt();
    }

    @Then("information must change")
    public void informationMustChange() {
        try {
            Assert.assertEquals("MANAGED SERVICES", driver.findElement(By.xpath("//*[@id=\"main\"]/div[1]/div[2]/section/div[1]/div/div[2]/div/div/div/div[3]/div[1]/div[1]/h2")).getText());
            System.out.println("Navigated to correct webpage");
        } catch (Throwable pageNavigationError) {
            System.out.println("Didn't navigate to correct webpage");
        }

        driver.quit();
    }
}
