package daniel.nofulla.customsearchenginebackend.twilio.sms;

import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("twilio/sms")
@CrossOrigin(origins = "*")
public class TwilioSMSController {

    private final TwilioSMSService service;

    @Autowired
    public TwilioSMSController(TwilioSMSService service) {
        this.service = service;
    }

    @GetMapping
    @CrossOrigin(origins = "*")
    public ResponseEntity<?> getData() {
        return ResponseEntity.ok().body(new JSONObject().appendField("message", "Twilio SMS Endpoint"));
    }

    @PostMapping
    @CrossOrigin(origins = "*")
    public void sendSms(@Valid @RequestBody TwilioSMSRequest smsRequest) {
        service.sendSms(smsRequest);
    }
}