# PokemonGame
Patika X Allianz İşbirliği Bootcamp Programı (Week 7 - Homework)

Welcome to the Pokemon game! This project is a simple text-based game where two players battle with their chosen Pokemon characters. The game revolves around selecting attacks and using weather effects to defeat the opponent's Pokemon. Let's see how to play and understand the project structure.

## How to Play

Run the Main class in the Main.java file to start the game.
Each player will be prompted to create their character and choose a Pokemon from the available list.
The starting player will be selected randomly.
During each round, players will choose their attacks, and the damage will be calculated based on the attack type and weather effects.
The game continues until all rounds are completed or one of the players loses all their Pokemon.

## Project Structure

The project is organized into several classes to handle different aspects of the game:

## Weather Effects

During each round, a random weather effect is generated using the WeatherService. This effect modifies the power of both players' Pokemon. The types of weather effects are not shown in the provided code.

## Winning the Game

The game is played in rounds, and each player's goal is to defeat the opponent's Pokemon. When a player's Pokemon health reaches zero or below, they lose the round. After a predetermined number of rounds, the game will end, and the player with the surviving Pokemon will be declared the winner.


`Have fun playing the Pokemon game! If you have any questions or feedback, feel free to reach out.`
