package com.hubspot.core.net.client.http.method;

import java.util.concurrent.CountDownLatch;
import com.hubspot.core.net.client.http.HttpClient;
import com.hubspot.core.net.client.http.result.HttpResponseDto;
import com.net.env.EnvError;
import com.net.env.EnvErrorCode;
import com.net.env.EnvErrorException;
import com.net.gson.JsonConverter;
import org.asynchttpclient.AsyncCompletionHandler;
import org.asynchttpclient.Response;

public class HttpGetDto<V extends JsonConverter> extends HttpBase {

    private class CompletionHandler extends AsyncCompletionHandler<HttpResponseDto<V>> {

        private final CountDownLatch countDownLatch;
        private HttpResponseDto<V> responseDto;
        private EnvError error;

        public CompletionHandler(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void onThrowable(Throwable t) {
            error = new EnvError(EnvErrorCode.ExtnNetworkError, t);
            updateError();
            tell();
        }

        @Override
        public HttpResponseDto<V> onCompleted(Response response) {
            int statusCode = response.getStatusCode();
            if (statusCode == 200) {
                String json = response.getResponseBody();
                V value = json == null ? null : JsonConverter.fromJson(json, responseClass);
                responseDto = new HttpResponseDto<>(path, value, responseClass);
                tell();
                return responseDto;
            } else {
                error = new EnvError(EnvErrorCode.ExtnNetworkError, response.getStatusText());
                error.put(HttpPostDto.class, "StatusCode", statusCode);
                updateError();
                tell();
                return null;
            }
        }

        private void updateError() {
            error.put(HttpPostDto.class, "Uri", path);
            error.put(HttpPostDto.class, "Url", url);
        }

        private void tell() {
                countDownLatch.countDown();
        }

    }

    public final Class<V> responseClass;

    public HttpGetDto(String url, String path, Class<V> responseClass) {
        super(url, path);
        this.responseClass = responseClass;
    }

    public HttpResponseDto<V> execute() throws EnvErrorException, InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        CompletionHandler completionHandler = new CompletionHandler(countDownLatch);
        get(completionHandler);
        countDownLatch.await();
        if (completionHandler.error != null) {
            throw new EnvErrorException(completionHandler.error);
        }
        return completionHandler.responseDto;
    }

    private void get(CompletionHandler completionHandler) {
        HttpClient.get(url, realm, signatureCalculator, completionHandler);
    }

}