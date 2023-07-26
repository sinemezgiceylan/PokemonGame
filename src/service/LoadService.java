package service;

import model.*;
import model.Character;

import java.util.ArrayList;

public class LoadService {

    public ArrayList<Character> loadCharacter() {

        SpecialPower strategy1 = new Strategy("Strategy", 4, 1);
        SpecialPower strategy2 = new Strategy("Strategy II", 3, 1);

        Character ash = new Ash("Ash", strategy1);
        Character brooke = new Brock("Brock", strategy2);
        Character james = new James("James", strategy1);
        Character serena = new Serena("Serena", strategy2);

        ArrayList<Character> characterList = new ArrayList<>();
        characterList.add(ash);
        characterList.add(brooke);
        characterList.add(james);
        characterList.add(serena);
        return characterList;

    }

    public ArrayList<Pokemon> loadPokemons(){
        SpecialPower electricity = new Electricity("Electricity", 3, 3);
        SpecialPower water = new Water("Water", 1, 3);
        SpecialPower fire = new Fire("Fire", 5, 3);
        SpecialPower wind = new Earth("Wind", 4, 3);

        Pokemon pokemon1 = new Pikachu("Pikachu", 100, 10, TypeEnum.ELECTRICY, electricity);
        Pokemon pokemon2 = new Squirtle("Squirtle", 100, 8, TypeEnum.WATER, water);
        Pokemon pokemon3 = new Charmander("Charmander", 100, 12, TypeEnum.FIRE, fire);
        Pokemon pokemon4 = new Bulbasaur("Bulbasaur", 100, 7, TypeEnum.WIND, wind);

        ArrayList<Pokemon> pokemonList = new ArrayList<>();
        pokemonList.add(pokemon1);
        pokemonList.add(pokemon2);
        pokemonList.add(pokemon3);
        pokemonList.add(pokemon4);

        return pokemonList;
    }





}
