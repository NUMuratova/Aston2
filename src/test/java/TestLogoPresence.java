import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestLogoPresence {

    public static WebDriver driver;

    @BeforeClass
    public static void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();
    }

    @Test
    public void testLogoPresence() throws Exception{
        driver.get("https://www.mts.by/");
        TestLogoPresence.driver.findElement(By.cssSelector("#cookie-agree")).click();
        driver.manage().window().maximize();

        boolean visaLogoPresent = driver.findElements(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[1]/img")).size() > 0;
        boolean mastercardLogoPresent = driver.findElements(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[3]/img")).size() > 0;
        boolean belkartLogoPresent = driver.findElements(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[5]/img")).size() > 0;

        assertTrue("Логотип Visa отсутствует на странице.", visaLogoPresent);
        assertTrue("Логотип Visa отсутствует на странице.", mastercardLogoPresent);
        assertTrue("Логотип Visa отсутствует на странице.", belkartLogoPresent);
    }
}