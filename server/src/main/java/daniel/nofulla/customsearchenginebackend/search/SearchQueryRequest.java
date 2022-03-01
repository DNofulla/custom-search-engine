package daniel.nofulla.customsearchenginebackend.search;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class SearchQueryRequest {

    @NotBlank
    private String query;

    @NotBlank
    private String category;

    public SearchQueryRequest(@JsonProperty("query") String query, @JsonProperty("category") String category) {
        this.query = query;
        this.category = category;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Search Query Request on " + getCategory() + "\n and with query: " + getQuery();
    }

}
