import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class TestFormSubmission2 {
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
    public void testFormSubmission() {
        WebElement onlinePaymentBlock = driver.findElement(By.xpath("//h2[contains(text(), 'Онлайн пополнение')]"));
        onlinePaymentBlock.click();
        driver.findElement(By.xpath("//*[@id=\"connection-phone\"]")).sendKeys("297777777");
        driver.findElement(By.xpath("//*[@id=\"connection-sum\"]")).sendKeys("100");
        driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button")).click();

        boolean confirmationPageShown = driver.findElements(By.xpath("/html/body/app-root/div/div")).size() > 0;
        assertTrue(confirmationPageShown);

        WebElement summ = driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/div/div[1]/div[1]/span"));
        assert summ.getText().equals("100.00 BYN");

        WebElement summButton = driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/button"));
        assert summButton.getText().equals("Оплатить 100.00 BYN");

        WebElement phoneNumber = driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/div/div[2]/span"));
        assert phoneNumber.getText().equals("Оплата: Услуги связи Номер:375297777777");

        WebElement cardNumber = driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[1]/label"));
        assert cardNumber.getText().equals("Номер карты");

        WebElement duration = driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[2]/div[1]/app-input/div/div/div[1]/label"));
        assert duration.getText().equals("Срок действия");

        WebElement cvc = driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[2]/div[3]/app-input/div/div/div[1]/label"));
        assert cvc.getText().equals("CVC");

        WebElement cardholderName = driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[3]/app-input/div/div/div[1]/label"));
        assert cardholderName.getText().equals("Имя и фаилия на карте");

        boolean cardbrandVisaShown = driver.findElements(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div/img[1]")).size() > 0;
        assertTrue(cardbrandVisaShown);

        boolean cardbrandMastercardShown = driver.findElements(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div/img[2]")).size() > 0;
        assertTrue(cardbrandMastercardShown);

        boolean cardbrandBelkartShown = driver.findElements(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div/img[3]")).size() > 0;
        assertTrue(cardbrandBelkartShown);

        boolean cardbrandMirShown = driver.findElements(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div/div/img[1]")).size() > 0;
        assertTrue(cardbrandMirShown);
    }
}
