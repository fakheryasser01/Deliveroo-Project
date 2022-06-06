package data;

public enum TestData {
    HomePageURL("https://deliveroo.co.uk/") , DeliveryAddress("St James's Square"),
    CountryOfAddress("London, UK"), Burgers("Burgers"), RestaurantName("five guys"),
    ProductName("Little Hamburger"), EmptyBasket("Your basket is empty");


    private final String value;

    TestData(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
