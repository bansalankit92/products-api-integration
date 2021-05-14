package com.app.extensions.domains.collaboration;

import java.util.List;
import com.krista.extensions.Domain;
import com.krista.extensions.Extension;

/**
 * THIS IS GENERATED CODE; MODIFY ONLY IF YOU UNDERSTAND WHAT YOU'RE DOING
 */
@Domain(
        id = "catEntryDomain_5fa2fc97-4b17-44cf-b98f-aa91a459a091",
        name = "Collaboration",
        version = "ver_b9325397-37f1-4731-b618-229f730d7aad"
)
public interface CollaborationExtension extends Extension {
    /**
     * Entity Selector For Event Details
     */
    List entitySelectorForEventDetails(String matchPattern,
                                       String selector, Long fetchSize, Long fetchPageNumber) throws Exception;

    /**
     * Entity Selector For Attendee
     */
    List entitySelectorForAttendee(String matchPattern, String selector,
                                   Long fetchSize, Long fetchPageNumber) throws Exception;

    /**
     * Fetch Attendee By Primary Key
     */
    Attendee fetchAttendeeByPrimaryKey(String primaryKey) throws
            Exception;

    /**
     * Fetch Fields Supporting Search ForAttendee
     */
    List fetchFieldsSupportingSearchForAttendee();

    /**
     * Entity Selector For Mail Details
     */
    List entitySelectorForMailDetails(String matchPattern,
                                      String selector, Long fetchSize, Long fetchPageNumber) throws Exception;

    /**
     * Send a mail
     */
    String sendMail(String to, String subject, String message) throws
            Exception;

    /**
     * Fetch All Labels
     */
    List fetchAllLabels() throws Exception;

    /**
     * Fetch Mails By Labels
     */
    List fetchMailsByLabels(String label) throws Exception;

    /**
     * Fetch Mail Details By Query
     */
    List fetchMailDetailsByQuery(String query) throws Exception;

    /**
     * Fetch Inbox
     */
    List fetchInbox() throws Exception;

    /**
     * Fetch Sent
     */
    List fetchSent() throws Exception;

    /**
     * Schedule a meeting invite and it will be scheduled on the next hour of that date
     */
    String scheduleMeeting(String title, String details, String location,
                           Long dateFrom, Long dateTo, String attendeeEmail) throws Exception;

    /**
     * Add Attendees
     */
    String addAttendees(String eventId, String attendees) throws
            Exception;

    /**
     * Remove Attendee
     */
    String removeAttendee(String eventId, String attendeeMail) throws
            Exception;

    /**
     * Get Next meetings
     */
    List getNextMeetings(Long numberOfMeeting) throws Exception;

    /**
     * Delete Event
     */
    String deleteEvent(String eventId) throws Exception;

    /**
     * Accept Invitation
     */
    EventDetails acceptInvitation(String eventId, String emailAddress)
            throws Exception;

    /**
     * Tentative Invitation
     */
    EventDetails tentativeInvitation(String eventId, String emailAddress)
            throws Exception;

    /**
     * Decline Invitation
     */
    EventDetails declineInvitation(String eventId, String emailAddress)
            throws Exception;

    /**
     * Fetch Event Details By Primary Key
     */
    EventDetails fetchEventDetailsByPrimaryKey(String primaryKey) throws Exception;

    /**
     * Fetch Fields Supporting Search For Event Details
     */
    List fetchFieldsSupportingSearchForEventDetails();

    /**
     * For Generic Search for entity selector for Event Details. The List is a List<Pair<String, Pair<String, String>>>
     */
    List genericSearchForEntitySelectorForEventDetails(List searchParams, Double fetchSize,
                                                       Double fetchPageNumber) throws Exception;

    /**
     * Create Event Details
     */
    String createEventDetails(EventDetails entityDefinition) throws Exception;

    /**
     * Update Event Details
     */
    String updateEventDetails(EventDetails entityDefinition, String primaryKey) throws Exception;

    /**
     * Fetch Mail Details By Primary Key
     */
    MailDetails fetchMailDetailsByPrimaryKey(String primaryKey) throws Exception;

    /**
     * Fetch Fields Supporting Search For Mail Details
     */
    List fetchFieldsSupportingSearchForMailDetails();

    /**
     * For Generic Search for entity selector for Mail Details. The List is a List<Pair<String, Pair<String, String>>>
     */
    List genericSearchForEntitySelectorForMailDetails(List searchParams, long fetchSize,
                                                      long fetchPageNumber) throws Exception;

    /**
     * Create Mail Details
     */
    String createMailDetails(MailDetails entityDefinition) throws Exception;

    /**
     * Update Mail Details
     */
    String updateMailDetails(MailDetails entityDefinition, String primaryKey) throws Exception;
}
