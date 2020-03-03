package ru.job4j.tdd.prices;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PriceCombinerTest {

    @Test
    public void mergeWhenOldPricesAndNewPricesAreEmptyThenReturnEmpty() {
        PriceCombiner priceCombiner = new PriceCombiner();
        List<Price> oldPrices = new ArrayList<>();
        List<Price> newPrices = new ArrayList<>();

        List<Price> expected = new ArrayList<>();

        List<Price> actual = priceCombiner.mergePrices(oldPrices, newPrices);

        assertThat(expected, is(actual));
    }

    @Test
    public void mergeWhenOldPricesIsEmptyAndNewPricesHasOneThenReturnHsOne() {
        LocalDateTime beginNew = LocalDateTime.of(2013, 1, 15, 0, 0, 0);
        LocalDateTime endNew = LocalDateTime.of(2013, 2, 15, 0, 0, 0);
        Price newPrice = new Price("111", 1, 1, beginNew, endNew, 1000);
        Price expectPrice = newPrice;
        PriceCombiner priceCombiner = new PriceCombiner();
        List<Price> oldPrices = new ArrayList<>();
        List<Price> newPrices = new ArrayList<>(List.of(newPrice));

        List<Price> expected = new ArrayList<>(List.of(expectPrice));

        List<Price> actual = priceCombiner.mergePrices(oldPrices, newPrices);

        assertThat(expected, is(actual));
    }

    @Test
    public void mergeWhenOldPriceAndNewPriceHaveNoOverlappingPeriodThenNewPriceIsAdded() {
        LocalDateTime beginOld = LocalDateTime.of(2013, 1, 1, 0, 0, 0);
        LocalDateTime endOld = LocalDateTime.of(2013, 2, 1, 0, 0, 0);
        Price oldPrice = new Price("111", 1, 1, beginOld, endOld, 1000);
        LocalDateTime beginNew = LocalDateTime.of(2013, 2, 2, 0, 0, 0);
        LocalDateTime endNew = LocalDateTime.of(2013, 2, 15, 0, 0, 0);
        Price newPrice = new Price("111", 1, 1, beginNew, endNew, 1000);
        PriceCombiner priceCombiner = new PriceCombiner();
        List<Price> oldPrices = new ArrayList<>(List.of(oldPrice));
        List<Price> newPrices = new ArrayList<>(List.of(newPrice));

        List<Price> expected = new ArrayList<>(List.of(oldPrice, newPrice));

        List<Price> actual = priceCombiner.mergePrices(oldPrices, newPrices);

        assertThat(expected, is(actual));
    }

    @Test
    public void mergeWhenOldPriceAndNewPriceHaveOverlappingPeriodThenPricePeriodIsExtended() {
        LocalDateTime beginOld = LocalDateTime.of(2013, 1, 1, 0, 0, 0);
        LocalDateTime endOld = LocalDateTime.of(2013, 2, 1, 0, 0, 0);
        Price oldPrice = new Price("111", 1, 1, beginOld, endOld, 1000);
        LocalDateTime beginNew = LocalDateTime.of(2013, 1, 15, 0, 0, 0);
        LocalDateTime endNew = LocalDateTime.of(2013, 2, 15, 0, 0, 0);
        Price newPrice = new Price("111", 1, 1, beginNew, endNew, 1000);
        Price expectPrice = new Price("111", 1, 1, beginOld, endNew, 1000);
        PriceCombiner priceCombiner = new PriceCombiner();
        List<Price> oldPrices = new ArrayList<>(List.of(oldPrice));
        List<Price> newPrices = new ArrayList<>(List.of(newPrice));

        Price expected = new ArrayList<>(List.of(expectPrice)).get(0);

        Price actual = priceCombiner.mergePrices(oldPrices, newPrices).get(0);

        assertThat(expected, is(actual));
    }

    @Test
    public void mergeWhenNewPriceIsInMiddleOldPriceThenCreatedThreeNewPrices() {
        LocalDateTime beginOld = LocalDateTime.of(2013, 1, 1, 0, 0, 0);
        LocalDateTime endOld = LocalDateTime.of(2013, 2, 1, 0, 0, 0);
        Price oldPrice = new Price("111", 1, 1, beginOld, endOld, 1000);
        LocalDateTime beginNew = LocalDateTime.of(2013, 1, 10, 0, 0, 0);
        LocalDateTime endNew = LocalDateTime.of(2013, 1, 20, 0, 0, 0);
        Price newPrice = new Price("111", 1, 1, beginNew, endNew, 500);
        Price resultPrice1 = new Price("111", 1, 1, beginOld, beginNew, 1000);
        Price resultPrice2 = new Price("111", 1, 1, beginNew, endNew, 500);
        Price resultPrice3 = new Price("111", 1, 1, endNew, endOld, 1000);
        PriceCombiner priceCombiner = new PriceCombiner();
        List<Price> oldPrices = new ArrayList<>(List.of(oldPrice));
        List<Price> newPrices = new ArrayList<>(List.of(newPrice));

        List<Price> expected = new ArrayList<>(List.of(resultPrice1, resultPrice2, resultPrice3));

        List<Price> actual = priceCombiner.mergePrices(oldPrices, newPrices);

        assertThat(expected, is(actual));
    }

    @Test
    public void mergeWhenNewPriceIsInMiddleOldPriceAndHasAnotherPriceThenFourPrices() {
        LocalDateTime beginOld = LocalDateTime.of(2013, 1, 1, 0, 0, 0);
        LocalDateTime endOld = LocalDateTime.of(2013, 2, 1, 0, 0, 0);
        Price oldPrice = new Price("111", 1, 1, beginOld, endOld, 1000);
        LocalDateTime beginNew = LocalDateTime.of(2013, 1, 10, 0, 0, 0);
        LocalDateTime endNew = LocalDateTime.of(2013, 1, 20, 0, 0, 0);
        Price newPrice = new Price("111", 1, 1, beginNew, endNew, 500);
        Price anotherPrice = new Price("9999", 1, 1, beginOld, endOld, 9999);
        Price resultPrice1 = new Price("111", 1, 1, beginOld, beginNew, 1000);
        Price resultPrice2 = new Price("111", 1, 1, beginNew, endNew, 500);
        Price resultPrice3 = new Price("111", 1, 1, endNew, endOld, 1000);
        PriceCombiner priceCombiner = new PriceCombiner();
        List<Price> oldPrices = new ArrayList<>(List.of(oldPrice, anotherPrice));
        List<Price> newPrices = new ArrayList<>(List.of(newPrice));

        List<Price> expected = new ArrayList<>(List.of(resultPrice1, resultPrice2, resultPrice3, anotherPrice));

        List<Price> actual = priceCombiner.mergePrices(oldPrices, newPrices);

        assertThat(expected, is(actual));
    }

    @Test
    public void mergeWhenNewPriceIsInMiddleOldPriceAndHasAnotherOldAndAnotherNewPricePriceThenFivePrices() {
        LocalDateTime beginOld = LocalDateTime.of(2013, 1, 1, 0, 0, 0);
        LocalDateTime endOld = LocalDateTime.of(2013, 2, 1, 0, 0, 0);
        Price oldPrice = new Price("111", 1, 1, beginOld, endOld, 1000);
        LocalDateTime beginNew = LocalDateTime.of(2013, 1, 10, 0, 0, 0);
        LocalDateTime endNew = LocalDateTime.of(2013, 1, 20, 0, 0, 0);
        Price newPrice = new Price("111", 1, 1, beginNew, endNew, 500);
        Price anotherOldPrice = new Price("9999", 1, 1, beginOld, endOld, 9999);
        Price anotherNewPrice = new Price("444", 1, 1, beginOld, endOld, 777);
        Price resultPrice1 = new Price("111", 1, 1, beginOld, beginNew, 1000);
        Price resultPrice2 = new Price("111", 1, 1, beginNew, endNew, 500);
        Price resultPrice3 = new Price("111", 1, 1, endNew, endOld, 1000);
        PriceCombiner priceCombiner = new PriceCombiner();
        List<Price> oldPrices = new ArrayList<>(List.of(oldPrice, anotherOldPrice));
        List<Price> newPrices = new ArrayList<>(List.of(anotherNewPrice, newPrice));

        List<Price> expected = new ArrayList<>(List.of(resultPrice1, resultPrice2, resultPrice3, anotherNewPrice, anotherOldPrice));

        List<Price> actual = priceCombiner.mergePrices(oldPrices, newPrices);

        assertThat(expected, is(actual));
    }
}