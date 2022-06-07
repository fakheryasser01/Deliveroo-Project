package pagesTest;

import base.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;


public class CartTest extends TestBase {

    String productName;
    int productCount;

    /* TC01
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
    public void test_Add_Item_ToCart_Successfully() throws IOException, ParseException {

        openItemDetails();
        restaurantPage.clickOnAddItem();
        Assert.assertTrue(restaurantPage.getItemNameFromCard().contains(productName));
        Assert.assertEquals(restaurantPage.getItemCountFromCard(), productCount);

    }


    /* TC04
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
    @Description("TC04 - The Guest user should be able to see the cart’s empty view when “remove/decrease " +
            "the last item’s count till be zero” the from the cart")
    public void test_AppearanceOf_Cart_EmptyView_Successfully_After_Remove_LastItem() throws IOException, ParseException {

        openItemDetails();
        restaurantPage.clickOnAddItem();
        Assert.assertTrue(restaurantPage.getItemNameFromCard().contains(productName));
        Assert.assertEquals(restaurantPage.getItemCountFromCard(), productCount);
        restaurantPage.clickOnDecreaseItemCount();
        Assert.assertTrue(restaurantPage.geEmptyCartTxt().contains(jsonReader.EmptyBasket));


    }


    private void openItemDetails() throws IOException, ParseException {
        jsonReader.JsonReader();
        homePage.clickOnAcceptCookiesBtn()
                .setDeliveryAddress(jsonReader.DeliveryAddress)
                .clickOnSearchResultByCountry(jsonReader.CountryOfAddress);

        allRestaurantsPage
                .clickOnOfferOkBtn()
                .searchOnRestaurantByName(jsonReader.RestaurantName)
                .selectTheRestaurant();

        restaurantPage.clickOnMenuSection(jsonReader.Burgers)
                .selectSpecificItemFromMenu(jsonReader.ProductName);

        productName = restaurantPage.getItemName();
        productCount = restaurantPage.getItemCount();
    }

}
