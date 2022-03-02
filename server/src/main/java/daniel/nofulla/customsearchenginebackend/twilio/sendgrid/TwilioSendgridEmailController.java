package daniel.nofulla.customsearchenginebackend.twilio.sendgrid;

import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sendgrid.Response;


@RestController
@RequestMapping("twilio/sendgrid")
public class TwilioSendgridEmailController {

    @Autowired
    private TwilioSendgridEmailService twilioSendgridEmailService;

    @GetMapping
    public ResponseEntity<?> getData() {
        return ResponseEntity.ok().body(new JSONObject().appendField("message", "Twilio Sendgrid Endpoint"));
    }

    @PostMapping
    public ResponseEntity<?> sendEmail(@RequestBody TwilioSendgridEmailRequest twilioSendgridEmailRequest) {
        Response response = twilioSendgridEmailService.sendEmail(twilioSendgridEmailRequest);
        int status = response.getStatusCode();

        if (status == 200 || status == 202) {
            return ResponseEntity.ok().body(new JSONObject().appendField("message","Email sent successfully!"));
        }

        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

}