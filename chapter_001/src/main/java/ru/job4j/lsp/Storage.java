package ru.job4j.lsp;

import java.util.List;

public interface Storage {
    void add(Food food);

    List<Food> getProducts();
}
