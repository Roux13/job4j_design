package ru.job4j.lsp.storage;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Predicate;

public class ControlQuality {

    private final Predicate<Double> toWarehouse = life -> life < 25.0;
    private final Predicate<Double> toShop = life -> life >= 25.0 && life < 75.0;
    private final Predicate<Double> toDiscount = life -> life >= 75.0 && life < 100.0;

    private final Storage warehouse;
    private final Storage shop;
    private final Storage trash;

    public ControlQuality(Storage warehouse, Storage shop, Storage trash) {
        this.warehouse = warehouse;
        this.shop = shop;
        this.trash = trash;
    }

    public void redistribute() {
        resort();
    }

    private void resort() {
        Storage tempStorage = new Warehouse();
        takeAllProducts(warehouse, tempStorage);
        takeAllProducts(shop, tempStorage);
        takeAllProducts(trash, tempStorage);
        checkStorage(tempStorage);
    }

    public double calculateLife(Food food) {
        int storageLife = Period.between(food.getCreateDate(), food.getExpiryDate()).getDays();
        int remainingLife = Period.between(LocalDate.now(), food.getExpiryDate()).getDays();
        return  (1.0 * (storageLife - remainingLife) / storageLife) * 100.0;
    }

    private void takeAllProducts(Storage src, Storage dest) {
        src.getProducts().forEach(dest::add);
        src.getProducts().clear();
    }

    private void checkStorage(Storage storage) {
        for (Food food : storage.getProducts()) {
            double life = calculateLife(food);
            if (toWarehouse.test(life)) {
                warehouse.add(food);
            } else if (toShop.test(life)) {
                shop.add(food);
            } else if (toDiscount.test(life)) {
                food.setDiscount(0.25);
                shop.add(food);
            } else {
                trash.add(food);
            }
        }
    }


    public Storage getWarehouse() {
        return warehouse;
    }

    public Storage getShop() {
        return shop;
    }

    public Storage getTrash() {
        return trash;
    }
}
