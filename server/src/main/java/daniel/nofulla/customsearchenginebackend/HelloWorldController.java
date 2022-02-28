package daniel.nofulla.customsearchenginebackend;

import net.minidev.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping()
    public JSONObject helloWorld() {
        return new JSONObject().appendField("message", "Welcome to the custom search engine API");
    }
}
