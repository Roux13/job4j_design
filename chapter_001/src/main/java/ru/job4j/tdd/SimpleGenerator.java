package ru.job4j.tdd;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleGenerator implements Template {

    private final Pattern keys = Pattern.compile("\\$\\{\\S*\\}");

    @Override
    public String generate(String template, String[] data) throws NoKeysInMapException, MoreKeysThanParametersException {
        Matcher matcher = keys.matcher(template);
        int index = 0;
        int keyCounter = 0;
        String currentKey;
        while (matcher.find()) {
            keyCounter++;
            currentKey = matcher.group();
            template = template.replaceAll(Pattern.quote(currentKey), data[index++]);
            matcher = keys.matcher(template);
        }
        if (keyCounter == 0) {
            throw new NoKeysInMapException();
        }
        if (keyCounter < data.length) {
            throw new MoreKeysThanParametersException();
        }
        return template;
    }


}
