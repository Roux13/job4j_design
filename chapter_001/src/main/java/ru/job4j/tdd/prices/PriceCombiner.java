package ru.job4j.tdd.prices;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class PriceCombiner {

//    //#1
//    public List<Price> mergePrices(List<Price> oldPrices, List<Price> newPrices) {
//        return null;
//    }

//    //#2
//    public List<Price> mergePrices(List<Price> oldPrices, List<Price> newPrices) {
//        oldPrices.addAll(newPrices);
//        return oldPrices;
//    }

    //#3
//    public List<Price> mergePrices(List<Price> oldPrices, List<Price> newPrices) {
//        ListIterator<Price> oldIterator = oldPrices.listIterator();
//        ListIterator<Price> newIterator = newPrices.listIterator();
//        while (oldIterator.hasNext()) {
//            Price oldPrice = oldIterator.next();
//            while (newIterator.hasNext()) {
//                Price newPrice = newIterator.next();
//                if (this.comparePrices(oldPrice, newPrice) && oldPrice.getEnd().isAfter(newPrice.getBegin())) {
//                    Price tempPrice = new Price(
//                            oldPrice.getProductCode(),
//                            oldPrice.getNumber(),
//                            oldPrice.getDepart(),
//                            oldPrice.getBegin(),
//                            newPrice.getEnd(),
//                            oldPrice.getValue());
//                    oldIterator.remove();
//                    newIterator.remove();
//                    newIterator.add(tempPrice);
//                }
//            }
//        }
//        oldPrices.addAll(newPrices);
//        return oldPrices;
//    }
//
//    private boolean comparePrices(Price oldPrice, Price newPrice) {
//        return oldPrice.getProductCode().equals(newPrice.getProductCode())
//                && oldPrice.getNumber() == newPrice.getNumber()
//                && oldPrice.getDepart() == newPrice.getDepart();
//    }


    // #4

    public List<Price> mergePrices(List<Price> oldPrices, List<Price> newPrices) {
        ListIterator<Price> oldIterator = oldPrices.listIterator();
        ListIterator<Price> newIterator = newPrices.listIterator();
        while (oldIterator.hasNext()) {
            Price oldPrice = oldIterator.next();
            boolean isConverted = false;
            while (newIterator.hasNext()) {
                Price newPrice = newIterator.next();
                if (this.comparePrices(oldPrice, newPrice)) {
                    isConverted = true;
                    List<Price> tempList = this.convertFromOldToNewPrice(oldPrice, newPrice);
                    newIterator.remove();
                    oldIterator.remove();
                    tempList.forEach(oldIterator::add);
                } else {
                    isConverted = true;
                    oldIterator.add(newPrice);
                    newIterator.remove();
                }
                if (isConverted) {
                    isConverted = false;
                    oldIterator = oldPrices.listIterator();
                    newIterator = newPrices.listIterator();
                    break;
                }
            }
        }
        oldPrices.addAll(newPrices);
        return oldPrices;
    }

    private List<Price> convertFromOldToNewPrice(Price oldPrice, Price newPrice) {
        List<Price> resultList = new ArrayList<>();
        if (newPrice.getBegin().isAfter(oldPrice.getBegin()) && newPrice.getEnd().isBefore(oldPrice.getEnd())) {
            resultList = this.pasteNewPriceIntoOldPrice(oldPrice, newPrice);
        } else if (oldPrice.getEnd().isAfter(newPrice.getBegin())) {
            resultList = this.extensionPrice(oldPrice, newPrice);
        } else {
            resultList.add(oldPrice);
            resultList.add(newPrice);
        }
        return resultList;
    }

    private List<Price> pasteNewPriceIntoOldPrice(Price oldPrice, Price newPrice) {
        List<Price> resultList = new ArrayList<>();
        String productCode = oldPrice.getProductCode();
        int number = oldPrice.getNumber();
        int depart = oldPrice.getDepart();
        LocalDateTime beginOld = oldPrice.getBegin();
        LocalDateTime endOld = oldPrice.getEnd();
        LocalDateTime beginNew = newPrice.getBegin();
        LocalDateTime endNew = newPrice.getEnd();
        long oldValue = oldPrice.getValue();
        long newValue = newPrice.getValue();
        Price resultPrice1 = new Price(productCode, number, depart, beginOld, beginNew, oldValue);
        Price resultPrice2 = new Price(productCode, number, depart, beginNew, endNew, newValue);
        Price resultPrice3 = new Price(productCode, number, depart, endNew, endOld, oldValue);
        resultList.add(resultPrice1);
        resultList.add(resultPrice2);
        resultList.add(resultPrice3);
        return resultList;
    }

    private List<Price> extensionPrice(Price oldPrice, Price newPrice) {
        List<Price> resultList = new ArrayList<>();
        Price tempPrice = new Price(
                oldPrice.getProductCode(),
                oldPrice.getNumber(),
                oldPrice.getDepart(),
                oldPrice.getBegin(),
                newPrice.getEnd(),
                oldPrice.getValue());
        resultList.add(tempPrice);
        return resultList;
    }

    private boolean comparePrices(Price oldPrice, Price newPrice) {
        return oldPrice.getProductCode().equals(newPrice.getProductCode())
                && oldPrice.getNumber() == newPrice.getNumber()
                && oldPrice.getDepart() == newPrice.getDepart();
    }
}
