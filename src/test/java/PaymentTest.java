import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class PaymentTest {
    public static WebDriver driver;

    @BeforeClass
    public static void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.mts.by/");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("#cookie-agree")).click();
    }

    @Test
    public void testOnlinePaymentPlaceholders() {

        WebElement onlinePaymentBlock = driver.findElement(By.xpath("//h2[contains(text(), 'Онлайн пополнение')]"));
        onlinePaymentBlock.click();

        WebElement variants = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button"));
        variants.click();

        WebElement connectionServicesInput = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[1]/p"));
        assert connectionServicesInput.getText().equals("Услуги связи");

        WebElement homeInternetInput = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[2]/p"));
        assert homeInternetInput.getText().equals("Домашний интернет");

        WebElement installmentInput = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[3]/p"));
        assert installmentInput.getText().equals("Рассрочка");

        WebElement debtInput = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[4]/p"));
        assert debtInput.getText().equals("Задолженность");
    }
    @AfterClass
    public static void tearDown() throws Exception {
        if(driver != null){
            driver.quit();
        }
    }
}