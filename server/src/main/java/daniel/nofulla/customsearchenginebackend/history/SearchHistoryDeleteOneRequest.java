package daniel.nofulla.customsearchenginebackend.history;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class SearchHistoryDeleteOneRequest {

    @NotBlank
    private String ipAddress;

    @NotBlank
    private String query;

    @NotBlank
    private int id;

    public SearchHistoryDeleteOneRequest(@JsonProperty("ipAddress") String ipAddress, @JsonProperty("query") String query, @JsonProperty("id") int id) {
        this.ipAddress = ipAddress;
        this.query = query;
        this.id = id;
    }


    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
