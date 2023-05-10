package org.example.druglord;

import java.util.EnumMap;
import java.util.Map;

public class Player {
    private static final int PLAYER_MAX_HEALTH = 100;
    private int cash;
    private int bank;
    private int debt;
    private int status;
    private int health;
    private int hold;
    private int currentHold = 0;
    private Map<Drug, Integer> drugs;

    public Player(int cash, int bank, int debt, int status, int health, int hold, Map<Drug, Integer> drugs) {
        this.cash = cash;
        this.bank = bank;
        this.debt = debt;
        this.status = status;
        this.health = health;
        this.hold = hold;
        this.drugs = drugs;
    }

    @Override
    public String toString() {
        return "Player{" +
                "cash=" + cash +
                ", bank=" + bank +
                ", debt=" + debt +
                ", status=" + status +
                ", health=" + health +
                ", hold=" + hold +
                '}';
    }

    public int getCash() {
        return cash;
    }

    public int getBank() {
        return bank;
    }

    public int getDebt() {
        return debt;
    }

    public int getStatus() {
        return status;
    }

    public int getHealth() {
        return health;
    }

    public int getHold() {
        return hold;
    }

    public int getCurrentHold() {
        return currentHold;
    }

    public Map<Drug, Integer> getDrugs() {
        return drugs;
    }

    public int getDrugCount(Drug drug) {
        return drugs.get(drug);
    }

    public String playerInformation() {
        StringBuilder ret = new StringBuilder();
        ret.append(String.format("%27s%d (%d max)%n", "Hold: ", currentHold, hold));
        ret.append(String.format("%27s%d%n", "Cash: ", cash));
        ret.append(String.format("%27s%d%n", "In Bank: ", bank));
        ret.append(String.format("%27s%d%n", "In Dept: ", debt));
        ret.append(String.format("%27s%d%n", "Status Pts: ", status));
        ret.append(String.format("%27s%d%n", "Health: ", health));
        return ret.toString();
    }

    public void pay(int price) {
        cash -= price;
    }

    public boolean checkPay(int price) {
        return price <= cash;
    }

    public boolean checkHold(int amout) {
        return (currentHold + amout) <= hold;
    }

    public void addDrug(Drug drug, int amount) {
        drugs.put(drug, drugs.get(drug) + amount);
    }

    public void addHold(int amount) {
        currentHold += amount;
    }

    public void sellDrug(Drug drug, int price, int amount) {
        currentHold -= amount;
        cash += price * amount;
        drugs.put(drug, drugs.get(drug) - amount);
    }

    public boolean checkSellDrug(Drug drug, int amount) {
        return amount <= getDrugCount(drug);
    }

    public boolean checkWithdraw(int amount) {
        return amount <= bank;
    }

    public void withdraw(int amount) {
        bank -= amount;
        cash += amount;
    }

    public boolean checkDeposit(int amount) {
        return amount <= cash;
    }

    public void deposit(int amount) {
        cash -= amount;
        bank += amount;
    }

    public int checkHospital() {
        return health;
    }

    public void loan(int money) {
        cash += money;
        debt += money;
    }

    public void payLoanBack(int money) {
        pay(money);
        debt = (money > debt) ? 0 : debt - money;
    }

    public void increaseLoan(double loanSharkInterest) {
        debt = debt + (int) Math.floor(debt * loanSharkInterest);
    }

    public void damage(int i) {
        health -= i;
    }
}
