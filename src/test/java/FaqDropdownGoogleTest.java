import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.MainPageSamokat;
import org.junit.Assert;
import java.time.Duration;

public class FaqDropdownGoogleTest {

    private WebDriver driver;
    private MainPageSamokat mainPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Андрей\\.cache\\selenium\\chromedriver\\win64\\133.0.6943.98\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        mainPage = new MainPageSamokat(driver);
    }

    @Test
    public void testFaqDropdown() {
        //  Вопросы
        WebElement[] questions = {
                mainPage.getPerviyVopros(),
                mainPage.getVtoroyVopros(),
                mainPage.getTretiyVopros(),
                mainPage.getChetvertyiyVopros(),
                mainPage.getPiatiyVopros(),
                mainPage.getShestoyVopros(),
                mainPage.getSedmoyVopros(),
                mainPage.getVosmoyVopros()
        };

        // Ответы
        WebElement[] answers = {
                mainPage.getOtvetNaPerviyVopros(),
                mainPage.getOtvetNaVtoroyVopros(),
                mainPage.getOtvetNaTretiyVopros(),
                mainPage.getOtvetNaChetvertyiyVopros(),
                mainPage.getOtvetNaPiatiyVopros(),
                mainPage.getOtvetNaShestoyVopros(),
                mainPage.getOtvetNaSedmoyVopros(),
                mainPage.getOtvetNaVosmoyVopros()
        };

        // 3. Ожидаемые ответы
        String[] expectedAnswers = {
                mainPage.getExpectedAnswer1(),
                mainPage.getExpectedAnswer2(),
                mainPage.getExpectedAnswer3(),
                mainPage.getExpectedAnswer4(),
                mainPage.getExpectedAnswer5(),
                mainPage.getExpectedAnswer6(),
                mainPage.getExpectedAnswer7(),
                mainPage.getExpectedAnswer8()
        };

        //  проход по всем вопросам
        for (int i = 0; i < questions.length; i++) {
            // 5. Получите элемент вопроса
            WebElement questionElement = questions[i];

            // 6. Прокрутите страницу к элементу вопроса (если необходимо)
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", questionElement);

            // 7. Кликните на элемент вопроса
            questionElement.click();

            // 8. Получите элемент ответа
            WebElement answerElement = answers[i];

            // 9. Дождитесь, пока ответ станет видимым
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(answerElement));

            // 10. Получите фактический текст ответа
            String actualAnswer = answerElement.getText();

            // 11. Проверьте, что ответ отображается и соответствует ожидаемому значению
            Assert.assertEquals("Ответ на вопрос " + (i + 1) + " не соответствует ожидаемому", expectedAnswers[i], actualAnswer);
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}