package com.app.extensions.domains.collaboration.impl;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.*;
import java.util.stream.Collectors;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import com.app.extensions.domains.collaboration.*;
import com.app.extensions.domains.collaboration.util.GmailUtil;
import com.github.scribejava.core.exceptions.OAuthException;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.oauth.OAuth20Service;
import com.google.api.client.auth.oauth2.TokenResponseException;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.model.Label;
import com.google.api.services.gmail.model.Message;
import com.google.gson.Gson;

/**
 * THIS IS GENERATED TEMPLATE CODE; YOU NEED TO IMPLEMENT REQUESTS & LIFECYCLE METHODS
 */
public class CollaborationExtensionImpl implements CollaborationExtension {

    public static final String ME = "me";
    private OAuth20Service oAuthService;
    private Map<String, Object> attributes = new HashMap<>();

    private static Gson gson = new Gson();

    /**
     * Entity Selector For Event Details
     */
    @Override
    public List entitySelectorForEventDetails(String matchPattern,
            String selector, Long fetchSize, Long fetchPageNumber) throws Exception {
        throw new UnsupportedOperationException();
    }

    /**
     * Fetch Event Details By Primary Key
     */
    @Override
    public EventDetails fetchEventDetailsByPrimaryKey(String primaryKey)
            throws Exception {
        throw new UnsupportedOperationException();
    }

    /**
     * Fetch Fields Supporting Search ForEvent Details
     */
    @Override
    public List fetchFieldsSupportingSearchForEventDetails() {
        throw new UnsupportedOperationException();
    }

    @Override
    public List genericSearchForEntitySelectorForEventDetails(List searchParams, Double fetchSize,
            Double fetchPageNumber) throws Exception {
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
        List<Pair<String, String>> res = new ArrayList<>();
        if (selector.equalsIgnoreCase("label")) {
            String label = fetchAllLabels().stream().filter(lab -> lab.toLowerCase().contains(matchPattern)).findFirst()
                    .orElseThrow(() -> new RuntimeException("Labels not found " + matchPattern));
            res = fetchMailsByLabels(label).stream()
                    .map(issue -> new Pair<>(issue.id, issue.toString()))
                    .collect(Collectors.toList());
        } else if (selector.equalsIgnoreCase("Search")) {
            res = fetchMailDetailsByQuery(matchPattern).stream()
                    .map(issue -> new Pair<>(issue.id, issue.toString()))
                    .collect(Collectors.toList());
        }
        return res;
    }

    /**
     * Fetch Mail Details By Primary Key
     */
    @Override
    public MailDetails fetchMailDetailsByPrimaryKey(String primaryKey)
            throws Exception {
        return getMailDetails(primaryKey);
    }

    /**
     * Fetch Fields Supporting Search ForMail Details
     */
    @Override
    public List fetchFieldsSupportingSearchForMailDetails() {
        return List.of("Label", "Search");
    }

    @Override
    public List genericSearchForEntitySelectorForMailDetails(List searchParams, long fetchSize, long fetchPageNumber)
            throws Exception {

        return new ArrayList();
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

        try {
            MimeMessage mimeMessage;
            if (to.contains(",")) {
                mimeMessage =
                        GmailUtil.createEmail("noreply@example.com", Arrays.asList(to.split(",")), subject, message);
            } else {
                mimeMessage = GmailUtil.createEmail("noreply@example.com", to, subject, message);
            }
            Message email = GmailUtil.sendMessage(getGmail(), ME, mimeMessage);
            return "Message Sent Successfully and id is " + email.getId();
        } catch (OAuthException | TokenResponseException e) {
            throw new RuntimeException("Authorization error reauthorize the resource" + e.getMessage());
        } catch (GeneralSecurityException e) {
            throw new Exception("There is some general security exception: " + e.getMessage());
        } catch (Exception e) {
            throw new Exception("There is some exception: " + e.getMessage());
        }
    }

    /**
     * Fetch All Labels
     */
    @Override
    public List<String> fetchAllLabels() throws Exception {

        try {

            List<Label> labels = GmailUtil.getLabels(getGmail(), ME);
            if (labels.isEmpty()) {
                throw new RuntimeException(new RuntimeException("No Labels found"));
            } else {
                return labels.stream().map(Label::getName).collect(Collectors.toList());
            }
        } catch (OAuthException | TokenResponseException e) {
            throw new RuntimeException("Authorization error reauthorize the resource" + e.getMessage());
        } catch (GeneralSecurityException e) {
            throw new Exception("There is some general security exception: " + e.getMessage());
        } catch (Exception e) {
            throw new Exception("There is some exception: " + e.getMessage());
        }
    }

    /**
     * Fetch Mails By Labels
     */
    @Override
    public List<MailDetails> fetchMailsByLabels(String label) throws Exception {

        try {
            List<Message> msg = GmailUtil.listMessagesWithLabels(getGmail(), ME, label.toUpperCase(), 20L);
            return getMessageDetails(msg);
        } catch (OAuthException | TokenResponseException e) {
            throw new RuntimeException("Authorization error reauthorize the resource" + e.getMessage());
        } catch (GeneralSecurityException e) {
            throw new Exception("There is some general security exception: " + e.getMessage());
        } catch (Exception e) {
            throw new Exception("There is some exception: " + e.getMessage());
        }
    }

