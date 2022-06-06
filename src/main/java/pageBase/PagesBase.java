package pageBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class PagesBase {

    private WebDriver driver;

    private PagesBase() {
    }

    private static PagesBase instance;

    public static PagesBase getInstance() {
        if (instance == null) {
            synchronized (PagesBase.class) {
                if (instance == null) {
                    instance = new PagesBase();

                }
            }
        }
        return instance;
    }

    public WebDriver getDriver() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        return driver;
    }


    public void waitUntilAppearanceOf(By element) {
        FluentWait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        wait.until(ExpectedConditions.presenceOfElementLocated(element));

    }

    public void clickOn(By element) {
        waitUntilAppearanceOf(element);
        driver.findElement(element).click();
    }




    public void enterData(By element, String value) {
        waitUntilAppearanceOf(element);
        driver.findElement(element).clear();
        driver.findElement(element).sendKeys(value);

    }

    public String getElementText(By element) {
        waitUntilAppearanceOf(element);
        System.out.println("The element Text : " + driver.findElement(element).getText());
        return driver.findElement(element).getText();
    }


    public List<String> listOf(By element) {
        waitUntilAppearanceOf(element);
        List<WebElement> menuItems = driver.findElements(element);

//        (menuItems.size() != 0, "List is empty, failed to collect");

        menuItems.stream()
                .map(WebElement::getText).
                forEach(s -> System.out.println(s));

        return menuItems.stream()
                .map(WebElement::getText)
                .collect(toList());
    }


    public void clickOnSpecific(By element, String searchText) {
        waitUntilAppearanceOf(element);
        List<WebElement> menuItems = driver.findElements(element);
        int count = menuItems.size();
        System.out.println(count);
        for (int i = 0; i < count; i++) {

            String text = menuItems.get(i).getText();
            if (text.contains(searchText)) {
                waitUntilAppearanceOf(element);
                menuItems.get(i).click();
                break;

            }
        }
    }

}
