package data;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class JsonDataReader {
    public String DeliveryAddress, CountryOfAddress, Burgers, RestaurantName, ProductName, EmptyBasket;

    public void JsonReader() throws IOException, ParseException {

        String filePath = System.getProperty("user.dir") + "/src/test/java/data/TestData.Json";

        JSONParser parser = new JSONParser();
        File srcFile = new File(filePath);


        JSONParser jsonParser = new JSONParser();
        JSONArray allData = (JSONArray) jsonParser.parse(new FileReader(srcFile));

        for (Object jsonObj : allData) {
            JSONObject data = (JSONObject) jsonObj;
            System.out.println("TestData---------------------------------------------");

            DeliveryAddress = (String) data.get("DeliveryAddress");
            System.out.println(DeliveryAddress);

            CountryOfAddress = (String) data.get("CountryOfAddress");
            System.out.println(CountryOfAddress);


            Burgers = (String) data.get("Burgers");
            System.out.println(Burgers);

            RestaurantName = (String) data.get("RestaurantName");
            System.out.println(RestaurantName);

            ProductName = (String) data.get("ProductName");
            System.out.println(ProductName);

            EmptyBasket = (String) data.get("EmptyBasket");
            System.out.println(EmptyBasket);
            System.out.println("--------------------------------------------------------");


        }
    }
}
