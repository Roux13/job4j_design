package ru.job4j.kiss;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MaxMinTest {

    @Test
    public void maxWhenListHasOneValue() {
        Integer value = 1;
        List<Integer> list = new ArrayList<>(List.of(value));
        Comparator<Integer> comparator = Comparator.naturalOrder();
        MaxMin maxMin = new MaxMin();
        Integer expect = value;
        Integer actual = maxMin.max(list, comparator);
        assertThat(actual, is(expect));
    }

    @Test
    public void minWhenListHasOneValue() {
        Integer value = 1;
        List<Integer> list = new ArrayList<>(List.of(value));
        Comparator<Integer> comparator = Comparator.naturalOrder();
        MaxMin maxMin = new MaxMin();
        Integer expect = value;
        Integer actual = maxMin.min(list, comparator);
        assertThat(actual, is(expect));
    }

    @Test
    public void maxWhenListHasTwoValues() {
        Integer value1 = 1;
        Integer value2 = 2;
        List<Integer> list = new ArrayList<>(List.of(value2, value1));
        Comparator<Integer> comparator = Comparator.naturalOrder();
        MaxMin maxMin = new MaxMin();
        Integer expect = value2;
        Integer actual = maxMin.max(list, comparator);
        assertThat(actual, is(expect));
    }

    @Test
    public void minWhenListHasTwoValues() {
        Integer value1 = 1;
        Integer value2 = 2;
        List<Integer> list = new ArrayList<>(List.of(value2, value1));
        Comparator<Integer> comparator = Comparator.naturalOrder();
        MaxMin maxMin = new MaxMin();
        Integer expect = value1;
        Integer actual = maxMin.min(list, comparator);
        assertThat(actual, is(expect));
    }

    @Test
    public void maxWhenListHasTwoStrings() {
        String value1 = "A";
        String value2 = "B";
        List<String> list = new ArrayList<>(List.of(value2, value1));
        Comparator<String> comparator = Comparator.naturalOrder();
        MaxMin maxMin = new MaxMin();
        String expect = value2;
        String actual = maxMin.max(list, comparator);
        assertThat(actual, is(expect));
    }

    @Test
    public void minWhenListHasTwoStrings() {
        String value1 = "A";
        String value2 = "B";
        List<String> list = new ArrayList<>(List.of(value2, value1));
        Comparator<String> comparator = Comparator.naturalOrder();
        MaxMin maxMin = new MaxMin();
        String expect = value1;
        String actual = maxMin.min(list, comparator);
        assertThat(actual, is(expect));
    }
}