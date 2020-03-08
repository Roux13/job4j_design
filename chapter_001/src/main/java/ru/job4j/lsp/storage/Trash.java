package ru.job4j.lsp.storage;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Storage {

    private final List<Food> products = new ArrayList<>();

    @Override
    public void add(Food food) {
        if (!products.contains(food)) {
            products.add(food);
        }
    }

    @Override
    public List<Food> getProducts() {
        return products;
    }

}
