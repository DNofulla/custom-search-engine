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
    private SearchQueryConfiguration searchQueryConfiguration;

    @Autowired
    private SearchHistoryService searchHistoryService;

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

        System.out.println("Selected Category " + category);

        ObjectMapper mapper = new ObjectMapper();

        try {

            OkHttpClient client = new OkHttpClient();
            System.out.println("Created OkHttpClient ");


            Request request = new Request.Builder()
                    .url(searchUrl + query)
                    .get()
                    .addHeader("x-user-agent", searchQueryConfiguration.getAgent())
                    .addHeader("x-proxy-location", searchQueryConfiguration.getLocation())
                    .addHeader("x-rapidapi-host", searchQueryConfiguration.getHost())
                    .addHeader("x-rapidapi-key", searchQueryConfiguration.getKey())
                    .build();
            System.out.println("Build Request ");


            Response response = client.newCall(request).execute();

            System.out.println("Executed Request ");


            String jsonData = response.body().string();

            System.out.println("Converted json to string ");


            Map<String, ?> map = mapper.readValue(jsonData, Map.class);

            System.out.println("Read JSON into Map ");


            searchHistoryService.getUserSearchHistory(new SearchHistoryGetAllRequest(searchQueryRequest.getIpAddress()));

            ResponseEntity requestAddUser = searchHistoryService.addOneSearchHistory(new SearchHistoryAddOneRequest(searchQueryRequest.getIpAddress(), searchQueryRequest.getQuery()));

            System.out.println("Finished calling addOne Search service and getUserSearch Service");
            JSONObject jsonObject = new JSONObject(map).appendField("user", requestAddUser.getBody());
            System.out.println("Appending user from JSON object. Returning response");

            return ResponseEntity.ok().body(jsonObject);
        } catch (IOException ex) {
            System.out.println("Exception on Search Query Service");
            System.out.println(ex.getMessage());
            return ResponseEntity.badRequest().body(new JSONObject().appendField("error", true).appendField("message", "Request failed, IOException"));

        }
    }

}
