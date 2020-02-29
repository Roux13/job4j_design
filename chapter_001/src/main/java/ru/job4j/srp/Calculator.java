package ru.job4j.srp;

import java.util.Locale;

/**
 * Class Calculator for calculating arithmetic operations:
 * 1.add - addition.
 * 2.div - division.
 * 3.multiply - multiplication.
 * 4.subtrack - subtraction.
 *
 * @author Yuri Nehodov
 * @since 5.01.2020
 * @version 1.0
 */


public class Calculator {

    public static void add(double first, double second) {
        System.out.printf(Locale.ENGLISH, "%,.1f + %,.1f = %,.1f%n", first, second, first + second);
    }

    public static void div(double first, double second) {
        System.out.printf(Locale.ENGLISH, "%,.1f / %,.1f = %,.1f%n", first, second, first / second);
    }

    public static void multiply(double first, double second) {
        System.out.printf(Locale.ENGLISH, "%,.1f * %,.1f = %,.1f%n", first, second, first * second);
    }

    public static void subtrack(double first, double second) {
        System.out.printf(Locale.ENGLISH, "%,.1f - %,.1f = %,.1f%n", first, second, first - second);
    }

    /**
     * Method main for testing class Calculator.
     * It is testing Calculator's methods with fixed parameters.
     *
     * @param args
     */
    public static void main(String[] args) {
        add(1, 1);
        div(4, 2);
        multiply(2, 1);
        subtrack(10, 5);
    }

}