package com.app.extensions.domains.collaboration;

import java.util.List;
import java.util.stream.Collectors;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventAttendee;
import com.google.gson.annotations.SerializedName;

/**
 * THIS IS GENERATED CODE; MODIFY ONLY IF YOU UNDERSTAND WHAT YOU'RE DOING
 */
public final class EventDetails {
  @SerializedName("Details")
  public String details;

  @SerializedName("Date To")
  public String dateTo;

  @SerializedName("Contacts")
  public List contacts;

  @SerializedName("Title")
  public String title;

  @SerializedName("Event Id")
  public String eventId;

  @SerializedName("Date From")
  public String dateFrom;

  @SerializedName("Location")
  public String location;

  public static EventDetails getEventDetailsByEvent(Event event) {
        EventDetails details = new EventDetails();
        details.eventId = event.getId();
        details.dateFrom = event.getStart().getDateTime().toStringRfc3339();
        details.dateTo = event.getEnd().getDateTime().toStringRfc3339();
        details.details = event.getDescription();
        details.title = event.getSummary();
        details.location = event.getLocation();
        //
        details.contacts =
                event.getAttendees().stream().map(EventAttendee::getEmail).collect(Collectors.toList());
        return details;
    }

  /**
   * Please add only relevant fields here for summary.
   */
  @Override
  public String toString() {
    return title;
  }
}
