import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class TestMTSPageObject {
    private WebDriver driver;
    private WebDriverWait wait;

    public TestMTSPageObject(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    private By bepaidIframe = By.cssSelector("iframe[src*='bepaid']");
    private By labelNumber = By.xpath("//div[contains(@class,'content')]//label[contains(text(),'Номер карты')]");
    private By labelExpiry = By.xpath("//div[contains(@class,'content')]//label[contains(text(),'Срок действия')]");
    private By labelCvc = By.xpath("//div[contains(@class,'content')]//label[contains(text(),'CVC')]");
    private By labelNameSurname = By.xpath("//div[contains(@class,'content')]//label[contains(text(),'Имя и фамилия на карте')]");
    private By payButton = By.xpath("//div[contains(@class,'card-page__card')]//button");
    private By paymentIcons = By.cssSelector("div.cards-brands img");
    private By connectionPhoneField = By.id("connection-phone");
    private By connectionSumField = By.id("connection-sum");
    private By connectionContinueButton = By.xpath("//form[@id='pay-connection']//button");
    private By bepaidContainer = By.cssSelector("div[class*='bepaid']");
    private By cardNumberField = By.cssSelector("input[name='number']");
    private By expiryField = By.cssSelector("input[name='expiry']");
    private By cvcField = By.cssSelector("input[name='cvc']");
    private By visaIcon = By.cssSelector("img[src*='visa']");
    private By mastercardIcon = By.cssSelector("img[src*='mastercard']");
    private By blockTitle = By.xpath("//div[@class='pay__wrapper']//h2");
    private By logosImages = By.cssSelector("div.pay__partners img");
    private By moreDetailsLink = By.xpath("//section[@class='pay']//a");
    private By breadcrumb = By.xpath("//div[@class='breadcrumbs__wrapper']//ul//li[3]//span[@itemprop='name']");
    private By sumPreview = By.xpath("//div[@class='pay-description__cost']//span");
    private By phonePreview = By.xpath("//div[@class='pay-description__text']//span");
    private By serviceDropdown = By.xpath("//button[@class='select__header']");
    private By dropdownOptions = By.xpath("//div[@class='select__wrapper opened']//ul//li");

    public void openServiceDropdown() {
        wait.until(ExpectedConditions.elementToBeClickable(serviceDropdown)).click();
    }

    public void selectServiceByName(String serviceName) {
        openServiceDropdown();
        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(dropdownOptions));
        for (WebElement option : options) {
            if (option.getText().trim().equals(serviceName)) {
                option.click();
                return;
            }
        }
        throw new NoSuchElementException("Сервис с названием '" + serviceName + "' не найден в меню");
    }

    public String getFormIdByServiceName(String serviceName) {
        switch (serviceName) {
            case "Услуги связи":
                return "pay-connection";
            case "Домашний интернет":
                return "pay-internet";
            case "Рассрочка":
                return "pay-instalment";
            case "Задолженность":
                return "pay-arrears";
            default:
                throw new IllegalArgumentException("Unknown service: " + serviceName);
        }
    }

    public List<String> getAllVisiblePlaceholders() {
        List<WebElement> inputs = driver.findElements(By.cssSelector("form#pay-connection input[placeholder]"));
        List<String> placeholders = new ArrayList<>();

        for (WebElement input : inputs) {
            String placeholder = input.getAttribute("placeholder");
            placeholders.add(placeholder);
        }
        return placeholders;
    }

    private By[] placeholders = new By[]{
            By.xpath("//input[@id='connection-phone']"),
            By.xpath("//input[@id='connection-sum']"),
            By.xpath("//input[@id='connection-email']"),
    };

    public String getBlockTitleText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(blockTitle)).getText();
    }

    public boolean hasLogos() {
        List<WebElement> logos = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(logosImages));
        return !logos.isEmpty();
    }

    public void clickMoreDetailsLink() {
        wait.until(ExpectedConditions.elementToBeClickable(moreDetailsLink)).click();
    }

    public String getBreadcrumbText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(breadcrumb)).getText();
    }

    public String getPlaceholder(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator)).getAttribute("placeholder");
    }

    public void fillConnectionForm(String phone, String sum) {
        wait.until(ExpectedConditions.elementToBeClickable(connectionPhoneField)).sendKeys(phone);
        wait.until(ExpectedConditions.elementToBeClickable(connectionSumField)).sendKeys(sum);
    }

    public void submitConnectionForm() {
        wait.until(ExpectedConditions.elementToBeClickable(connectionContinueButton)).click();
    }

    public boolean isBepaidVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(bepaidContainer)).isDisplayed();
    }

    public boolean areCardFieldsVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cardNumberField)).isDisplayed()
                && wait.until(ExpectedConditions.visibilityOfElementLocated(expiryField)).isDisplayed()
                && wait.until(ExpectedConditions.visibilityOfElementLocated(cvcField)).isDisplayed();
    }

    public boolean arePaymentIconsVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(visaIcon)).isDisplayed()
                && wait.until(ExpectedConditions.visibilityOfElementLocated(mastercardIcon)).isDisplayed();
    }

    public String getSumPreview() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(sumPreview)).getText();
    }

    public String getPhonePreview() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(phonePreview)).getText();
    }

    public By[] getPlaceholders() {
        return placeholders;
    }

    public void switchToPaymentIframe() {
        WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(bepaidIframe));
        driver.switchTo().frame(iframe);
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    public String getLabelNumberText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(labelNumber)).getText();
    }
    public String getLabelExpiryText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(labelExpiry)).getText();
    }
    public String getLabelCvcText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(labelCvc)).getText();
    }
    public String getLabelNameSurnameText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(labelNameSurname)).getText();
    }

    public String getPayButtonText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(payButton)).getText().trim();
    }

    public int getPaymentIconsCount() {
        List<WebElement> icons = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(paymentIcons, 4));
        return icons.size();
    }
}