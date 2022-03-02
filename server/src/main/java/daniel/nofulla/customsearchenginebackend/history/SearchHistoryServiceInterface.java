package daniel.nofulla.customsearchenginebackend.history;

import org.springframework.http.ResponseEntity;

public interface SearchHistoryServiceInterface {
    ResponseEntity<?> getUserSearchHistory(SearchHistoryGetAllRequest searchHistoryGetOneRequest);
    ResponseEntity<?> addOneSearchHistory(SearchHistoryAddOneRequest searchHistoryAddOneRequest);
    ResponseEntity<?> deleteOneSearchHistory(SearchHistoryDeleteOneRequest searchHistoryDeleteOneRequest);
    ResponseEntity<?> deleteAllSearchHistory(SearchHistoryDeleteAllRequest searchHistoryDeleteAllRequest);
}
