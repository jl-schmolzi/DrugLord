package org.example.druglord;

import java.util.*;

import static org.example.druglord.CityName.*;

public class GameState {
    private static final int START_HEALTH = 100;
    private static final int START_CASH = 500;
    private static final int START_STATUS = 1;
    private static final int START_HOLD = 10;
    private static final int START_BANK = 0;
    private static final int START_LOAN_DEPT = 0;
    private static final double LOAN_SHARK_INTEREST = 0.05;
    private static final int LOAN_SHARK_DMG = 25;
    private static final int LOAN_SHARK_DMG_MODIFIER = 1;
    private CityName currentCity;
    private final List<City> cities;
    private Player player;

    public GameState() {
        this.cities = new ArrayList<>();
        initCities();
        initStartingCity();
        initPlayerInformation();
    }

    private void initPlayerInformation() {
        Map<Drug, Integer> playerDrugs = new EnumMap<>(Drug.class);
        playerDrugs.put(Drug.COCAINE, 0);
        playerDrugs.put(Drug.CRACK, 0);
        playerDrugs.put(Drug.HEROIN, 0);
        playerDrugs.put(Drug.ACID, 0);
        playerDrugs.put(Drug.CRYSTAL, 0);
        playerDrugs.put(Drug.GRASS, 0);
        playerDrugs.put(Drug.SPEED, 0);
        playerDrugs.put(Drug.LUDES, 0);
        player = new Player(START_CASH, START_BANK, START_LOAN_DEPT,
                START_STATUS, START_HEALTH, START_HOLD, playerDrugs);
    }

    private void initStartingCity() {
        Random random = new Random();
        int index = random.nextInt(cities.size());
        currentCity = cities.get(index).getName();

    }

    private void initCities() {
        initChicago();
        initDetroit();
        initLasVegas();
        initLosAngeles();
        initMiami();
        initNewYork();
        initSanDiego();
        initWashingtonDC();
    }

    private void initSanDiego() {
        Map<Drug, Integer> drugPrices = initRandomDrugs();

        Map<CityName, Integer> flightPrices = new EnumMap<>(CityName.class);
        flightPrices.put(CHICAGO, 214);
        flightPrices.put(DETROIT, 241);
        flightPrices.put(LAS_VEGAS, 109);
        flightPrices.put(LOS_ANGELES, 25);
        flightPrices.put(MIAMI, 330);
        flightPrices.put(NEW_YORK, 330);
        flightPrices.put(SAN_DIEGO, 0);
        flightPrices.put(WASHINGTON_D_C, 330);

        City city = new City(drugPrices, flightPrices, SAN_DIEGO);
        cities.add(city);
    }

    private void initNewYork() {
        Map<Drug, Integer> drugPrices = initRandomDrugs();

        Map<CityName, Integer> flightPrices = new EnumMap<>(CityName.class);
        flightPrices.put(CHICAGO, 145);
        flightPrices.put(DETROIT, 159);
        flightPrices.put(LAS_VEGAS, 265);
        flightPrices.put(LOS_ANGELES, 330);
        flightPrices.put(MIAMI, 145);
        flightPrices.put(NEW_YORK, 0);
        flightPrices.put(SAN_DIEGO, 330);
        flightPrices.put(WASHINGTON_D_C, 25);

        City city = new City(drugPrices, flightPrices, NEW_YORK);
        cities.add(city);
    }

    private Map<Drug, Integer> initRandomDrugs() {
        Map<Drug, Integer> ret = new EnumMap<>(Drug.class);
        ret.put(Drug.COCAINE, (int) (Math.random() * 20_000) + 40_000);
        ret.put(Drug.CRACK, (int) (Math.random() * 15_000) + 20_000);
        ret.put(Drug.HEROIN, (int) (Math.random() * 2_000) + 8_000);
        ret.put(Drug.ACID, (int) (Math.random() * 2_000) + 1_000);
        ret.put(Drug.CRYSTAL, (int) (Math.random() * 200) + 500);
        ret.put(Drug.GRASS, (int) (Math.random() * 200) + 200);
        ret.put(Drug.SPEED, (int) (Math.random() * 100) + 50);
        ret.put(Drug.LUDES, (int) (Math.random() * 40) + 10);
        return ret;
    }

