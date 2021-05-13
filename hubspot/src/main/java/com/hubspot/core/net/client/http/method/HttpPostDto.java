package com.hubspot.core.net.client.http.method;

import java.util.concurrent.CountDownLatch;
import com.hubspot.core.net.client.http.HttpClient;
import com.hubspot.core.net.client.http.result.HttpRequestResponseDto;
import com.net.env.EnvError;
import com.net.env.EnvErrorCode;
import com.net.env.EnvErrorException;
import com.net.gson.JsonConverter;
import org.asynchttpclient.AsyncCompletionHandler;
import org.asynchttpclient.Response;

public class HttpPostDto<K, V> extends HttpBase {

    private abstract class CompletionHandler<T> extends AsyncCompletionHandler<T> {

        private final CountDownLatch countDownLatch;
        protected EnvError dtoError;
        private T dtoResponse;

        public CompletionHandler(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void onThrowable(Throwable t) {
            dtoError = new EnvError(EnvErrorCode.ExtnNetworkError, t);
            updateError();
            tell();
        }

        @Override
        public T onCompleted(Response response) {
            int statusCode = response.getStatusCode();
            if (statusCode == 200) {
                String json = response.getResponseBody();
                V value = json == null ? null : JsonConverter.fromJson(json, responseClass);
                dtoResponse = createResponse(value);
                tell();
                return dtoResponse;
            } else {
                String errorText = response.getResponseBody();
                if (errorText == null) {
                    dtoError = new EnvError(EnvErrorCode.ExtnNetworkError, response.getStatusText());
                } else {
                    dtoError = new EnvError(EnvErrorCode.ExtnInternal, errorText);
                    dtoError.put(HttpPostDto.class, "StatusText", response.getStatusText());
                }

                dtoError.put(HttpPostDto.class, "StatusCode", statusCode);
                updateError();
                tell();
                return null;
            }
        }

        protected abstract T createResponse(V value);

        protected void updateError() {
            dtoError.put(HttpPostDto.class, "Path", path);
            dtoError.put(HttpPostDto.class, "Url", url);
        }

        private void tell() {
                countDownLatch.countDown();
        }

    }

    public final Class<K> requestClass;
    public final Class<V> responseClass;

    public HttpPostDto(String url, String path, Class<K> requestClass, Class<V> responseClass) {
        super(url, path);
        this.requestClass = requestClass;
        this.responseClass = responseClass;
    }

    public HttpRequestResponseDto<K, V> execute(K request) throws EnvErrorException, InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        String json = request == null ? null : JsonConverter.toJson(request);
        CompletionHandler<HttpRequestResponseDto<K, V>> handler =
                new CompletionHandler<HttpRequestResponseDto<K, V>>(countDownLatch) {
                    @Override
                    protected HttpRequestResponseDto<K, V> createResponse(V value) {
                        return new HttpRequestResponseDto<>(path, request, requestClass, value, responseClass);
                    }

                    protected void updateError() {
                        super.updateError();
                        dtoError.setRequest(request);
                    }
                };
        execute(json, handler);
        countDownLatch.await();
        if (handler.dtoError != null) {
            throw new EnvErrorException(handler.dtoError);
        }
        return handler.dtoResponse;
    }

    //region internal

    private <T> void execute(String reqJson, CompletionHandler<T> completionHandler) {
        HttpClient.post(url, realm, signatureCalculator, reqJson, completionHandler);
    }

    //endregion
}