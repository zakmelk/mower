package com.moweritnow.utils;

import java.util.regex.Pattern;

public class InputValidator {
    public static final String REGEX_NUM = "\\d+";
    public static final String DELIMITER_SPACE = " ";
    public static final String REGEX_ORIENTATION = "[NEWS]";
    public static final Pattern PATTERN_ORIENTATION = Pattern.compile(REGEX_ORIENTATION);
    public static final String REGEX_MOVE = "[GAD]";
    public static final Pattern PATTERN_MOVE = Pattern.compile(REGEX_MOVE);
}
