package daniel.nofulla.customsearchenginebackend.twilio.sms;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class TwilioSMSRequest {

    @NotBlank
    private String phoneNumber;

    @NotBlank
    private String message;

    public TwilioSMSRequest(@JsonProperty("phoneNumber") String phoneNumber, @JsonProperty("message") String message) {
        this.phoneNumber = phoneNumber;
        this.message = message;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "SMS Request to " + getPhoneNumber() + " with message: \n" + getMessage();
    }
}