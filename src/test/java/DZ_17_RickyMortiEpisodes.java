import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jsonObjects.episodes.ResultEpisodes;
import jsonObjects.episodes.RootEpisodes;
import rest.Rest;
import org.junit.Test;
public class DZ_17_RickyMortiEpisodes {
    @Test
    public void testAllCharacters() throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        RootEpisodes episodes = om.readValue(Rest.getRest("https://rickandmortyapi.com/api/episode"), RootEpisodes.class);
        do {
            for (ResultEpisodes l : episodes.results) {
                System.out.println(l.name + " = " + l.air_date + " : ");
            }
            if (episodes.info.next != null) {
                episodes = om.readValue(Rest.getRest(episodes.info.next), RootEpisodes.class);
            }
        } while (episodes.info.next != null);
    }
}
