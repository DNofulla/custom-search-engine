package daniel.nofulla.customsearchenginebackend.twilio.sendgrid;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sendgrid.SendGrid;

@Configuration
@ConfigurationProperties("sendgrid")
public class TwilioSendgridEmailConfiguration {
    private String key;

    @Bean
    public SendGrid getSendgrid() {
        return new SendGrid(key);
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}