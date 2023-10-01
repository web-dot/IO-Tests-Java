package com.example.game_io_input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class GuessingGame {
	private int numberToGuess;
	private int attempts;
	private boolean hasGuessedCorrectly;
	public GuessingGame() {
		Random random = new Random();
		this.numberToGuess = random.nextInt(100) + 1; // generate a random number between 1 to 100
		this.attempts = 0;
		this.hasGuessedCorrectly = false;
	}
	
	public void play() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Welcome to the Gussing game");
		
		while(!this.hasGuessedCorrectly) {
			System.out.println("Enter your guess: ");
			int userGuess = Integer.parseInt(reader.readLine());
			this.attempts++;

			if(userGuess < this.numberToGuess) {
				System.out.println("Too low! Try again");
			}
			else if(userGuess > this.numberToGuess) {
				System.out.println("Too high! Try again");
			}
			else {
				System.out.println("Congratulations, you guessed the number");
				this.hasGuessedCorrectly = true;
			}
		}
		
	}
	
	
	public static void main(String[] args) throws IOException {
		GuessingGame game =  new GuessingGame();
		game.play();
	}
}
