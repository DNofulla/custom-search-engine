package daniel.nofulla.customsearchenginebackend.history;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "history")
@CrossOrigin(origins = "*")
public class SearchHistoryController {

    @Autowired
    private SearchHistoryService searchHistoryService;

    @PostMapping
    @CrossOrigin(origins = "*")
    public ResponseEntity<?> getSearchHistory(@RequestBody SearchHistoryGetAllRequest searchHistoryGetAllRequest) {
        System.out.println(searchHistoryGetAllRequest.getIpAddress());
        return this.searchHistoryService.getUserSearchHistory(searchHistoryGetAllRequest);
    }

    @PostMapping("add/one")
    @CrossOrigin(origins = "*")
    public ResponseEntity<?> addOneSearchHistory(@RequestBody SearchHistoryAddOneRequest searchHistoryAddOneRequest) {
        return this.searchHistoryService.addOneSearchHistory(searchHistoryAddOneRequest);
    }

    @PostMapping("delete/one")
    @CrossOrigin(origins = "*")
    public ResponseEntity<?> deleteOneSearchHistory(@RequestBody SearchHistoryDeleteOneRequest searchHistoryDeleteOneRequest) {
        return this.searchHistoryService.deleteOneSearchHistory(searchHistoryDeleteOneRequest);
    }

    @PostMapping("delete/all")
    @CrossOrigin(origins = "*")
    public ResponseEntity<?> deleteAllSearchHistory(@RequestBody SearchHistoryDeleteAllRequest searchHistoryDeleteAllRequest) {
        return this.searchHistoryService.deleteAllSearchHistory(searchHistoryDeleteAllRequest);
    }
}
