import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchJob {

    public WebDriver driver;

    public SearchJob(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"new_form_job_search_1445745853_copy-keyword\"]")
    private WebElement keywordJob;

    @FindBy(xpath = "//*[@id=\"main\"]/div[1]/div[3]/section/div/div[2]/div/form/button")
    private WebElement findButton;

    public void enterKeywordJob(String keyword){
        keywordJob.sendKeys(keyword);
    }

    public void clickFindButt(){
        findButton.click();
    }

}
