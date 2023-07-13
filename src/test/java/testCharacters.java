import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import rest.Rest;
import org.json.JSONObject;
import org.junit.Test;
import jsonObjects.Characters;
import jsonObjects.Result;
public class testCharacters {
    @Test
    public void printAllAlive() throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        Characters character = om.readValue(Rest.getRest("https://rickandmortyapi.com/api/character"), Characters.class);
        do {
            for (Result l : character.results) {
                if (l.status.equals("Alive")) {
                    System.out.println(l.name);
                }
            }
            if (character.info.next != null) {
                character = om.readValue(Rest.getRest(character.info.next), Characters.class);
            }
        } while (character.info.next != null);
    }
    @Test
    public void print() throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        int numberOfPages = new JSONObject(Rest.getRest("https://rickandmortyapi.com/api/character")).getJSONObject("info").getInt("pages");
        for (int i = 1; i < numberOfPages; i++) {
            Characters character = om.readValue(Rest.getRest("https://rickandmortyapi.com/api/character?page=" + i), Characters.class);
            for (Result l : character.results) {
                if (l.status.equals("Alive")) {
                    System.out.println(l.name);
                }
            }
        }
    }
}
