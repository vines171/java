import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpVerifyMail {
    private WebDriver driver;

    public SignUpVerifyMail(WebDriver driver) {
        this.driver = driver;
    }
    private By headingHaveAPhoneNumber = By.xpath("//div[@class='b-panel__header']/span[text()='Дождитесь звонка']");
    private By headingNoPhoneNumber = By.xpath("span[text()='Регистрация']");
    private By captcha =  By.xpath("//p[text()='Укажите код с картинки']");

    public SignUpVerifyMail() {
    }

    public  String getHeadingHaveAPhoneNumberText() {
        return driver.findElement(headingHaveAPhoneNumber).getText();
    }
    public  String getHeadingNoPhoneNumberText() {
        return driver.findElement( headingNoPhoneNumber).getText();
    }
    public  String getCaptchaText() {
        return driver.findElement(captcha).getText();
    }


    //https://account.mail.ru/signup/verify дождитесь звонка

}
