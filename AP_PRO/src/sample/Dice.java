package sample;

import java.util.Random;

public class Dice {
    public Dice(){

    }
    public int rollDice(){
        Random rand = new Random();
        int result = rand.nextInt(6);
        return result+1;
    }
}
