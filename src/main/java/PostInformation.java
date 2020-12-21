import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PostInformation {

    public WebDriver driver;

    public PostInformation(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"main\"]/div[1]/div[2]/section/div/div/div/div[1]/div/div[3]/div/div/div/div/div/div/div/div/div/div[3]/div/a")
    private WebElement learnMoreButton;

    public void clickLearnMoreButt(){
        driver.get(learnMoreButton.getAttribute("href"));
    }
}
