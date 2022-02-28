package daniel.nofulla.customsearchenginebackend;

import net.minidev.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @RequestMapping("/")
    public JSONObject helloWorld() {
        return new JSONObject().appendField("message", "Hello World from Spring Boot");
    }
}
