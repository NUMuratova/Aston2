import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OnlineFillingTest {

    private WebDriverWait wait;
    private WebDriver driver;

    @BeforeMethod

    public static void main (String[] args) {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get ("https://google.com");
    }
    public void setUp() {
        wait = new WebDriverWait(driver, 10);
        driver.get("https://mts.by");
    }

    @Test
    public void testOnlineFilling() {
        WebElement blockTitle = driver.findElement(By.xpath("//h2[contains(text(), 'Онлайн пополнение без комиссии')]"));
        Assert.assertTrue(blockTitle.isDisplayed(), "Блок 'Онлайн пополнение без комиссии' не найден");

        WebElement visaLogo = driver.findElement(By.xpath("//img[@alt='Visa']"));
        WebElement mastercardLogo = driver.findElement(By.xpath("//img[@alt='MasterCard']"));
        Assert.assertTrue(visaLogo.isDisplayed(), "Логотип Visa не найден");
        Assert.assertTrue(mastercardLogo.isDisplayed(), "Логотип MasterCard не найден");

        WebElement moreInfoLink = driver.findElement(By.xpath("//a[contains(text(), 'Подробнее о сервисе')]"));
        moreInfoLink.click();
        wait.until(ExpectedConditions.titleContains("Подробнее о сервисе"));
        Assert.assertTrue(driver.getTitle().contains("Подробнее о сервисе"), "Ссылка 'Подробнее о сервисе' не работает");

        WebElement inputField = driver.findElement(By.id("inputFieldId"));
        inputField.sendKeys("2977777777");
        WebElement continueButton = driver.findElement(By.id("continueButtonId"));
        continueButton.click();
        wait.until(ExpectedConditions.titleContains("Услуги связи"));
        Assert.assertTrue(driver.getTitle().contains("Услуги связи"), "Кнопка 'Продолжить' не работает");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
