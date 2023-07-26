import model.Character;
import model.Players;
import model.Pokemon;
import service.GameService;
import service.LoadService;
import service.PlayerService;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        LoadService loadService = new LoadService();
        PlayerService playerService = new PlayerService();
        GameService gameService = new GameService();

        // Load Character
        ArrayList<model.Character> characterList = loadService.loadCharacter();
        System.out.println("-----Characters-----");
        for (Character character : characterList) {
            System.out.println(character.toString());
        }

        // Load Pokemon
        ArrayList<Pokemon> pokemonList = loadService.loadPokemons();
        System.out.println("-----Pokemon-----");
        for (Pokemon pokemon : pokemonList) {
            System.out.println(pokemon.toString());
        }

        characterList.get(0).getPokemonArrayList().add(pokemonList.get(0));
        characterList.get(1).getPokemonArrayList().add(pokemonList.get(1));

        Players player1 = playerService.createPlayer("Tuğçe", characterList.get(0));
        Players player2 = playerService.createPlayer("Hasan", characterList.get(1));

        gameService.attack(player1, player2, true, true);

        gameService.healthCheck(player2);

        




    }
}