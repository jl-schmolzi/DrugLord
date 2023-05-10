package org.example.druglord;

import java.util.Map;

public record City (Map<Drug, Integer> drugPrices, Map<CityName, Integer> flightPrices, CityName name){
    public int getDrugPrice(Drug value) {
        return drugPrices.get(value);
    }
    public String getFlightPricesString() {
        StringBuilder ret = new StringBuilder();
        ret.append("Where do you want to go?\n");
        for (var entry : flightPrices.entrySet()) {
            ret.append(String.format("%d: %s %-4d%n", entry.getKey().getIntId(), entry.getKey().getStringName(), entry.getValue()));
        }
        return ret.toString();
    }

    public String getDrugPricesString() {
        StringBuilder ret = new StringBuilder();
        ret.append("What do you want to buy?\n");
        for (var entry : drugPrices.entrySet()) {
            ret.append(String.format("%d: %s %6d$%n", entry.getKey().getDrugId(), entry.getKey(), entry.getValue()));
        }
        return ret.toString();
    }
}
