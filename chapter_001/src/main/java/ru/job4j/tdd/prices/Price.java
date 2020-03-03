package ru.job4j.tdd.prices;

import java.time.LocalDateTime;
import java.util.Objects;

public class Price {

    private static long primaryKey = 0;

    private long id;
    private String productCode;
    private int number;
    private int depart;
    private LocalDateTime begin;
    private LocalDateTime end;
    private long value;

    public Price(String productCode, int number, int depart, LocalDateTime begin, LocalDateTime end, long value) {
        this.id = primaryKey++;
        this.productCode = productCode;
        this.number = number;
        this.depart = depart;
        this.begin = begin;
        this.end = end;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Price price = (Price) o;
        return number == price.number
                && depart == price.depart
                && value == price.value
                && Objects.equals(productCode, price.productCode)
                && Objects.equals(begin, price.begin)
                && Objects.equals(end, price.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productCode, number, depart, begin, end, value);
    }

    public long getId() {
        return id;
    }

    public String getProductCode() {
        return productCode;
    }

    public int getNumber() {
        return number;
    }

    public int getDepart() {
        return depart;
    }

    public LocalDateTime getBegin() {
        return begin;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public long getValue() {
        return value;
    }
}
