package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MTSPaymentPage {

    private final WebDriver driver;

    @FindBy(id = "serviceNumber")
    private WebElement serviceNumberField;

    @FindBy(name = "amount")
    private WebElement amountField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement continueButton;

    @FindBy(css = ".payment-info__number")
    private WebElement phoneNumberInfo;

    @FindBy(css = ".payment-info__sum")
    private WebElement paymentAmountInfo;

    public MTSPaymentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillServiceDetails(String number, String amount) {
        serviceNumberField.sendKeys(number);
        amountField.sendKeys(amount);
    }

    public void clickContinue() {
        continueButton.click();
    }

    public String getPhoneNumberText() {
        return phoneNumberInfo.getText().trim();
    }

    public String getPaymentAmountText() {
        return paymentAmountInfo.getText().trim();
    }

    public boolean isCardHolderEmptyLabelVisible() {
        return driver.findElement(By.cssSelector(".card-holder.empty")).isDisplayed();
    }

    public boolean isCardNumberEmptyLabelVisible() {
        return driver.findElement(By.cssSelector(".card-number.empty")).isDisplayed();
    }

    public boolean arePaymentSystemIconsPresent() {
        try {
            driver.findElement(By.xpath("//img[contains(@alt,'Visa')]"));
            driver.findElement(By.xpath("//img[contains(@alt,'MasterCard')]"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}