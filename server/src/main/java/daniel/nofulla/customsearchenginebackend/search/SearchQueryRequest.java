package daniel.nofulla.customsearchenginebackend.search;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class SearchQueryRequest {

    @NotBlank
    private String query;

    @NotBlank
    private String category;

    @NotBlank
    private String ipAddress;

    public SearchQueryRequest(@JsonProperty("query") String query, @JsonProperty("category") String category, @JsonProperty("ipAddress") String ipAddress) {
        this.query = query;
        this.category = category;
        this.ipAddress = ipAddress;
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

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Override
    public String toString() {
        return "Search Query Request on " + getCategory() + "\n and with query: " + getQuery() + "\n from IP: " + getIpAddress();
    }

}
