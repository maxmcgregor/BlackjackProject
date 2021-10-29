package com.skilldistillery.cards;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
	
	protected List<Card> cards;
	
	public Hand() {
		cards = new ArrayList<>();
	}
	
	public void addCard(Card c) {
		cards.add(c);
	}
	
	public void clear() {
		cards.removeAll(cards);
	}
	
	public int getHandValue() {
		int totalValue = 0;
		for (Card card : cards) {
			totalValue += card.getValue();
		}
		return totalValue;
	}

	@Override
	public String toString() {
		return "Hand [cards=" + cards + "]";
	}
	
	
	
}
