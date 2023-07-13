import rest.Rest;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.BeforeClass;
import org.junit.Test;
import java.io.IOException;

public class TestApi {
    static JSONArray jsonArray;

    @BeforeClass
    public static void tt() throws IOException {
        jsonArray = new JSONArray(Rest.getRest("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json"));
    }

    @Test
    public void test1() throws IOException {
         System.out.println(Rest.getRest("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json"));
    }

    @Test
    public void test2() {
        System.out.println(jsonArray.get(0));
    }

    @Test
    public void test3() {
        JSONObject exchange = jsonArray.getJSONObject(0);
        System.out.println(exchange.getString("cc"));
        System.out.println(exchange.getDouble("rate"));
    }

    @Test
    public void test4() {
        System.out.println(jsonArray.getJSONObject(0).getString("cc"));
    }

    @Test
    public void test5() {
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject object = jsonArray.getJSONObject(i);
            System.out.println(object.getString("cc") + " = " + object.getDouble("rate"));
        }
    }
}