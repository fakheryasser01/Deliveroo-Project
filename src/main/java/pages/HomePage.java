package pages;

import org.openqa.selenium.By;
import pageBase.PagesBase;

public class HomePage {
    PagesBase pagesBase = PagesBase.getInstance();


    private By locationSearchField = By.id("location-search");
    private  By searchResultsItems = By.className("ccl-329f91fe3811b3d9");
    private  By cookies = By.id("onetrust-accept-btn-handler");


    public HomePage clickOnAcceptCookiesBtn() {
        pagesBase.clickOn(cookies);
        return this;
    }

    public HomePage setDeliveryAddress(Enum a) {
        pagesBase.enterData(locationSearchField, a.toString());
        return this;
    }

    public HomePage clickOnSearchResultByCountry(Enum country) {
        pagesBase.clickOnSpecific(searchResultsItems, country.toString());
        return this;
    }

}
