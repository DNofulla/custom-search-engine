package daniel.nofulla.customsearchenginebackend.search;

import com.fasterxml.jackson.databind.ObjectMapper;
import daniel.nofulla.customsearchenginebackend.history.SearchHistoryAddOneRequest;
import daniel.nofulla.customsearchenginebackend.history.SearchHistoryGetAllRequest;
import daniel.nofulla.customsearchenginebackend.history.SearchHistoryService;
import net.minidev.json.JSONObject;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;


@Service
public class SearchQueryService implements SearchQueryServiceInterface {


    @Autowired
    SearchQueryConfiguration searchQueryConfiguration;

    @Autowired
    SearchHistoryService searchHistoryService;

    public ResponseEntity<?> getQueryResults(SearchQueryRequest searchQueryRequest) {

        String query = searchQueryRequest.getQuery().replaceAll("\\\\s+", " ").replaceAll(" ", "+");
        String category = searchQueryRequest.getCategory();

        String searchUrl = "";

        switch (category) {
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

            searchHistoryService.getUserSearchHistory(new SearchHistoryGetAllRequest(searchQueryRequest.getIpAddress()));

            ResponseEntity requestAddUser = searchHistoryService.addOneSearchHistory(new SearchHistoryAddOneRequest(searchQueryRequest.getQuery(), searchQueryRequest.getIpAddress()));


            JSONObject jsonObject = new JSONObject(map).appendField("user", requestAddUser.getBody());

            return ResponseEntity.ok().body(jsonObject);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return ResponseEntity.badRequest().body(new JSONObject().appendField("error", true).appendField("message", "Request failed, IOException"));

        }
    }

}
