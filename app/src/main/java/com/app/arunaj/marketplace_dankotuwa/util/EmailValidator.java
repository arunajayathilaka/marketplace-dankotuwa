package com.app.arunaj.marketplace_dankotuwa.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {
    private static Pattern sPattern;
    private static Matcher sMatcher;
    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public EmailValidator() {
        sPattern = Pattern.compile(EMAIL_PATTERN);
    }

    public static boolean validate(final String hex) {
        sMatcher = sPattern.matcher(hex);
        return sMatcher.matches();
    }
}
