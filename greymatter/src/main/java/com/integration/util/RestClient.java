package com.integration.util;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.integration.extensions.domains.greymatter.model.MetaRequest;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.glassfish.jersey.media.multipart.MultiPart;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.media.multipart.file.FileDataBodyPart;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.util.List;
import java.util.Map;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

public class RestClient {

    private final WebTarget webTarget;
    private final String cookie;

    public RestClient(String hostUrl, String cookie) {
        this.cookie = cookie;
        webTarget = ClientBuilder.newBuilder()
                .register(MultiPartFeature.class).build().target(hostUrl);
    }

    public String post(String url, JsonObject body) {
        Invocation.Builder request = webTarget.path(url).request(APPLICATION_JSON);
        request.header("Cookie", cookie);
        return handleResponse(request.post(Entity.entity(body.toString(), APPLICATION_JSON)));
    }

    //meta: [{"parentoid":"1644e33c5516d7e1","name":"New Folder","isfile":false,"security":{"label":"DECIPHER//GMDATA","foreground":"#FFFFFF","background":"green"},"objectpolicy":null,"originalobjectpolicy":"(if (contains email \"ankit@antbrains.com\")(yield-all)(yield R X))","action":"U","derived":{}}]
    public String postMultipart(String url, List<MetaRequest> meta, File file) {
        Invocation.Builder request = webTarget.path(url).request(APPLICATION_JSON);
        request.header("Cookie", cookie);
        MultiPart multipartEntity = new FormDataMultiPart().field("meta", new Gson().toJson(meta), MediaType.APPLICATION_JSON_TYPE);
        if (file != null) {
            FileDataBodyPart filePart = new FileDataBodyPart("blob", file);
            multipartEntity.bodyPart(filePart);
        }
        return handleResponse(request.post(Entity.entity(multipartEntity, multipartEntity.getMediaType())));
    }

    public String get(String url, Map<String, Object> queryParams) {
        WebTarget resourceTarget = webTarget.path(url);
        for (Map.Entry<String, Object> entrySet : queryParams.entrySet()) {
            resourceTarget = resourceTarget.queryParam(entrySet.getKey(), entrySet.getValue());
        }
        Invocation.Builder request = resourceTarget.request(APPLICATION_JSON);
        request.header("Cookie", cookie);
        return handleResponse(request.get());
    }

    public String put(String url, JsonObject body) {
        Invocation.Builder request = webTarget.path(url).request(APPLICATION_JSON);
        request.header("Cookie", cookie);
        return handleResponse(request.put(Entity.entity(body.toString(), APPLICATION_JSON)));
    }

    public String delete(String url, Map<String, Object> queryParams) {
        WebTarget resourceTarget = webTarget.path(url);
        for (Map.Entry<String, Object> entrySet : queryParams.entrySet()) {
            resourceTarget = resourceTarget.queryParam(entrySet.getKey(), entrySet.getValue());
        }
        Invocation.Builder request = resourceTarget.request(APPLICATION_JSON);
        request.header("Cookie", cookie);
        return handleResponse(request.delete());
    }

    // region Internal

    private static String handleResponse(Response response) {
        if (response.getStatusInfo().getFamily() == Response.Status.Family.SUCCESSFUL)
            return response.readEntity(String.class);
        else if (response.getStatus() == Response.Status.UNAUTHORIZED.getStatusCode())
            throw new RuntimeException(response.getStatusInfo().getReasonPhrase());
        else throw new RuntimeException(response.readEntity(String.class));
    }

    // endregion
}
