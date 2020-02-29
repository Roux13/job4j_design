package ru.job4j.tdd;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleGenerator implements Template {

    private final Pattern keys = Pattern.compile("\\$\\{\\S*}");

    @Override
    public String generate(String template, String[] data) throws NoKeysInMapException, MoreKeysThanParametersException {
        Matcher matcher = keys.matcher(template);
        Map<String, String> map = new HashMap<>();
        while (matcher.find()) {
            map.putIfAbsent(matcher.group(), null);
        }
        matcher.reset();
        if (map.size() == 0) {
            throw new NoKeysInMapException();
        }
        if (map.size() < data.length) {
            throw new MoreKeysThanParametersException();
        }
        int[] index = {0};
        map.keySet().forEach(key -> map.put(key, data[index[0]++]));
        while (matcher.find()) {
            template = matcher.replaceFirst(map.get(matcher.group()));
            matcher = this.keys.matcher(template);
        }
        return template;
    }


}
