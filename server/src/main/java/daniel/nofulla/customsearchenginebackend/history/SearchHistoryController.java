package daniel.nofulla.customsearchenginebackend.history;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("history/")
public class SearchHistoryController {

    @Autowired
    private SearchHistoryService searchHistoryService;

    @GetMapping
    public ResponseEntity<?> getSearchHistory(@RequestBody SearchHistoryGetAllRequest searchHistoryGetAllRequest) {
        return this.searchHistoryService.getUserSearchHistory(searchHistoryGetAllRequest);
    }

    @PostMapping("add/one")
    public ResponseEntity<?> addOneSearchHistory(@RequestBody SearchHistoryAddOneRequest searchHistoryAddOneRequest) {
        return this.searchHistoryService.addOneSearchHistory(searchHistoryAddOneRequest);
    }

    @PostMapping("delete/one")
    public ResponseEntity<?> deleteOneSearchHistory(@RequestBody SearchHistoryDeleteOneRequest searchHistoryDeleteOneRequest) {
        return this.searchHistoryService.deleteOneSearchHistory(searchHistoryDeleteOneRequest);
    }

    @PostMapping("delete/all")
    public ResponseEntity<?> deleteAllSearchHistory(@RequestBody SearchHistoryDeleteAllRequest searchHistoryDeleteAllRequest) {
        return this.searchHistoryService.deleteAllSearchHistory(searchHistoryDeleteAllRequest);
    }
}
