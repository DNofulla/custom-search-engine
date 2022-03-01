package daniel.nofulla.customsearchenginebackend.twilio.sendgrid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sendgrid.SendGrid;

@Configuration
@ConfigurationProperties("sendgrid")
public class TwilioSendgridEmailConfiguration {
    private String key;

    public TwilioSendgridEmailConfiguration() {

    }

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