import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ChangeLanguageTest {

    public ChangeLanguage changeLanguage;
    public static WebDriver driver;

    //осуществление настроек
    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", ConfigProp.getProperty("chromedriver"));
        driver = new ChromeDriver();
        changeLanguage = new ChangeLanguage(driver);
        driver.manage().window().maximize();
        driver.get(ConfigProp.getProperty("mainpage"));
    }

    @Test
    public void languageTest(){
        changeLanguage.clickLangButt();
        changeLanguage.clickRusButton();
        try {
            Assert.assertEquals("EPAM | Разработка ПО", driver.getTitle());
            System.out.println("Right language");
        } catch (Throwable pageNavigationError) {
            System.out.println("Wrong Language");
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
