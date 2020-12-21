import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ServicesOptimizeTest {
    public static ServicesOptimize servicesOptimize;
    public static WebDriver driver;


    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", ConfigProp.getProperty("chromedriver"));
        driver = new ChromeDriver();
        servicesOptimize = new ServicesOptimize(driver);
        driver.manage().window().maximize();
        driver.get(ConfigProp.getProperty("optimizepage"));
    }

   //@Test
    public void servicesOptPage1() {
        servicesOptimize.clickDeliveryOptButt();
        try {
            Assert.assertEquals("DELIVERY OPTIMIZATION", driver.findElement(By.xpath("//*[@id=\"main\"]/div[1]/div[2]/section/div[1]/div/div[1]/div/div/div/div[3]/div[1]/div[1]/h2")).getText());
            System.out.println("Navigated to correct webpage");
        } catch (Throwable pageNavigationError) {
            System.out.println("Didn't navigate to correct webpage");
        }
    }

    @Test
    public void servicesOptPage2() {
        servicesOptimize.clickDeliveryOptButt();
        servicesOptimize.clickManagedSerButt();
        try {
            Assert.assertEquals("MANAGED SERVICES", driver.findElement(By.xpath("//*[@id=\"main\"]/div[1]/div[2]/section/div[1]/div/div[2]/div/div/div/div[3]/div[1]/div[1]/h2")).getText());
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
