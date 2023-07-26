package service;
import model.Players;
import model.Pokemon;

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
}
