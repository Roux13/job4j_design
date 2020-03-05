package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;

public class MaxMin {
    public <T> T max(List<T> values, Comparator<T> comparator) {
        T result = values.get(0);
        for (T v : values) {
            if (comparator.compare(v, result) > 0) {
                result = v;
            }
        }
        return result;
    }

    public <T> T min(List<T> values, Comparator<T> comparator) {
        return this.max(values, comparator.reversed());
    }

}
