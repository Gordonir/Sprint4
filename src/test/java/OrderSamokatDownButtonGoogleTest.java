import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.FormaDlaKogoSamokatWan;
import pageobjects.FormaObArenda;
import pageobjects.MainPageSamokat;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class OrderSamokatDownButtonGoogleTest {

    private WebDriver driver;
    private MainPageSamokat mainPageSamokat;
    private FormaDlaKogoSamokatWan formaDlaKogoSamokatWan;
    private FormaObArenda formaObArenda;

    private String name;
    private String family;
    private String address;
    private String metro;
    private String phone;
    private String date;
    private String days;
    private String color;
    private String comment;

    public OrderSamokatDownButtonGoogleTest(String name, String family, String address, String metro, String phone, String date, String days, String color, String comment) {
        this.name = name;
        this.family = family;
        this.address = address;
        this.metro = metro;
        this.phone = phone;
        this.date = date;
        this.days = days;
        this.color = color;
        this.comment = comment;
    }

    @Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][] {
                { "Иван", "Иванов", "Москва, ул. Ленина, д. 1", "Локомотив", "89991234567", "23.02.2025", "двое суток", "чёрный жемчуг", "Позвоните за час" },
                { "Петр", "Петров", "Санкт-Петербург, Невский пр., д. 2", "Лубянка", "89997654321", "15.03.2025", "трое суток", "серая безысходность", "Доставка к подъезду" }
        });
    }

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); // исправил путь на относительный
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        mainPageSamokat = new MainPageSamokat(driver);
        mainPageSamokat.acceptCookies(); // Принимаем куки
    }

    @Test
    public void testOrderScooterPositiveFlow() {
        // Кликнуть на кнопку "Заказать" (нижняя)
        mainPageSamokat.clickDownOrderButton();

        // Заполнить первую форму
        formaDlaKogoSamokatWan = new FormaDlaKogoSamokatWan(driver);
        formaDlaKogoSamokatWan.setName(name);
        formaDlaKogoSamokatWan.setFamily(family);
        formaDlaKogoSamokatWan.setAddress(address);
        formaDlaKogoSamokatWan.setMetro(metro);
        formaDlaKogoSamokatWan.setphone(phone);
        formaDlaKogoSamokatWan.clickNextButton();

        // Заполнить вторую форму
        formaObArenda = new FormaObArenda(driver);
        formaObArenda.setDate(date); // Используйте формат, который ожидает сайт
        formaObArenda.selectDays(days); // Использование параметра days
        formaObArenda.selectColor(color); // Использование параметра color
        formaObArenda.setСoment(comment); // Использование параметра comment
        formaObArenda.clickOrderButton();

        // Подтвердить заказ
        formaObArenda.clickConfirmButton();

        // Проверка, что появилось всплывающее окно с сообщением об успешном создании заказа
        Assert.assertTrue("Сообщение об успешном заказе не появилось", formaObArenda.isOrderConfirmationMessageVisible());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
