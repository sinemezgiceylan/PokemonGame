package model;

import java.util.ArrayList;

public class Serena extends Character{
    public Serena(String name, SpecialPower specialPower, ArrayList<Pokemon> pokemonArrayList) {
        super(name, specialPower, pokemonArrayList);
    }

    public Serena(String name, SpecialPower specialPower) {
        super(name, specialPower);
    }
}
