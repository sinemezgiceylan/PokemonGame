package model;

import java.util.ArrayList;

public class Brock extends Character{
    public Brock(String name, SpecialPower specialPower, ArrayList<Pokemon> pokemonArrayList) {
        super(name, specialPower, pokemonArrayList);
    }

    public Brock(String name, SpecialPower specialPower) {
        super(name, specialPower);
    }
}
