package daniel.nofulla.customsearchenginebackend.history;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class SearchHistoryAddOneRequest {

    @NotBlank
    private String ipAddress;

    @NotBlank
    private String query;

    public SearchHistoryAddOneRequest(@JsonProperty("ipAddress") String ipAddress, @JsonProperty("query") String query) {
        this.ipAddress = ipAddress;
        this.query = query;
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


}
