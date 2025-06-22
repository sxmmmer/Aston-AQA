import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ModifiedTestMTS {
    private static WebDriver driver;
    private static WebDriverWait wait;
    private static TestMTSPageObject mtsPage;

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.get("https://www.mts.by/");
        mtsPage = new TestMTSPageObject(driver, wait);

        try {
            WebElement cookieButton = driver.findElement(By.xpath("//div[@class='cookie show']//button[@id='cookie-agree']"));
            if (cookieButton.isDisplayed()) cookieButton.click();
        } catch (NoSuchElementException ignored) {}
    }

    @Test
    @Order(1)
    public void testBlockTitle() {
        String title = mtsPage.getBlockTitleText();
        assertTrue(title.contains("Онлайн пополнение"));
        assertTrue(title.contains("без комиссии"));
    }

    @Test
    @Order(2)
    public void testLogosPresence() {
        assertTrue(mtsPage.hasLogos(), "Логотипы платёжных систем не найдены.");
    }

    @Test
    @Order(3)
    public void testMoreDetailsNavigation() {
        mtsPage.clickMoreDetailsLink();
        String breadcrumb = mtsPage.getBreadcrumbText();
        assertEquals("Порядок оплаты и безопасность интернет платежей", breadcrumb);
    }

    @Test
    @Order(4)
    public void testPlaceholdersForAllServices() {
        driver.get("https://www.mts.by/");

        String[][] servicesAndPlaceholders = {
                {"Услуги связи", "Номер телефона", "Сумма", "E-mail для отправки чека"},
                {"Домашний интернет", "Номер абонента", "Сумма", "E-mail для отправки чека"},
                {"Рассрочка", "Номер счета на 44", "Сумма", "E-mail для отправки чека"},
                {"Задолженность", "Номер счета на 2073", "Сумма", "E-mail для отправки чека"}
        };

        for (String[] service : servicesAndPlaceholders) {
            String serviceName = service[0];
            String[] expectedPlaceholders = Arrays.copyOfRange(service, 1, service.length);
            mtsPage.selectServiceByName(serviceName);
            String formId = mtsPage.getFormIdByServiceName(serviceName);
            List<WebElement> inputs = driver.findElements(By.cssSelector("form#" + formId + " input[placeholder]"));
            for (int i = 0; i < inputs.size(); i++) {
                String actualPlaceholder = inputs.get(i).getAttribute("placeholder");
                assertEquals(expectedPlaceholders[i], actualPlaceholder,
                        "Плейсхолдер не совпадает для сервиса " + serviceName + " в поле " + (i + 1));
            }
        }
    }

    @Test
    @Order(5)
    public void testConnectionPaymentPreview() {
        mtsPage.selectServiceByName("Услуги связи");
        String testPhone = "297777777";
        String testSum = "5";
        mtsPage.fillConnectionForm(testPhone, testSum);
        mtsPage.submitConnectionForm();
        mtsPage.switchToPaymentIframe();
        String previewSum = mtsPage.getSumPreview();
        assertTrue(previewSum.contains(testSum), "Сумма отображается некорректно: " + previewSum);
        String previewPhone = mtsPage.getPhonePreview();
        assertTrue(previewPhone.contains(testPhone), "Номер телефона отображается некорректно: " + previewPhone);
        assertEquals("Номер карты", mtsPage.getLabelNumberText(), "Текст лейбла для поля 'Номер карты' некорректный");
        assertEquals("Срок действия", mtsPage.getLabelExpiryText(), "Текст лейбла для поля 'Срок действия' некорректный");
        assertEquals("CVC", mtsPage.getLabelCvcText(), "Текст лейбла для поля 'CVC' некорректный");
        assertEquals("Имя и фамилия на карте", mtsPage.getLabelNameSurnameText(), "Текст лейбла для поля 'Имя и фамилия на карте' некорректный");
        assertEquals("Оплатить " + testSum + ".00 BYN", mtsPage.getPayButtonText(), "Сумма на кнопке 'Оплатить' некорректная");
        assertEquals(5, mtsPage.getPaymentIconsCount(), "Должно отображаться 4 иконки платёжных систем");
        mtsPage.switchToDefaultContent();
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) driver.quit();
    }
}
