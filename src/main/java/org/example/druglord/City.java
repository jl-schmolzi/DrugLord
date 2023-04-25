package org.example.druglord;

import java.util.Map;

public class City {
    private final Map<Drug, Integer> drugPrices;
    private final Map<CityName, Integer> flightPrices;
    private final CityName name;

    public City(Map<Drug, Integer> drugPrices, Map<CityName, Integer> flightPrices, CityName name) {
        this.drugPrices = drugPrices;
        this.flightPrices = flightPrices;
        this.name = name;
    }

    public int getDrugPrice(Drug value) {
        return drugPrices.get(value);
    }

    public Map<CityName, Integer> getFlightPrices() {
        return flightPrices;
    }
    public CityName getName() {
        return name;
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
