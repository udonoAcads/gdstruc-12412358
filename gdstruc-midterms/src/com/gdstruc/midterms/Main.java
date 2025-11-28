package com.gdstruc.midterms;

import java.util.Random;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        CardStack playerDeck = new CardStack("Player Deck");
        playerDeck.FillStack();

        CardStack discardPile = new CardStack("Discard Pile");

        System.out.printf("Initializing Decks...");

        PressEnterToContinue();

        while (!playerDeck.IsEmpty())
        {
            DoCardCommand(playerDeck, discardPile);

            playerDeck.PrintCount();
            discardPile.PrintCount();

            PressEnterToContinue();
        }

    }

    private static void DoCardCommand(CardStack playerDeck, CardStack discardPile)
    {
        Random random = new Random();
        int commandRandomizer = random.nextInt(0, 3);
        int countRandomizer = random.nextInt(1, 6);

        switch(commandRandomizer)
        {
            case 0:

                System.out.println("Drawing " + countRandomizer + " cards:");

                LinkedList<Card> drawnCards = playerDeck.PopBatch(countRandomizer);
                for (int i = 0; i < drawnCards.size(); i++)
                {
                    System.out.println(drawnCards.get(i));
                }

                break;

            case 1:

                System.out.println("Discarding " + countRandomizer + " cards:");

                LinkedList<Card> discardedCards = playerDeck.PopBatch(countRandomizer);
                for (int i = 0; i < discardedCards.size(); i++)
                {
                    System.out.println(discardedCards.get(i));
                    discardPile.Push(discardedCards.get(i));
                }

                break;

            case 2:

                System.out.println("Getting " + countRandomizer + " cards from the discard pile:");

                LinkedList<Card> returnedCards = discardPile.PopBatch(countRandomizer);
                for (int i = 0; i < returnedCards.size(); i++)
                {
                    System.out.println(returnedCards.get(i));
                    playerDeck.Push(returnedCards.get(i));
                }

                break;
        }
    }

    private static void PressEnterToContinue()
    {
        System.out.println("\nPress Enter to Continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

    }
}