package daniel.nofulla.customsearchenginebackend.search;

import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("search")
public class SearchQueryController {

    @Autowired
    private SearchQueryService searchQueryService;

    @GetMapping
    public ResponseEntity<?> getQueryResults(@RequestBody SearchQueryRequest searchQueryRequest) {
        System.out.println(searchQueryRequest.getQuery());
        return this.searchQueryService.getQueryResults(searchQueryRequest);
    }
}
