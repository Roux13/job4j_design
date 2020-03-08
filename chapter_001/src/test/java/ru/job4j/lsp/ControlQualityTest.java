package ru.job4j.lsp;

import org.junit.Test;
import ru.job4j.lsp.storage.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ControlQualityTest {

    @Test
    public void redistributeWhenOneFreshFood() {
        Storage warehouse = new Warehouse();
        Storage shop = new Shop();
        Storage trash = new Trash();
        ControlQuality controlQuality = new ControlQuality(warehouse, shop, trash);
        Food milk = new Milk(
                "Korovka",
                LocalDate.now(),
                LocalDate.now().plus(Period.ofDays(10)),
                40,
                0.0);
        controlQuality.getWarehouse().add(milk);

        List<Food> expected = List.of(milk);

        controlQuality.redistribute();
        List<Food> actual = warehouse.getProducts();

        assertThat(actual, is(expected));
    }

    @Test
    public void redistributeWhenOneFoodAndHalfExpiryDateThenAddToShop() {
        Storage warehouse = new Warehouse();
        Storage shop = new Shop();
        Storage trash = new Trash();
        ControlQuality controlQuality = new ControlQuality(warehouse, shop, trash);
        Food milk = new Milk(
                "Korovka",
                LocalDate.now().minus(Period.ofDays(10)),
                LocalDate.now().plus(Period.ofDays(10)),
                40,
                0.0);
        controlQuality.getWarehouse().add(milk);

        List<Food> expected = List.of(milk);

        controlQuality.redistribute();
        List<Food> actual = shop.getProducts();

        assertThat(actual, is(expected));
    }

    @Test
    public void redistributeWhenOneFoodAndNearExpiryDateThenFoodIsDiscountAndAddToShop() {
        Storage warehouse = new Warehouse();
        Storage shop = new Shop();
        Storage trash = new Trash();
        ControlQuality controlQuality = new ControlQuality(warehouse, shop, trash);
        Food milk = new Milk(
                "Korovka",
                LocalDate.now().minus(Period.ofDays(10)),
                LocalDate.now().plus(Period.ofDays(1)),
                40,
                0.0);
        controlQuality.getShop().add(milk);

        Food milkAfter = new Milk(
                "Korovka",
                LocalDate.of(2020, 3, 1),
                LocalDate.of(2020, 3, 9),
                40,
                0.25);
        List<Food> expected = List.of(milkAfter);

        controlQuality.redistribute();
        List<Food> actual = shop.getProducts();

        assertThat(actual.get(0).getDiscount(), is(expected.get(0).getDiscount()));
    }

    @Test
    public void redistributeWhenOneFoodLifeIsExpiredThenFoodAddToTrash() {
        Storage warehouse = new Warehouse();
        Storage shop = new Shop();
        Storage trash = new Trash();
        ControlQuality controlQuality = new ControlQuality(warehouse, shop, trash);
        Food milk = new Milk(
                "Korovka",
                LocalDate.now().minus(Period.ofDays(10)),
                LocalDate.now().minus(Period.ofDays(1)),
                40,
                0.0);
        controlQuality.getShop().add(milk);

        List<Food> expected = List.of(milk);

        controlQuality.redistribute();
        List<Food> actual = trash.getProducts();

        assertThat(actual, is(expected));
    }

    @Test
    public void redistributeWhenOneFreshOneHalfLifeOneNearExpiredOneExpired() {
        Storage warehouse = new Warehouse();
        Storage shop = new Shop();
        Storage trash = new Trash();
        ControlQuality controlQuality = new ControlQuality(warehouse, shop, trash);
        Food freshMilk = new Milk(
                "Korovka",
                LocalDate.now(),
                LocalDate.now().plus(Period.ofDays(10)),
                40,
                0.0);
        Food halfMilk = new Milk(
                "Korovka",
                LocalDate.now().minus(Period.ofDays(10)),
                LocalDate.now().plus(Period.ofDays(10)),
                40,
                0.0);
        Food nearExpiredBread = new Bread(
                "Kirpich",
                LocalDate.now().minus(Period.ofDays(10)),
                LocalDate.now().plus(Period.ofDays(1)),
                40,
                0.0);
        Food expiredEgg = new Egg(
                "Ryaba",
                LocalDate.now().minus(Period.ofDays(10)),
                LocalDate.now().minus(Period.ofDays(1)),
                40,
                0.0);
        controlQuality.getWarehouse().add(freshMilk);
        controlQuality.getWarehouse().add(halfMilk);
        controlQuality.getWarehouse().add(nearExpiredBread);
        controlQuality.getWarehouse().add(expiredEgg);

        Food nearExpiredBreadAfter = new Bread(
                "Kirpich",
                LocalDate.now().minus(Period.ofDays(10)),
                LocalDate.now().plus(Period.ofDays(1)),
                40,
                0.0);
        nearExpiredBreadAfter.setDiscount(0.25);
        List<Food> expected = List.of(freshMilk, halfMilk, nearExpiredBreadAfter, expiredEgg);

        controlQuality.redistribute();
        List<Food> actual = List.of(
                controlQuality.getWarehouse().getProducts().get(0),
                controlQuality.getShop().getProducts().get(0),
                controlQuality.getShop().getProducts().get(1),
                controlQuality.getTrash().getProducts().get(0)
        );

        assertThat(actual, is(expected));
    }

    @Test
    public void calculateLifeWhenCreatedNowThen0() {
        Storage warehouse = new Warehouse();
        Storage shop = new Shop();
        Storage trash = new Trash();
        ControlQuality controlQuality = new ControlQuality(warehouse, shop, trash);
        Food milk = new Milk(
                "Korovka",
                LocalDate.now(),
                LocalDate.now().plus(Period.ofDays(8)),
                40,
                0.0);

        double expected = 0.0;

        double actual = controlQuality.calculateLife(milk);

        assertEquals(actual, expected, 0.0001);
    }

    @Test
    public void calculateLifeWhenHalfLifeThen50() {
        Storage warehouse = new Warehouse();
        Storage shop = new Shop();
        Storage trash = new Trash();
        ControlQuality controlQuality = new ControlQuality(warehouse, shop, trash);
        Food milk = new Milk(
                "Korovka",
                LocalDate.now().minus(Period.ofDays(8)),
                LocalDate.now().plus(Period.ofDays(8)),
                40,
                0.0);

        double expected = 50.0;

        double actual = controlQuality.calculateLife(milk);

        assertEquals(actual, expected, 0.0001);
    }

    @Test
    public void calculateLifeWhen75percentLifeThen75() {
        Storage warehouse = new Warehouse();
        Storage shop = new Shop();
        Storage trash = new Trash();
        ControlQuality controlQuality = new ControlQuality(warehouse, shop, trash);
        Food milk = new Milk(
                "Korovka",
                LocalDate.now().minus(Period.ofDays(12)),
                LocalDate.now().plus(Period.ofDays(4)),
                40,
                0.0);

        double expected = 75.0;

        double actual = controlQuality.calculateLife(milk);

        assertEquals(actual, expected, 0.0001);
    }

    @Test
    public void calculateLifeWhenLifeEndedThen100() {
        Storage warehouse = new Warehouse();
        Storage shop = new Shop();
        Storage trash = new Trash();
        ControlQuality controlQuality = new ControlQuality(warehouse, shop, trash);
        Food milk = new Milk(
                "Korovka",
                LocalDate.now().minus(Period.ofDays(12)),
                LocalDate.now(),
                40,
                0.0);

        double expected = 100.0;

        double actual = controlQuality.calculateLife(milk);

        assertEquals(actual, expected, 0.0001);
    }
}