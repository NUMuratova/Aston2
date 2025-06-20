import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class TestFormSubmission {
    public static WebDriver driver;

    @BeforeClass
    public static void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();
    }


    @Test
    public void testFormSubmission() {
        driver.get("https://www.mts.by/");
        TestFormSubmission.driver.findElement(By.cssSelector("#cookie-agree")).click();
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"connection-phone\"]")).sendKeys("297777777");
        driver.findElement(By.xpath("//*[@id=\"connection-sum\"]")).sendKeys("100");
        driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button")).click();

        boolean confirmationPageShown = driver.findElements(By.xpath("/html/body/app-root/div/div")).size() > 0;
        assertTrue(confirmationPageShown);
    }
}