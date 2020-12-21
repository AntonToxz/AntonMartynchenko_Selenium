import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchKeyword {

    public WebDriver driver;

    public SearchKeyword(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /**
     * местоположение кнопки поиска
     */
    @FindBy(xpath = "//*[@id=\"wrapper\"]/div[2]/div[1]/header/div/ul/li[3]/div/button")
    private WebElement searchButton;

    /**
     * местоположение поля ввода
     */
    @FindBy(xpath = "//*[@id=\"new_form_search\"]")
    private WebElement keywordField;

    /**
     * местоположение кнопки "найти"
     */
    @FindBy(xpath = "//*[@id=\"wrapper\"]/div[2]/div[1]/header/div/ul/li[3]/div/div/form/button")
    private WebElement findButton;


    /**
     * метод клика кнопки поиска
     */
    public void clickSrchButt(){
        searchButton.click();
    }

    /**
     * метод ввода в поле поиска
     */
    public void enterKeyword(String keyword){
        keywordField.sendKeys(keyword);
    }

    /**
     * метод клика на кнопку "найти"
     */
    public void clickFindButt(){
        findButton.click();
    }

}
