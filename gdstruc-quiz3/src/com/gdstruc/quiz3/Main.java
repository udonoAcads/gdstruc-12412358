package com.gdstruc.quiz3;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        int playerIdCounter = 1;
        int matches = 0;
        int turns = 0;

        while (matches < 10)
        {
            turns++;
            PlayerQueue newQueue = ExecuteTurn(matches, turns, playerIdCounter);
            playerIdCounter += newQueue.size();

            if (newQueue.size() >= 5)
            {
                matches++;
                PlayGame(newQueue, matches);
            }
        }

    }

    private static PlayerQueue ExecuteTurn(int matches, int turns, int currPlayerId)
    {
        PlayerQueue newQueue = new PlayerQueue();

        //Add a random amount of new players
        Random random = new Random();
        int playerCountRandomizer = random.nextInt(1, 8);
        for (int i = 0; i < playerCountRandomizer; i++)
        {
            int playerLevelRandomizer = random.nextInt(1, 1000);
            newQueue.enqueue(new Player(currPlayerId, playerLevelRandomizer));
            currPlayerId++;
        }

        System.out.println("TURN " + turns);
        System.out.println("Current number of players in queue: " + newQueue.size());
        newQueue.PrintQueue();

        PressEnterToContinue();

        return newQueue;
    }

    private static void PlayGame(PlayerQueue playerQueue, int matches)
    {
        if (playerQueue.size() >= 5)
        {

            System.out.println("GAME " + matches + " STARTED!");
            System.out.println("Eliminated players:");

            for (int i = 0; i < 5; i++)
            {
                System.out.println(playerQueue.dequeue());
            }

            PressEnterToContinue();
        }
    }

    private static void PressEnterToContinue()
    {
        System.out.println("\nPress Enter to Continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
}