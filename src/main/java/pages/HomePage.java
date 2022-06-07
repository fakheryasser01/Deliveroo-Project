package pages;

import frameworkBase.PageBase;
import org.openqa.selenium.By;

public class HomePage {
    PageBase pageBase = PageBase.getInstance();


    private By locationSearchField = By.id("location-search");
    private By searchResultsItems = By.className("ccl-329f91fe3811b3d9");
    private By cookies = By.id("onetrust-accept-btn-handler");


    public HomePage clickOnAcceptCookiesBtn() {
        pageBase.clickOn(cookies);
        return this;
    }

    public HomePage setDeliveryAddress(String a) {
        pageBase.enterData(locationSearchField, a);
        return this;
    }

    public HomePage clickOnSearchResultByCountry(String country) {
        pageBase.clickOnSpecific(searchResultsItems, country);
        return this;
    }

}
