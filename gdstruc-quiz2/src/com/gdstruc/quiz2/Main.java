package com.gdstruc.quiz2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Player> playerList = new ArrayList<>(100);

        Player asuna = new Player(1, "Asuna", 1);
        Player lethalBacon = new Player(2, "LethalBacon", 10);
        Player hpDeskJet = new Player(3, "HPDeskJet", 50);

        PlayerLinkedList playerLinkedList = new PlayerLinkedList();

        playerLinkedList.AddToFront(asuna);
        playerLinkedList.AddToFront(lethalBacon);
        playerLinkedList.AddToFront(hpDeskJet);

        playerLinkedList.PrintList();
        playerLinkedList.GetSize();
        System.out.println(playerLinkedList.Contains(new Player(3, "HPDeskJet", 50)) + "\n");
        playerLinkedList.GetIndexOf(new Player(3, "HPDeskJet", 50));

        playerLinkedList.RemoveFront();

        playerLinkedList.PrintList();
        playerLinkedList.GetSize();
        System.out.println(playerLinkedList.Contains(new Player(3, "HPDeskJet", 50)) + "\n");
        playerLinkedList.GetIndexOf(new Player(3, "HPDeskJet", 50));
    }
}