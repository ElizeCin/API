import rest.Rest;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class RickyMorty {
    static JSONObject jsonOBject = null;
    @BeforeClass
    public static void b() {
        Assert.assertEquals(200, Rest.getStatusCode("https://rickandmortyapi.com/api"));
            jsonOBject = new JSONObject(Rest.getRest("https://rickandmortyapi.com/api"));
        }

    @Test
    public void test1(){
        Assert.assertEquals(201, Rest.getStatusCode(jsonOBject.getString("characters")));
    }
    @Test
    public void test2(){
        Assert.assertEquals(200, Rest.getStatusCode(jsonOBject.getString("locations")));
    }
    @Test
    public void test3(){
        Assert.assertEquals(200, Rest.getStatusCode(jsonOBject.getString("episodes")));
    }
}
