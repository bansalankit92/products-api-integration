package com.app.extensions.domains.collaboration.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.util.*;
import javax.mail.Address;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import com.github.scribejava.apis.GoogleApi20;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.oauth.OAuth20Service;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.Base64;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.GmailScopes;
import com.google.api.services.gmail.model.*;
import com.app.extensions.domains.collaboration.MailDetails;

public class GmailUtil {
    public static final String CLIENT_ID = "clientId";
    public static final String CLIENT_SECRET = "clientSecret";
    public static final String CALL_BACK_URI = "callBackUri";
    public static final String REFRESH_TOKEN = "refresh_token";
    static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    public static final String PRIMARY = "primary";

    public static OAuth20Service getGoogleService(Map<String, Object> connectionAttributes) {
        return new ServiceBuilder((String) connectionAttributes.get(CLIENT_ID))
                .apiSecret((String) connectionAttributes.get(CLIENT_SECRET))
                .defaultScope(GmailScopes.GMAIL_MODIFY)
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

    public static Gmail getGmail(Map<String, Object> attributes) throws GeneralSecurityException, IOException {
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        GoogleCredential credential = getGoogleCredential(attributes, HTTP_TRANSPORT);
        return new Gmail.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential)
                .setApplicationName("Google Mail")
                .build();
    }


    public static List<Message> listMessagesMatchingQuery(Gmail service, String userId,
                                                          String query, int size) throws IOException {
        ListMessagesResponse response = service.users().messages().list(userId).setQ(query).setMaxResults((long) size).execute();

        List<Message> messages = new ArrayList<Message>();
        while (response.getMessages() != null && messages.size() < size) {
            messages.addAll(response.getMessages());
            if (response.getNextPageToken() != null) {
                String pageToken = response.getNextPageToken();
                response = service.users().messages().list(userId).setQ(query)
                        .setPageToken(pageToken).execute();
            } else {
                break;
            }
        }
        return messages;
    }

    /**
     * List all Messages of the user's mailbox with labelIds applied.
     *
     * @param service Authorized Gmail API instance.
     * @param userId  User's email address. The special value "me"
     *                can be used to indicate the authenticated user.
     * @param labelId Only return Messages with these labelIds applied.
     * @throws IOException
     */
    public static List<Message> listMessagesWithLabels(Gmail service, String userId,
                                                       String labelId, Long size) throws IOException {
        ListMessagesResponse response = service.users().messages().list(userId)
                .setLabelIds(Collections.singletonList(labelId.toUpperCase())).execute();

        List<Message> messages = new ArrayList<Message>();
        while (response.getMessages() != null && messages.size() < size) {
            messages.addAll(response.getMessages());
            if (response.getNextPageToken() != null) {
                String pageToken = response.getNextPageToken();
                response = service.users().messages().list(userId).setLabelIds(Collections.singletonList(labelId.toUpperCase()))
                        .setPageToken(pageToken).execute();
            } else {
                break;
            }
        }
        return messages;
    }

    public static Message sendMessage(Gmail service,
                                      String userId,
                                      MimeMessage emailContent)
            throws MessagingException, IOException {
        Message message = createMessageWithEmail(emailContent);
        message = service.users().messages().send(userId, message).execute();
        return message;
    }

    public static MimeMessage createEmail(String from,
                                          String to,
                                          String subject,
                                          String bodyText)
            throws MessagingException {
        Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);

        MimeMessage email = new MimeMessage(session);

