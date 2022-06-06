package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.locators.RelativeLocator;
import pageBase.PagesBase;

public class RestaurantPage {
    PagesBase pagesBase = PagesBase.getInstance();

    private By menuList = RelativeLocator.with(By.tagName("li")).below(
            By.cssSelector("ul[class='UILayoutList-35695df5e1d82d37']"));
    private  By burgerName = RelativeLocator.with(By.cssSelector("p[class='ccl-19882374e640f487 ccl-1daa0367dee37c3b ccl-a5fb02a1085896d3 ccl-dd90031787517421 ccl-9d0a5327c911d0f3']")).below(
            By.cssSelector("div[class='UIMenuItemCard-3b733b66e7f3b27d']"));

    private  By addItemBtn = By.cssSelector("div[class='MenuItemModal-d3cb8fce011dc83f']>span");
    private  By itemNameTxt = By.cssSelector("h3[class='ccl-2a4b5924e2237093 ccl-21bead492ce4ada2 ccl-99c566dc40a8a156 ccl-b4ea21f0be0a150a ccl-2913207c6cd67950']");
    private  By itemCountTxt = By.className("MenuItemModal-f557e77e901cef4f");


    private  By menuItemsList = By.cssSelector("div[class='ccl-b176b26fc7009752']>div[class='ccl-1aa46f2e5c0e8f0e ccl-1cb83a1a40889f7f']>div[class='ccl-329f91fe3811b3d9']>p");
    private  By menuItemCountTxt = By.className("BasketItem-015e00629c8f0793");
    private  By decreaseItemCount = RelativeLocator.with(By.tagName("button")).toRightOf(menuItemsList);
    private  By emptyCartView = By.cssSelector("p[class='ccl-19882374e640f487 ccl-1daa0367dee37c3b ccl-7e3800ad826d750a ccl-9d0a5327c911d0f3 ccl-c8eb8fd8fb351d32']");

    private  By menuSectionList = By.cssSelector("span[class='ccl-19882374e640f487 ccl-417df52a76832172 ccl-deab34eb04186352']");


    public RestaurantPage clickOnMenuSection(Enum menuSectionName ) {
        pagesBase.clickOnSpecific(menuList,menuSectionName.toString());
        return this;
    }


    public RestaurantPage selectSpecificItemFromMenu(Enum itemName) {
        pagesBase.clickOnSpecific(menuList, itemName.toString());
        return this;
    }

    public RestaurantPage clickOnAddItem() {
        pagesBase.clickOn(addItemBtn);
        return this;
    }

    public RestaurantPage clickOnDecreaseItemCount() {
        pagesBase.clickOn(decreaseItemCount);
        return this;
    }

    public String getItemName() {

        return pagesBase.getElementText(itemNameTxt);
    }


    public int getItemCount() {
        int count = Integer.parseInt(pagesBase.getElementText(itemCountTxt).trim());
        return count;
    }


    public String getItemNameFromCard() {
        return pagesBase.getElementText(menuItemsList);
    }

    public int getItemCountFromCard() {
        int count = Integer.parseInt(pagesBase.getElementText(menuItemCountTxt).trim());
        return count;
    }


    public String geEmptyCartTxt() {

        return pagesBase.getElementText(emptyCartView);
    }
}
