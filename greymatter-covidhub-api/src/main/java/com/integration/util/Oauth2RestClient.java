package com.integration.util;

import com.google.gson.Gson;
import com.integration.exception.AuthException;
import com.integration.extensions.Response;
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
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

public class Oauth2RestClient {

    private final OAuthUtil oAuthUtil;

    public Oauth2RestClient(Map<String, Object> attributes) {
        oAuthUtil = new OAuthUtil(attributes);
    }

    public WebTarget getWebTarget() {
        return ClientBuilder.newBuilder()
                .register(MultiPartFeature.class).build().target(oAuthUtil.getValue(OAuthUtil.HOST_URL));
    }

    public String postMultipart(String url, List<MetaRequest> meta, File file) throws InterruptedException, ExecutionException, IOException {
        Invocation.Builder request = getWebTarget().path(url).request(APPLICATION_JSON);
        request.header("Cookie", "access_token=" + oAuthUtil.getGoogleToken());
        MultiPart multipartEntity = new FormDataMultiPart().field("meta", new Gson().toJson(meta), MediaType.APPLICATION_JSON_TYPE);
        if (file != null) {
            FileDataBodyPart filePart = new FileDataBodyPart("blob", file);
            multipartEntity.bodyPart(filePart);
        }
        return handleResponse(request.post(Entity.entity(multipartEntity, multipartEntity.getMediaType())));
    }

    public String get(String url, Map<String, Object> queryParams) throws InterruptedException, ExecutionException, IOException {
        WebTarget resourceTarget = getWebTarget().path(url);
        for (Map.Entry<String, Object> entrySet : queryParams.entrySet()) {
            resourceTarget = resourceTarget.queryParam(entrySet.getKey(), entrySet.getValue());
        }
        Invocation.Builder request = resourceTarget.request(APPLICATION_JSON);
        String accessToken = oAuthUtil.getGoogleToken();
        request.header("Cookie", "access_token=" + accessToken);
        return handleResponse(request.get());
    }

    private static String handleResponse(javax.ws.rs.core.Response response) {
        if (response.getStatusInfo().getFamily() == javax.ws.rs.core.Response.Status.Family.SUCCESSFUL)
            return response.readEntity(String.class);
        else if (response.getStatus() == javax.ws.rs.core.Response.Status.UNAUTHORIZED.getStatusCode())
            throw new AuthException(response.getStatusInfo().getReasonPhrase());
        else throw new RuntimeException(response.readEntity(String.class));
    }

    public String getAuthorizationUrl() {
        return oAuthUtil.getAuthorizationUrl();
    }

    public Response getAuthTokenResponse() throws InterruptedException, ExecutionException, IOException {
        return oAuthUtil.getAuthAccessTokenByCode();
    }
}
