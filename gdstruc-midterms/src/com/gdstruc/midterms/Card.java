package com.gdstruc.midterms;

import java.util.Random;

public class Card {

    private String type;
    private int id;
    private int count;
    private int countLimit = 13;

    public Card(int id)
    {
        Random random = new Random();

        this.id = id;

        int typeRandomizer = random.nextInt(1, 5);

        switch (typeRandomizer)
        {
            case 1:
                type = "Hearts";
                break;
            case 2:
                type = "Spades";
                break;
            case 3:
                type = "Diamonds";
                break;
            case 4:
                type = "Clubs";
                break;
        }

        count = random.nextInt(1, countLimit + 1);
    }

    @Override
    public String toString() {

        String countDisplay;

        switch(count)
        {
            case 11:
                countDisplay = "Jack";
                break;
            case 12:
                countDisplay = "Queen";
                break;
            case 13:
                countDisplay = "King";
                break;
            default:
                countDisplay = Integer.toString(count);
                break;
        }

        return "Card " +
                id + ": " +
                countDisplay + " of " +
                type;
    }
}
