package com.app.extensions.domains.messaging.util;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import com.app.extensions.domains.messaging.DateRange;
import com.app.extensions.domains.messaging.mapper.TMessage;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageReader;

public class TwilioUtil {

    public static com.app.extensions.domains.messaging.Message sendTwilioMessage(String msg, String twilioPhoneNumber, String toPhoneNumber) {
        Message message = Message
                .creator(new com.twilio.type.PhoneNumber(toPhoneNumber), // to
                        new com.twilio.type.PhoneNumber(twilioPhoneNumber), // from
                        msg)
                .create();
        return TMessage.from(message);
    }

    public static com.app.extensions.domains.messaging.Message fetch(String msgid) {
        Message message = Message.fetcher(msgid).fetch();
        return TMessage.from(message);
    }

    public static List<com.app.extensions.domains.messaging.Message> list(String from, String to, Long dateSent, DateRange dateRange, Long pageSize, Long pageNumber) {
        MessageReader reader = Message.reader();
        if (dateRange != null && dateRange.from != null && dateRange.to != null) {
            reader.setDateSentAfter(ZonedDateTime.ofInstant(Instant.ofEpochMilli(dateRange.from),
                    ZoneId.systemDefault()));
            reader.setDateSentBefore(ZonedDateTime.ofInstant(Instant.ofEpochMilli(dateRange.to),
                    ZoneId.systemDefault()));
        }
        if (dateSent != null) {
            reader.setDateSent(ZonedDateTime.ofInstant(Instant.ofEpochMilli(dateSent),
                    ZoneId.systemDefault()));
        }
        if (from != null && !from.isBlank())
            reader.setFrom(new com.twilio.type.PhoneNumber(from));
        if (to != null && !to.isBlank())
            reader.setTo(new com.twilio.type.PhoneNumber(to));
        long size = pageSize != null ? pageSize : 20;
        long page = pageNumber != null ? pageNumber : 1;
        reader.limit(size * page);
        List<com.app.extensions.domains.messaging.Message> res = new ArrayList<>();
        ResourceSet<Message> messages = reader.read();
        for (Message m : messages) {
            res.add(TMessage.from(m));
        }
        return res;
    }

}