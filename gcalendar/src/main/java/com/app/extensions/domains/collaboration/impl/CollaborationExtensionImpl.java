package com.app.extensions.domains.collaboration.impl;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import com.app.extensions.domains.collaboration.*;
import com.github.scribejava.apis.GoogleApi20;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.exceptions.OAuthException;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.oauth.OAuth20Service;
import com.google.api.client.auth.oauth2.TokenResponseException;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.CalendarScopes;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventAttendee;
import com.google.api.services.calendar.model.EventDateTime;
import com.google.api.services.calendar.model.Events;
import com.google.gson.Gson;

/**
 * THIS IS GENERATED TEMPLATE CODE; YOU NEED TO IMPLEMENT REQUESTS & LIFECYCLE METHODS
 */
public class CollaborationExtensionImpl implements CollaborationExtension {

    public static final String CLIENT_ID = "clientId";
    public static final String CLIENT_SECRET = "clientSecret";
    public static final String CALL_BACK_URI = "callBackUri";
    public static final String REFRESH_TOKEN = "refresh_token";
    static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    public static final String PRIMARY = "primary";

    private static Gson gson = new Gson();

    private static OAuth20Service getGoogleService(Map<String, Object> connectionAttributes) {
        return new ServiceBuilder((String) connectionAttributes.get(CLIENT_ID))
                .apiSecret((String) connectionAttributes.get(CLIENT_SECRET))
                .defaultScope(CalendarScopes.CALENDAR)
                .callback((String) connectionAttributes.get(CALL_BACK_URI))
                .build(GoogleApi20.instance());
    }

    private static GoogleCredential getGoogleCredential(
            Map<String, Object> conAttr, NetHttpTransport HTTP_TRANSPORT) {
        // validate if extn attributes has the required values else return err
        GoogleCredential credential =
                new GoogleCredential.Builder()
                        .setClientSecrets((String) conAttr.get(CLIENT_ID), (String) conAttr.get(CLIENT_SECRET))
                        .setJsonFactory(JacksonFactory.getDefaultInstance())
                        .setTransport(HTTP_TRANSPORT)
                        .build();

        credential.setRefreshToken((String) conAttr.get(REFRESH_TOKEN));
        return credential;
    }

    private OAuth20Service oAuthService;
    private Map<String, Object> attributes = new HashMap<>();

    /**
     * Entity Selector For Event Details
     */
    @Override
    public List entitySelectorForEventDetails(String matchPattern,
            String selector, Long fetchSize, Long fetchPageNumber) throws Exception {
        List<Pair<String, String>> res = new ArrayList<>();
        res = getNextMeetings(Long.parseLong(matchPattern)).stream()
                .map(issue -> new Pair<>(issue.eventId, issue.toString()))
                .collect(Collectors.toList());
        return res;
    }

    /**
     * Fetch Event Details By Primary Key
     */
    @Override
    public EventDetails fetchEventDetailsByPrimaryKey(String primaryKey)
            throws Exception {
        return getEventDetails(primaryKey);
    }

    /**
     * Fetch Fields Supporting Search ForEvent Details
     */
    @Override
    public List fetchFieldsSupportingSearchForEventDetails() {
        return List.of("Number of hours");
    }

    @Override
    public List genericSearchForEntitySelectorForEventDetails(List searchParams, long fetchSize, long fetchPageNumber)
            throws Exception {

        return null;
    }

    @Override
    public String createEventDetails(EventDetails entityDefinition) throws Exception {
        return null;
    }

    @Override
    public String updateEventDetails(EventDetails entityDefinition, String primaryKey) throws Exception {
        return null;
    }

    /**
     * Entity Selector For Attendee
     */
    @Override
    public List entitySelectorForAttendee(String matchPattern,
            String selector, Long fetchSize, Long fetchPageNumber) throws Exception {
        throw new UnsupportedOperationException();
    }

    /**
     * Fetch Attendee By Primary Key
     */
    @Override
    public Attendee fetchAttendeeByPrimaryKey(String primaryKey) throws
            Exception {
        throw new UnsupportedOperationException();
    }

    /**
     * Fetch Fields Supporting Search ForAttendee
     */
    @Override
    public List fetchFieldsSupportingSearchForAttendee() {
        throw new UnsupportedOperationException();
    }

    /**
     * Entity Selector For Mail Details
     */
    @Override
    public List entitySelectorForMailDetails(String matchPattern,
            String selector, Long fetchSize, Long fetchPageNumber) throws Exception {
        throw new UnsupportedOperationException();
    }

    /**
     * Fetch Mail Details By Primary Key
     */
    @Override
    public MailDetails fetchMailDetailsByPrimaryKey(String primaryKey)
            throws Exception {
        throw new UnsupportedOperationException();
    }

