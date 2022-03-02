package daniel.nofulla.customsearchenginebackend.history;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class SearchHistoryGetAllRequest {

    @NotBlank
    private String ipAddress;

    public SearchHistoryGetAllRequest(@JsonProperty("ipAddress") String ipAddress) {
        this.ipAddress = ipAddress;
    }


    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
}
