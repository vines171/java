import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TermsOfUseMail {
    private WebDriver driver;

    public TermsOfUseMail(WebDriver driver) {
        this.driver = driver;
    }
    private By headingTermsOfUse = By.xpath("//div[@class='cell cell_middle']/div");

   public String getHeadingTermsOfUseText() {
       return driver.findElement(headingTermsOfUse).getText();

   }







}