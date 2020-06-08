package http.request;

import java.util.HashMap;
import java.util.Map;

public class Cookies {
    private Map<String, String> cookies = new HashMap<>();

    public Cookies(String value) {
        String[] values = value.split("; ");
        for (String cookie : values) {
            String[] result = cookie.split("=");

            addCookie(result);
        }
    }

    private void addCookie(String[] result) {
        if (result.length > 1) {
            cookies.put(result[0], result[1]);
        }
    }

    public Map<String, String> getCookies() {
        return cookies;
    }
}
