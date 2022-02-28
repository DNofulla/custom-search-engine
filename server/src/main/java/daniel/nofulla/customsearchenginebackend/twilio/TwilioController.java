package daniel.nofulla.customsearchenginebackend.twilio;

import net.minidev.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/twilio")
public class TwilioController {

    @GetMapping()
    public ResponseEntity<?> helloTwilio() {
        return ResponseEntity.ok().body(new JSONObject().appendField("message", "Hello from Twilio - Sent by Spring Boot API"));
    }
}
