package service;

import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeatherService {

    public WeatherEnum createWeatherEnum() {

        Random randomWeather = new Random();
        List<WeatherEnum> weatherList = new ArrayList<>();
        for (WeatherEnum weather : WeatherEnum.values()) {
            weatherList.add(weather);
        }
        int index = randomWeather.nextInt(4);
        return weatherList.get(index);

    }


    // Hava durumuna göre pokemonların güçleri düzenlendi.

    public void EffectOfWeatherOnPower(Pokemon pokemon, WeatherEnum weatherEnum) {

        switch (pokemon.getTypeEnum().toString()) {
            case "ELECTRICY" -> {
                if (weatherEnum == WeatherEnum.RAINY) {
                    pokemon.setDamage((pokemon.getDamage() + 5));
                    System.out.println("Pikachu yağmurlu havada güç kazandı.");
                } else if (weatherEnum == WeatherEnum.WINDY) {
                    if (pokemon.getDamage() <= 0) {
                        pokemon.setDamage(0);
                    } else {
                        pokemon.setDamage((pokemon.getDamage() - 3));
                    }

                    System.out.println("Pikachu rüzgarlı havada güç kaybetti.");
                }
            }
            case "WATER" -> {
                if (weatherEnum == WeatherEnum.RAINY) {
                    pokemon.setDamage(pokemon.getDamage() + 5);
                    System.out.println("Squirtle yağmurlu havada güç kazandı.");
                } else if (weatherEnum == WeatherEnum.SUNNY) {
                    if (pokemon.getDamage() <= 0) {
                        pokemon.setDamage(0);
                    } else {
                        pokemon.setDamage((pokemon.getDamage() - 3));
                    }
                    System.out.println("Squirtle güneşli havada güç kaybetti.");
                }
            }
            case "FIRE" -> {
                if (weatherEnum == WeatherEnum.HOT) {
                    pokemon.setDamage(pokemon.getDamage() + 5);
                    System.out.println("Charmander sıcak havada güç kazandı.");
                } else if (weatherEnum == WeatherEnum.RAINY) {
                    if (pokemon.getDamage() <= 0) {
                        pokemon.setDamage(0);
                    } else {
                        pokemon.setDamage((pokemon.getDamage() - 3));
                    }
                    System.out.println("Charmander yağmurlu havada güç kaybetti.");
                }
            }
            case "WIND" -> {
                if (weatherEnum == WeatherEnum.WINDY) {
                    pokemon.setDamage(pokemon.getDamage() + 5);
                    System.out.println("Bulbasaur rüzgarlı havada güç kazandı.");
                } else if (weatherEnum == WeatherEnum.HOT) {
                    if (pokemon.getDamage() <= 0) {
                        pokemon.setDamage(0);
                    } else {
                        pokemon.setDamage((pokemon.getDamage() - 3));
                    }
                    System.out.println("Bulbasaur sıcak havada güç kaybetti.");
                }
            }
        }
    }
}
