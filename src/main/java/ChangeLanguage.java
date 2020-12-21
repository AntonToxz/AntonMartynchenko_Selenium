import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.xml.xpath.XPath;

public class ChangeLanguage {


    public WebDriver driver;

    public ChangeLanguage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"wrapper\"]/div[2]/div[1]/header/div/ul/li[2]/div/button")
    private WebElement languageButton;

    @FindBy(xpath = "//*[@id=\"wrapper\"]/div[2]/div[1]/header/div/ul/li[2]/div/nav/ul/li[9]/a")
    private WebElement rusLanguage;

    public void clickLangButt(){
        languageButton.click();
    }

    public void clickRusButton(){
        driver.get(rusLanguage.getAttribute("href"));
    }
}
