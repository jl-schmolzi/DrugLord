package org.example.UI;

import org.example.druglord.GameState;

public class DrugLordUIImpl implements  DrugLordUI{
    @Override
    public void printOptions() {
        System.out.println("(B)uy drugs");
        System.out.println("(S)ell drugs");
        System.out.println("(J)et to another city");
        System.out.println("(V)isit bank");
        System.out.println("Visit (H)ospital");
        System.out.println("See (L)oan Shark");
        System.out.println("(Q)uit Game");
    }

    @Override
    public void printGameState(GameState gameState) {

    }
}
