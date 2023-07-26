package model;

import java.util.ArrayList;

public class Ash extends Character{
    public Ash(String name, SpecialPower specialPower, ArrayList<Pokemon> pokemonArrayList) {
        super(name, specialPower, pokemonArrayList);
    }

    public Ash(String name, SpecialPower specialPower) {
        super(name, specialPower);
    }

}
