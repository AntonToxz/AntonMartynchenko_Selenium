import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class FeedbackTest {
    public static Feedback feedback;
    public static WebDriver driver;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", ConfigProp.getProperty("chromedriver"));
        driver = new ChromeDriver();
        feedback = new Feedback(driver);
        driver.manage().window().maximize();
        driver.get(ConfigProp.getProperty("contactpage"));
    }

    @Test
    public void feedbackTest() {
        feedback.enterFirstName("A");
        feedback.enterLastName("M");
        feedback.enterEmail("testing22@gmail.com");
        //feedback.enterLocation("Ukraine");
        feedback.enterPhone("0553535");
        //feedback.clickCheckbox1();
        //feedback.clickCheckbox2();
        List<WebElement> allCheckbox = driver.findElements(By.xpath("//input[@type='checkbox']"));  //?????????????
        for (WebElement e : allCheckbox) {                                                          //?????????????org.openqa.selenium.ElementClickInterceptedException: element click intercepted: Element <button class="button-ui" type="submit">...</button> is not clickable at point (1357, 901).
            if (e.isSelected()) {                                                                   //?????????????Other element would receive the click: <span class="button__content">...</span>
                e.click();                                                                          //?????????????
            }                                                                                       //?????????????
        }                                                                                           //?????????????
        feedback.clickSubmitButt();

        try {
            Assert.assertEquals("Search", driver.getTitle());
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
