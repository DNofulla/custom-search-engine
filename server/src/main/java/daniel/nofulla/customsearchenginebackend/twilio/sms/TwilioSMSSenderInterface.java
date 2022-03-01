package daniel.nofulla.customsearchenginebackend.twilio.sms;

public interface TwilioSMSSenderInterface {
    void sendSms(TwilioSMSRequest smsRequest);
}