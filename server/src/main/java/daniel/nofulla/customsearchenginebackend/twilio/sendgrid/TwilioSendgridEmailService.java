package daniel.nofulla.customsearchenginebackend.twilio.sendgrid;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

@Service
public class TwilioSendgridEmailService implements TwilioSendgridEmailSenderInterface {

    @Autowired
    SendGrid sendGrid;

    public Response sendEmail(TwilioSendgridEmailRequest twilioSendgridEmailRequest) {

        Email from = new Email("dnofulla@outlook.com");
        Email to = new Email(twilioSendgridEmailRequest.getTo());
        String subject = twilioSendgridEmailRequest.getSubject();
        String body = twilioSendgridEmailRequest.getBody();
        Content content = new Content("text/plain", body);

        Mail mail = new Mail(from, subject, to, content);
        mail.setReplyTo(new Email("dnofulla@outlook.com"));

        Request request = new Request();
        Response response = null;

        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            response = this.sendGrid.api(request);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        return response;
    }



}