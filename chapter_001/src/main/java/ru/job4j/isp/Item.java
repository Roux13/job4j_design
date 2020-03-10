package ru.job4j.isp;

import java.util.List;

public class Item {

    private String name;
    private List<Item> nestedItems;

    public Item(String name, List<Item> nestedItems) {
        this.name = name;
        this.nestedItems = nestedItems;
    }

    public String getName() {
        return name;
    }

    public List<Item> getNestedItems() {
        return nestedItems;
    }

}
