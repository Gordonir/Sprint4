package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MainPageSamokat {
    // Тут элементы страницы и их локаторы

        private WebDriver driver;
        private By topOrderInButton = By.className("Button_Button__ra12g"); // Верхняя кнопка заказать
        private By downOrderInButton = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM"); // нижняя кнопка заказать



    // Часто задаваемые вопросы
    private By perviyVopros = By.id("accordion__heading-0");
    private By vtoroyVopros = By.id("accordion__heading-1");
    private By tretiyVopros = By.id("accordion__heading-2");
    private By chetvertyiyVopros = By.id("accordion__heading-3");
    private By piatiyVopros = By.id("accordion__heading-4");
    private By shestoyVopros = By.id("accordion__heading-5");
    private By sedmoyVopros = By.id("accordion__heading-6");
    private By vosmoyVopros = By.id("accordion__heading-7");

    private By otvetNaPerviyVopros = By.id("accordion__panel-0");
    private By otvetNaVtoroyVopros = By.id("accordion__panel-1");
    private By otvetNaTretiyVopros = By.id("accordion__panel-2");
    private By otvetNaChetvertyiyVopros = By.id("accordion__panel-3");
    private By otvetNaPiatiyVopros = By.id("accordion__panel-4");
    private By otvetNaShestoyVopros = By.id("accordion__panel-5");
    private By otvetNaSedmoyVopros = By.id("accordion__panel-6");
    private By otvetNaVosmoyVopros = By.id("accordion__panel-7");

    private String expectedAnswer1 = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    private String expectedAnswer2 = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    private String expectedAnswer3 = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    private String expectedAnswer4 = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    private String expectedAnswer5 = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    private String expectedAnswer6 = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    private String expectedAnswer7 = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    private String expectedAnswer8 = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";


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




    // Геттеры для вопросов
    public WebElement getPerviyVopros() {
        return driver.findElement(perviyVopros);
    }

    public WebElement getVtoroyVopros() {
        return driver.findElement(vtoroyVopros);
    }

    public WebElement getTretiyVopros() {
        return driver.findElement(tretiyVopros);
    }

    public WebElement getChetvertyiyVopros() {
        return driver.findElement(chetvertyiyVopros);
    }

    public WebElement getPiatiyVopros() {
        return driver.findElement(piatiyVopros);
    }

    public WebElement getShestoyVopros() {
        return driver.findElement(shestoyVopros);
    }

    public WebElement getSedmoyVopros() {
        return driver.findElement(sedmoyVopros);
    }

    public WebElement getVosmoyVopros() {
        return driver.findElement(vosmoyVopros);
    }

    // Геттеры для ответов
    public WebElement getOtvetNaPerviyVopros() {
        return driver.findElement(otvetNaPerviyVopros);
    }

    public WebElement getOtvetNaVtoroyVopros() {
        return driver.findElement(otvetNaVtoroyVopros);
    }

    public WebElement getOtvetNaTretiyVopros() {
        return driver.findElement(otvetNaTretiyVopros);
    }

    public WebElement getOtvetNaChetvertyiyVopros() {
        return driver.findElement(otvetNaChetvertyiyVopros);
    }

    public WebElement getOtvetNaPiatiyVopros() {
        return driver.findElement(otvetNaPiatiyVopros);
    }

    public WebElement getOtvetNaShestoyVopros() {
        return driver.findElement(otvetNaShestoyVopros);
    }

    public WebElement getOtvetNaSedmoyVopros() {
        return driver.findElement(otvetNaSedmoyVopros);
    }

    public WebElement getOtvetNaVosmoyVopros() {
        return driver.findElement(otvetNaVosmoyVopros);
    }

    // Методы для получения ожидаемых значений ответов
    public String getExpectedAnswer1() {
        return expectedAnswer1;
    }

    public String getExpectedAnswer2() {
        return expectedAnswer2;
    }

    public String getExpectedAnswer3() {
        return expectedAnswer3;
    }

    public String getExpectedAnswer4() {
        return expectedAnswer4;
    }

    public String getExpectedAnswer5() {
        return expectedAnswer5;
    }

    public String getExpectedAnswer6() {
        return expectedAnswer6;
    }

    public String getExpectedAnswer7() {
        return expectedAnswer7;
    }

    public String getExpectedAnswer8() {
        return expectedAnswer8;
    }


}
