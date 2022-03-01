package daniel.nofulla.customsearchenginebackend.twilio.sms;

import com.twilio.Twilio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TwilioSMSInitializer {

    private final static Logger LOGGER = LoggerFactory.getLogger(TwilioSMSInitializer.class);

    private final TwilioSMSConfiguration twilioConfiguration;

    @Autowired
    public TwilioSMSInitializer(TwilioSMSConfiguration twilioConfiguration) {
        this.twilioConfiguration = twilioConfiguration;
        Twilio.init(
                twilioConfiguration.getAccountSid(),
                twilioConfiguration.getAuthToken()
        );
        LOGGER.info("Twilio initialized ... with account sid {} ", twilioConfiguration.getAccountSid());
    }
}