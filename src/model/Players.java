package model;

import java.util.ArrayList;

public class Players {

    private String name;

    private Character character;

    private boolean isWinner;

    public Players(String name, Character character) {
        this.name = name;
        this.character = character;
        this.isWinner = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public boolean isWinner() {
        return isWinner;
    }

    public void setWinner(boolean winner) {
        isWinner = winner;
    }


    @Override
    public String toString() {
        return "Oyuncu adı : " + name + '\n'
                +"Karakter : " + character;
    }
}
