package com.moweritnow.in;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

@Slf4j
public class InputValidator {
    public static final String REGEX_NUM = "\\d+";
    public static final String DELIMITER_SPACE = " ";
    public static final String REGEX_ORIENTATION = "[NEWS]";
    public static final Pattern PATTERN_ORIENTATION = Pattern.compile(REGEX_ORIENTATION);
    public static final String REGEX_MOVE = "[GAD]";
    public static final Pattern PATTERN_MOVE = Pattern.compile(REGEX_MOVE);

    public static List<String> getLines(String fileName) {
        List<String> lines = new ArrayList<>();
        try {
            Path path = Paths.get(Objects.requireNonNull(TaskBuilderFileAdapter.class.getClassLoader().getResource(fileName)).toURI());
            lines = Files.readAllLines(path);
        } catch (IOException | URISyntaxException e) {
            log.error("Error while reading file !", e);
        }
        return lines;
    }

    public static boolean isFileValid(String fileName) {
        return isFileExists(fileName) && isFileContentValid(fileName);
    }

    private static boolean isFileContentValid(String fileName) {
        try {
            Path path = Paths.get(Objects.requireNonNull(TaskBuilderFileAdapter.class.getClassLoader().getResource(fileName)).toURI());
            List<String> lines = Files.readAllLines(path);
            if (Objects.nonNull(lines) && lines.size() >= 3 && (lines.size() % 2 == 1)) {
                if (isValidLawnInput(lines.get(0))) {
                    boolean isValid = true;
                    for (int i = 1; i < lines.size(); i++) {
                        if (((i % 2 == 1) && !isValidMowerInput(lines.get(i))) || ((i % 2 == 0) && !isValidOrdersInput(lines.get(i)))) {
                            isValid = false;
                            break;
                        }
                    }
                    return isValid;
                }
            }
        } catch (IOException | URISyntaxException e) {
            log.error("Error reading file {}", fileName);
        }
        return false;
    }

    private static boolean isValidMowerInput(String mowerInput) {
        if (StringUtils.isBlank(mowerInput)) {
            return false;
        }
        String[] split = mowerInput.split(DELIMITER_SPACE);
        return split.length == 3 &&
                split[0].matches(REGEX_NUM) &&
                split[1].matches(REGEX_NUM) &&
                PATTERN_ORIENTATION.matcher(split[2]).find();
    }

    private static boolean isValidOrdersInput(String ordersInput) {
        return PATTERN_MOVE.matcher(ordersInput).find();
    }

    private static boolean isFileExists(String fileName) {
        try {
            return Files.exists(Paths.get(Objects.requireNonNull(InputValidator.class.getClassLoader().getResource(fileName)).toURI()));
        } catch (URISyntaxException e) {
            log.error("Error checking file {}", fileName);
            return false;
        }
    }

    private static boolean isValidLawnInput(String input) {
        if (StringUtils.isBlank(input)) {
            return false;
        }
        String[] split = input.split(DELIMITER_SPACE);
        return split.length == 2 &&
                split[0].matches(REGEX_NUM) &&
                split[1].matches(REGEX_NUM);
    }
}
