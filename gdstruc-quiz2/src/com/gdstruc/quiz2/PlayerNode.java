package com.gdstruc.quiz2;

import java.util.Objects;

public class PlayerNode {

    private Player player;
    private PlayerNode nextPlayer;
    private PlayerNode previousPlayer;

    public PlayerNode GetPreviousPlayer() {
        return previousPlayer;
    }

    public void SetPreviousPlayer(PlayerNode previousPlayer) {
        this.previousPlayer = previousPlayer;
    }

    public PlayerNode(Player player) {
        this.player = player;
    }

    public Player GetPlayer() {
        return player;
    }

    public void SetPlayer(Player player) {
        this.player = player;
    }

    public PlayerNode GetNextPlayer() {
        return nextPlayer;
    }

    public void SetNextPlayer(PlayerNode nextPlayer) {
        this.nextPlayer = nextPlayer;
    }
}
