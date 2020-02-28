package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        int index = value.size() - 1;
        return sortAndGetNumber(value, comparator, index);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        int index = 0;
        return sortAndGetNumber(value, comparator, index);
    }

    private <T> T sortAndGetNumber(List<T> value, Comparator<T> comparator, int index) {
        value.sort(comparator);
        return value.get(index);
    }
}
