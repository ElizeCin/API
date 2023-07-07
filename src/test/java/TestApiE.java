import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

public class TestApiE {
    static Exchange[] exchanges;
    @BeforeClass
    public static void tt() throws IOException {
        ObjectMapper om = new ObjectMapper();
        exchanges = om.readValue(Rest.getRest("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json"),Exchange[].class);
            }
            @Test
    public void test1() {
                System.out.println(exchanges[0].cc+exchanges[0].rate);
                Exchange myEx = exchanges[0];
            }

            @Test
    public void test2() {
        for (Exchange l : exchanges) {
            System.out.println(l.cc + " " + l.rate);
        }
    }
}
