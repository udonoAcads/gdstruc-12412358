package com.gdstruc.quiz4;

import java.util.Objects;

public class Player {

    private int id;
    private String userName;
    private int level;

    public Player(int id, String userName, int level) {
        this.id = id;
        this.userName = userName;
        this.level = level;
    }

    public int GetId() {
        return id;
    }

    public void SetId(int id) {
        this.id = id;
    }

    public String GetUsername() {
        return userName;
    }

    public void SetName(String name) {
        this.userName = name;
    }

    public int GetLevel() {
        return level;
    }

    public void SetLevel(int level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return id == player.id && level == player.level && Objects.equals(userName, player.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, level);
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + userName + '\'' +
                ", level=" + level +
                '}';
    }

}

