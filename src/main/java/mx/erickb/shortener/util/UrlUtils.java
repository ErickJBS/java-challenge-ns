package mx.erickb.shortener.util;

import org.springframework.stereotype.Component;

@Component
public class UrlUtils {

    private static final String GOOGLE_DICT = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String YAHOO_DICT = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    private static final String GENERIC_DICT = "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ";
    private static final int GOOGLE_ALIAS_LENGTH = 5;
    private static final int YAHOO_ALIAS_LENGTH = 7;

    public String generateUrlAlias(String url) {
        if (url.contains("google")) {
            return googleAliasFormat(url);
        } else if (url.contains("yahoo")) {
            return yahooAliasFormat(url);
        } else {
            return genericAliasFormat(url);
        }
    }

    private String googleAliasFormat(String url) {
        return getAlias(url, GOOGLE_DICT, GOOGLE_ALIAS_LENGTH);
    }

    private String yahooAliasFormat(String url) {
        return getAlias(url, YAHOO_DICT, YAHOO_ALIAS_LENGTH);
    }

    private String genericAliasFormat(String url) {
        StringBuilder builder = new StringBuilder();
        for (char c : url.toCharArray()) {
            if (GENERIC_DICT.contains("" + c)) {
                builder.append(c);
            }
        }
        return builder.toString();
    }

    private String getAlias(String url, String dict, int length) {
        int hash = Math.abs(url.hashCode());
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int idx = hash % dict.length();
            hash /= dict.length();
            builder.append(dict.charAt(idx));
        }
        return builder.toString();
    }
}