        email.setFrom(new InternetAddress(from));
        email.addRecipient(javax.mail.Message.RecipientType.TO,
                new InternetAddress(to));
        email.setSubject(subject);
        email.setText(bodyText);
        return email;
    }

    public static MimeMessage createEmail(String from,
                                          List<String> to,
                                          String subject,
                                          String bodyText)
            throws MessagingException {
        Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);

        MimeMessage email = new MimeMessage(session);

        email.setFrom(new InternetAddress(from));

        Address[] tos = getAddresses(to);
        email.addRecipients(javax.mail.Message.RecipientType.TO,
                tos);
        email.setSubject(subject);
        email.setText(bodyText);
        return email;
    }

    public static MimeMessage createEmail(String from,
                                          List<String> to,
                                          List<String> cc,
                                          String subject,
                                          String bodyText)
            throws MessagingException {
        Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);

        MimeMessage email = new MimeMessage(session);

        email.setFrom(new InternetAddress(from));
        Address[] tos = getAddresses(to);
        email.addRecipients(javax.mail.Message.RecipientType.TO,
                tos);

        Address[] ccs = getAddresses(cc);
        email.addRecipients(javax.mail.Message.RecipientType.CC,
                ccs);
        email.setSubject(subject);
        email.setText(bodyText);
        return email;
    }

    private static Address[] getAddresses(List<String> to) throws AddressException {
        Address[] tos = new Address[to.size()];
        for (int i = 0; i < to.size(); i++) {
            tos[i] = new InternetAddress(to.get(i).trim());
        }
        return tos;
    }

    public static MimeMessage createEmail(MailDetails mailDetails)
            throws MessagingException {
        Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);

        MimeMessage email = new MimeMessage(session);

        email.setFrom(new InternetAddress(mailDetails.from));
        email.addRecipient(javax.mail.Message.RecipientType.TO,
                new InternetAddress(mailDetails.to));
        email.setSubject(mailDetails.subject);
        email.setText(mailDetails.message);
        return email;
    }

    public static Message createMessageWithEmail(MimeMessage emailContent)
            throws MessagingException, IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        emailContent.writeTo(buffer);
        byte[] bytes = buffer.toByteArray();
        String encodedEmail = com.google.api.client.util.Base64.encodeBase64URLSafeString(bytes);
        Message message = new Message();
        message.setRaw(encodedEmail);
        return message;
    }

    public static Draft createDraft(Gmail service,
                                    String userId,
                                    MimeMessage emailContent)
            throws MessagingException, IOException {
        Message message = createMessageWithEmail(emailContent);
        Draft draft = new Draft();
        draft.setMessage(message);
        draft = service.users().drafts().create(userId, draft).execute();
        return draft;
    }

    public static List<Label> getLabels(Gmail service,
                                        String userId) throws IOException {
        ListLabelsResponse listResponse = service.users().labels().list(userId).execute();
        List<Label> labels = listResponse.getLabels();
        return labels;
    }


    /**
     * Get Message with given ID.
     *
     * @param service   Authorized Gmail API instance.
     * @param userId    User's email address. The special value "me"
     *                  can be used to indicate the authenticated user.
     * @param messageId ID of Message to retrieve.
     * @return Message Retrieved Message.
     * @throws IOException
     */
    public static Message getMessage(Gmail service, String userId, String messageId)
            throws IOException {
        Message message = service.users().messages().get(userId, messageId).execute();
        return message;
    }

    /**
     * Get a Message and use it to create a MimeMessage.
     *
     * @param service   Authorized Gmail API instance.
     * @param userId    User's email address. The special value "me"
     *                  can be used to indicate the authenticated user.
     * @param messageId ID of Message to retrieve.
     * @return MimeMessage MimeMessage populated from retrieved Message.
     * @throws IOException
     * @throws MessagingException
     */
    public static MimeMessage getMimeMessage(Gmail service, String userId, String messageId)
            throws IOException, MessagingException {
        Message message = service.users().messages().get(userId, messageId).setFormat("raw").execute();

        byte[] emailBytes = Base64.decodeBase64(message.getRaw());

        Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);

        MimeMessage email = new MimeMessage(session, new ByteArrayInputStream(emailBytes));

        return email;
    }


    public static MailDetails from(Message email) throws MessagingException, IOException {
            MailDetails mailDetails = new MailDetails();

            MessagePart part = email.getPayload();

            for (MessagePartHeader partHeader : part.getHeaders()) {
                if (partHeader.getName().equalsIgnoreCase("from")) {
                    mailDetails.from = partHeader.getValue();
                }
                if (partHeader.getName().equalsIgnoreCase("to")) {
                    mailDetails.to = partHeader.getValue();
                }
                if (partHeader.getName().equalsIgnoreCase("subject")) {
                    mailDetails.subject = partHeader.getValue();
                }
            }
            mailDetails.snippet = email.getSnippet();
            mailDetails.message = getContent(email);

            return mailDetails;

        }

        public static String getContent(Message message) {
            StringBuilder stringBuilder = new StringBuilder();
            try {
                getPlainTextFromMessageParts(message.getPayload().getParts(), stringBuilder);
                byte[] bodyBytes = com.google.api.client.repackaged.org.apache.commons.codec.binary.Base64.decodeBase64(stringBuilder.toString());
                String text = new String(bodyBytes, StandardCharsets.UTF_8);
                return text;
            } catch (Exception e) {
                //System.out.println("UnsupportedEncoding: " + e.toString());
                return message.getSnippet();
            }
        }

        // https://stackoverflow.com/questions/24428246/retrieve-email-message-body-in-html-using-gmail-api
        private static void getPlainTextFromMessageParts(List<MessagePart> messageParts, StringBuilder stringBuilder) {
            for (MessagePart messagePart : messageParts) {
                if (messagePart.getMimeType().equals("text/plain")) {
                    stringBuilder.append(messagePart.getBody().getData());
                }

                if (messagePart.getParts() != null) {
                    getPlainTextFromMessageParts(messagePart.getParts(), stringBuilder);
                }
            }

        }

}