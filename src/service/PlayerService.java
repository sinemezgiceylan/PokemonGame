package service;

import model.Character;
import model.Players;
import model.Pokemon;

import java.util.ArrayList;
import java.util.Scanner;

public class PlayerService {

    public Players createPlayer(String name, Character character) {

        return new Players(name, character);

    }

    public Players createPlayer(ArrayList<Character> characterList, ArrayList<Pokemon> pokemonList) {

        Scanner input = new Scanner(System.in);

        // ----------------  Player oluşturuldu. ------------------

        System.out.println("Adınızı giriniz: ");
        String playerName = input.nextLine();

        // Karakterlerin listelenmesi.

        System.out.println("Karakter seçiniz: ");
        for (int i = 0; i < characterList.size(); i++) {
            System.out.println((i + 1) + ": " + characterList.get(i).getName());
        }
        int playerCharacter = input.nextInt();


        // Pokemonların listelenmesi.

        System.out.println("Pokemon seçiniz: ");
        for (int j = 0; j < pokemonList.size(); j++) {
            System.out.println((j + 1) + ": " + pokemonList.get(j).getName());
        }
        int playerPokemon = input.nextInt();

        characterList.get(playerCharacter - 1).getPokemonArrayList().add(pokemonList.get(playerPokemon - 1));

        Players player = createPlayer(playerName, characterList.get(playerCharacter - 1));

        characterList.remove(playerCharacter - 1);
        pokemonList.remove(playerPokemon - 1);
        return player;
    }


    // Oyuna hangi oyuncunun başlayacağına karar verildi.
    public Players startingPlayer(Players player1, Players player2, int index) {

        System.out.println("Oyun başlıyor...");

        if (index == 1) {
            System.out.println("Oyuna " + player1.getName() + " başlıyor.");
            return player1;

        } else {
            System.out.println("Oyuna " + player2.getName() + " başlıyor ");
            return player2;

        }

    }

}