    /**
     * Fetch Fields Supporting Search ForMail Details
     */
    @Override
    public List fetchFieldsSupportingSearchForMailDetails() {
        throw new UnsupportedOperationException();
    }

    @Override
    public List genericSearchForEntitySelectorForMailDetails(List searchParams, Double fetchSize,
            Double fetchPageNumber) throws Exception {
        return null;
    }

    @Override
    public String createMailDetails(MailDetails entityDefinition) throws Exception {
        return null;
    }

    @Override
    public String updateMailDetails(MailDetails entityDefinition, String primaryKey) throws Exception {
        return null;
    }

    /**
     * Send a mail
     */
    @Override
    public String sendMail(String to, String subject, String message)
            throws Exception {
        throw new UnsupportedOperationException();
    }

    /**
     * Fetch All Labels
     */
    @Override
    public List fetchAllLabels() {
        throw new UnsupportedOperationException();
    }

    /**
     * Fetch Mails By Labels
     */
    @Override
    public List fetchMailsByLabels(String label) throws Exception {
        throw new UnsupportedOperationException();
    }

    /**
     * Fetch Mail Details By Query
     */
    @Override
    public List fetchMailDetailsByQuery(String query) throws Exception {
        throw new UnsupportedOperationException();
    }

    /**
     * Fetch Inbox
     */
    @Override
    public List fetchInbox() {
        throw new UnsupportedOperationException();
    }

    /**
     * Fetch Sent
     */
    @Override
    public List fetchSent() {
        throw new UnsupportedOperationException();
    }

    /**
     * Schedule a meeting invite and it will be scheduled on the next hour of that date
     */
    @Override
    public String scheduleMeeting(String title, String details,
            String location, Long dateFrom, Long dateTo, String attendeeEmail) throws Exception {

        List<String> invitees = getAttendeesByCsv(attendeeEmail);

        try {
            Calendar service = getCalendar();
            Event event = new Event();
            // date from in ISO format "2020-05-17T05:30:00Z"

            Date from = new Date(dateFrom + (3600 * 1000));

            Date to = new Date(dateTo + (3600 * 1000 * 2));
            DateTime start = new DateTime(from);
            // "2020-05-17T06:30:00Z"
            DateTime end = new DateTime(to);
            event.setLocation(location);
            event.setStart(new EventDateTime().setDateTime(start));
            event.setEnd(new EventDateTime().setDateTime(end));
            event.setSummary(title);
            event.setDescription(details);
            List<EventAttendee> attendees = getEventAttendees(invitees);
            event.setAttendees(attendees);
            Event insertedEvent = service.events().insert(PRIMARY, event).execute();

            return insertedEvent.getId();
        } catch (OAuthException | TokenResponseException e) {
            throw new RuntimeException("Authorization error reauthorize the resource" + e.getMessage());
        } catch (GeneralSecurityException e) {
            throw new Exception("There is some general security exception: " + e.getMessage());
        } catch (IOException e) {
            throw new Exception("There is some IO exception: " + e.getMessage());
        }
    }

    /**
     * Add Attendees
     */
    @Override
    public String addAttendees(String eventId, String attendees) throws
            Exception {
        return this.addAttendees(eventId, getAttendeesByCsv(attendees));
    }

    /**
     * Remove Attendee
     */
    @Override
    public String removeAttendee(String eventId, String attendeeMail)
            throws Exception {

        try {
            Calendar service = getCalendar();
            Event fetchedEvent = service.events().get(PRIMARY, eventId).execute();
            List<String> deletedAttendeeEmail =
                    getEventAttendees(getAttendeesByCsv(attendeeMail)).stream().map(EventAttendee::getEmail)
                            .collect(Collectors.toList());

            fetchedEvent.setAttendees(fetchedEvent.getAttendees().stream()
                    .filter(eventAttendee -> !deletedAttendeeEmail.contains(eventAttendee.getEmail())).collect(
                            Collectors.toList()));
            Event updatedEvent = service.events().patch(PRIMARY, eventId, fetchedEvent).execute();
            System.out.println(updatedEvent.getAttendees().size());
            System.out.println(updatedEvent.getId());
            return updatedEvent.getId();
        } catch (OAuthException | TokenResponseException e) {
            throw new RuntimeException("Authorization error reauthorize the resource" + e.getMessage());
        } catch (GoogleJsonResponseException ex) {
            throw new Exception("There is some error in adding attendees maybe invalid email Id: " + ex.getMessage());
        } catch (GeneralSecurityException e) {
            throw new Exception("There is some general security exception: " + e.getMessage());
        } catch (IOException e) {
            throw new Exception("There is some IO exception: " + e.getMessage());
        }
    }

