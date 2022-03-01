package daniel.nofulla.customsearchenginebackend.search;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.JSONObject;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@Service
public class SearchQueryService {


    @Autowired
    SearchQueryConfiguration searchQueryConfiguration;

    public ResponseEntity<?> getQueryResults(SearchQueryRequest searchQueryRequest) {

        String query = searchQueryRequest.getQuery().replaceAll("\\\\s+", " ").replaceAll(" ", "+");
        String category = searchQueryRequest.getCategory();

        String searchUrl;


        switch (category) {
            case "text":
                searchUrl = searchQueryConfiguration.getTextUrl();
                break;
            case "images":
                searchUrl = searchQueryConfiguration.getImagesUrl();
                break;
            case "news":
                searchUrl = searchQueryConfiguration.getNewsUrl();
                break;
            default:
                searchUrl = searchQueryConfiguration.getTextUrl();
                break;
        }

        ObjectMapper mapper = new ObjectMapper();

        try {

            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url(searchUrl + query)
                    .get()
                    .addHeader("x-user-agent", searchQueryConfiguration.getAgent())
                    .addHeader("x-proxy-location", searchQueryConfiguration.getLocation())
                    .addHeader("x-rapidapi-host", searchQueryConfiguration.getHost())
                    .addHeader("x-rapidapi-key", searchQueryConfiguration.getKey())
                    .build();

            Response response = client.newCall(request).execute();
            String jsonData = response.body().string();

            Map<String, String> map = mapper.readValue(jsonData, Map.class);
            JSONObject jsonObject = new JSONObject(map);

            return ResponseEntity.ok().body(jsonObject);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return ResponseEntity.badRequest().body(new JSONObject().appendField("error", true).appendField("message", "Request failed, IOException"));

        }
    }

}
