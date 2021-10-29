package com.skilldistillery.cards;

import java.util.List;

public class BlackjackDealer {

	public BlackjackDealer() {
		
	}
	
	public Deck shuffle(Deck d) {
		d.shuffle();
		return d;
	}
	//deal player hand
	
	
	public BlackjackHand dealPlayerHand(Deck d) {
		BlackjackHand playerHand = new BlackjackHand();
		
		playerHand.addCard(d.dealCard());
		playerHand.addCard(d.dealCard());
		
		playerHand.printHand();
		
		return playerHand;
	}
	
	//deal dealer hand
	
	//hit player
	
	//hit dealer
	
	//checks for blackjack
	
}
