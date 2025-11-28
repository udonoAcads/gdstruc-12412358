package com.gdstruc.quiz3;

import java.util.Objects;

public class Player
{
    private int id;
    private int level;

    public Player(int id, int level) {
        this.id = id;
        this.level = level;
    }

    public int GetId() {
        return id;
    }

    public void SetId(int id) {
        this.id = id;
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
        return id == player.id && level == player.level;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, level);
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", level=" + level +
                '}';
    }
}
