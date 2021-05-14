package com.app.extensions.domains.messaging.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.app.extensions.domains.messaging.DateRange;
import com.app.extensions.domains.messaging.Message;
import com.app.extensions.domains.messaging.MessagingExtension;
import com.app.extensions.domains.messaging.util.TwilioUtil;
import com.google.gson.Gson;
import com.twilio.Twilio;

/**
 * THIS IS GENERATED TEMPLATE CODE; YOU NEED TO IMPLEMENT REQUESTS & LIFECYCLE METHODS
 */
public class MessagingExtensionImpl implements MessagingExtension {

    public static final String ACCOUNT_SID = "Account SId";
    public static final String AUTH_TOKEN = "Auth Token";
    public static final String PHONE_NUMBER = "Your Phone Number";
    private Map<String, Object> attributes = new HashMap<>();
    private String twilioPhoneNumber;
    private String myPhoneNo;
    private static Gson gson = new Gson();

    @Override
    public Message sendSmsToMe(String message) throws Exception {
        return TwilioUtil.sendTwilioMessage(message, twilioPhoneNumber, myPhoneNo);
    }

    @Override
    public Message sendMessage(String msg, String phoneNumber) throws Exception {
        return TwilioUtil.sendTwilioMessage(msg, twilioPhoneNumber, phoneNumber);
    }

    @Override
    public Message fetchMessage(String messageId) throws Exception {
        return TwilioUtil.fetch(messageId);
    }

    @Override
    public List listMessages(String from, String to, DateRange dateRange, Long pageSize, Long pageNumber)
            throws Exception {
        return TwilioUtil.list(from, to, null, dateRange, pageSize, pageNumber);
    }

    @Override
    public Message fetchMessageByPrimaryKey(String primaryKey) throws Exception {
        return TwilioUtil.fetch(primaryKey);
    }

    @Override
    public List fetchFieldsSupportingSearchForMessage() {
        return new ArrayList<>();
    }

    @Override
    public String createMessage(Message m) throws Exception {
        return sendMessage(m.body, m.to).id;
    }

    @Override
    public String updateMessage(Message entityDefinition, String primaryKey) throws Exception {
        return null;
    }

    public void init(final HashMap arg0) {
        attributes = arg0;

        Twilio.init(getValue(ACCOUNT_SID), getValue(AUTH_TOKEN));
        twilioPhoneNumber = getValue(PHONE_NUMBER);
        myPhoneNo = "+919889562323";

    }

    public String getValue(String key) {
        Object value = (attributes.get(key));
        if (value == null) {
            throw new RuntimeException("Please provide correct " + key);
        }
        return String.valueOf(value);
    }

}
