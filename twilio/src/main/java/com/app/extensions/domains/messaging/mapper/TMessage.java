package com.app.extensions.domains.messaging.mapper;

import com.app.extensions.domains.messaging.Message;

public class TMessage {

    public static Message from(com.twilio.rest.api.v2010.account.Message msg){
        Message m = new Message();
        m.body = msg.getBody();
        m.dateSent = msg.getDateSent()!=null ?msg.getDateSent().toInstant().toEpochMilli():null;
        m.from = msg.getFrom().toString();
        m.to = msg.getTo();
        m.status = msg.getStatus().name();
        m.id = msg.getSid();


        return m;
    }
}