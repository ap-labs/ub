package ru.aplabs.ub.api.utils;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Simple & dependency free (uses Java HttpUrlConnection internally) handy HTTP client.
 */
public final class Http {

    private final String baseUrl;
    private final ObjectMapper mapper;
    private Integer connectionTimeout = 15_000;
    private Integer readTimeout = 15_000;


    public Http(String baseUrl, ObjectMapper mapper) {
        this.baseUrl = baseUrl;
        this.mapper = mapper;
    }

    /**
     * Sets connection timeout in millis.
     *
     * @param timeout - specified timeout
     * @return current instance (to add ability to make nice chain calls)
     */
    public Http withConnectionTimeout(Integer timeout) {
        connectionTimeout = timeout;
        return this;
    }

    /**
     * Sets read timeout in millis.
     *
     * @param timeout - specified timeout
     * @return current instance (to add ability to make nice chain calls)
     */
    public Http withReadTimeout(Integer timeout) {
        readTimeout = timeout;
        return this;
    }

    public void get(String url) {
        withConnection(url, (c) -> {
            c.setRequestMethod("GET");

        });
    }

    public void post() {

    }

    private void withConnection(String url, ConsumerWithException<HttpURLConnection> run) {
        HttpURLConnection connection = null;
        boolean connected = false;
        try {
            connection = (HttpURLConnection) completeUrl(url).openConnection();
            connected = true;
            connection.setConnectTimeout(connectionTimeout);
            connection.setReadTimeout(readTimeout);
            run.run(connection);
        } catch (Exception e) {

        } finally {
            if (connected) {
                connection.disconnect();
            }
        }
    }

    private URL completeUrl(String url) {
        try {
            return new URL(baseUrl + url);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Can't construct URL for specified baseUrl and url");
        }
    }

    @FunctionalInterface
    private interface ConsumerWithException<T> {

        void run(T value) throws Exception;
    }
}
