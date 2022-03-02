package daniel.nofulla.customsearchenginebackend.history;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class SearchHistoryDeleteAllRequest {

    @NotBlank
    private String ipAddress;

    public SearchHistoryDeleteAllRequest(@JsonProperty("ipAddress") String ipAddress) {
        this.ipAddress = ipAddress;
    }


    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

}
