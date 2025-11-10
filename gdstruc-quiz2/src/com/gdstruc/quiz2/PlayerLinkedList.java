package com.gdstruc.quiz2;

public class PlayerLinkedList {

    private PlayerNode head;

    public void AddToFront(Player player)
    {
        PlayerNode playerNode = new PlayerNode(player);
        playerNode.SetNextPlayer(head);

        if (head != null)
        {
            head.SetPreviousPlayer(playerNode);
        }

        head = playerNode;
    }

    public void RemoveFront()
    {
        head = head.GetNextPlayer();
        head.SetPreviousPlayer(null);
    }

    public void GetSize()
    {
        System.out.print("Player Linked List Size: -> ");
        PlayerNode current = head;
        int counter = 0;

        while (current != null)
        {
            counter++;
            current = current.GetNextPlayer();
        }

        System.out.print(counter + "\n\n");
    }

    public boolean Contains(Player player)
    {
        PlayerNode current = head;

        while (current != null)
        {

            if (current.GetPlayer().equals(player))
            {
                return true;
            }

            current = current.GetNextPlayer();
        }

        return false;
    }

    public void GetIndexOf(Player player)
    {

        PlayerNode current = head;

        int indexCounter = 0;
        boolean isFound = false;

        while (current != null)
        {
            if (current.GetPlayer().equals(player))
            {
                isFound = true;
                break;
            }
            else
            {
                current = current.GetNextPlayer();
                indexCounter++;
            }
        }

        if (isFound)
        {
            System.out.println("Index of " + player.GetName() + ": " + indexCounter);
        }
        else
        {
            System.out.println("The player " + player.GetName() + " does not exist in the list.");
        }

    }

    public void PrintList()
    {
        PlayerNode current = head;
        System.out.print("HEAD -> ");

        while (current != null)
        {
            System.out.print(current.GetPlayer());
            System.out.print(" -> ");
            current = current.GetNextPlayer();
        }

        System.out.print("NULL\n\n");
    }

}
