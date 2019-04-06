import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MainPageMail {
    private WebDriver driver;

    public MainPageMail(WebDriver driver) {
        this.driver = driver;
    }

    private By firstname = By.xpath("//input[@name='firstname']");
    private By lastname = By.xpath("//input[@name='lastname']");
    //private By dataOfBirth = By.xpath("//span[text()='День']");
   // private By gender = By.xpath("//span[@class='b-radiogroup__text']/span[text()='Женский']");
    private By emailName = By.xpath("//span[@class='b-email__name']");
    private By numberPhone = By.xpath("//input[@name='phone.phone']");
    private By iDoNotHaveAMobilePhone = By.xpath("//a[@href='/signup/simple']");
    private By termsOfUse = By.xpath("//a[@href='https://help.mail.ru/mail-help/UA']");
    private By registrButton = By.xpath("//button[@class='btn btn_main btn_responsive btn_responsive-wide ']");
    private By errorName = By.xpath("//div[@class='b-form-field__errors']/div[text()='Укажите имя']");
    private By logoMail = By.xpath("//img[@class='b-header__img']");

    public MainPageMail selectBirthDate (String day) {
        String listXpath = String.format(("//span[text()='%s']"), day);
        driver.findElement(By.xpath(listXpath)).click();
        return null;
    }
    public MainPageMail selectBirthMonth (String month) {
        String listXpath = String.format(("//span[text()='%s']"), month);
        driver.findElement(By.xpath(listXpath)).click();
        return null;
    }
    public MainPageMail selectBirthYear (String year) {
        String listXpath = String.format(("//span[text()='%s']"), year);
        driver.findElement(By.xpath(listXpath)).click();
        return null;
    }
    public MainPageMail selectGender (String gender) {
        String listXpath = String.format(("//span[@class='b-radiogroup__text']/span[text()='%s']"), gender);
        driver.findElement(By.xpath(listXpath)).click();
        return null;
    }






}
