package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class FormaObArenda {

    // Тут элементы страницы и их локаторы

    private WebDriver driver;
    private By dateField = By.xpath("//input[@placeholder='* Когда привезти самокат']"); // Поле дата когда привезти самокат

    private By termField = By.cssSelector(".Dropdown-control"); // Поле "Срок аренды"
    private By oneDay = By.xpath("//div[@class='Dropdown-option' and text()='сутки']"); // 1 сутки
    private By twoDay = By.xpath("//div[@class='Dropdown-option' and text()='двое суток']"); // 2 дня
    private By threeDay = By.xpath("//div[@class='Dropdown-option' and text()='трое суток']");// 3 дня
    private By fourDay = By.xpath("//div[@class='Dropdown-option' and text()='четверо суток']"); // 4 дня
    private By fiveDay = By.xpath("//div[@class='Dropdown-option' and text()='пятеро суток']"); // 5 дней
    private By sixDay = By.xpath("//div[@class='Dropdown-option' and text()='шестеро суток']"); // 6 дней
    private By sevenDay = By.xpath("//div[@class='Dropdown-option' and text()='семеро суток']"); // 7 дней

    private By blackColorCheckbox = By.xpath("//label[@for='black']"); // чек-бокс черный цвет
    private By greyColorCheckbox = By.xpath("//label[@for='grey']"); // чек-бокс серый цвет
    private By comentField = By.xpath("//input[@placeholder='Комментарий для курьера']"); // поле комментарий для курьера
    private By orderButton = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button[2]");
    private By orderConfirmationMessage = By.xpath("//div[@class='Order_ModalHeader__3FDaJ']"); // Локатор для сообщения об успешном заказе
    private String expectedConfirmationMessage = "Заказ оформлен"; // Ожидаемый текст сообщения// кнопка заказать
    By confirmButton = By.xpath("//button[text()='Да']"); // Кнопка да на форме подверждения

    // Тут консруктор

    public FormaObArenda (WebDriver driver) {
        this.driver = driver;
    }

    // Тут методы
    // Заполнить дату
    public void setDate(String date) {
        driver.findElement(dateField).click(); // Кликаем на поле даты, чтобы открыть календарь
        driver.findElement(dateField).sendKeys(date); //Вводим дату в поле

        // Разбить дату на день, месяц и год
        String[] dateParts = date.split("\\.");
        String day = dateParts[0]; // Получаем день

        // XPath для конкретного дня
        By specificDay = By.xpath("//div[contains(@class, 'react-datepicker__day') and text()='" + day + "']");

        // Ожидание для конкретного дня
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dayElement = wait.until(ExpectedConditions.elementToBeClickable(specificDay));

        dayElement.click(); // Клик на конкретный день в календаре
    }

    // Метод для параметризованного выбора срока аренды
    public void selectDays(String days) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Явное ожидание

        //  Клик на поле "Срок аренды"
        WebElement termFieldElement = wait.until(ExpectedConditions.elementToBeClickable(termField));
        termFieldElement.click();

        By dayLocator = null;

        // Определить локатор для выбора срока
        switch (days) {
            case "сутки":
                dayLocator = oneDay;
                break;
            case "двое суток":
                dayLocator = twoDay;
                break;
            case "трое суток":
                dayLocator = threeDay;
                break;
            case "четверо суток":
                dayLocator = fourDay;
                break;
            case "пятеро суток":
                dayLocator = fiveDay;
                break;
            case "шестеро суток":
                dayLocator = sixDay;
                break;
            case "семеро суток":
                dayLocator = sevenDay;
                break;
            default:
                throw new IllegalArgumentException("Недопустимый срок аренды: " + days);
        }

        // Выбор срока из списка
        if (dayLocator != null) {
            WebElement dayElement = wait.until(ExpectedConditions.elementToBeClickable(dayLocator));
            dayElement.click();
        }
    }


    // Метод для параметризованного выбора цвета
    public void selectColor(String color) {
        if (color.equals("чёрный жемчуг")) {
            WebElement blackCheckbox = driver.findElement(blackColorCheckbox);
            if (!blackCheckbox.isSelected()) { // Проверяем, что чекбокс не выбран
                blackCheckbox.click();
            }
        } else if (color.equals("серая безысходность")) {
            WebElement greyCheckbox = driver.findElement(greyColorCheckbox);
            if (!greyCheckbox.isSelected()) { // Проверяем, что чекбокс не выбран
                greyCheckbox.click();
            }
        } else {
            throw new IllegalArgumentException("Недопустимый цвет: " + color);
        }
    }
    // Заполнение поля комментарий
    public void setСoment(String Сoment) {
        driver.findElement(comentField).sendKeys(Сoment);
    }
    // клик по кнопке заказать
    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }
    // Метод для клика на кнопку "Да" в форме подтверждения
    public void clickConfirmButton() {
        // Ожидание появления кнопки подтверждения заказа
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement confirmButtonElement = wait.until(ExpectedConditions.elementToBeClickable(confirmButton));

        // Клик на кнопку подтверждения заказа
        confirmButtonElement.click();
    }

    // Метод для проверки видимости сообщения об успешном заказе
    public boolean isOrderConfirmationMessageVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            return wait.until(ExpectedConditions.textToBePresentInElementLocated(orderConfirmationMessage, expectedConfirmationMessage));
        } catch (org.openqa.selenium.TimeoutException e) {
            return false; // Сообщение не появилось за отведенное время
        }
    }
}
