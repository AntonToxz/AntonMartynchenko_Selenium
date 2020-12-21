import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchKeywordTest {

    public static SearchKeyword searchKeyword;
    public static WebDriver driver;

    //осуществление настроек
    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", ConfigProp.getProperty("chromedriver"));
        driver = new ChromeDriver();
        searchKeyword = new SearchKeyword(driver);
        driver.manage().window().maximize();
        driver.get(ConfigProp.getProperty("mainpage"));
    }

    //тест1
    @Test
    public void searchTest1() {
        searchKeyword.clickSrchButt();
        searchKeyword.enterKeyword("EPAM");
        searchKeyword.clickFindButt();
        try {
            Assert.assertEquals("Search", driver.getTitle());
            System.out.println("Navigated to correct webpage");
        } catch (Throwable pageNavigationError) {
            System.out.println("Didn't navigate to correct webpage");
        }
    }

    //тест2
    @Test
    public void searchTest2() {
        searchKeyword.clickSrchButt();
        searchKeyword.enterKeyword("Find something coool");
        searchKeyword.clickFindButt();
        try {
            Assert.assertEquals("Search", driver.getTitle());
            System.out.println("Navigated to correct webpage");
        } catch (Throwable pageNavigationError) {
            System.out.println("Didn't navigate to correct webpage");
        }
    }

    //закрытие
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
