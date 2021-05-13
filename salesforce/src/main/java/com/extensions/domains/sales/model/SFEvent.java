package com.extensions.domains.sales.model;

import com.google.gson.annotations.SerializedName;
import com.extensions.domains.sales.Event;

import java.util.Date;

/**
 * THIS IS GENERATED CODE; MODIFY ONLY IF YOU UNDERSTAND WHAT YOU'RE DOING
 */

public final class SFEvent {
    @SerializedName("AccountId")
    public String accountId;

    @SerializedName("LastModifiedDate")
    public Date lastModifiedDate;

    @SerializedName("OwnerId")
    public String ownerId;

    @SerializedName("IsPrivate")
    public Boolean isPrivate;

    @SerializedName("CreatedDate")
    public Date createdDate;

    @SerializedName("WhoId")
    public String leadId;

    @SerializedName("StartDateTime")
    public Date startDateTime;

    @SerializedName("EndDateTime")
    public Date endDateTime;

    @SerializedName("Id")
    public String id;

    @SerializedName("IsGroupEvent")
    public Boolean isGroupEvent;

    @SerializedName("Subject")
    public String subject;

    @SerializedName("Location")
    public String location;

    public static Event to(SFEvent sfEvent) {
        Event event = new Event();
        event.id = sfEvent.id;
        event.lastModifiedDate = sfEvent.lastModifiedDate != null ? sfEvent.lastModifiedDate.getTime() : null;
        event.ownerId = sfEvent.ownerId;
        event.createdDate = sfEvent.createdDate != null ? sfEvent.createdDate.getTime() : null;
        event.subject = sfEvent.subject;
        event.accountId = sfEvent.accountId;
        event.endDateTime = sfEvent.endDateTime != null ? sfEvent.endDateTime.getTime() : null;
        event.startDateTime = sfEvent.startDateTime != null ? sfEvent.startDateTime.getTime() : null;
        event.location = sfEvent.location;
        event.isGroupEvent = sfEvent.isGroupEvent;
        event.isPrivate = sfEvent.isPrivate;
        event.leadId = sfEvent.leadId;
        return event;
    }

    public static SFEvent from(Event sfEvent) {
        SFEvent event = new SFEvent();
        event.id = sfEvent.id;
        event.ownerId = sfEvent.ownerId;
        event.location = sfEvent.location;
        event.isGroupEvent = sfEvent.isGroupEvent;
        event.isPrivate = sfEvent.isPrivate;
        event.leadId = sfEvent.leadId;
        event.subject = sfEvent.subject;
        event.accountId = sfEvent.accountId;
        if (sfEvent.lastModifiedDate != null)
            event.lastModifiedDate = new Date(sfEvent.lastModifiedDate);
        if (sfEvent.createdDate != null)
            event.createdDate = new Date(sfEvent.createdDate);
        if (sfEvent.startDateTime != null)
            event.startDateTime = new Date(sfEvent.startDateTime);
        if (sfEvent.endDateTime != null)
            event.endDateTime = new Date(sfEvent.endDateTime);
        return event;
    }

    //Id,WhoId,Subject,Location,StartDateTime,EndDateTime,Description,AccountId,OwnerId,IsPrivate,ShowAs,IsGroupEvent,CreatedDate,LastModifiedDate

}
