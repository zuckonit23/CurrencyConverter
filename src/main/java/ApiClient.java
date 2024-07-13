import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class ApiClient {
    private static final String API_URL = "https://api.exchangerate-api.com/v4/latest/USD";
    private static final String API_KEY = "e0467dff5499672327eb326e";

    public static String getRates() throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet(API_URL + "?access_key=" + API_KEY);
        CloseableHttpResponse response = httpClient.execute(request);

        try {
            return EntityUtils.toString(response.getEntity());
        } finally {
            response.close();
        }
    }
}
