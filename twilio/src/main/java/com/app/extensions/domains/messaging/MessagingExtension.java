package com.app.extensions.domains.messaging;

import java.util.List;

public interface MessagingExtension {

    /**
     * Send sms to myself based on phone number added in profile.
     */
    Message sendSmsToMe(String message) throws Exception;

    /**
     * Send messages to a number
     */
    Message sendMessage(String message, String phoneNumber) throws Exception;

    /**
     * fetch Message Details
     */
    Message fetchMessage(String messageId) throws Exception;

    /**
     * list messages  filter
     */
    List listMessages(String from, String to, DateRange dateRange, Long pageSize, Long pageNumber)
            throws Exception;

    /**
     * Fetch Message By Primary Key
     */
    Message fetchMessageByPrimaryKey(String primaryKey) throws Exception;

    /**
     * Fetch Fields Supporting Search For Message
     */
    List fetchFieldsSupportingSearchForMessage();

    /**
     * Create Message
     */
    String createMessage(Message entityDefinition) throws Exception;

    /**
     * Update Message
     */
    String updateMessage(Message entityDefinition, String primaryKey) throws Exception;

}