    private void initMiami() {
        Map<Drug, Integer> drugPrices = initRandomDrugs();

        Map<CityName, Integer> flightPrices = new EnumMap<>(CityName.class);
        flightPrices.put(CHICAGO, 194);
        flightPrices.put(DETROIT, 241);
        flightPrices.put(LAS_VEGAS, 293);
        flightPrices.put(LOS_ANGELES, 330);
        flightPrices.put(MIAMI, 0);
        flightPrices.put(NEW_YORK, 145);
        flightPrices.put(SAN_DIEGO, 330);
        flightPrices.put(WASHINGTON_D_C, 145);

        City city = new City(drugPrices, flightPrices, MIAMI);
        cities.add(city);
    }

    private void initLosAngeles() {
        Map<Drug, Integer> drugPrices = initRandomDrugs();

        Map<CityName, Integer> flightPrices = new EnumMap<>(CityName.class);
        flightPrices.put(CHICAGO, 214);
        flightPrices.put(DETROIT, 241);
        flightPrices.put(LAS_VEGAS, 109);
        flightPrices.put(LOS_ANGELES, 0);
        flightPrices.put(MIAMI, 330);
        flightPrices.put(NEW_YORK, 330);
        flightPrices.put(SAN_DIEGO, 25);
        flightPrices.put(WASHINGTON_D_C, 330);

        City city = new City(drugPrices, flightPrices, LOS_ANGELES);
        cities.add(city);
    }

    private void initLasVegas() {
        Map<Drug, Integer> drugPrices = initRandomDrugs();

        Map<CityName, Integer> flightPrices = new EnumMap<>(CityName.class);
        flightPrices.put(CHICAGO, 145);
        flightPrices.put(DETROIT, 159);
        flightPrices.put(LAS_VEGAS, 0);
        flightPrices.put(LOS_ANGELES, 109);
        flightPrices.put(MIAMI, 293);
        flightPrices.put(NEW_YORK, 265);
        flightPrices.put(SAN_DIEGO, 109);
        flightPrices.put(WASHINGTON_D_C, 265);

        City city = new City(drugPrices, flightPrices, LAS_VEGAS);
        cities.add(city);
    }

    private void initDetroit() {
        Map<Drug, Integer> drugPrices = initRandomDrugs();

        Map<CityName, Integer> flightPrices = new EnumMap<>(CityName.class);
        flightPrices.put(CHICAGO, 85);
        flightPrices.put(DETROIT, 0);
        flightPrices.put(LAS_VEGAS, 159);
        flightPrices.put(LOS_ANGELES, 241);
        flightPrices.put(MIAMI, 241);
        flightPrices.put(NEW_YORK, 159);
        flightPrices.put(SAN_DIEGO, 241);
        flightPrices.put(WASHINGTON_D_C, 159);

        City city = new City(drugPrices, flightPrices, DETROIT);
        cities.add(city);
    }

    private void initWashingtonDC() {
        Map<Drug, Integer> drugPrices = initRandomDrugs();

        Map<CityName, Integer> flightPrices = new EnumMap<>(CityName.class);
        flightPrices.put(CHICAGO, 145);
        flightPrices.put(DETROIT, 159);
        flightPrices.put(LAS_VEGAS, 265);
        flightPrices.put(LOS_ANGELES, 330);
        flightPrices.put(MIAMI, 145);
        flightPrices.put(NEW_YORK, 25);
        flightPrices.put(SAN_DIEGO, 330);
        flightPrices.put(WASHINGTON_D_C, 0);

        City city = new City(drugPrices, flightPrices, WASHINGTON_D_C);
        cities.add(city);
    }

