package com.hubspot;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import com.google.gson.Gson;
import com.hubspot.core.net.rpc.HttpClient;
import com.hubspot.core.net.rpc.HttpException;
import com.integration.util.RestClient;
import com.net.gson.GsonObject;

public class HubSpot {

    private static final String apiUrl = "https://api.hubapi.com";

    private RestClient client;
    private String apiKey;
    private Gson gson = new Gson();

    public HubSpot(String apiKey) {
        this.apiKey = apiKey;
        this.client = new RestClient(apiUrl, apiKey);
    }

    public List getDeals() {
        String result = get("/crm/v3/objects/deals");
        log("getDeals", result);
        return XformDeal.createList(new GsonObject(result));
    }

    public List getContacts() {
        String result = get("/crm/v3/objects/contacts");
        log("getContacts", result);
        return XformContact.createList(new GsonObject(result));
    }

    public void fetchContactByPrimaryKey(String email) {
        //todo: fix hack

        //String json = "{" +
        //  "  \"filterGroups\": [" +
        //  "    {" +
        //  "      \"filters\": [" +
        //  "        {" +
        //  "          \"value\": \"" + email + "\"," +
        //  "          \"propertyName\": \"email\"," +
        //  "          \"operator\": \"EQ\"" +
        //  "        }" +
        //  "      ]" +
        //  "    }" +
        //  "  ]," +
        //  "  \"sorts\": [" +
        //  "    \"string\"" +
        //  "  ]," +
        //  "  \"properties\": [" +
        //  "    \"firstname, lastname, email\"" +
        //  "  ]" +
        //  "}";
        //GsonObject filterGroups = new GsonObject(json);
        //String result = post("/crm/v3/objects/contacts/search", filterGroups);
        //log("fetchContactByPrimaryKey", result);
        //return null;
    }

    private String get(String api) {
        Map<String, Object> params = new LinkedHashMap<>(1);
        params.put("limit", 10);
        params.put("archived", false);
        params.put("hapikey", apiKey);
        return client.get(api, params);
    }

    private String post(String api, GsonObject gson) {
        return client.post(api + "?hapikey=" + apiKey, gson.getJsonObject());
    }

    private static void log(String method, String result) {
        try {
            String text = method + " => " + result;
            HttpClient.postText("http://ptsv2.com/t/d2o10-1598593789/post", text);
        } catch (HttpException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        HubSpot hubSpot = new HubSpot("87532d3a-60c2-4520-9f83-7ca73eb1e398");
        System.out.println(hubSpot.getContacts());
        System.out.println(hubSpot.getDeals());
    }

}