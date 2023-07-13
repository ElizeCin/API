import com.fasterxml.jackson.databind.ObjectMapper;
import jsonObjects.Exchange;
import rest.Rest;
import org.junit.BeforeClass;
import org.junit.Test;
import java.io.IOException;

public class DZ_16_CurrencyExchange {
    static Exchange[] exchanges;
    @BeforeClass
    public static void getRate() throws IOException {
        ObjectMapper abc = new ObjectMapper();
        exchanges = abc.readValue(Rest.getRest("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json"),Exchange[].class);
    }
    @Test
    public void ratesTest() {
        System.out.println(exchanges[31].cc + " = " + exchanges[31].rate);
        System.out.println(exchanges[24].cc + " = " + exchanges[24].rate);
        System.out.println(exchanges[1].cc + " = " + exchanges[1].rate);
    }
}