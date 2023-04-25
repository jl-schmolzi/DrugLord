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
            switch (action) {
                case 'q' -> stop = true;
                case 'b' -> startBuyDrugs();
                case 's' -> startSellDrugs();
                case 'j' -> startJetToCity();
                case 'v' -> startVisitBank();
                case 'h' -> startGoToHospital();
                case 'l' -> startSeeLoanShark();
                default -> startUnknownAction();
            }
        }
    }

    private void startUnknownAction() {
        System.out.println("I dont know this action.");
    }

    private void printState() {
        System.out.println(gameState.getStringOfState());
    }


    private void startSeeLoanShark() {
    }

    private void startGoToHospital() {
        int hostpitalPay = gameState.checkHospitalPrice();
        if (hostpitalPay == 0) {
            System.out.println("You are healthy enough");
        } else {
            System.out.printf("You need to pay %d. Do you want to pay that? (Y/N)  ", hostpitalPay);
            char action = scanner.nextLine().toLowerCase().charAt(0);
            if(action == '<'){
                if (gameState.checkHospital(hostpitalPay)){
                    gameState.payHospital(hostpitalPay);
                    System.out.println("You got fixed");
                }else{
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
                if (gameState.checkWithdraw(amount))
                    gameState.withdraw(amount);
                else
                    System.out.println("Cannot withdraw that");
            } else {
                if (gameState.checkDeposit(amount))
                    gameState.deposit(amount);
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
        if (gameState.CheckBuyDrug(index, amount)) {
            gameState.buyDrug(index, amount);
        } else {
            System.out.println("That is not possible");
        }
    }

    private void printActions() {
        ui.printOptions();
    }
}
