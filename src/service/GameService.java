package service;

import model.Players;
import model.Pokemon;

import java.util.Random;
import java.util.Scanner;

public class GameService {

    WeatherService weatherService = new WeatherService();

    public void attack(Players attacker, Players defender, boolean isPokeSpecialAttack, boolean isCharSpecialAttack) {
        Pokemon attackingPokemon = attacker.getCharacter().getPokemonArrayList().get(0);
        Pokemon defendingPokemon = defender.getCharacter().getPokemonArrayList().get(0);

        boolean specialAttack = false;
        if (isPokeSpecialAttack && isCharSpecialAttack) {
            specialAttack = attackingPokemon.getSpecialPower().getRemainRight() > 0
                    && attacker.getCharacter().getSpecialPower().getRemainRight() > 0;
        } else if (isPokeSpecialAttack) {
            specialAttack = attackingPokemon.getSpecialPower().getRemainRight() > 0;
        } else if (isCharSpecialAttack) {
            specialAttack = attacker.getCharacter().getSpecialPower().getRemainRight() > 0;
        }

        int charRemainingRights = attacker.getCharacter().getSpecialPower().getRemainRight();

        int damage = 0;
        if (specialAttack) {
            if (isPokeSpecialAttack && isCharSpecialAttack) {
                damage += attackingPokemon.specialAttack();
                damage += attacker.getCharacter().getSpecialPower().getExtraDamage();
                attacker.getCharacter().getSpecialPower().setRemainRight(charRemainingRights - 1);
            } else if (isPokeSpecialAttack) {
                damage += attackingPokemon.specialAttack();
            } else {
                damage += attackingPokemon.getDamage();
                damage += attacker.getCharacter().getSpecialPower().getExtraDamage();
                attacker.getCharacter().getSpecialPower().setRemainRight(charRemainingRights - 1);
            }
        } else {
            if (isPokeSpecialAttack || isCharSpecialAttack) {
                damage = 0;
            } else {
                damage += attackingPokemon.getDamage();
            }
        }
        defendingPokemon.setHealth(defendingPokemon.getHealth() - damage);
    }

    // Sağlık kontrolü yapıldı.
    public boolean healthCheck(Players player) {
        if (player.getCharacter().getPokemonArrayList().get(0).getHealth() > 0) {
            return true;
        } else {
            System.out.println(player.getName() + " oyunu kaybetti.");
            return false;
        }
    }

    public void attackChoice(Players attacker, Players defender, int selectAttack) {

        if (selectAttack == 1) {
            attack(attacker, defender, false, false);
        } else if (selectAttack == 2) {
            attack(attacker, defender, true, false);
        } else if (selectAttack == 3) {
            attack(attacker, defender, false, true);
        } else {
            System.out.println("Geçersiz sayı girildi!");
        }


    }




}
