package daniel.nofulla.customsearchenginebackend.twilio.sendgrid;

import com.sendgrid.Response;

public interface TwilioSendgridEmailSenderInterface {
    Response sendEmail(TwilioSendgridEmailRequest twilioSendgridEmailRequest);
}
