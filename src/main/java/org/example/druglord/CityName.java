package org.example.druglord;

public enum CityName {
    CHICAGO("Chicago"),
    DETROIT("Deroit"),
    LAS_VEGAS("Las Vegas"),
    LOS_ANGELES("Los Angeles"),
    MIAMI("Miami"),
    NEW_YORK("New York"),
    SAN_DIEGO("San Diego"),
    WASHINGTON_D_C("Washington D.C.");

    private final String name;
    CityName(String name1){
        this.name = name1;
    }

    public String getStringName(){
        return this.name;
    }
    public int getIntId(){
        return switch (this){
            case CHICAGO -> 0;
            case DETROIT -> 1;
            case LAS_VEGAS -> 2;
            case LOS_ANGELES -> 3;
            case MIAMI -> 4;
            case NEW_YORK -> 5;
            case SAN_DIEGO -> 6;
            case WASHINGTON_D_C -> 7;
        };
    }
    public static CityName cityNameFromId(int id){
        return switch (id){
            case 0 -> CHICAGO;
            case 1 -> DETROIT;
            case 2 -> LAS_VEGAS;
            case 3 -> LOS_ANGELES;
            case 4 -> MIAMI;
            case 5 -> NEW_YORK;
            case 6 -> SAN_DIEGO;
            case 7 -> WASHINGTON_D_C;
            default -> null;
        };
    }
}
