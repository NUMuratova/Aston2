package lesson10;

import net.bytebuddy.implementation.InvokeDynamic;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MTSPaymentPage;
import static org.assertj.core.api.Assertions.assertThat;

class PaymentTest {

    private static WebDriver driver;
    private static MTSPaymentPage mtspage;

    @BeforeAll
    public static void setUpClass() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        mtspage = new MTSPaymentPage(driver);
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void testOnlinePaymentWithoutCommission() throws InterruptedException {
        driver.get("https://www.mts.by/");

        driver.findElement(By.linkText("Пополнить баланс")).click();

        Thread.sleep(2000);

        mtspage.fillServiceDetails("+37529XXXXXXX", "10"); // Номер телефона и сумма для примера
        mtspage.clickContinue();

        Thread.sleep(2000);

        assertThat(mtspage.getPhoneNumberText()).as("Неверный номер телефона").isEqualTo("+37529XXXXXXX");

        assertThat(mtspage.getPaymentAmountText()).as("Сумма неверна").startsWith("10 руб.");

        assertThat(mtspage.isCardHolderEmptyLabelVisible()).as("Отсутствует предупреждение о незаполненном имени держателя карты").isTrue();
        assertThat(mtspage.isCardNumberEmptyLabelVisible()).as("Отсутствует предупреждение о незаполненном номере карты").isTrue();

        assertThat(mtspage.arePaymentSystemIconsPresent()).as("Иконки платежной системы отсутствуют").isTrue();
    }
}
