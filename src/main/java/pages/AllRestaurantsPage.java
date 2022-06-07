package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.locators.RelativeLocator;
import frameworkBase.PageBase;

public class AllRestaurantsPage {

    PageBase pageBase = PageBase.getInstance();


    private By offerOkBtn =
            By.cssSelector("button[class='ccl-d0484b0360a2b432 ccl-233931c277401e86 ccl-ed9aadeaa18a9f19 ccl-a97a150ddadaa172']");
    private  By searchField = By.name("search");
    private  By selectRestaurant =
            RelativeLocator.with(By.tagName("ul")).below(By.xpath("//h4[contains(text(),'Places')]"));


    public AllRestaurantsPage clickOnOfferOkBtn() {
        pageBase.clickOn(offerOkBtn);
        return this;
    }


    public AllRestaurantsPage searchOnRestaurantByName(String restaurantName) {
        pageBase.enterData(searchField, restaurantName);
        return this;
    }

    public void selectTheRestaurant() {
        pageBase.clickOn(selectRestaurant);
    }
}
