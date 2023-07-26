import model.Character;
import model.Players;
import model.Pokemon;
import model.WeatherEnum;
import service.GameService;
import service.LoadService;
import service.PlayerService;
import service.WeatherService;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        LoadService loadService = new LoadService();
        PlayerService playerService = new PlayerService();
        GameService gameService = new GameService();
        WeatherService weatherService = new WeatherService();

        // Load Character
        ArrayList<model.Character> characterList = loadService.loadCharacter();

        // Load Pokemon
        ArrayList<Pokemon> pokemonList = loadService.loadPokemons();


        //gameService.attack(player1, player2, true, true);

        //gameService.healthCheck(player2);

        Players player1 = playerService.createPlayer(characterList, pokemonList);
        System.out.println("1. oyuncu oluşturuldu.\n" + player1.toString());

        Players player2 = playerService.createPlayer(characterList, pokemonList);
        System.out.println("2. oyuncu oluşturuldu.\n" + player2.toString());



        if (gameService.healthCheck(player1) && gameService.healthCheck(player2)) {
            gameService.startingPlayer(player1, player2);
            System.out.println(player1.toString());
            System.out.println(player2.toString());
        }

        WeatherEnum weatherEnum = weatherService.createWeatherEnum();

        weatherService.EffectOfWeatherOnPower(player1.getCharacter().getPokemonArrayList().get(0), weatherEnum);
        weatherService.EffectOfWeatherOnPower(player2.getCharacter().getPokemonArrayList().get(0), weatherEnum);

        int round = 1;

        while (round == 3) {


        }









    }
}