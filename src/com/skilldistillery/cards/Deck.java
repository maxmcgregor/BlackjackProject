package com.skilldistillery.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	
	private List<Card> deckOfCards = new ArrayList<>();

	public Deck() {
		for (Rank value : Rank.values()) {
			for (Suit suit : Suit.values()) {
				Card newCard = new Card(suit, value);
				deckOfCards.add(newCard);
			}
		}
	}
	
	public int checkDeckSize() {
		int deckSize = deckOfCards.size();
		return deckSize;
	}
	
	public Card dealCard() {
		Card cardToBeDealt = deckOfCards.remove(0);
		return cardToBeDealt;
	}
	
	public void shuffle() {
		Collections.shuffle(deckOfCards);
	}
	
	public void viewDeck() {
		for (Card card : deckOfCards) {
			System.out.println(card);
		}
	}
}
