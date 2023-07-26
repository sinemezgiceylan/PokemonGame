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

        // Load Pokemon
        ArrayList<Pokemon> pokemonList = loadService.loadPokemons();


        //gameService.attack(player1, player2, true, true);

        //gameService.healthCheck(player2);

        Players player1 = playerService.createPlayer(characterList, pokemonList);
        System.out.println("1. oyuncu oluşturuldu.\n" + player1.toString());

        Players player2 = playerService.createPlayer(characterList, pokemonList);
        System.out.println("2. oyuncu oluşturuldu.\n" + player2.toString());

        // Başlangıç oyuncusu seçildi.

        if (gameService.healthCheck(player1) && gameService.healthCheck(player2)) {
            gameService.startingPlayer(player1, player2);
            System.out.println(player1.toString());
            System.out.println(player2.toString());
        }







    }
}