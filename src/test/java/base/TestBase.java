package base;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pageBase.PagesBase;
import pages.AllRestaurantsPage;
import pages.HomePage;
import pages.RestaurantPage;

import java.io.File;
import java.io.IOException;

import static data.TestData.HomePageURL;

public class TestBase {
    public WebDriver driver;

    public HomePage homePage = new HomePage();
    public AllRestaurantsPage allRestaurantsPage = new AllRestaurantsPage();
    public RestaurantPage restaurantPage = new RestaurantPage();
    public PagesBase pagesBase = PagesBase.getInstance();


    @BeforeClass
    public void setupDriver() {
        driver = pagesBase.getDriver();

    }

    @BeforeMethod
    public void setupApp() {
        driver.manage().deleteAllCookies();
        driver.get(HomePageURL.toString());
    }


    @AfterMethod
    public void recordFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            TakesScreenshot camera = ((TakesScreenshot) driver);
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot, new File("failure-screenshots/" + result.getName() + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
