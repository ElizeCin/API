import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import java.io.IOException;

public class Rest {
    public static String getRest(String url) throws IOException {
        return EntityUtils.toString(HttpClientBuilder.create().build().execute(new HttpGet(url)).getEntity());

//    public static String getRest(String url) {
//        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
//        String ent = null;
//        HttpResponse response;
//        try {
//            response = httpClient.execute(new HttpGet(url));
//            ent = EntityUtils.toString(response.getEntity());
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return ent;
    }
}
