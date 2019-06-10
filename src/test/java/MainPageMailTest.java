import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MainPageMailTest<driver> {

    private WebDriver driver;
    private MainPageMail mainPageMail;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ira\\testselenium\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //driver.manage().window().maximize();
        driver.get("https://account.mail.ru/signup?from=main&rf=auth.mail.ru");
        mainPageMail = new MainPageMail(driver);
    }

    @Test
    //@Ignore
    public void validRegisterTest() {
        SignUpVerifyMail signUpVerifyMail = mainPageMail
                .register("irina",
                        "",
                        "2",
                        3,
                        "Месяц",
                        "Апрель",
                        "Год",
                        1992,
                        "Женский",
                        "vines5392",
                        "list.ru",
                        "detepo811",
                        "detepo811",
                        "9254035392"
                );
        WebElement explicitWait = new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='b-panel__header']/span[text()='Дождитесь звонка']")));
        String heading = signUpVerifyMail.getHeadingHaveAPhoneNumberText();
        Assert.assertEquals("Дождитесь звонка", heading);
    }

    @Test
    @Ignore
    public void clickTermsOfUseTest() {
        TermsOfUseMail termsOfUseMail = mainPageMail.clickTermsOfUse();
        String heading = termsOfUseMail.getHeadingTermsOfUseText();
        Assert.assertEquals("Пользовательское Соглашение", heading);
    }
    @After
    public void tearDown(){
        driver.quit();

    }


}
