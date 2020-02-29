package ru.job4j.srp;

public class ConsoleCalcView implements CalcView {

    private CalcController calcController;

    @Override
    public void show(String message) {
        System.out.println(message);
    }

    @Override
    public void showMenu(String[] operations) {
        int select;
        while (true) {
            this.show("Select an operation:");
            for (int i = 0; i < operations.length; i++) {
                this.show(String.format("%d. %s", i, operations[i]));
            }
            this.show(String.format("%d. Exit", operations.length));
            select = calcController.getCalcInput().receiveNumber();
            if (select == operations.length) {
                break;
            }
        }


    }

    public void setCalcController(CalcController calcController) {
        this.calcController = calcController;
    }
}
