import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PostInformationTest {
    public static PostInformation postInformation;
    public static WebDriver driver;


    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", ConfigProp.getProperty("chromedriver"));
        driver = new ChromeDriver();
        postInformation = new PostInformation(driver);
        driver.manage().window().maximize();
        driver.get(ConfigProp.getProperty("mainpage"));
    }

    @Test
    public void postInfoTest() {
        postInformation.clickLearnMoreButt();
        try {
            Assert.assertEquals("EPAM Continuum | EPAM", driver.getTitle());
            System.out.println("Navigated to correct webpage");
        } catch (Throwable pageNavigationError) {
            System.out.println("Didn't navigate to correct webpage");
        }
    }

    @AfterClass
    public static void tearDown() {
        /*try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        driver.quit();
    }
}
