package com.skilldistillery.cards;

import java.util.ArrayList;
import java.util.List;

public class BlackjackHand extends Hand {
	
	protected Deck bjdeck = new Deck();
	protected List<Card> hand;
  	
	public BlackjackHand() {	
		hand = new ArrayList<>();
	}
	
	public int getHandValue() {
		int value = 0;
		for (Card card : hand) {
			value += card.getValue();
		}
		return value;
	}
	
	public boolean isBlackjack() {
		//if hand value equals 21
		return true;
	}
	
	public boolean isBust() {
		//if hand value is > 21
		return false;
	}
	
	public void printHand() {
		for (Card card : hand) {
			System.out.println(card);
		}
	}

}