    /**
     * Get Next meetings
     */
    @Override
    public List<EventDetails> getNextMeetings(Long numberOfMeeting) throws Exception {

        try {
            Calendar service = getCalendar();
            DateTime now = new DateTime(System.currentTimeMillis());
            Events events = service
                    .events()
                    // primary means current logged in user calendar
                    // in case of other user we need to pass the calendar id
                    .list(PRIMARY)
                    .setMaxResults(Math.toIntExact(numberOfMeeting))
                    .setTimeMin(now)
                    .setOrderBy("startTime")
                    .setSingleEvents(true)
                    .execute();

            return events.getItems().stream().map(EventDetails::getEventDetailsByEvent).collect(
                    Collectors.toList());
        } catch (OAuthException | TokenResponseException e) {
            throw new RuntimeException("Authorization error reauthorize the resource" + e.getMessage());
        } catch (GeneralSecurityException e) {
            throw new Exception("There is some general security exception: " + e.getMessage());
        } catch (IOException e) {
            throw new Exception("There is some IO exception: " + e.getMessage());
        }
    }

    public List<EventDetails> searchMeetings(String q, Long numberOfMeeting) throws Exception {

        try {
            Calendar service = getCalendar();
            DateTime now = new DateTime(System.currentTimeMillis());
            Events events = service
                    .events()
                    // primary means current logged in user calendar
                    // in case of other user we need to pass the calendar id
                    .list(PRIMARY)
                    .set("q", q)
                    .setMaxResults(Math.toIntExact(numberOfMeeting))
                    .setTimeMin(now)
                    .setOrderBy("startTime")
                    .setSingleEvents(true)
                    .execute();

            return events.getItems().stream().map(EventDetails::getEventDetailsByEvent).collect(
                    Collectors.toList());
        } catch (OAuthException | TokenResponseException e) {
            throw new RuntimeException("Authorization error reauthorize the resource" + e.getMessage());
        } catch (GeneralSecurityException e) {
            throw new Exception("There is some general security exception: " + e.getMessage());
        } catch (IOException e) {
            throw new Exception("There is some IO exception: " + e.getMessage());
        }
    }

    /**
     * Delete Event
     */
    @Override
    public String deleteEvent(String eventId) throws Exception {
        try {
            Calendar service = getCalendar();
            service.events().delete(PRIMARY, eventId).execute();
            return "Event Deleted Successfully";
        } catch (OAuthException | TokenResponseException e) {
            throw new RuntimeException("Authorization error reauthorize the resource" + e.getMessage());
        } catch (GeneralSecurityException e) {
            throw new Exception("There is some general security exception: " + e.getMessage());
        } catch (IOException e) {
            throw new Exception("There is some IO exception: " + e.getMessage());
        }
    }

    /**
     * Accept Invitation
     */
    @Override
    public EventDetails acceptInvitation(String eventId,
            String emailAddress) throws Exception {

        try {
            return updateInvitation(eventId, "accepted", emailAddress);
        } catch (OAuthException | TokenResponseException e) {
            throw new RuntimeException("Authorization error reauthorize the resource" + e.getMessage());
        } catch (GeneralSecurityException e) {
            throw new Exception("There is some general security exception: " + e.getMessage());
        } catch (IOException e) {
            throw new Exception("There is some IO exception: " + e.getMessage());
        }
    }

    /**
     * Tentative Invitation
     */
    @Override
    public EventDetails tentativeInvitation(String eventId,
            String emailAddress) throws Exception {

        try {
            return updateInvitation(eventId, "tentative", emailAddress);
        } catch (OAuthException | TokenResponseException e) {
            throw new RuntimeException("Authorization error reauthorize the resource" + e.getMessage());
        } catch (GeneralSecurityException e) {
            throw new Exception("There is some general security exception: " + e.getMessage());
        } catch (IOException e) {
            throw new Exception("There is some IO exception: " + e.getMessage());
        }
    }

    /**
     * Decline Invitation
     */
    @Override
    public EventDetails declineInvitation(String eventId,
            String emailAddress) throws Exception {

        try {
            return updateInvitation(eventId, "declined", emailAddress);
        } catch (OAuthException | TokenResponseException e) {
            throw new RuntimeException("Authorization error reauthorize the resource" + e.getMessage());
        } catch (GeneralSecurityException e) {
            throw new Exception("There is some general security exception: " + e.getMessage());
        } catch (IOException e) {
            throw new Exception("There is some IO exception: " + e.getMessage());
        }
    }

