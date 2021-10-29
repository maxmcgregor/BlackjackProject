package com.skilldistillery.cards;

import java.util.Collections;
import java.util.Scanner;

public class BlackjackApp {
	private BlackjackDealer bjd = new BlackjackDealer();
	private BlackjackHand playerHand;
	private BlackjackHand dealerHand;
	private Deck deck;

	public static void main(String[] args) {
		BlackjackApp bja = new BlackjackApp();
		bja.run();
	}

	public void run() {
		Scanner sc = new Scanner(System.in);
		
		printWelcome();
		sc.nextLine();
		
		// dealer deals player hand & prints
		startGame();
		dealPlayerHand();
			
		// dealer deals dealer hand & prints 
		
		// check player for blackjack
		
		// ask player to stand or hit in while loop
		
		// 
		
		// check both for blackjack
		sc.close();
	}

	public void startGame() {
		deck = new Deck();
		deck.shuffle();
		System.out.println("Dealer is shuffling deck...");
	}
	
	public void printWelcome() {
		System.out.println("Welcome to the Blackjack table. Press enter to begin.");
	}
	
	public void dealPlayerHand() {
		bjd.dealPlayerHand(deck);
	}
	
	public void dealDealerHand() {
		
	}
	

}
