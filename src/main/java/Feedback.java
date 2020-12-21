import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Feedback {

    public WebDriver driver;

    public Feedback(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"_content_epam_en_about_who-we-are_contact_jcr_content_content-container_section_section-par_form_constructor_user_first_name\"]")
    private WebElement firstNameField;

    @FindBy(xpath = "//*[@id=\"_content_epam_en_about_who-we-are_contact_jcr_content_content-container_section_section-par_form_constructor_user_last_name\"]")
    private WebElement lastNameField;

    @FindBy(xpath = "//*[@id=\"_content_epam_en_about_who-we-are_contact_jcr_content_content-container_section_section-par_form_constructor_user_email\"]")
    private WebElement emailField;

    @FindBy(xpath = "//*[@id=\"_content_epam_en_about_who-we-are_contact_jcr_content_content-container_section_section-par_form_constructor_user_phone\"]")
    private WebElement phoneField;

    @FindBy(xpath = "//*[@id=\"_content_epam_en_about_who-we-are_contact_jcr_content_content-container_section_section-par_form_constructor\"]/div[2]/div/div/div/div/div[5]/div/div[1]/div/span[1]/span[1]/span/span[1]")
    private WebElement locationField;


    @FindBy(xpath = "//*[@id=\"_content_epam_en_about_who-we-are_contact_jcr_content_content-container_section_section-par_form_constructor\"]/div[2]/div/div/div/div/div[8]/div/div[2]/label")
    private WebElement checkbox1;

    @FindBy(xpath = "//*[@id=\"_content_epam_en_about_who-we-are_contact_jcr_content_content-container_section_section-par_form_constructor\"]/div[2]/div/div/div/div/div[9]/div")
    private WebElement checkbox2;

    @FindBy(xpath = "//*[@id=\"_content_epam_en_about_who-we-are_contact_jcr_content_content-container_section_section-par_form_constructor\"]/div[3]/div/div[2]/button")
    private WebElement submitButton;

    public void enterFirstName(String str) {
        firstNameField.sendKeys(str);
    }

    public void enterLastName(String str) {
        lastNameField.sendKeys(str);
    }

    public void enterEmail(String str) {
        emailField.sendKeys(str);
    }

    public void enterPhone(String str) {
        phoneField.sendKeys(str);
    }

    public void enterLocation(String str) {
        locationField.sendKeys(str);
    }

    public void clickCheckbox1() {
        checkbox1.click();
    }

    public void clickCheckbox2() {
        checkbox2.click();
    }

    public void clickSubmitButt() {
        submitButton.click();
    }
}
