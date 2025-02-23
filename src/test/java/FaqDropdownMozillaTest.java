import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.MainPageSamokat;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;

public class FaqDropdownMozillaTest {
    private WebDriver driver;
    private MainPageSamokat mainPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\Mozilla Firefox\\geckodriver.exe"); // Исправленный путь и ключ

        driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        mainPage = new MainPageSamokat(driver);
    }

    @Test
    public void testFaqDropdown() {

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


        for (int i = 0; i < questions.length; i++) {

            WebElement questionElement = questions[i];


            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", questionElement);


            questionElement.click();


            WebElement answerElement = answers[i];


            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(answerElement));


            String actualAnswer = answerElement.getText();


            Assert.assertEquals("Ответ на вопрос " + (i + 1) + " не соответствует ожидаемому", expectedAnswers[i], actualAnswer);
        }
    }
    @After
    public void tearDown() {
        driver.quit();
    }

}