    private EventDetails updateInvitation(String eventId, String status, String emailId)
            throws GeneralSecurityException, IOException {
        Calendar service = getCalendar();
        Event fetchedEvent = service.events().get(PRIMARY, eventId).execute();
        for (EventAttendee ea : fetchedEvent.getAttendees()) {
            if (ea.getEmail().equals(emailId)) {
                ea.setResponseStatus(status);
            }
        }
        Event e = service.events().patch(PRIMARY, eventId, fetchedEvent).execute();
        return EventDetails.getEventDetailsByEvent(e);
    }

    private EventDetails getEventDetails(String eventId) throws GeneralSecurityException, IOException {
        Calendar service = getCalendar();
        return EventDetails.getEventDetailsByEvent(service.events().get(PRIMARY, eventId).execute());
    }

    public void init(final Map attributes) {
        this.attributes = attributes;

        this.oAuthService = getGoogleService(this.attributes);
    }

    public String getAuthorizationUrl() {
        return this.oAuthService.getAuthorizationUrl() + "&access_type=offline&approval_prompt=force";
    }

    public Map getAuthTokenResponse()
            throws InterruptedException, ExecutionException, IOException, Exception {
        // assume that init method is called and extn attributes contain code from callback uri

        try {
            OAuth2AccessToken accessToken = oAuthService.getAccessToken((String) attributes.get("code"));

            Map resp = new HashMap();
            if (accessToken == null) {
                resp.put("error_message", "Didnt got the access token");
                resp.put("auth_url", getAuthorizationUrl());
                throw new RuntimeException("Authorization error occurred as the response is empty");
            } else {
                resp.put("access_token", accessToken.getAccessToken());
                resp.put("expires_in", accessToken.getExpiresIn());
                resp.put("scope", accessToken.getScope());
                resp.put("token_type", accessToken.getTokenType());
                resp.put("refresh_token", accessToken.getRefreshToken());
            }
            // need to save the response in db so that in further calls we can pass refresh token
            return resp;
        } catch (OAuthException | TokenResponseException e) {
            throw new RuntimeException(
                    "Authorization error reauthorize the resource"
                            + e.getMessage());
        } catch (Exception e) {
            throw new Exception(
                    "There is some exception: " + e.getMessage() + " " + Arrays.toString(e.getStackTrace()));
        }
    }

    public String getAuthUrl() {
        return getAuthorizationUrl();
    }

    private Calendar getCalendar() throws GeneralSecurityException, IOException {
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        GoogleCredential credential = getGoogleCredential(attributes, HTTP_TRANSPORT);
        return new Calendar.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential)
                .setApplicationName("Google Calendar")
                .build();
    }

    private List<EventAttendee> getEventAttendees(List eventDetailsAttendee) {
        List<EventAttendee> attendees = new ArrayList<>();
        if (eventDetailsAttendee != null && !eventDetailsAttendee.isEmpty()) {
            // in case of we have contact entity then we can get it from contact
            if (eventDetailsAttendee.get(0) instanceof String) {
                for (Object email : eventDetailsAttendee) {
                    attendees.add(new EventAttendee().setEmail((String) email));
                }
            }
            if (eventDetailsAttendee.get(0) instanceof Attendee) {
                for (Object attendee : eventDetailsAttendee) {
                    attendees.add(Attendee.to((Attendee) attendee));
                }
            }
        }
        return attendees;
    }

    private List<String> getAttendeesByCsv(String attendeeEmail) {
        List<String> invitees = new ArrayList<>();
        if (attendeeEmail.contains(",")) {
            String[] atten = attendeeEmail.trim().split(",");
            for (String a : atten) {
                invitees.add(a.trim());
            }
        } else {
            invitees.add(attendeeEmail);
        }
        return invitees;
    }

    public String addAttendees(String eventId, List attendees) throws
            Exception {

        try {
            Calendar service = getCalendar();
            Event getEvent = service.events().get(PRIMARY, eventId).execute();
            List<EventAttendee> eventAttendees = getEventAttendees(attendees);
            getEvent.getAttendees().addAll(eventAttendees);
            // uppdate
            Event updatedEvent = service.events().patch(PRIMARY, eventId, getEvent).execute();
            return updatedEvent.getId();
        } catch (OAuthException | TokenResponseException e) {
            throw new RuntimeException("Authorization error reauthorize the resource" + e.getMessage());
        } catch (GoogleJsonResponseException ex) {
            throw new Exception("There is some error in adding attendees maybe invalid email Id: " + ex.getMessage());
        } catch (GeneralSecurityException e) {
            throw new Exception("There is some general security exception: " + e.getMessage());
        } catch (IOException e) {
            throw new Exception("There is some IO exception: " + e.getMessage());
        }
    }

}
