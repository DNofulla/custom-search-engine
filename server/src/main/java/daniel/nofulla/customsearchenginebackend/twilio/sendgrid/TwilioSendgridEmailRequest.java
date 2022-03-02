package daniel.nofulla.customsearchenginebackend.twilio.sendgrid;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotBlank;

public class TwilioSendgridEmailRequest {

    @NotBlank
    private String to;

    @NotBlank
    private String subject;

    @NotBlank
    private String body;

    public TwilioSendgridEmailRequest(@JsonProperty("to") String to, @JsonProperty("subject") String subject, @JsonProperty("body") String body) {
        super();
        this.to = to;
        this.subject = subject;
        this.body = body;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Email Request to " + getTo() + " with subject:\n" + getSubject() + " and Email Body:\n" + getBody();
    }
}