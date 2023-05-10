package org.example.druglord;


import org.example.UI.DrugLordUI;
import org.example.UI.DrugLordUIImpl;

import java.util.Scanner;

public class DrugLord {
    //    private static final int WINDOW_SIZE = 100;
    private GameState gameState;
    private final Scanner scanner = new Scanner(System.in);
    private DrugLordUI ui;

    public DrugLord() {
        gameState = new GameState();
        ui = new DrugLordUIImpl();
    }

    public void start() {
        boolean stop = false;
        while (!stop) {
            printState();
            printActions();
            char action = scanner.nextLine().toLowerCase().charAt(0);
            boolean stopManual = false;
            switch (action) {
                case 'q' -> stopManual = true;
                case 'b' -> startBuyDrugs();
                case 's' -> startSellDrugs();
                case 'j' -> startJetToCity();
                case 'v' -> startVisitBank();
                case 'h' -> startGoToHospital();
                case 'l' -> startSeeLoanShark();
                default -> startUnknownAction();
            }
            boolean stopWin = startCheckWin();
            boolean stopLose = startStopLose();
            stop = stopLose || stopWin || stopManual;
        }
    }

    private boolean startStopLose() {
        if(gameState.checkLose()){
            System.out.printf("YOU DIED!!");
            return true;
        }
        return false;
    }

    private boolean startCheckWin() {
        if(gameState.checkWin()){
            System.out.printf("YOU WON!!!");
            return true;
        }
        return false;
    }

    private void startUnknownAction() {
        System.out.println("I dont know this action.");
    }

    private void printState() {
        System.out.println(gameState.getStringOfState());
    }


    private void startSeeLoanShark() {
        int currentDebt = gameState.getPlayer().getDebt();
        if (currentDebt > 0) {
            System.out.printf("you owe %d$%nHow much do you want to pay back?%n", currentDebt);
            int money = scanner.nextInt();
            scanner.nextLine();
            if (gameState.getPlayer().checkPay(money)) {
                System.out.println("Thanks");
                gameState.payLoanBack(money);
            } else {
                System.out.println("You dont have that much money");
            }
        } else {
            System.out.println("How much money do you want?");
            int money = scanner.nextInt();
            scanner.nextLine();
            gameState.loan(money);
        }

    }

    private void startGoToHospital() {
        int hostpitalPay = gameState.checkHospitalPrice();
        if (hostpitalPay == 0) {
            System.out.println("You are healthy enough");
        } else {
            System.out.printf("You need to pay %d. Do you want to pay that? (Y/N)  ", hostpitalPay);
            char action = scanner.nextLine().toLowerCase().charAt(0);
            if (action == '<') {
                if (gameState.checkHospital(hostpitalPay)) {
                    gameState.payHospital(hostpitalPay);
                    System.out.println("You got fixed");
                } else {
                    System.out.println("You need money to get fixed");
                }
            }
        }
    }

    private void startSellDrugs() {
        System.out.println(gameState.getCurrentDrugPricesString());
        int index = scanner.nextInt();
        scanner.nextLine();
        System.out.println("How many?");
        int amount = scanner.nextInt();
        scanner.nextLine();
        if (gameState.checkSellDrug(index, amount)) {
            gameState.sellDrug(index, amount);
        } else {
            System.out.println("That is not possible");
        }
    }

    private void startVisitBank() {
        System.out.println("(W)ithdraw or (D)eposit?");
        char action = scanner.nextLine().toLowerCase().charAt(0);
        if (!(action == 'w' || action == 'd')) {
            System.out.println("Not a legal action!");
        } else {
            System.out.println("how much?");
            int amount = scanner.nextInt();
            scanner.nextLine();
            if (action == 'w') {
                if (gameState.checkWithdraw(amount)) {
                    gameState.withdraw(amount);
                }
                else
                    System.out.println("Cannot withdraw that");
            } else {
                if (gameState.checkDeposit(amount)) {
                    gameState.deposit(amount);
                }
                else
                    System.out.println("Cannot withdraw that");
            }
        }
    }


    private void startJetToCity() {
        System.out.println(gameState.getCurrentFlightPricesString());
        int index = scanner.nextInt();
        scanner.nextLine();
        if (gameState.CheckTravelTo(index)) {
            gameState.travelTo(index);
        } else {
            System.out.println("That is not possible");
        }
    }

    private void startBuyDrugs() {
        System.out.println(gameState.getCurrentDrugPricesString());
        int index = scanner.nextInt();
        scanner.nextLine();
        System.out.println("How many?");
        int amount = scanner.nextInt();
        scanner.nextLine();
        if (gameState.checkBuyDrug(index, amount)) {
            gameState.buyDrug(index, amount);
        } else {
            System.out.println("That is not possible");
        }
    }

    private void printActions() {
        ui.printOptions();
    }
}
