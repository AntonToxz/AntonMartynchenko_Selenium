import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ServicesOptimize {

    public WebDriver driver;

    public ServicesOptimize(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"main\"]/div[1]/div[2]/section/header/div[4]/div[1]/a")
    private WebElement deliveryOptButton;

    @FindBy(xpath = "//*[@id=\"main\"]/div[1]/div[2]/section/header/div[4]/div[3]/a")
    private WebElement managedServicesButton;

    public void clickDeliveryOptButt(){
        deliveryOptButton.click();
    }

    public void clickManagedSerButt(){
        managedServicesButton.click();
    }
}