    /**
     * Fetch Mail Details By Query
     */
    @Override
    public List<MailDetails> fetchMailDetailsByQuery(String query) throws Exception {

        try {
            List<Message> msg = GmailUtil.listMessagesMatchingQuery(getGmail(), ME, query, 20);
            return getMessageDetails(msg);
        } catch (OAuthException | TokenResponseException e) {
            throw new RuntimeException("Authorization error reauthorize the resource" + e.getMessage());
        } catch (GeneralSecurityException e) {
            throw new Exception("There is some general security exception: " + e.getMessage());
        } catch (Exception e) {
            throw new Exception("There is some exception: " + e.getMessage());
        }
    }

    /**
     * Fetch Inbox
     */
    @Override
    public List fetchInbox() throws Exception {
        try {
            List<Message> msgs = GmailUtil.listMessagesWithLabels(getGmail(), ME, "INBOX", 20L);
            return getMessageDetails(msgs);
        } catch (OAuthException | TokenResponseException e) {
            throw new RuntimeException("Authorization error reauthorize the resource" + e.getMessage());
        } catch (GeneralSecurityException e) {
            throw new Exception("There is some general security exception: " + e.getMessage());
        } catch (Exception e) {
            throw new Exception("There is some exception: " + e.getMessage());
        }
    }

    /**
     * Fetch Sent
     */
    @Override
    public List fetchSent() throws Exception {

        try {
            List<Message> msgs = GmailUtil.listMessagesWithLabels(getGmail(), ME, "SENT", 20L);
            return getMessageDetails(msgs);
        } catch (OAuthException | TokenResponseException e) {
            throw new RuntimeException("Authorization error reauthorize the resource" + e.getMessage());
        } catch (GeneralSecurityException e) {
            throw new Exception("There is some general security exception: " + e.getMessage());
        } catch (Exception e) {
            throw new Exception("There is some exception: " + e.getMessage());
        }
    }

    /**
     * Schedule a meeting invite and it will be scheduled on the next hour of that date
     */
    @Override
    public String scheduleMeeting(String title, String details,
            String location, Long dateFrom, Long dateTo, String attendeeEmail) throws Exception {
        throw new UnsupportedOperationException();
    }

    /**
     * Add Attendees
     */
    @Override
    public String addAttendees(String eventId, String attendees) throws
            Exception {
        throw new UnsupportedOperationException();
    }

    /**
     * Remove Attendee
     */
    @Override
    public String removeAttendee(String eventId, String attendeeMail)
            throws Exception {
        throw new UnsupportedOperationException();
    }

    /**
     * Get Next meetings
     */
    @Override
    public List getNextMeetings(Long numberOfMeeting) throws Exception {
        throw new UnsupportedOperationException();
    }

    /**
     * Delete Event
     */
    @Override
    public String deleteEvent(String eventId) throws Exception {
        throw new UnsupportedOperationException();
    }

    /**
     * Accept Invitation
     */
    @Override
    public EventDetails acceptInvitation(String eventId,
            String emailAddress) throws Exception {
        throw new UnsupportedOperationException();
    }

    /**
     * Tentative Invitation
     */
    @Override
    public EventDetails tentativeInvitation(String eventId,
            String emailAddress) throws Exception {
        throw new UnsupportedOperationException();
    }

    /**
     * Decline Invitation
     */
    @Override
    public EventDetails declineInvitation(String eventId,
            String emailAddress) throws Exception {
        throw new UnsupportedOperationException();
    }

    // @Override
    public List fetchDraft() throws Exception {
        try {
            List<Message> msgs = GmailUtil.listMessagesWithLabels(getGmail(), ME, "DRAFT", 20L);
            return getMessageDetails(msgs);
        } catch (OAuthException | TokenResponseException e) {
            throw new RuntimeException("Authorization error reauthorize the resource" + e.getMessage());
        } catch (GeneralSecurityException e) {
            throw new Exception("There is some general security exception: " + e.getMessage());
        } catch (Exception e) {
            throw new Exception("There is some exception: " + e.getMessage());
        }
    }

    public String getAuthorizationUrl() {
        return this.oAuthService.getAuthorizationUrl() + "&access_type=offline&approval_prompt=force";
    }

    public Map getAuthTokenResponse()
            throws Exception {
        // assume that init method is called and extn attributes contain code from callback uri

        try {
            Object code = attributes.get("code");

            Map resp = new HashMap();
            if (code == null) {
                resp.put("error_message", "Didnt got the access token");
                resp.put("auth_url", getAuthorizationUrl());
                throw new RuntimeException("Authorization error occurred as the response is empty");
            } else {
                OAuth2AccessToken accessToken = oAuthService.getAccessToken((String) code);
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

    private Gmail getGmail() throws GeneralSecurityException, IOException {
        return GmailUtil.getGmail(attributes);
    }

    public String getAuthUrl() {
        return getAuthorizationUrl();
    }

    private List<MailDetails> getMessageDetails(List<Message> msgs) {
        return msgs.stream().map(msg -> {
            try {
                Message message = GmailUtil.getMessage(getGmail(), ME, msg.getId());
                MailDetails mailDetails = GmailUtil.from(message);
                mailDetails.id = message.getId();
                return mailDetails;
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }).collect(Collectors.toList());
    }

    private MailDetails getMailDetails(String id) throws GeneralSecurityException, IOException, MessagingException {
        Message message = GmailUtil.getMessage(getGmail(), ME, id);
        MailDetails mailDetails = GmailUtil.from(message);
        mailDetails.id = message.getId();
        return mailDetails;
    }

}
