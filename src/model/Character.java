package model;

import java.util.ArrayList;

public class Character {

    private String name;

    private SpecialPower specialPower;

    private ArrayList<Pokemon> pokemonArrayList;

    public Character(String name, SpecialPower specialPower, ArrayList<Pokemon> pokemonArrayList) {
        this.name = name;
        this.specialPower = specialPower;
        this.pokemonArrayList = pokemonArrayList;
    }

    public Character(String name, SpecialPower specialPower) {
        this.name = name;
        this.specialPower = specialPower;
        this.pokemonArrayList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SpecialPower getSpecialPower() {
        return specialPower;
    }

    public void setSpecialPower(SpecialPower specialPower) {
        this.specialPower = specialPower;
    }

    public ArrayList<Pokemon> getPokemonArrayList() {
        return pokemonArrayList;
    }

    public void setPokemonArrayList(ArrayList<Pokemon> pokemonArrayList) {
        this.pokemonArrayList = pokemonArrayList;
    }


    @Override
    public String toString() {
        return name + '\n' + pokemonArrayList.toString();
    }
}
