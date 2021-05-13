package com.extensions.domains.sales.util;

import com.github.scribejava.apis.salesforce.SalesforceToken;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Verb;
import com.google.gson.Gson;
import com.extensions.domains.sales.model.SFEmail;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

public class SalesforceUtil {
    private OAuthUtil authUtil;

    public SalesforceUtil(Map<String, Object> attributes) {
        this.authUtil = new OAuthUtil(attributes);
    }

    public String getObjects()
            throws IOException, ExecutionException, InterruptedException {
        SalesforceToken salesforceToken = authUtil.getSalesforceToken();
        String url = salesforceToken.getInstanceUrl() + "/services/data/v48.0/sobjects";
        final OAuthRequest request = new OAuthRequest(Verb.GET, url);
        request.addHeader("Content-Type", "application/json");
        request.addHeader("Authorization", "Bearer " + salesforceToken.getAccessToken());
        authUtil.getoAuthService().signRequest(salesforceToken, request);
        try (com.github.scribejava.core.model.Response response = authUtil.getoAuthService().execute(request)) {
            if (response.getCode() == 400) {
                throw new RuntimeException("Bad Request, Please enter correct required data. The response is " + response.getBody());
            }
            return response.getBody();
        }
    }

    public String getRecordById(String id, String sobject)
            throws IOException, ExecutionException, InterruptedException {
        SalesforceToken salesforceToken = authUtil.getSalesforceToken();
        String url = salesforceToken.getInstanceUrl() + "/services/data/v48.0/sobjects/" + sobject + "/" + id;
        final OAuthRequest request = new OAuthRequest(Verb.GET, url);
        request.addHeader("Content-Type", "application/json");
        request.addHeader("Authorization", "Bearer " + salesforceToken.getAccessToken());
        authUtil.getoAuthService().signRequest(salesforceToken, request);
        try (com.github.scribejava.core.model.Response response = authUtil.getoAuthService().execute(request)) {
            if (response.getCode() == 400) {
                throw new RuntimeException("Bad Request, Please enter correct required data. The response is " + response.getBody());
            }
            return response.getBody();
        }
    }

    public String updateRecord(String id, String body, String sobject)
            throws IOException, ExecutionException, InterruptedException {
        SalesforceToken salesforceToken = authUtil.getSalesforceToken();
        String url = salesforceToken.getInstanceUrl() + "/services/data/v48.0/sobjects/" + sobject + "/" + id +
                "?_HttpMethod=PATCH";
        final OAuthRequest request = new OAuthRequest(Verb.POST, url);
        request.setPayload(body);
        request.addHeader("Content-Type", "application/json");
        request.addHeader("Authorization", "Bearer " + salesforceToken.getAccessToken());
        authUtil.getoAuthService().signRequest(salesforceToken, request);
        try (com.github.scribejava.core.model.Response response = authUtil.getoAuthService().execute(request)) {
            if (response.getCode() == 400) {
                throw new RuntimeException("Bad Request, Please enter correct required data. The response is " + response.getBody());
            }
            return response.getBody();
        }
    }

    public String getRecordByQuery(String query)
            throws IOException, ExecutionException, InterruptedException {
        SalesforceToken salesforceToken = authUtil.getSalesforceToken();
        String url = salesforceToken.getInstanceUrl() + "/services/data/v48.0/query?q=";
        final String queryEncoded = URLEncoder.encode(query, StandardCharsets.UTF_8);
        final OAuthRequest request = new OAuthRequest(Verb.GET, url + queryEncoded);
        request.addHeader("Content-Type", "application/json");
        request.addHeader("Authorization", "Bearer " + salesforceToken.getAccessToken());
        authUtil.getoAuthService().signRequest(salesforceToken, request);
        try (com.github.scribejava.core.model.Response response = authUtil.getoAuthService().execute(request)) {
            if (response.getCode() == 400) {
                throw new RuntimeException("Bad Request, Please enter correct required data. " + response.getBody());
            }
            return response.getBody();
        }
    }

    public String getMe()
            throws IOException, ExecutionException, InterruptedException {
        SalesforceToken salesforceToken = authUtil.getSalesforceToken();
        String url = salesforceToken.getInstanceUrl() + "/services/data/v48.0/chatter/users/me";
        final OAuthRequest request = new OAuthRequest(Verb.GET, url);
        request.addHeader("Content-Type", "application/json");
        request.addHeader("Authorization", "Bearer " + salesforceToken.getAccessToken());
        authUtil.getoAuthService().signRequest(salesforceToken, request);
        try (com.github.scribejava.core.model.Response response = authUtil.getoAuthService().execute(request)) {
            if (response.getCode() == 400) {
                throw new RuntimeException("Bad Request, Please enter correct required data. " + response.getBody());
            }
            return response.getBody();
        }
    }

    public String sendEmail(String recepients, String subj, String body)
            throws IOException, ExecutionException, InterruptedException {
        SalesforceToken salesforceToken = authUtil.getSalesforceToken();
        String url = salesforceToken.getInstanceUrl() + "/services/data/v48.0/actions/standard/emailSimple";
        final OAuthRequest request = new OAuthRequest(Verb.POST, url);
        SFEmail.Body body1 = new SFEmail.Body();
        body1.inputs.add(new SFEmail(recepients.trim(),subj.trim(),body.trim()));
        System.out.println(new Gson().toJson(body1));
        request.setPayload(new Gson().toJson(body1));
        request.addHeader("Content-Type", "application/json");
        request.addHeader("Authorization", "Bearer " + salesforceToken.getAccessToken());
        authUtil.getoAuthService().signRequest(salesforceToken, request);
        try (com.github.scribejava.core.model.Response response = authUtil.getoAuthService().execute(request)) {
            if (response.getCode() == 400) {
                throw new RuntimeException("Bad Request, Please enter correct required data. " + response.getBody());
            }
            return response.getBody();
        }
    }

    public String createRecord(String body, String sobject)
            throws IOException, ExecutionException, InterruptedException {
        SalesforceToken salesforceToken = authUtil.getSalesforceToken();
        String url = salesforceToken.getInstanceUrl() + "/services/data/v48.0/sobjects/" + sobject + "/";
        final OAuthRequest request = new OAuthRequest(Verb.POST, url);
        request.setPayload(body);
        request.addHeader("Content-Type", "application/json");
        request.addHeader("Authorization", "Bearer " + salesforceToken.getAccessToken());
        authUtil.getoAuthService().signRequest(salesforceToken, request);
        try (com.github.scribejava.core.model.Response response = authUtil.getoAuthService().execute(request)) {
            if (response.getCode() >= 400) {
                throw new RuntimeException("Bad Request, Please enter correct required data. " + response.getBody());
            }
            return response.getBody();
        }
    }


    public static Map<String, String> getDifference(Object old, Object newObj) throws IllegalAccessException {
        Map<String, String> values = new HashMap<>();
        for (Field field : old.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Object value1 = field.get(old);
            Object value2 = field.get(newObj);
            if (value1 != null && value2 != null) {
                if (!Objects.equals(value1, value2)) {
                    if (!field.getName().toLowerCase().contains("date") && !field.getName().contains("id"))
                        values.put(field.getName(), (String) value2);
                }
            }
        }
        return values;
    }
}