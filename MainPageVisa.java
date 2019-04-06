import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPageVisa {
    //public MainPageVisa typeSurname;
    private WebDriver driver;

    public MainPageVisa(WebDriver driver) {
        this.driver = driver;
    }

    private By surnameField = By.xpath("//input[@id='last_name']");

    private By nameField = By.xpath("//input[@id='first_name']");

    private By buttonNext = By.xpath("//a[@id='btnNext0']");

    private By buttonDay = By.xpath("//select[@id='date_of_birth_day']");

    private By buttonMonth = By.xpath("//select[@id='date_of_birth_month']");

    private By buttonYear = By.xpath("//select[@id='date_of_birth_year']");

    private By countryOfCitizenship = By.xpath("//select[@id='country_of_citizenship']");

    private By countryOfBirth = By.xpath("//select[@id='country_of_birth']");

    private By genderMan = By.xpath("//input[@id='radio-gender-male']");

    private By genderWoman = By.xpath("//input[@id='radio-gender-female']");

    private By heading = By.xpath("//div[contains(text(), 'Подать')]");




    public String getHeadingText() {
        return driver.findElement(heading).getText();
    }


    public MainPageVisa selectDay(String day){
        String listXpath = String.format("//select[@id='date_of_birth_day']/option[text()='%s']", day);
        driver.findElement(By.xpath(listXpath)).click();
        return null;
    }
    public  MainPageVisa selectYear(String year){
        String listXpath = String.format("//select[@id='date_of_birth_year']/option[text()='%s']", year);
        driver.findElement(By.xpath(listXpath)).click();
        return null;
    }
    public MainPageVisa selectMonth(String month){
        String listXpath = String.format("//select[@id='date_of_birth_month']//option[text()='%s']", month);
        driver.findElement(By.xpath(listXpath)).click();
        return null;
    }

    public MainPageVisa selectOptionCountryOfBirth(String optionCountryOfBirth) {
       String listXpath = String.format("//select[@id='country_of_birth']/option[contains(text(), '%s')]", optionCountryOfBirth);
        driver.findElement(By.xpath(listXpath)).click();
        return null;
    }



    public  MainPageVisa selectOptionCountryOfCitizenship(String optionCountryOfCitizenship) {
        String listXpath = String.format("//select[@id='country_of_citizenship']/option[@data-country='%s']", optionCountryOfCitizenship);
        driver.findElement(By.xpath(listXpath)).click();
        return null;
    }


    public MainPageVisa typeSurname(String surname) {
        driver.findElement(surnameField).sendKeys(surname);
        return this;
    }

    public MainPageVisa typeName(String name) {
        driver.findElement(nameField).sendKeys(name);
        return this;
    }

    public MainPageVisa choicegenderMan() {
        driver.findElement(genderMan).click();
        return this;
    }
    public MainPageVisa choicegenderWoman() {
        driver.findElement(genderWoman).click();
        return this;
    }
    public ApplyPageVisa clickbuttonNext() {
        driver.findElement(buttonNext).click();
        return new ApplyPageVisa(driver);
    }

    public ApplyPageVisa register(String name,String surname, String optionCountryOfCitizenship, String optionCountryOfBirth, String day, String month, String year){
        this.typeName(name);
        this.typeSurname(surname);
        this.selectOptionCountryOfBirth(optionCountryOfBirth);
        this.selectOptionCountryOfCitizenship(optionCountryOfCitizenship);
        this.selectDay(day);
        this.selectMonth(month);
        this.selectYear(year);
        this.choicegenderMan();
        this.clickbuttonNext();
        return new ApplyPageVisa(driver);

    }



}









