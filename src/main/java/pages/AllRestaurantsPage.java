package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.locators.RelativeLocator;
import pageBase.PagesBase;

public class AllRestaurantsPage {

    PagesBase pagesBase = PagesBase.getInstance();


    private By offerOkBtn = By.cssSelector("button[class='ccl-d0484b0360a2b432 ccl-233931c277401e86 ccl-ed9aadeaa18a9f19 ccl-a97a150ddadaa172']");
    private  By searchField = By.name("search");
    private  By selectRestaurant =
            RelativeLocator.with(By.tagName("ul")).below(By.xpath("//h4[contains(text(),'Places')]"));


    public AllRestaurantsPage clickOnOfferOkBtn() {
        pagesBase.clickOn(offerOkBtn);
        return this;
    }


    public AllRestaurantsPage searchOnRestaurantByName(Enum restaurantName) {
        pagesBase.enterData(searchField, restaurantName.toString());
        return this;
    }

    public void selectTheRestaurant() {
        pagesBase.clickOn(selectRestaurant);
    }
}
