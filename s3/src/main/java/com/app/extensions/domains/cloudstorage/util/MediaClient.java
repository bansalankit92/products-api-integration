package com.app.extensions.domains.cloudstorage.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.media.multipart.MultiPartFeature;

import static javax.ws.rs.core.MediaType.*;

public class MediaClient {

    public static final String TEMP_DIR = "/tmp/krista/extension/s3/";
    private final WebTarget webTarget;

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public MediaClient(String mediaUrl) {
        webTarget = ClientBuilder.newBuilder()
                .register(MultiPartFeature.class).build()
                .target(mediaUrl);
        new File(TEMP_DIR).mkdirs();
    }

    public boolean upload(String url, File file) {
        WebTarget resourceTarget = webTarget.path(url);
        resourceTarget = resourceTarget.queryParam("len", file.length());
        return handleResponse(resourceTarget.request().post(Entity.entity(file, APPLICATION_OCTET_STREAM_TYPE)));
    }

    public File download(String url, String fileName) throws IOException {
        Response response = webTarget.path(url).request(MediaType.APPLICATION_OCTET_STREAM).get();
        boolean result = handleResponse(response);
        return result ? handleFileDownload(response, fileName) : null;
    }

    public static String nextMediaId(String fileName) {
        return "doc_binary_" + new Date().getTime() + "_" + fileName;
    }

    // region Internal

    private static boolean handleResponse(Response response) {
        if (response.getStatusInfo().getFamily() == Response.Status.Family.SUCCESSFUL) {
            return true;
        } else if (response.getStatus() == Response.Status.UNAUTHORIZED.getStatusCode()) {
            throw new RuntimeException(response.getStatusInfo().getReasonPhrase());
        } else {
            throw new ClientErrorException(response);
        }
    }

    private static File handleFileDownload(Response response, String fileName) throws IOException {
        InputStream is = response.readEntity(InputStream.class);
        File file = new File(TEMP_DIR + fileName);
        Files.copy(is, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
        return file;
    }

    // endregion
}
