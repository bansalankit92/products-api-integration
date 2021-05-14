import com.app.extensions.domains.messaging.impl.MessagingExtensionImpl;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class TwilioRunner {
    public static void main(String[] args) {
        MessagingExtensionImpl impl = new MessagingExtensionImpl();
        String sid = "AC53e7384abc9ec2f25456eed2c472e055";
        String authToken = "6fe20c6a42ef902698c6a4d565e45d36";
        String phoneNumber = "+13158471521";

        Twilio.init(sid, authToken);

        Message message = Message
                .creator(new PhoneNumber("+919765678853"), // to
                        new PhoneNumber(phoneNumber), // from
                        "I am sending you the message, If you got this you know who I am :)")
                .create();

        System.out.println(message.getSid());
    }
}