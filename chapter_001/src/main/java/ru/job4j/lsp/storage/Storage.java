package ru.job4j.lsp.storage;

import java.util.List;

public interface Storage {
    void add(Food food);

    List<Food> getProducts();
}
