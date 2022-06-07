package pages;

import frameworkBase.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.locators.RelativeLocator;

public class RestaurantPage {
    PageBase pageBase = PageBase.getInstance();

    private By menuList = RelativeLocator.with(By.tagName("li")).below(By.cssSelector("ul[class='UILayoutList-35695df5e1d82d37']"));
    private By addItemBtn = By.cssSelector("div[class='MenuItemModal-d3cb8fce011dc83f']>span");
    private By itemDetailsNameTxt = By.cssSelector("div> h3[class*='ccl-b4ea21f0be0a150a']");
    private By itemDetailsCountTxt = By.className("MenuItemModal-f557e77e901cef4f");
    private By cartItemsList = By.cssSelector("div[class='ccl-b176b26fc7009752']>div[class*='ccl-1aa46f2e5c0e8f0e']>div>p");
    private By cartItemCountTxt = By.className("BasketItem-015e00629c8f0793");
    private By cartDecreaseItemCountBtn = RelativeLocator.with(By.tagName("button")).toRightOf(cartItemsList);
    private By cartEmptyViewTxt = By.cssSelector("div>span+p[class*='ccl-1daa0367dee37c3b']");


    public RestaurantPage clickOnMenuSection(String menuSectionName) {
        pageBase.clickOnSpecific(menuList, menuSectionName);
        return this;
    }


    public RestaurantPage selectSpecificItemFromMenu(String itemName) {
        pageBase.clickOnSpecific(menuList, itemName);
        return this;
    }

    public RestaurantPage clickOnAddItem() {
        pageBase.clickOn(addItemBtn);
        return this;
    }

    public RestaurantPage clickOnDecreaseItemCount() {
        pageBase.clickOn(cartDecreaseItemCountBtn);
        return this;
    }

    public String getItemName() {

        return pageBase.getElementText(itemDetailsNameTxt);
    }


    public int getItemCount() {
        int count = Integer.parseInt(pageBase.getElementText(itemDetailsCountTxt).trim());
        return count;
    }


    public String getItemNameFromCard() {
        return pageBase.getElementText(cartItemsList);
    }

    public int getItemCountFromCard() {
        int count = Integer.parseInt(pageBase.getElementText(cartItemCountTxt).trim());
        return count;
    }


    public String geEmptyCartTxt() {

        return pageBase.getElementText(cartEmptyViewTxt);
    }
}