    private void initChicago() {
        Map<Drug, Integer> drugPrices = initRandomDrugs();

        Map<CityName, Integer> flightPrices = new EnumMap<>(CityName.class);
        flightPrices.put(CHICAGO, 0);
        flightPrices.put(DETROIT, 85);
        flightPrices.put(LAS_VEGAS, 145);
        flightPrices.put(LOS_ANGELES, 214);
        flightPrices.put(MIAMI, 194);
        flightPrices.put(NEW_YORK, 145);
        flightPrices.put(SAN_DIEGO, 214);
        flightPrices.put(WASHINGTON_D_C, 145);

        City city = new City(drugPrices, flightPrices, CHICAGO);
        cities.add(city);
    }

    public int getPlayerDrugs(Drug drug) {
        return player.getDrugCount(drug);
    }

    public String getStringOfState() {
        //        System.out.printf("|%s|%n", new String(new char[WINDOW_SIZE - 2]).replace('\u0000', '='));
        System.out.println("        Drugs on hand        Street prices ");
        StringBuilder ret = new StringBuilder();
        for (Drug value : Drug.values()) {
            ret.append(String.format("     %1$-10s %2$8d | %1$-10s %3$8d$ %n",
                    value, getPlayerDrugs(value), getDrugPrice(value)));
        }
        ret.append(String.format("%27s%s%n", "Location: ", currentCity.getStringName()));
        ret.append(player.playerInformation());
        return ret.toString();
    }

    private City getCurrentCityFromList() {
        return cities.stream().filter(city -> city.getName() == currentCity).findAny().orElse(null);
    }

    private int getDrugPrice(Drug value) {
        return getCurrentCityFromList().getDrugPrice(value);
    }

    public CityName getCurrentCity() {
        return currentCity;
    }

    public String getCurrentFlightPricesString() {
        return getCurrentCityFromList().getFlightPricesString();
    }

    public boolean CheckTravelTo(int index) {
        CityName cityName = CityName.cityNameFromId(index);
        int price = getCurrentCityFromList().getFlightPrices().get(cityName);
        return player.checkPay(price);
    }

    public void travelTo(int cityId) {
        CityName cityName = CityName.cityNameFromId(cityId);
        int price = getCurrentCityFromList().getFlightPrices().get(cityName);
        player.pay(price);
        currentCity = cityName;
    }

    public String getCurrentDrugPricesString() {
        return getCurrentCityFromList().getDrugPricesString();
    }

    public boolean CheckBuyDrug(int index, int amount) {
        int price = getCurrentCityFromList().getDrugPrice(Drug.drugFromId(index)) * amount;
        return player.checkHold(amount) && player.checkPay(price);
    }

    public void buyDrug(int index, int amount) {
        int price = getCurrentCityFromList().getDrugPrice(Drug.drugFromId(index)) * amount;
        player.pay(price);
        player.addDrug(Drug.drugFromId(index), amount);
        player.addHold(amount);
    }

    public boolean checkSellDrug(int index, int amount) {
        return player.checkSellDrug(Drug.drugFromId(index), amount);
    }

    public void sellDrug(int index, int amount) {
        Drug drug = Drug.drugFromId(index);
        int price = getCurrentCityFromList().getDrugPrice(drug);
        player.sellDrug(drug, price, amount);
    }

    public void advance(int days) {

    }

    public boolean checkWithdraw(int amount) {
        return player.checkWithdraw(amount);
    }

    public void withdraw(int amount) {
        player.withdraw(amount);
    }

    public boolean checkDeposit(int amount) {
        return player.checkDeposit(amount);
    }

    public void deposit(int amount) {
        player.deposit(amount);
    }

    public void goToHospital() {

    }

    public int checkHospitalPrice() {
        int health = player.checkHospital();
        if (health == 100) {
            return 0;
        } else if (health > 75) {
            return 250;
        } else if (health > 50) {
            return 500;
        } else if (health > 25) {
            return 750;
        } else {
            return 1000;
        }
    }

    public boolean checkHospital(int hostpitalPay) {
        return player.checkPay(hostpitalPay);
    }

    public void payHospital(int hostpitalPay) {
        player.pay(hostpitalPay);
    }
}
