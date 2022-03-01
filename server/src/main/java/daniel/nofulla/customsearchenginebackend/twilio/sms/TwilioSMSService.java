package daniel.nofulla.customsearchenginebackend.twilio.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class TwilioSMSService {

    private final TwilioSMSSenderInterface smsSender;

    @Autowired
    public TwilioSMSService(@Qualifier("twilio") TwilioSMSSender smsSender) {
        this.smsSender = smsSender;
    }

    public void sendSms(TwilioSMSRequest smsRequest) {
        this.smsSender.sendSms(smsRequest);
    }
}