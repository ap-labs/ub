package ru.aplabs.ub.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * UB client.
 */
public class UBClient {

    private static final Logger log = LoggerFactory.getLogger(UBClient.class);

    private final String url;

    public UBClient(String url) {
        this.url = url;
    }


}
