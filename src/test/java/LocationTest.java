import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import rest.Rest;
import org.junit.Test;
import jsonObjects.location.*;

public class LocationTest {
    @Test
    public void test1() throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        Locations location = om.readValue(Rest.getRest("https://rickandmortyapi.com/api/location"), Locations.class);
        do {
            for (Result l : location.results) {
                System.out.println(l.name + " = " + l.type + " : ");
            for (String resident : l.residents) {
                System.out.println(new JSONObject(Rest.getRest(resident)).getString("name") + " , ");
            }
                System.out.println("");
        }
            if (location.info.next != null) {
                location = om.readValue(Rest.getRest(location.info.next), Locations.class);
            }
        } while (location.info.next != null);
    }
}
