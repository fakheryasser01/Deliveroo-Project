package frameworkBase;

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

public class PageBase {

    //singleton class

    private WebDriver driver;

    //Singleton Implementation ----------------------------------------------------------
    private PageBase() {
    }

    private static PageBase instance;

    public static PageBase getInstance() {
        if (instance == null) {
            synchronized (PageBase.class) {
                if (instance == null) {
                    instance = new PageBase();

                }
            }
        }
        return instance;
    }

    // Driver Implementation --------------------------------------------------------
    public WebDriver getDriver() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        return driver;
    }

    // Close Driver  --------------------------------------------------------

    public void quitDriver()
    {
        driver.quit();
    }

    //Common functions --------------------------------------------------------

    public void waitUntilAppearanceOf(By element) {
        FluentWait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofSeconds(1))
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
        return driver.findElement(element).getText();
    }

    public void clickOnSpecific(By element, String searchText) {
        waitUntilAppearanceOf(element);
        List<WebElement> menuItems = driver.findElements(element);
        int count = menuItems.size();
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
