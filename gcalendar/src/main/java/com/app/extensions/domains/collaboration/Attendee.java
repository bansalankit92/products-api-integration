package com.app.extensions.domains.collaboration;

import com.google.api.services.calendar.model.EventAttendee;
import com.google.gson.annotations.SerializedName;

/**
 * THIS IS GENERATED CODE; MODIFY ONLY IF YOU UNDERSTAND WHAT YOU'RE DOING
 */
public final class Attendee {
    @SerializedName("Display Name")
    public String displayName;

    @SerializedName("Comment")
    public String comment;

    @SerializedName("Response Status")
    public String responseStatus;

    @SerializedName("Email")
    public String email;

    @SerializedName("Id")
    public String id;

    /**
     * Please add only relevant fields here for summary.
     */
    @Override
    public String toString() {
        return displayName + " | " + email;
    }

    public Attendee(String id, String displayName, String email, String responseStatus, String comment) {
        this.id = id;
        this.displayName = displayName;
        this.email = email;
        this.responseStatus = responseStatus;
        this.comment = comment;
    }

    public static Attendee from(EventAttendee eventAttendee) {
        return new Attendee(eventAttendee.getId(), eventAttendee.getDisplayName(), eventAttendee.getEmail(),
                eventAttendee.getResponseStatus() == null ? "needsAction" : eventAttendee.getResponseStatus(),
                eventAttendee.getComment());
    }

    public static EventAttendee to(Attendee attendee) {
        return new EventAttendee().setDisplayName(attendee.displayName).setEmail(attendee.email).setComment(attendee.comment)
                .setResponseStatus(attendee.responseStatus);
    }
}
