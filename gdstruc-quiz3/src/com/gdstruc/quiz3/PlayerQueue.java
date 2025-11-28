package com.gdstruc.quiz3;

import java.util.LinkedList;

public class PlayerQueue
{
    private LinkedList<Player> playerQueue;

    public PlayerQueue()
    {
        playerQueue = new LinkedList<Player>();
    }

    public void enqueue(Player player)
    {
        playerQueue.addLast(player);
    }

    public Player dequeue()
    {
        return playerQueue.removeFirst();
    }

    public Player peek()
    {
        return playerQueue.getFirst();
    }

    public int size()
    {
        return playerQueue.size();
    }

    public void PrintQueue()
    {
        for (int i = 0; i < playerQueue.size(); i++)
        {
            System.out.println(playerQueue.get(i));
        }
    }
}
