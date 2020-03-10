package ru.job4j.isp;

import java.util.List;

public class MenuViewer {

    private Item startMenu;
    private Output output;
    private final String prefix = "--";

    public MenuViewer(Item startMenu, Output output) {
        this.startMenu = startMenu;
        this.output = output;
    }

    public void startMenu() {
        output.display(startMenu.getName());
        walkMenu(startMenu.getNestedItems(), prefix);
    }

    public void walkMenu(List<Item> menu, String prefix) {
        menu.forEach(item -> {
            output.display(prefix + item.getName());
            if (item.getNestedItems() != null) {
                walkMenu(item.getNestedItems(), prefix + prefix);
            }
        });
    }
}
