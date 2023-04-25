package org.example.druglord;

public enum Drug {
    COCAINE,
    CRACK,
    HEROIN,
    ACID,
    CRYSTAL,
    GRASS,
    SPEED,
    LUDES;

    public int getDrugId(){
        return switch(this){
            case COCAINE -> 0;
            case CRACK -> 1;
            case HEROIN -> 2;
            case ACID -> 3;
            case CRYSTAL -> 4;
            case GRASS -> 5;
            case SPEED -> 6;
            case LUDES -> 7;
        };
    }

    public static Drug drugFromId(int id){
        return switch(id){
            case 0 -> COCAINE;
            case 1 -> CRACK;
            case 2 -> HEROIN;
            case 3 -> ACID;
            case 4 -> CRYSTAL;
            case 5 -> GRASS;
            case 6 -> SPEED;
            case 7 -> LUDES;
            default -> null;
        };
    }
}
