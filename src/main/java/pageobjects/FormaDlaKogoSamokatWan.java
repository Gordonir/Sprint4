package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class FormaDlaKogoSamokatWan {
    // Тут нужные элементы страницы и их локаторы

    private WebDriver driver;
    private By nameField = By.xpath("//input[@placeholder='* Имя']"); // Поле имя
    private By familyField = By.xpath("//input[@placeholder='* Фамилия']"); // Поле фамилия
    private By addresField = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']"); // Поле адрес
    private By metroField = By.xpath("//input[@placeholder='* Станция метро']"); // Поле станция метро
    private By phoneField = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']"); // поле номер телфона
    private By nextButton = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM"); // Верхняя кнопка заказать

    // Тут консруктор

    public FormaDlaKogoSamokatWan(WebDriver driver) {
        this.driver = driver;
    }

    //Тут методы
    // Заполнить имя
    public void setName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    // Заполнить фамилию
    public void setFamily(String family) {
        driver.findElement(familyField).sendKeys(family);
    }

    // Заполнить адрес
    public void setAddress(String address) {
        driver.findElement(addresField).sendKeys(address);
    }

    // Заполнить станцию метро
    public void setMetro(String metro) {
        driver.findElement(metroField).click(); // Кликаем на поле, чтобы открыть список
        driver.findElement(metroField).sendKeys(metro); // Вводим название станции

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // ждем пока появится список станций
        By specificMetroStation = By.xpath("//li[@class='select-search__row']//button[@class='Order_SelectOption__82bhS select-search__option']//div[@class='Order_Text__2broi' and text()='" + metro + "']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(specificMetroStation));
        driver.findElement(specificMetroStation).click();
    }


    // Заполнить номер телефона
    public void setphone(String phone) {
        driver.findElement(phoneField).sendKeys(phone);
    }

    // Кликнуть по кнопке далее
    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }
}