package ru.job4j.isp;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Item item2 = new Item("Item2", null);
        List<Item> menu2 = List.of(item2, item2, item2);
        Item item1 = new Item("Item1", menu2);
        List<Item> menu1 = List.of(item1, item1, item1);
        Item mainMenu = new Item("Main menu", menu1);
        MenuViewer menuViewer = new MenuViewer(mainMenu, new ConsoleOutput());
        menuViewer.startMenu();
    }

}
