package com.skilldistillery.blackjackapp;

import java.util.Collections;
import java.util.Scanner;

import com.skilldistillery.blackjack.BlackjackDealer;
import com.skilldistillery.blackjack.BlackjackHand;
import com.skilldistillery.cards.Deck;

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
		printPlayerHand();
		
		dealDealerHand();
		printDealerFirstCard();
		
		printPlayerTotal();
		
		if (!checkPlayerForBlackjack()) {
			System.out.println("Blackjack! Press enter to see the dealer complete their turn.");
			sc.nextLine();
			//method for finish dealer turn
			printDealerSecondCard();
			printDealerTotal();
			finishDealerTurn();
		}
		
		
		// ask player to stand or hit in while loop
		
		// 
		
		// check both for blackjack
		sc.close();
	}

	public void startGame() {
		System.out.println("Dealer is shuffling deck...");
		bjd.shuffle();
		System.out.println("Dealer is dealing...\n");
	}
	
	public void printWelcome() {
		System.out.println("Welcome to the Blackjack table. Press enter to begin.");
	}
	
	public void dealPlayerHand() {
		bjd.dealPlayerHand();
	}
	
	public void dealDealerHand() {
		bjd.dealDealerHand();
	}
	
	public void printPlayerHand() {
		System.out.println("Your cards are:");
		bjd.printPlayerHand();	
	}
	
	public void printDealerFirstCard() {
		System.out.print("\nDealer shows ");
		bjd.printDealerFirstCard();
	}
	
	public void printDealerSecondCard() {
		System.out.print("Dealer second card is ");
		bjd.printDealerSecondCard();
	}
	
	public void printPlayerTotal() {
		System.out.print("\nYour total is ");
		bjd.printPlayerTotal();
	}
	
	public void printDealerTotal() {
		System.out.print("Dealer total is ");
		bjd.printDealerTotal();
	}
	
	public boolean checkPlayerForBlackjack() {
		return bjd.checkPlayerForBlackjack();
	}
	
	public void finishDealerTurn() {
		bjd.finishDealerTurn();
	}
	

}
