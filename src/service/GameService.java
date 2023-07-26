package service;

import model.Players;
import model.Pokemon;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GameService {

    public void attack(Players attacker, Players defender, boolean isPokemonSpecialAttack, boolean isCharSpecialAttack) {

        Pokemon attackingPokemon = attacker.getCharacter().getPokemonArrayList().get(0);
        Pokemon defendingPokemon = attacker.getCharacter().getPokemonArrayList().get(0);

        boolean specialAttack = false;

        if (isPokemonSpecialAttack && isCharSpecialAttack) {
            specialAttack = attackingPokemon.getSpecialPower().getRemainRight() > 0
                    && attacker.getCharacter().getSpecialPower().getRemainRight() > 0;

        } else if (isPokemonSpecialAttack) {
            specialAttack = attackingPokemon.getSpecialPower().getRemainRight() > 0;

        } else if (isCharSpecialAttack) {
            specialAttack = attacker.getCharacter().getSpecialPower().getRemainRight() > 0;
        }
        int charRemainingRights = attacker.getCharacter().getSpecialPower().getRemainRight();

        int damage = 0;
        if (specialAttack) {
            if (isPokemonSpecialAttack && isCharSpecialAttack) {
                damage += attackingPokemon.specialAttack();
                damage += attacker.getCharacter().getSpecialPower().getExtraDamage();

                attacker.getCharacter().getSpecialPower().setRemainRight(charRemainingRights - 1);
            } else if (isPokemonSpecialAttack) {
                damage += attackingPokemon.specialAttack();
            } else {
                damage += attackingPokemon.getDamage();
                damage += attacker.getCharacter().getSpecialPower().getExtraDamage();

                attacker.getCharacter().getSpecialPower().setRemainRight(charRemainingRights - 1);
            }
        } else {
            if (isPokemonSpecialAttack || isCharSpecialAttack) {
                damage = 0;
            } else {
                damage += attackingPokemon.getDamage();
            }
        }

        defendingPokemon.setHealth(defendingPokemon.getHealth() - damage);

    }

    public boolean healthCheck(Players player) {
        if (player.getCharacter().getPokemonArrayList().get(0).getHealth() > 0) {
            System.out.println(player.toString());
            System.out.println("Oyun devam ediyor.");
            return true;
        } else {
            System.out.println(player.toString());
            System.out.println(player.getName() + " oyunu kaybetti.");
            return false;
        }
    }

    public void attackChoice(Players player1, Players player2) {

        Scanner input = new Scanner(System.in);
        System.out.println("Saldırınızı seçiniz: ");
        System.out.println("1: Normal saldırı\n2: Pokemon Saldırısı\n3: Karakter Saldırısı");
        int select = input.nextInt();

        if (select == 1) {
            attack(player1, player2, false, false);

        } else if (select == 2) {
            attack(player1, player2, true, false);
        } else if (select == 3) {
            attack(player1, player2, false, true);
        } else {
            System.out.println("Geçersiz sayı girildi!");
        }

    }

    // Oyuna hangi oyuncunun başlayacağına karar verildi.
    public void startingPlayer(Players player1, Players player2) {

        Random randomNumber = new Random();
        int index = randomNumber.nextInt(3);

        System.out.println("Oyun başlıyor...");

        if (index == 1) {
            System.out.println("Oyuna " + player1 + " başlıyor.");
            attackChoice(player1, player2);
        } else {
            System.out.println("Oyuna " + player2 + " başlıyor ");
            attackChoice(player2, player1);
        }

    }



}
