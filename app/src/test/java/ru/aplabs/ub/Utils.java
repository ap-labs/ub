package ru.aplabs.ub;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class Utils {

    private static Logger log = LoggerFactory.getLogger(ru.aplabs.ub.util.Utils.class);

    public static String readFromClasspath(String path) {
        InputStream s = ru.aplabs.ub.util.Utils.class.getClassLoader().getResourceAsStream("classpath:" + path);
        if (s == null) {
            throw new IllegalArgumentException("Failed to find file at specified location");
        }
        StringBuilder result = new StringBuilder();
        try (Reader r = new BufferedReader(new InputStreamReader(s))) {
            int c = 0;
            while ((c = r.read()) != -1) {
                result.append((char) c);
            }
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        return result.toString();
    }
}
