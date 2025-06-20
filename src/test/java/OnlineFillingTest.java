import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertTrue;

public class OnlineFillingTest {

    public static WebDriver driver;

    @BeforeClass
    public static void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();

        driver.get("https://www.mts.by/");
        driver.manage().window().maximize();
        OnlineFillingTest.driver.findElement(By.cssSelector("#cookie-agree")).click();
    }

    @Test
    public void testBlockTitle() {
        String blockTitle = driver.findElement(By.xpath("//h2[contains(text(), 'Онлайн пополнение')]")).getText();
        assertTrue(blockTitle.contains("Онлайн пополнение"));
    }

    @Test
    public void testServiceLink() {
        driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/a")).click();
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains("/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"));
    }

    @AfterClass
    public static void tearDown() throws Exception {
        if(driver != null){
            driver.quit();
        }
    }
}