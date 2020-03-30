package ru.aplabs.ub.impl.tinkoff;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.aplabs.ub.Json;

import java.security.MessageDigest;
import java.util.TreeMap;

public class SignUtil {

    /**
     * Implementation of signature algorithm as described in - https://oplata.tinkoff.ru/develop/api/request-sign/
     * @param request
     * @param password
     * @return
     */
    public static String sign(String request, String password) {
        try {
            ObjectMapper mapper = Json.mapper;
            final JsonNode node = mapper.readTree(request);
            TreeMap<String, String> fields = new TreeMap<>();
            node.fieldNames().forEachRemaining(n -> {
                if (n.equals("Receipt") || n.equalsIgnoreCase("DATA")) {
                    return;
                }
                fields.put(n, node.get(n).textValue());
            });
            fields.put("Password", password);
            StringBuilder values = new StringBuilder();
            fields.values().forEach(values::append);
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            return convertToHex(digest.digest(values.toString().getBytes()));
        } catch (Exception e) {
            throw new RuntimeException("Failed to sign request", e);
        }
    }

    private static String convertToHex(byte[] value) {
        StringBuilder result = new StringBuilder();
        for (byte b : value) {
            result.append(String.format("%02x", b));
        }
        return result.toString();
    }
}
