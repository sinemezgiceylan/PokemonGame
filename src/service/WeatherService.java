package service;

import model.Pikachu;
import model.Players;
import model.Pokemon;
import model.WeatherEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeatherService {

    public WeatherEnum weatherEnum() {

        Random randomWeather = new Random();
        List<WeatherEnum> weatherList = new ArrayList<>();
        for (WeatherEnum weather : WeatherEnum.values()) {
            weatherList.add(weather);
        }

        int index = randomWeather.nextInt();
        return weatherList.get(index);
    }

    // Hava durumuna göre pokemonların güçleri düzenlendi.
    public void EffectOfWeatherOnPower(Players players, WeatherEnum weatherEnum) {

        Pokemon pokemon = players.getCharacter().getPokemonArrayList().get(0);

        if (pokemon.getName().equals("Pikachu")) {
            if (weatherEnum == WeatherEnum.RAINY) {
                pokemon.setDamage((pokemon.getDamage() * 15 / 10));
                System.out.println("Pikachu yağmurlu havada güç kazandı.");
            } else if (weatherEnum == WeatherEnum.WINDY) {
                pokemon.setDamage((pokemon.getDamage() * 5 / 10));
                System.out.println("Pikachu rüzgarlı havada güç kaybetti.");
            }
        } else if (pokemon.getName().equals("Squirtle")) {
            if (weatherEnum == WeatherEnum.RAINY) {
                pokemon.setDamage(pokemon.getDamage() * 15 / 10);
                System.out.println("Squirtle yağmurlu havada güç kazandı.");
            } else if (weatherEnum == WeatherEnum.SUNNY) {
                pokemon.setDamage(pokemon.getDamage() * 5 / 10);
                System.out.println("Squirtle güneşli havada güç kaybetti.");
            }
        } else if (pokemon.getName().equals("Charmander")) {
            if (weatherEnum == WeatherEnum.HOT) {
                pokemon.setDamage(pokemon.getDamage() * 15 / 10);
                System.out.println("Charmander sıcak havada güç kazandı.");
            } else if (weatherEnum == WeatherEnum.RAINY) {
                pokemon.setDamage(pokemon.getDamage() * 5 / 10);
                System.out.println("Charmander yağmurlu havada güç kaybetti.");
            }
        } else if (pokemon.getName().equals("Bulbasaur")) {
            if (weatherEnum == WeatherEnum.WINDY) {
                pokemon.setDamage(pokemon.getDamage() * 15 / 10);
                System.out.println("Bulbasaur rüzgarlı havada güç kazandı.");
            } else if (weatherEnum == WeatherEnum.HOT) {
                pokemon.setDamage(pokemon.getDamage() * 5 / 10);
                System.out.println("Bulbasaur sıcak havada güç kaybetti.");
            }
        }
    }
}
