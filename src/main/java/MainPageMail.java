import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MainPageMail extends SignUpVerifyMail {
    private WebDriver driver;

    public MainPageMail(WebDriver driver) {
        this.driver = driver;
    }

    private By firstname = By.xpath("//input[@name='firstname']");
    private By lastname = By.xpath("//input[@name='lastname']");
    private By typeEmail = By.xpath("//span[@class='b-email__name']/input");
    private By EmailButton = By.xpath("//span[@class='b-email__domain']//div[@class='b-dropdown__ctrl']/div");
    private By typePassword = By.xpath("//div[@data-bem='b-password']/input");
    private By typePasswordRetry =By.xpath("//input[@id='passwordRetry']");
    private By additionalEmail = By.xpath("//div[@name='additional_email']");
    private By typePhone = By.xpath("//input[@name='phone.phone']");
    private By haveAMobilePhone = By.xpath("//div[@class='b-form-field__message']/a[text()='У меня есть мобильный телефон']");
    private By iDoNotHaveAMobilePhone = By.xpath("//div[@class='b-form-field__message']/a[text()='У меня нет мобильного телефона']");
    private By termsOfUse = By.xpath("//a[@href='https://help.mail.ru/mail-help/UA']");
    private By registrButton = By.xpath("//div[@class='b-form__controls b-form__controls_responsive b-form__controls_popup']//button");
    private By logoMail = By.cssSelector("//img[@class='b-header__img']");
    private By errorFirstname = By.xpath("//input[@name='firstname']/ancestor::div/following-sibling::div[@class='b-form-field__errors']");
    private By errorLastname = By.xpath("//input[@name='lastname']/ancestor::div/following-sibling::div[@class='b-form-field__errors']");
    private By errorEmail = By.xpath("//span[@class='b-email__name']/input/ancestor::div/following-sibling::div[@class='b-form-field__errors']");
    private By errorPassword = By.xpath("//div[@data-bem='b-password']/input/ancestor::div/following-sibling::div[@class='b-form-field__errors']");
    private By errorPasswordRetry =By.xpath("//input[@id='passwordRetry']/ancestor::div/following-sibling::div[@class='b-form-field__errors']");
    private By errorPhone = By.xpath("//input[@name='phone.phone']");



    public MainPageMail selectBirthDate (String day, int optionDay) {
        String listXpath = String.format("//div[@class='b-select__dropdown']//span[text()='%s']", day);
        String optionXpath = String.format(("//span[text()='%s']"), optionDay);
        driver.findElement(By.xpath(listXpath)).click();
        driver.findElement(By.xpath(optionXpath)).click();
        return null;
    }

    public MainPageMail selectBirthMonth (String month, String optionMonth) {
        String listXpath = String.format("//div[@class='b-select__dropdown']//span[text()='%s']", month);
        String optionXpath = String.format(("//span[text()='%s']"), optionMonth);
        driver.findElement(By.xpath(listXpath)).click();
        driver.findElement(By.xpath(optionXpath)).click();
        return null;
    }
    public MainPageMail selectBirthYear (String year, int optionYear) {
        String listXpath = String.format("//div[@class='b-select__dropdown']//span[text()='%s']", year);
        String optionXpath = String.format(("//span[text()='%s']"), optionYear);
        driver.findElement(By.xpath(listXpath)).click();
        driver.findElement(By.xpath(optionXpath)).click();
        return null;
    }
    public MainPageMail selectGender (String gender) {
        String listXpath = String.format(("//span[@class='b-radiogroup__text']/span[text()='%s']"), gender);
        driver.findElement(By.xpath(listXpath)).click();
        return null;
    }
    public MainPageMail typeName(String name) {
        driver.findElement(firstname).sendKeys(name);
        return this;
    }
    public MainPageMail typeSurname(String surname) {
        driver.findElement(lastname).sendKeys(surname);
        return this;
    }
    public MainPageMail typeEmail(String email) {
        driver.findElement(typeEmail).sendKeys(email);
        return this;
    }
    public MainPageMail selectEmail (String selectEmail) {
        String listXpath = String.format("//a[@data-value='%s']/span", selectEmail);
        driver.findElement(EmailButton).click();
        driver.findElement(By.xpath(listXpath)).click();
        return null;
    }
    public String errorLastnameGetText () {
        return driver.findElement(errorLastname).getText();
    }

    public String errorFirstnameGetText () {
        return driver.findElement(errorFirstname).getText();
    }

    public String errorEmailGetText () {
        return driver.findElement(errorEmail).getText();
    }
    public String errorPassworGetText () {
        return driver.findElement(errorPassword).getText();
    }
    public String errorPasswordRetryGetText () {
        return driver.findElement(errorPasswordRetry).getText();
    }
    public String  errorPhoneGetText () {
        return driver.findElement(errorPhone).getText();
    }

    public MainPageMail typePassword(String password) {
        driver.findElement(typePassword).sendKeys(password);
        return this;
    }
    public MainPageMail typePasswordRetry(String passwordRetry) {
        driver.findElement(typePasswordRetry).sendKeys(passwordRetry);
        return this;
    }
    public MainPageMail typePhone(String numberPhone) {
        driver.findElement(typePhone).sendKeys(numberPhone);
        return this;
    }
    public SignUpVerifyMail clickbutton() {
        driver.findElement(registrButton).click();
        return new SignUpVerifyMail(driver);
    }
    public TermsOfUseMail clickTermsOfUse(){
        driver.findElement(termsOfUse).click();
        for (String windowHandle : driver.getWindowHandles())
            driver.switchTo().window(windowHandle);
        return new TermsOfUseMail(driver);
    }



    public SignUpVerifyMail register (String firstname,
                                      String lastname,
                                      String day,
                                      int optionDay,
                                      String month,
                                      String optionMonth,
                                      String year,
                                      int optionYear,
                                      String gender,
                                      String emailName,
                                      String optionEmail,
                                      String password,
                                      String passwordRetry,
                                      String numberPhone) {
        this.typeName(firstname);
        this.typeSurname(lastname);
        this.selectBirthDate(day, optionDay);
        this.selectBirthMonth(month, optionMonth);
        this.selectBirthYear(year, optionYear);
        this.selectGender(gender);
        this.typeEmail(emailName);
        this.selectEmail(optionEmail);
        this.typePassword(password);
        this.typePasswordRetry(passwordRetry);
        this.typePhone(numberPhone);
        this.clickbutton();
        return new SignUpVerifyMail(driver);
    }








}
