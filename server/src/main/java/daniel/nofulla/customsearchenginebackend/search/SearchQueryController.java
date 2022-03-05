package daniel.nofulla.customsearchenginebackend.search;

import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("search")
@CrossOrigin(origins = "*")
public class SearchQueryController {

    @Autowired
    private SearchQueryService searchQueryService;

    @PostMapping
    @CrossOrigin(origins = "*")
    public ResponseEntity<?> getQueryResults(@RequestBody SearchQueryRequest searchQueryRequest) {
        System.out.println(searchQueryRequest.getQuery());
        return this.searchQueryService.getQueryResults(searchQueryRequest);
    }
}
