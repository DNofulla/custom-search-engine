package daniel.nofulla.customsearchenginebackend.search;

import org.springframework.http.ResponseEntity;

public interface SearchQueryServiceInterface {
    ResponseEntity<?> getQueryResults(SearchQueryRequest searchQueryRequest);
}
