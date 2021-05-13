package com.extensions.domains.sales.util;

import com.extensions.domains.sales.CreateRecordResponse;
import com.extensions.domains.sales.Event;
import com.extensions.domains.sales.model.SFEvent;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class EventUtil {

    private static Gson gson = new Gson();
    public static final String EVENT = "Event";
    public static final String QUERY_FIELDS = " Id,WhoId,Subject,Location,StartDateTime,EndDateTime,Description,AccountId,OwnerId,IsPrivate,ShowAs,IsGroupEvent,CreatedDate,LastModifiedDate ";


    public static List<Event> getEvents(SalesforceUtil salesforceUtil, long size, long page) throws InterruptedException, ExecutionException, IOException {
        String res = salesforceUtil.getRecordByQuery(
                "Select " + QUERY_FIELDS + " from Event ORDER BY LastModifiedDate DESC LIMIT " + size + " OFFSET " + Math.max((page - 1) * size, 0));
        SalesforceListResponse<SFEvent> oppList =
                gson.fromJson(res, new TypeToken<SalesforceListResponse<SFEvent>>() {
                }.getType());
        System.out.println(res);
        if (oppList.records.size() > 0) {
            return oppList.records.stream().map(SFEvent::to).collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }

    public static List<Event> getEventByLeadWhoId(SalesforceUtil salesforceUtil, String whoId, long size, long page) throws InterruptedException, ExecutionException, IOException {
        String res = salesforceUtil.getRecordByQuery(
                "Select " + QUERY_FIELDS + "  from Event where WhoId LIKE '%" +
                        whoId + "%' ORDER BY LastModifiedDate DESC  LIMIT " + size + " OFFSET " + Math.max((page - 1) * size, 0));
        SalesforceListResponse<SFEvent> oppList =
                gson.fromJson(res, new TypeToken<SalesforceListResponse<SFEvent>>() {
                }.getType());
        if (oppList.records.size() > 0) {
            return oppList.records.stream().map(SFEvent::to).collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }

    public static List<Event> getEventByLeadWhoId(SalesforceUtil salesforceUtil, String whoId) throws InterruptedException, ExecutionException, IOException {
        String res = salesforceUtil.getRecordByQuery("Select " + QUERY_FIELDS + "  from Event where whoId  = '" + whoId + "'");
        SalesforceListResponse<SFEvent> oppList =
                gson.fromJson(res, new TypeToken<SalesforceListResponse<SFEvent>>() {
                }.getType());
        if (oppList.records.size() > 0) {
            return oppList.records.stream().map(SFEvent::to).collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }

    public static List<Event> getEventBySubject(SalesforceUtil salesforceUtil, String subject, long size, long page) throws InterruptedException, ExecutionException, IOException {
        String res = salesforceUtil.getRecordByQuery(
                "Select " + QUERY_FIELDS + "  from Event where Subject LIKE '%" +
                        subject + "%' ORDER BY LastModifiedDate DESC  LIMIT " + size + " OFFSET " + Math.max((page - 1) * size, 0));
        SalesforceListResponse<SFEvent> oppList =
                gson.fromJson(res, new TypeToken<SalesforceListResponse<SFEvent>>() {
                }.getType());
        if (oppList.records.size() > 0) {
            return oppList.records.stream().map(SFEvent::to).collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }

    public static List<Event> getEventBySubject(SalesforceUtil salesforceUtil, String subject, String leadId, long size, long page) throws InterruptedException, ExecutionException, IOException {
        if (leadId == null || leadId.isEmpty()) return getEventBySubject(salesforceUtil, subject, size, page);
        String res = salesforceUtil.getRecordByQuery(
                "Select " + QUERY_FIELDS + "  from Event where Subject LIKE '%" +
                        subject + "%' AND whoId = '" + leadId + "'  ORDER BY LastModifiedDate DESC  LIMIT " + size + " OFFSET " + Math.max((page - 1) * size, 0));
        SalesforceListResponse<SFEvent> oppList =
                gson.fromJson(res, new TypeToken<SalesforceListResponse<SFEvent>>() {
                }.getType());
        if (oppList.records.size() > 0) {
            return oppList.records.stream().map(SFEvent::to).collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }


    public static List<Event> getEventsByOwnerId(SalesforceUtil salesforceUtil, String ownerId, long size, long page) throws InterruptedException, ExecutionException, IOException {
        String res = salesforceUtil.getRecordByQuery(
                "Select " + QUERY_FIELDS + "  from Event where ownerId  = '" +
                        ownerId + "' ORDER BY LastModifiedDate DESC  LIMIT " + size + " OFFSET " + Math.max((page - 1) * size, 0));
        SalesforceListResponse<SFEvent> oppList =
                gson.fromJson(res, new TypeToken<SalesforceListResponse<SFEvent>>() {
                }.getType());
        if (oppList.records.size() > 0) {
            return oppList.records.stream().map(SFEvent::to).collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }

    public static List<Event> getEventsByOwnerId(SalesforceUtil salesforceUtil, String ownerId) throws InterruptedException, ExecutionException, IOException {
        String res = salesforceUtil.getRecordByQuery("Select " + QUERY_FIELDS + "  from Event where ownerId  = '" + ownerId + "'");
        SalesforceListResponse<SFEvent> oppList =
                gson.fromJson(res, new TypeToken<SalesforceListResponse<SFEvent>>() {
                }.getType());
        if (oppList.records.size() > 0) {
            return oppList.records.stream().map(SFEvent::to).collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }


    public static Event getEventById(SalesforceUtil salesforceUtil, String id) throws InterruptedException, ExecutionException, IOException {
        String res = salesforceUtil.getRecordByQuery(
                "Select " + QUERY_FIELDS + "  from Event where id = '" + id + "'");
        SalesforceListResponse<SFEvent> oppList =
                gson.fromJson(res, new TypeToken<SalesforceListResponse<SFEvent>>() {
                }.getType());
        if (oppList.records.size() > 0) {
            return oppList.records.stream().map(SFEvent::to).findFirst().orElseThrow(() -> new RuntimeException(EVENT + " Not found for id " + id));
        } else {
            throw new RuntimeException(EVENT + " Not found for id " + id);
        }
    }

    public static CreateRecordResponse addEvent(SalesforceUtil salesforceUtil, Event opportunity) throws InterruptedException, ExecutionException, IOException {
        return gson.fromJson(salesforceUtil.createRecord(gson.toJson(SFEvent.from(opportunity)), EVENT), CreateRecordResponse.class);
    }

    public static void updateEvent(SalesforceUtil salesforceUtil, Event Event) throws InterruptedException, ExecutionException, IOException, IllegalAccessException {
        if (Event.id == null || Event.id.isEmpty())
            throw new RuntimeException("Event Id cant be empty");
        SFEvent updatedEvent = SFEvent.from(Event);
        SFEvent oldEvent = SFEvent.from(getEventById(salesforceUtil, updatedEvent.id));
        Map<String, String> diff = SalesforceUtil.getDifference(oldEvent, updatedEvent);
        salesforceUtil.updateRecord(updatedEvent.id, gson.toJson(diff), EVENT);
    }


    public static List<Event> getEventByLastDays(SalesforceUtil salesforceUtil, int days) throws InterruptedException, ExecutionException, IOException {
        String res = salesforceUtil.getRecordByQuery(
                "Select " + QUERY_FIELDS + " from Event WHERE LastModifiedDate = LAST_N_DAYS:" + days);
        SalesforceListResponse<SFEvent> oppList =
                gson.fromJson(res, new TypeToken<SalesforceListResponse<SFEvent>>() {
                }.getType());
        if (oppList.records.isEmpty()) {
            return new ArrayList<>();
        } else {
            return oppList.records.stream().map(SFEvent::to).collect(Collectors.toList());
        }
    }
}