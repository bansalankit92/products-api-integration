package com.integration.extensions.domains.sumologic.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import com.google.gson.annotations.SerializedName;
import com.integration.extensions.domains.sumologic.SearchJobMessage;

public final class SlSearchJobMessage {

    public MessageMap[] messages;

    public static class MessageMap {

        public Message map;

    }

    public static class Message {

        @SerializedName("_sourcename")
        public String sourceName;

        @SerializedName("_sourcecategory")
        public String sourceCategory;

        @SerializedName("_size")
        public Double size;

        @SerializedName("_raw")
        public String raw;

        @SerializedName("_collectorid")
        public String collectorId;

        @SerializedName("_messagetime")
        public Long messageTime;

        @SerializedName("_sourcehost")
        public String sourceHost;

        @SerializedName("_messagecount")
        public String messageCount;

        @SerializedName("_source")
        public String source;

        @SerializedName("_blockid")
        public String blockId;

        @SerializedName("_sourceid")
        public String sourceId;

        @SerializedName("_collector")
        public String collector;

        @SerializedName("_receipttime")
        public Long receiptTime;

        @SerializedName("_messageid")
        public String messageId;

        public SearchJobMessage to() {
            SearchJobMessage message = new SearchJobMessage();

            message.blockId = blockId;
            message.collector = collector;
            message.collectorId = collectorId;
            message.messageCount = messageCount;
            message.messageId = messageId;
            message.messageTime = messageTime;
            message.raw = raw;
            message.receiptTime = receiptTime;
            message.size = size;
            message.source = source;
            message.sourceCategory = sourceCategory;
            message.sourceHost = sourceHost;
            message.sourceId = sourceId;
            message.sourceName = sourceName;

            return message;
        }

    }

    public List<SearchJobMessage> to() {
        return Arrays.stream(messages).map(m -> m.map).map(Message::to).collect(Collectors.toList());
    }

}
