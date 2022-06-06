package pagesTest;

import base.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

import static data.TestData.*;

public class CartTest extends TestBase {
    String itemName;
    int itemCount;


    /*
    1.	Open Deliveroo web App Using https://deliveroo.co.uk/
    2.	Click On Accept all Cookies
    3.	Enter the “delivery address” in search field and select location from the drop-down menu using “State/Country” .
    4.	Enter restaurant name in the search field and select Restaurant from the Places section.
    5.	Select “Menus Section” from the menu sections
    6.	Click on “Item” from the menu
    7.	Click Add Button to add item to the cart
    8.	Check the cart and verify the item is added to cart
     */

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("TC01 - The guest user should be able to add item to the cart successfully")
    public void test_Add_Item_ToCart_Successfully() {

        openItemDetails();
        restaurantPage.clickOnAddItem();
        Assert.assertTrue(restaurantPage.getItemNameFromCard().contains(itemName));
        Assert.assertEquals(restaurantPage.getItemCountFromCard(), itemCount);

    }


    /*
    1.	Open Deliveroo web App Using https://deliveroo.co.uk/
    2.	Click On Accept all Cookies
    3.	Enter the “delivery address” in search field and select location from the drop-down menu using “State/Country” .
    4.	Enter restaurant name in the search field and select Restaurant from the Places section.
    5.	Select “Menus Section” from the menu sections
    6.	Click on “Item” from the menu
    7.	Click Add Button to add item to the cart
    8.	Click on “-” decrease button and check the cart to verify the cart is empty
     */
    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("The Guest user should be able to see the cart’s empty view when “remove/decrease " +
            "the last item’s count till be zero” the from the cart")
    public void test_AppearanceOf_Cart_EmptyView_Successfully_After_Remove_LastItem() {

        openItemDetails();
        restaurantPage.clickOnAddItem();
        Assert.assertTrue(restaurantPage.getItemNameFromCard().contains(itemName));
        Assert.assertEquals(restaurantPage.getItemCountFromCard(), itemCount);
        restaurantPage.clickOnDecreaseItemCount();
        Assert.assertTrue(restaurantPage.geEmptyCartTxt().contains(EmptyBasket.toString()));


    }


    private void openItemDetails() {
        homePage.clickOnAcceptCookiesBtn()
                .setDeliveryAddress(DeliveryAddress)
                .clickOnSearchResultByCountry(CountryOfAddress);

        allRestaurantsPage
                .clickOnOfferOkBtn()
                .searchOnRestaurantByName(RestaurantName)
                .selectTheRestaurant();

        restaurantPage.clickOnMenuSection(Burgers)
                .selectSpecificItemFromMenu(ProductName);

        itemName = restaurantPage.getItemName();
        itemCount = restaurantPage.getItemCount();
    }

}
