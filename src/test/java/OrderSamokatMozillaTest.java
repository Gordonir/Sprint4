import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pageobjects.FormaDlaKogoSamokatWan;
import pageobjects.FormaObArenda;
import pageobjects.MainPageSamokat;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class OrderSamokatMozillaTest {

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

    public OrderSamokatMozillaTest(String name, String family, String address, String metro, String phone, String date, String days, String color, String comment) {
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

    @Parameterized.Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][] {
                { "Иван", "Иванов", "Москва, ул. Ленина, д. 1", "Локомотив", "89991234567", "23.02.2025", "двое суток", "чёрный жемчуг", "Позвоните за час" },
                { "Петр", "Петров", "Санкт-Петербург, Невский пр., д. 2", "Лубянка", "89997654321", "15.03.2025", "трое суток", "серая безысходность", "Доставка к подъезду" }
        });
    }

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe"); // исправил путь на относительный

        driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        mainPageSamokat = new MainPageSamokat(driver);
    }

    @Test
    public void testOrderScooterPositiveFlow() {
        //  Клик по кнопке "Заказать" (верхняя)
        mainPageSamokat.clickTopOrderButton();

        // Заполнение первой формы
        formaDlaKogoSamokatWan = new FormaDlaKogoSamokatWan(driver);
        formaDlaKogoSamokatWan.setName(name);
        formaDlaKogoSamokatWan.setFamily(family);
        formaDlaKogoSamokatWan.setAddress(address);
        formaDlaKogoSamokatWan.setMetro(metro);
        formaDlaKogoSamokatWan.setphone(phone);
        formaDlaKogoSamokatWan.clickNextButton();

        // Заполнение второй формы
        formaObArenda = new FormaObArenda(driver);
        formaObArenda.setDate(date); // Используйте формат, который ожидает сайт
        formaObArenda.selectDays(days); // Использование параметра days
        formaObArenda.selectColor(color); // Использование параметра color
        formaObArenda.setСoment(comment); // Использование параметра comment
        formaObArenda.clickOrderButton();

        // Нажать кнопку "Да" в подтверждении
        formaObArenda.clickConfirmButton();

        // Проверка, что появилось всплывающее окно с сообщением об успешном создании заказа
        Assert.assertTrue("Сообщение об успешном заказе не появилось", formaObArenda.isOrderConfirmationMessageVisible());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
