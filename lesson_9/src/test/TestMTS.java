import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestMTS {
    private static WebDriver driver;
    private static WebDriverWait wait;
    private static final String titleXPath = "//div[@class='pay__wrapper']//h2";
    private static final String linkXPath = "//div[@class='breadcrumbs__wrapper']//ul//li[3]//span[@itemprop='name']";

    @BeforeAll
    public static void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.get("https://www.mts.by/");
        try {
            WebElement cookieButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[@class='cookie show']//button[@id='cookie-agree']")));
            if (cookieButton.isDisplayed()) {
                cookieButton.click();
            }
        } catch (TimeoutException e) {

        }
    }

    @Test
    @Order(1)
    public void blockTitleTest() {
        WebElement blockTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(titleXPath)));
        String text = blockTitle.getText();
        assertTrue(text.contains("Онлайн пополнение"));
        assertTrue(text.contains("без комиссии"));
    }

    @Test
    @Order(2)
    public void logoTest() {
        WebElement logosBlock = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("div.pay__partners")));

        List<WebElement> logos = logosBlock.findElements(By.tagName("img"));

        Assertions.assertFalse(logos.isEmpty(), "Логотипы платёжных систем не найдены на странице");
    }

    @Test
    @Order(3)
    public void linkTest() {
        WebElement moreDetailsLink = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//section[@class='pay']//a")));
        moreDetailsLink.click();
        WebElement breadcrumb = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(linkXPath)));
        Assertions.assertEquals("Порядок оплаты и безопасность интернет платежей", breadcrumb.getText());
    }

    @Test
    @Order(4)
    public void formTest() {
        driver.get("https://www.mts.by/");

        try {
            WebElement cookieButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[@class='cookie show']//button[@id='cookie-agree']")));
            if (cookieButton.isDisplayed()) {
                cookieButton.click();
            }
        } catch (TimeoutException e) {

        }

        WebElement numberField = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("input[id='connection-phone']")));
        numberField.sendKeys("297777777");

        WebElement amountField = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("input[id='connection-sum']")));
        amountField.sendKeys("5");

        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//form[@id='pay-connection']//button")));
        continueButton.click();

        WebElement bepaidDiv = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("div[class*='bepaid']")
        ));

        assertTrue(bepaidDiv.isDisplayed());
    }
}
