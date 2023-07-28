import model.Character;
import model.Players;
import model.Pokemon;
import model.WeatherEnum;
import service.GameService;
import service.LoadService;
import service.PlayerService;
import service.WeatherService;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Random randomNumber = new Random();

        LoadService loadService = new LoadService();
        PlayerService playerService = new PlayerService();
        GameService gameService = new GameService();
        WeatherService weatherService = new WeatherService();

        // Load Character
        ArrayList<Character> characterList = loadService.loadCharacter();

        // Load Pokemon
        ArrayList<Pokemon> pokemonList = loadService.loadPokemons();


        System.out.println("Pokemon oyununa hoşgeldiniz! ");

        Players player1 = playerService.createPlayer(characterList, pokemonList);
        System.out.println("1. oyuncu oluşturuldu.\n" + player1.toString());
        Players player2 = playerService.createPlayer(characterList, pokemonList);
        System.out.println("2. oyuncu oluşturuldu.\n" + player2.toString());

        // Oyuna hangi oyuncunun başlacağı random olarak seçildi.
        int index = randomNumber.nextInt(3);
        Players ply1 = playerService.startingPlayer(player1, player2, index);
        Players ply2;
        if (ply1.equals(player1)) {
            ply2 = player2;
        } else {
            ply2 = player1;
        }

        int roundCount = 1;
        final int maxRounds = 2;

        // Oyunun oynanacağı hava koşulu belirlendi.
        WeatherEnum weatherEnum = weatherService.createWeatherEnum();
        weatherService.EffectOfWeatherOnPower(ply1.getCharacter().getPokemonArrayList().get(0), weatherEnum);
        weatherService.EffectOfWeatherOnPower(ply2.getCharacter().getPokemonArrayList().get(0), weatherEnum);

        while (true) {

            if (gameService.healthCheck(ply1) && gameService.healthCheck(ply2)) {

                // Oyuncunun attack seçimi yapıldı.
                System.out.println("Saldırınızı seçiniz: ");
                System.out.println("1: Normal saldırı\n2: Pokemon Saldırısı\n3: Karakter Saldırısı");
                int selectAttack1 = input.nextInt();
                gameService.attackChoice(ply1, ply2, selectAttack1);System.out.println(ply1.getName()
                        + " güncel gücü: " + ply1.getCharacter().getPokemonArrayList().get(0).getDamage());


                System.out.println("Saldırınızı seçiniz: ");
                System.out.println("1: Normal saldırı\n2: Pokemon Saldırısı\n3: Karakter Saldırısı");
                int selectAttack2 = input.nextInt();

                gameService.attackChoice(ply2, ply1, selectAttack2);System.out.println(ply2.getName()
                        + " güncel gücü: " + ply2.getCharacter().getPokemonArrayList().get(0).getDamage());
            }



            if (ply1.getCharacter().getPokemonArrayList().get(0).getHealth() <= 0 && ply2.getCharacter().getPokemonArrayList().get(0).getHealth() > 0) {
                System.out.println(ply2.getName() +  " oyunu kazandı");

                System.out.println(ply1.getName() + " oyunu kaybetti.");
                int initialWinnerHealth = ply2.getCharacter().getPokemonArrayList().get(0).getHealth();

                ply2.getCharacter().getPokemonArrayList().set(0, ply1.getCharacter().getPokemonArrayList().get(0));
                ply2.getCharacter().getPokemonArrayList().get(0).setHealth(initialWinnerHealth);

                Pokemon weakestPokemonForPlayer1 = loadService.getWeakestPokemonForPlayer(pokemonList);
                ply1.getCharacter().getPokemonArrayList().set(0, weakestPokemonForPlayer1);
                ply1.getCharacter().getPokemonArrayList().get(0).setHealth(weakestPokemonForPlayer1.getMaxHealth());

                roundCount++;


            } else if  (ply2.getCharacter().getPokemonArrayList().get(0).getHealth() <= 0 && ply1.getCharacter().getPokemonArrayList().get(0).getHealth() > 0){
                System.out.println(ply1.getName() +  " oyunu kazandı");
                int initialWinnerHealth = ply1.getCharacter().getPokemonArrayList().get(0).getHealth();

                ply1.getCharacter().getPokemonArrayList().set(0, ply2.getCharacter().getPokemonArrayList().get(0));
                ply1.getCharacter().getPokemonArrayList().get(0).setHealth(initialWinnerHealth);


                Pokemon weakestPokemonForPlayer1 = loadService.getWeakestPokemonForPlayer(pokemonList);
                ply2.getCharacter().getPokemonArrayList().set(0, weakestPokemonForPlayer1);
                ply2.getCharacter().getPokemonArrayList().get(0).setHealth(weakestPokemonForPlayer1.getMaxHealth());

                roundCount++;

            } else {
                System.out.println(ply1.getName() + " sağlığı : " + ply1.getCharacter().getPokemonArrayList().get(0).getHealth());
                System.out.println(ply2.getName() + " sağlığı : " + ply2.getCharacter().getPokemonArrayList().get(0).getHealth());
            }


            // Raund kontrolü yapıldı.cd
            if (roundCount == maxRounds + 1) {
                System.out.println("Oyun tamamlandı!");
                break;
            }

        }

    }

}
