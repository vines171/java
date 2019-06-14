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
                        "vishnevskaya",
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
    @Test
    public void signUpWithShortPassTest() {
        MainPageMail mp = mainPageMail.typePassword("asd");
        String error = mp.errorPassworGetText();
        Assert.assertEquals("Используйте не менее 8 символов", error);
    }
    @Test
    public void signUpWithLongPassTest() {
        MainPageMail mp = mainPageMail.typePassword("12345678910111213141516171819202122232425262728293031323334353637383940414243444546");
        String error = mp.errorPassworGetText();
        Assert.assertEquals("Используйте менее 40 символов", error);
    }
    @Test
    public void signUpWithPasswordSpecialCharactersTest() {
        MainPageMail mp = mainPageMail.typePassword("№№№#######*****");
        String error = mp.errorPassworGetText();
        Assert.assertEquals("Используйте только буквы (a–z, A–Z), цифры и символы ! @ # $ % ^ & * ( ) - _ + = ; : , . / ? \\ | ` ~ { }", error);
    }
    @Test
    public void signUpWithPasswordFromNumbersTest() {
        MainPageMail mp = mainPageMail.typePassword("12345678");
        String error = mp.errorPassworGetText();
        Assert.assertEquals("Используйте буквы (a-z, A-Z) и цифры", error);
    }
    @Test
    public void signUpWithAPasswordsOfLetterTest() {
        MainPageMail mp = mainPageMail.typePassword("cnjkjdfz");
        String error = mp.errorPassworGetText();
        Assert.assertEquals("Не используйте личные данные, последовательности (123456, qwerty) и популярные пароли (password).", error);
    }

    @Test
    public void signUpSpecialCharactersEmailTest() {
        MainPageMail mp = mainPageMail.typePassword("№№№#######*****");
        String error = mp.errorEmailGetText();
        Assert.assertEquals("Некорректное имя почтового ящика. Допустимо использовать только латинские буквы, цифры,\n" +
                "знак подчеркивания («_»), точку («.»), минус («-»)", error);
    }
    @Test
    public void signUpReservedEmailTest() {
        MainPageMail mp = mainPageMail.typePassword("vines");
        String error = mp.errorEmailGetText();
        Assert.assertEquals("Ящик с таким именем уже существует", error);
    }
    @After
    public void tearDown(){
        driver.quit();

    }


}
