package pageobjects; // переименовал
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.NoSuchElementException;

public class MainPageSamokat {
    // Тут элементы страницы и их локаторы

        private WebDriver driver;
        private By topOrderInButton = By.className("Button_Button__ra12g"); // Верхняя кнопка заказать
        private By downOrderInButton = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM"); // нижняя кнопка заказать
        private By cookieButtonLocator = By.id("rcc-confirm-button"); // локатор для нажатия на кнопку принятия куки



    // Часто задаваемые вопросы
    private By getVoprosLocator(int index) {
        return By.id("accordion__heading-" + index);
    }

    private By getOtvetLocator(int index) {
        return By.id("accordion__panel-" + index);
    }


    // Тут консруктор

    public MainPageSamokat(WebDriver driver) {
        this.driver = driver;
    }



    // Тут методы

    // клик по верхней кнопке "Заказать"
    public void clickTopOrderButton() {
        driver.findElement(topOrderInButton).click();
    }

    // клик по нижней кнопке "Заказать"
    public void clickDownOrderButton() {
        driver.findElement(downOrderInButton).click();
    }

      // Метот для нажатия на кнопку принятия куки
    public void acceptCookies() {
        try {
            WebElement cookieButton = driver.findElement(cookieButtonLocator);
            cookieButton.click();
        } catch (NoSuchElementException e) {
            // Кнопка cookie не найдена (возможно, она уже была нажата или ее нет на этой странице)
            System.out.println("Кнопка cookie не найдена: " + e.getMessage());
        }
    }

    // Метод для клика по вопросу по индексу
    public void clickQuestion(int index) {
        driver.findElement(getVoprosLocator(index)).click();
    }

    // Метод для получения текста ответа по индексу
    public String getAnswerText(int index) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Используем Duration
        WebElement answerElement = wait.until(ExpectedConditions.visibilityOfElementLocated(getOtvetLocator(index)));
        return answerElement.getText();
    }

}
